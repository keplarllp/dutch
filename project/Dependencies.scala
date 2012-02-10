import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    ScalaToolsSnapshots,
    "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
  )

  object V {
    val config    = "0.2.1"
    val argot     = "0.3.5"
  }

  object Libraries {
    // Used for Typesafe Config
    val config      = "com.typesafe.config"              % "config"  % V.config

    // User for Argot
    val argot       = "org.clapper"                      % "argot"   % V.argot
  }
}
