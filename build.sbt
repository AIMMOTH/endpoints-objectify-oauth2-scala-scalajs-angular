enablePlugins(ScalaJSPlugin)

name := "SBT for Scala.js build"

scalaVersion := "2.11.7"

scalaSource in Compile := baseDirectory.value / "src" / "main" / "scalajs"

val jsDir = "src/main/webapp" // Output dir for JavaScript generation

crossTarget in (Compile, fastOptJS) := file(jsDir)
