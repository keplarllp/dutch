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

// Specs2
import org.specs2.mutable.Specification

// Dutch
import utils._

class IsbnTest extends Specification {

  // List of tuples of correct ISBN-13, ISBN-10s
  val isbns = List(("978-1449398583", "1449398588"),
                   ("978-1934356593", "193435659X"),
                   ("978-0596805784", "0596805780"),
                   ("9780596805524", "0596805527"),
                   ("9780596802790", "059680279X"),
                   ("9781593272821", "1593272820"),
                   ("978 0981531649", "0981531644"),
                   ("978 0470227800", "047022780X"),
                   ("978 0321733016", "0321733010"))

  isbns.foreach { case (isbn13, isbn10) =>
    "The ISBN-10 version of %s".format(isbn13) should {
      "equal %s".format(isbn10) in {
        Isbn.isbn13to10(isbn13) must be_==(isbn10)
      }
    }
  }
}
