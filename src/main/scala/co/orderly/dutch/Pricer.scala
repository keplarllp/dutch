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
import java.io.{Reader, FileReader => FR}

// Config
import com.typesafe.config.{Config, ConfigFactory}

// Scala
import scala.collection.JavaConverters._

// opencsv
import au.com.bytecode.opencsv._

// Amazon MWS Products
import com.amazonservices.mws.products.{MarketplaceWebServiceProductsConfig, MarketplaceWebServiceProductsClient}
import com.amazonservices.mws.products.model.{ASINListType, GetCompetitivePricingForASINRequest}

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
   * Immediately construct a PricerConfig object which
   * holds all of our configuration variables (not
   * including the ones from the case class'
   * constructor).
   */
  object PricerConfig {

    // From the merchant Config
    private val merchant = config.getConfig("merchant")
    private val locale   = merchant.getString("locale")
    val seller      = merchant.getString("seller")
    val marketplace = merchant.getString("marketplace")
    val key         = merchant.getString("key")
    val secret      = merchant.getString("secret")

    // From the mws Config
    private val mws = ConfigFactory.load("mws").getConfig("mws")
    private val endpoint   = mws.getConfig("endpoints").getString(locale) // Locale is the key into the endpoints hash
    private val apiVersion = mws.getString("version")
    val url = "%s/%s".format(endpoint, apiVersion)
  }

  /**
   * Executes a pricing run
   */
  def run() {

    getProducts(input).foreach(_.debug())
    val service = initService

    val request = new GetCompetitivePricingForASINRequest()
    request.setSellerId(PricerConfig.seller)
    request.setMarketplaceId(PricerConfig.marketplace)

    val asins = new java.util.ArrayList[String]()
    asins.add("0712670572")
    request.setASINList(new ASINListType(asins))

    val response = service.getCompetitivePricingForASIN(request)

    GetCompetitivePricingForASINAdapted.invokeGetCompetitivePricingForASIN(service, request)
  }

  /**
   * Recursive function to extract all of the product lines from
   * 1+ input files OR stdin. Calls parseInput to do the heavy
   * lifting.
   */
  protected def getProducts(input: Seq[File]): List[ProductLine] = input match {

    case Seq()     => parseProducts(io.Source.stdin.bufferedReader())
    case Seq(file) => parseProducts(new FR(file))
    case Seq(file, files@_*) => parseProducts(new FR(file)) ::: getProducts(files)
  }

  /**
   * Parses an input Reader using opencsv to extract the
   * ProductLines from it.
   */
  protected def parseProducts(input: Reader): List[ProductLine] = {

    val line = if (header) 1 else 0 // Number of rows to skip
    val csvReader = new CSVReader(input, separator, quoteChar, line)

    ProductLine.asCsv.parse(ProductLine.mappingStrategy, csvReader).asScala.toList
  }

  /**
   * Initializes an Amazon MWS Products Client
   */
  protected def initService = new MarketplaceWebServiceProductsClient(
    PricerConfig.key,           // awsAccessKeyId
    PricerConfig.secret,        // awsSecretAccessKey
    generated.Settings.name,    // applicationName
    generated.Settings.version, // applicationVersion
    initConfig                  // config
  )

  /**
   * Initializes an MWS Products Config using the
   * appropriate endpoint and version (which are
   * defined in resources/mws.conf)
   */
  protected def initConfig = {
    val serviceConfig = new MarketplaceWebServiceProductsConfig()
    serviceConfig.setServiceURL(PricerConfig.url)
    serviceConfig
  }
}