import play.sbt.PlayImport

name := "commercetools-sunrise-java-training"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

val sunriseFrameworkVersion = "0.9.0"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .configs(IntegrationTest, PlayTest)
  .settings(commonTestSettings)


resolvers ++= Seq (
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.bintrayRepo("commercetools", "maven")
)

libraryDependencies ++= Seq(
  cache,
  "com.commercetools.sunrise" %% "product-catalog" % sunriseFrameworkVersion,
  "com.commercetools.sunrise" %% "shopping-cart" % sunriseFrameworkVersion,
  "com.commercetools.sunrise" % "commercetools-sunrise-theme" % "0.59.0",
  "org.webjars" %% "webjars-play" % "2.5.0-2",
  "com.commercetools.sunrise.cms" % "cms-contentful" % "0.1.0"
)

//important otherwise we get linked hash maps
val jacksonVersion = "2.7.5"
dependencyOverrides ++= Set (
  "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-core" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.module" % "jackson-module-parameter-names" % jacksonVersion,
  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % jacksonVersion
)

/**
 * TEST SETTINGS
 */

lazy val PlayTest = config("pt") extend Test

lazy val commonTestSettings = itBaseTestSettings ++ ptBaseTestSettings ++ configCommonTestSettings("test,it,pt")

lazy val itBaseTestSettings = Defaults.itSettings ++ configTestDirs(IntegrationTest, "it")

lazy val ptBaseTestSettings = inConfig(PlayTest)(Defaults.testSettings) ++ configTestDirs(PlayTest, "pt") ++ Seq (
  libraryDependencies ++= Seq (
    javaWs % "pt"
  )
)

def configTestDirs(config: Configuration, folderName: String) = Seq(
  javaSource in config := baseDirectory.value / folderName,
  scalaSource in config := baseDirectory.value / folderName,
  resourceDirectory in config := baseDirectory.value / s"$folderName/resources"
)

def configCommonTestSettings(scopes: String) = Seq(
  testOptions += Tests.Argument(TestFrameworks.JUnit, "-v"),
  libraryDependencies ++= Seq (
    "org.assertj" % "assertj-core" % "3.0.0" % scopes,
    PlayImport.component("play-test") % scopes
  ),
  dependencyOverrides ++= Set (
    "junit" % "junit" % "4.12" % scopes
  )
)

//TODO put it into an sbt plugin
/**
  * TEMPLATE SETTINGS
  */


//val copyTemplateFiles = inputKey[Unit]("Copies the provided template files into the project to enable editing, e.g.: 'copyTemplateFiles common/logo.hbs cart.hbs'")
//
//copyTemplateFiles := Def.inputTaskDyn {
//  val args: Seq[String] = spaceDelimited("<arg>").parsed
//  val templatePaths: Seq[String] = args.map(filePath => "templates/" + filePath)
//  val confFolder: String = (resourceDirectory in Compile).value.getPath
//  runMainInCompile(confFolder, templatePaths)
//}.evaluated
//
//val copyI18nFiles = inputKey[Unit]("Copies the provided i18n files into the project to enable editing, e.g.: 'copyI18nFiles en/home.yaml de/home.yaml'")
//
//copyI18nFiles := Def.inputTaskDyn {
//  val args: Seq[String] = spaceDelimited("<arg>").parsed
//  val i18nPaths: Seq[String] = args.map(filePath => "i18n/" + filePath)
//  val confFolder: String = (resourceDirectory in Compile).value.getPath
//  runMainInCompile(confFolder, i18nPaths)
//}.evaluated
//
//def runMainInCompile(dest: String, args: Seq[String]) = Def.taskDyn {
//  (runMain in Compile in `sbt-tasks`).toTask(s" com.commercetools.sunrise.theme.WebjarsFilesCopier $dest ${args.mkString(" ")}")
//}

