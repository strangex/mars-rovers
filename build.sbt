name := "mars"

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
  "org.rogach" %% "scallop" % "3.2.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
)
