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
import java.io.FileReader

// Config
import com.typesafe.config.Config

// Scala
import scala.collection.JavaConversions._

// opencsv
import au.com.bytecode.opencsv._
import bean.CsvToBean

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
  def run() { // TODO: change Seq[File] to Iterator[String]
    Console.println("Running pricing!")

    // for( ln <- io.Source.stdin.getLines ) println( ln )

    val line = if (header) 1 else 0

    // TODO: eurgh, assumes one file passed in
    val csvReader = new CSVReader(new FileReader(input(0)), separator, quoteChar, line)
    InputFile.asCsv.parse(InputFile.mappingStrategy, csvReader).foreach(_.debug())
  }
}