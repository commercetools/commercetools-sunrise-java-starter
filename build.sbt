name := """sunrise-java-demo"""

version := "0.1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

resolvers ++= Seq (
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "io.commercetools.sunrise" %% "product-catalog" % "0.7.0-framework-SNAPSHOT"
)


fork in run := true