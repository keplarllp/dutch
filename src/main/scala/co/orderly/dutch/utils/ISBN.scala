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
package utils

/**
 *
 */
class ISBN extends ProductLine { // TODO: rename this (or maybe delete it?)

  protected val Isbn13 = """^\d{3}[-|\s]?(\d{9})[\d|X]$""".r

  /**
   * Convert an ISBN-13 to an ISBN-10
   */
  def isbn13to10(isbn13: String): String = isbn13 match {

    case Isbn13(partial) => partial + checksum(partial)
    case _ => throw new RuntimeException("\"%s\" is not a valid ISBN 13 number".format(isbn13))
  }

  /**
   * Calculate a checksum for a partial ISBN
   */
  protected def checksum(partial): Char = {

    val weight = (10 to 1 by -1).toList
    val checksum = 11 - ((partial.toList(), weight).zipped.map{ case (c, w) => c.asDigit * w }.reduceLeft(_+_) % 11)

    // Finally what we return depends on the checksum value
    checksum match {
      case 10 => 'X'
      case 11 => "0"
      case _  => checksum
    }
  }
}