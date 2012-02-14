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
import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    ScalaToolsSnapshots,
    "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
  )

  object V {
    // Libraries for Pricer
    val config    = "0.2.1"
    val argot     = "0.3.5"
    val opencsv   = "2.0"

    // MWS - all the versions which come bundled with amazon-mws-v20111001-java-2012-01-01._V139771867_.zip
    val logging   = "1.1"
    val log4j     = "1.2.14"
    val http      = "3.0.1"
    val codec     = "1.3"
  }

  object Libraries {
    // Used for Typesafe Config
    val config      = "com.typesafe.config"        % "config"               % V.config

    // User for Argot
    val argot       = "org.clapper"                % "argot_2.9.0"          % V.argot

    // Used for reading/writing CSV files
    val opencsv     = "net.sf.opencsv"             % "opencsv"              % V.opencsv
  }

  object Mws {
    // Logging
    val logging     = "commons-logging"            % "commons-logging"      % V.logging
    val log4j       = "log4j"                      % "log4j"                % V.log4j

    // Apache HttpClient
    val http        = "commons-httpclient"         % "commons-httpclient"   % V.http
    val codec       = "commons-codec"              % "commons-codec"        % V.codec
  }
}
