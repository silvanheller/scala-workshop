import sbt.Keys._
import sbt.{ExclusionRule, project, _}

name := "scala-workshop"

lazy val commonSettings = Seq(
  organization := "ch.unibas.dmi.fmi",
  scalaVersion := "2.11.8"
)

//build
lazy val buildSettings = Seq(
  scalaVersion := "2.11.8",
  crossScalaVersions := Seq("2.11.8"),
  ivyScala := ivyScala.value.map(_.copy(overrideScalaVersion = true))
)

//projects
lazy val root = (project in file(".")).
  settings(commonSettings: _*)

unmanagedResourceDirectories in Compile += baseDirectory.value / "conf"
scalacOptions ++= Seq("-target:jvm-1.7")

//lib resolvers
resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Restlet Repositories" at "http://maven.restlet.org"
)
resolvers += Resolver.sonatypeRepo("snapshots")

//base libs
val baseLibs = Seq(
  "org.scala-lang" % "scala-compiler" % "2.11.8",
  "org.scala-lang" % "scala-reflect" % "2.11.8"
)

//libs
//Spark is just an example here.
val coreLibs = Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.1.0" excludeAll ExclusionRule("org.apache.hadoop"), //make sure that you use the same spark version as in your deployment!
).map(
  _.excludeAll(
    ExclusionRule("org.scala-lang"),
    ExclusionRule("org.slf4j", "slf4j-api")
  )
)

//secondary libs
val secondaryLibs = Seq(
  "org.apache.commons" % "commons-lang3" % "3.4",
  "org.apache.commons" % "commons-math3" % "3.4.1"
).map(
  _.excludeAll(
    ExclusionRule("org.scala-lang"),
    ExclusionRule("org.slf4j", "slf4j-api")
  )
)

//log libs
val logLibs = Seq(
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "org.slf4j" % "slf4j-log4j12" % "1.7.25"
)


libraryDependencies := baseLibs ++ coreLibs ++ secondaryLibs ++ logLibs

//Include all jars which are in the /lib folder
unmanagedBase <<= baseDirectory { base => base / "lib" }
//Resources are in /conf
unmanagedResourceDirectories in Compile += baseDirectory.value / "conf"

//provided libraries should be included in "run"
run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in(Compile, run), runner in(Compile, run))




