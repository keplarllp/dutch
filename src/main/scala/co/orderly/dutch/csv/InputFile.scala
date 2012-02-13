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
package csv

// Scala
import scala.reflect.BeanProperty
import au.com.bytecode.opencsv.bean.{CsvToBean, ColumnPositionMappingStrategy}

// opencsv
/**
 * Companion object for InputFile, containing the ColumnPositionMappingStrategy
 * generator which uses InputFile
 */
object InputFile {

  // The columns in an input file
  private val columns = Array("name", "supplier", "asin", "sku", "isbn")

  /**
   * Returns the mapping strategy for this InputFile.
   * The mapping strategy is positional (rather than
   * column name based), because our input file(s)
   * may not come with a header row.
   */
  def mappingStrategy = {

    val strat = new ColumnPositionMappingStrategy[InputFile]()
    strat.setType(classOf[InputFile])
    strat.setColumnMapping(columns)

    strat
  }

  /**
   * Creates a typed CsvToBean for InputFile
   */
  def asCsv = new CsvToBean[InputFile]()
}

/**
 * InputFile is the file structure which we expect any input CSV (including
 * from stdin) to take. This is defined as a Java bean so that it plays
 * nicely with opencsv:
 *
 *   http://opencsv.sourceforge.net/#javabean-integration
 */
class InputFile {

  @BeanProperty
  var name: String = _

  @BeanProperty
  var supplier: String = _

  @BeanProperty
  var asin: String = _

  @BeanProperty
  var sku: String = _

  @BeanProperty
  var isbn: String = _

  def debug() {
    Console.println("%s:%s:%s:%s:%s".format(name, supplier, asin, sku, isbn))
  }
}