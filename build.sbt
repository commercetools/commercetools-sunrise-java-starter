name := """sunrise-java-demo"""

version := "0.1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

resolvers ++= Seq (
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

val sunriseFrameworkVersion = "0.7.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache,
  javaWs,
  "com.commercetools.sunrise" %% "product-catalog" % sunriseFrameworkVersion,
  "com.commercetools.sunrise" %% "shopping-cart" % sunriseFrameworkVersion,
  "io.commercetools.sunrise" % "commercetools-sunrise-theme" % "0.56.0",
  "org.webjars" %% "webjars-play" % "2.5.0-2"
)

val jacksonVersion = "2.6.0"

//important otherwise we get linked hash maps
dependencyOverrides ++= Set (
  "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.module" % "jackson-module-parameter-names" % jacksonVersion,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % jacksonVersion
)


//fork in run := true