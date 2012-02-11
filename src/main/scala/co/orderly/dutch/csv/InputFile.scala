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

// opencsv
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy

/**
 * InputFile is the file structure which we expect any input CSV (including
 * from stdin) to take. This is defined as a Java bean so that it plays
 * nicely with opencsv:
 *
 *   http://opencsv.sourceforge.net/#javabean-integration
 */
class InputFile {

  @BeanProperty
  var blah: String = _
}