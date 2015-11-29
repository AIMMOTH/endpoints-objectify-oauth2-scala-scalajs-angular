enablePlugins(ScalaJSPlugin)

name := "SBT for Scala.js build"

scalaVersion := "2.11.7"

scalaSource in Compile := baseDirectory.value / "src" / "main" / "scalajs"

val jsDir = "src/main/webapp" // Output dir for JavaScript generation

crossTarget in (Compile, fastOptJS) := file(jsDir)

libraryDependencies ++= Seq(
    "biz.enef" %%% "scalajs-angulate" % "0.2.2",
    "com.googlecode.objectify" % "objectify" % "5.1.8"
  )