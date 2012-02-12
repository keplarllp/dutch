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

// Java
import java.lang.{Float => JFloat}

// Scala
import scala.reflect.BeanProperty

// opencsv
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy

/**
 * OutputFile is the file structure which we will populate for the output
 * CSV file. This is defined as a Java bean so that it plays nicely with
 * opencsv:
 *
 *   http://opencsv.sourceforge.net/#javabean-integration
 * 
 * OutputFile extends from InputFile because all of the fields from
 * InputFile are also included in the OutputFile, for simplicity.
 */
class OutputFile extends InputFile {

  @BeanProperty
  var amazonPrice: JFloat = _
  
  @BeanProperty
  var merchants: Int = _
  
  @BeanProperty
  var merchantLowestPrice = JFloat = _
}