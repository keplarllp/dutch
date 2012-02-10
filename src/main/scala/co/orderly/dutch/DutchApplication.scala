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

// Scala
import scala.math

// Argot
import org.clapper.argot._

// Config
import com.typesafe.config.{Config, ConfigFactory}

object DutchApplication {

  // Argument specifications
  import ArgotConverters._

  val parser = new ArgotParser(
    generated.Settings.name,
    preUsage = Some("%s: Version %s. Copyright (c) 2012, %s.".format(
      generated.Settings.name,
      generated.Settings.version,
      generated.Settings.organization))
  )

  val config = parser.option[Config](List("c", "config"),
                                     "filename",
                                     "Configuration file. Defaults to resources/example.conf if not set") {
    (c, opt) =>

      opt.value match {
        case None => ConfigFactory.load("example")

        case Some(f) => {

          val file = new File(f)
          if (file.exists) {
            ConfigFactory.parseFile(file)
          } else {
            parser.usage("Configuration file %s does not exist".format(f))
            ConfigFactory.empty()
          }
        }
      }
  }

  val noError = parser.flag[Boolean](List("n", "noerror"),
                                     "Do not abort on error.")
  val users = parser.multiOption[String](List("u", "user"), "username",
                                         "User to receive email. Email " +
                                         "address is queried from " +
                                         "database.")

  val email = parser.multiOption[String](List("e", "email"), "emailaddr",
                                         "Address to receive emailed " +
                                         "results.") {
    (s, opt) =>

    val ValidAddress = """^[^@]+@[^@]+\.[a-zA-Z]+$""".r
    ValidAddress.findFirstIn(s) match {
      case None    => parser.usage("Bad email address \"" + s +
                                   "\" for " + opt.name + " option.")
      case Some(_) => s
    }
  }

  val output = parser.parameter[String]("outputfile",
                                        "Output CSV file to which to write.",
                                        false)

  val input = parser.multiParameter[File]("input",
                                          "Input CSV files to read. If not " +
                                          "specified, use stdin.",
                                          true) {
    (s, opt) =>

    val file = new File(s)
    if (! file.exists)
      parser.usage("Input file \"" + s + "\" does not exist.")

    file
  }

  // The guts of the program (omitted here)
  def runCoolTool = {
    Console.println("Running cool tool!")
  }

  // Main program
  def main(args: Array[String]) {
    try {
      parser.parse(args)
      runCoolTool
    }

    catch {
      case e: ArgotUsageException => println(e.message)
    }
  }
}
