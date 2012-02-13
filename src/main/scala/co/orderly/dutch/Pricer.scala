/*
 * Copyright (c) 2012 Orderly Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package co.orderly.dutch

// Java
import java.io.File
import java.io.{Reader, FileReader}

// Config
import com.typesafe.config.{Config, ConfigFactory}

// Scala
import scala.collection.JavaConverters._

// opencsv
import au.com.bytecode.opencsv._
import bean.CsvToBean

// Amazon MWS Products
import com.amazonservices.mws.products.{MarketplaceWebServiceProductsConfig, MarketplaceWebServiceProductsClient}
// import com.amazonservices.mws.products.model.*

// Dutch
import csv._

/**
 * Pricer performs the competitive pricing
 */
case class Pricer(config: Config,
                  input: Seq[File],
                  separator: Char,
                  quoteChar: Char,
                  header: Boolean,
                  output: String) {

  /**
   * Executes a pricing run
   */
  def run() {

    getProducts(input, separator, quoteChar, header).foreach(_.debug())
    // val client = initClient(config.getConfig("merchant"))

    /*
       val request = new GetCompetitivePricingForASINRequest()
request.setSellerId(ProductsConfig.sellerId);
request.setMarketplaceId(ProductsConfig.marketplaceId);
List<String> asins = new ArrayList<String>();
asins.add("B004QNYOXQ");
request.setASINList(new ASINListType(asins));
     */

  }

  /**
   * Recursive function to extract all of the product lines from
   * 1+ input files OR stdin. Calls parseInput to do the heavy
   * lifting.
   */
  protected def getProducts(input: Seq[File],
                            separator: Char,
                            quoteChar: Char,
                            header: Boolean): List[ProductLine] = input match {

    case Seq() => parseProducts(io.Source.stdin.bufferedReader(), separator, quoteChar, header)
    case Seq(file) => parseProducts(new FileReader(file), separator, quoteChar, header)
    case Seq(file, files@_*) => parseProducts(new FileReader(file), separator, quoteChar, header) ::: getProducts(files, separator, quoteChar, header)
  }

  /**
   * Parses an input (either stdin or a file) using opencsv to
   * extract the ProductLines from it
   */
  protected def parseProducts(input: Reader,
                              separator: Char,
                              quoteChar: Char,
                              header: Boolean): List[ProductLine] = {

    val line = if (header) 1 else 0
    val csvReader = new CSVReader(input, separator, quoteChar, line)

    ProductLine.asCsv.parse(ProductLine.mappingStrategy, csvReader).asScala.toList
  }

  /**
   * Initializes an Amazon MWS Products Client
   */
  protected def initClient(config: Config) = new MarketplaceWebServiceProductsClient(
    config.getString("key"),     // awsAccessKeyId
    config.getString("secret"),  // awsSecretAccessKey
    config.getString("app"),     // applicationName
    config.getString("version"), // applicationVersion
    initClientConfig(config.getString("locale")) // config
  )

  /**
   * Initializes an MWS Products Config using the
   * appropriate endpoint and version (which are
   * defined in resources/mws.conf)
   */
  protected def initClientConfig(locale: String) = {

    val config = ConfigFactory.load("mws").getConfig("mws")
    val serviceUrl = "%s/%s".format(config.getConfig("endpoints").getString(locale), config.getString("version"))
    Console.println(serviceUrl)

    val clientConfig = new MarketplaceWebServiceProductsConfig()
    clientConfig.setServiceURL(serviceUrl)

    clientConfig
  }
}