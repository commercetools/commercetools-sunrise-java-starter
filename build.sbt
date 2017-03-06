
name := "commercetools-sunrise-java-starter"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

val sunriseFrameworkVersion = "0.17.0"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, SunriseThemeImporterPlugin)
  .configs(IntegrationTest, TestCommon.PlayTest)
  .settings(TestCommon.defaultSettings)
  .settings(sunriseThemeJarName in Compile := "commercetools-sunrise-theme")

resolvers ++= Seq (
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.bintrayRepo("commercetools", "maven")
)

libraryDependencies ++= Seq(
  cache,
  "com.commercetools.sunrise" %% "product-catalog" % sunriseFrameworkVersion,
  "com.commercetools.sunrise" %% "shopping-cart" % sunriseFrameworkVersion,
  "com.commercetools.sunrise" %% "my-account" % sunriseFrameworkVersion,
  "com.commercetools.sunrise" % "commercetools-sunrise-theme" % "0.64.0",
  "org.webjars" %% "webjars-play" % "2.5.0-2"
)