name := "mars-rovers"

version := "0.0"

scalaVersion := "2.12.8"

scalacOptions ++= Seq(
  "-encoding", "utf-8",
  "-explaintypes",
  "-Ypartial-unification",
  "-feature",
  "-deprecation",
  "-Xlint:infer-any",
  "-Xlint:inaccessible",
  "-Ywarn-inaccessible",
  "-Ywarn-unused:imports",
  "-Xfatal-warnings",
)

scalacOptions in (Compile, console) --= Seq(
  "-Ywarn-unused:imports",
  "-Xfatal-warnings"
)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2",
  "org.typelevel" %% "cats-effect" % "1.3.1",
  "org.rogach" %% "scallop" % "3.2.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
  "wolfendale" %% "scalacheck-gen-regexp" % "0.1.1" % "test"
)
