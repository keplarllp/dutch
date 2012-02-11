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

// Argot
import org.clapper.argot._

// Config
import com.typesafe.config.Config

/**
 * Pricer is the pricing module for Dutch
 */
object Pricer {

  /**
   * Executes a pricing run
   */
  def run(config: Config, input: Seq[File], output: String) { // TODO: change Seq[File] to Iterator[String]
    Console.println("Running pricing!")
    for( ln <- io.Source.stdin.getLines ) println( ln )
  }
}