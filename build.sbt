import sbt.complete.DefaultParsers._

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


//TODO put it into an sbt plugin
/**
  * TEMPLATE SETTINGS
  */

val copyTemplateFiles = inputKey[Unit]("Copies the provided template files into the project to enable editing, e.g.: 'copyTemplateFiles common/logo.hbs cart.hbs'")

copyTemplateFiles := Def.inputTaskDyn {
  val args: Seq[String] = spaceDelimited("<arg>").parsed
  val templatePaths: Seq[String] = args.map(filePath => "templates/" + filePath)
  val confFolder: String = (resourceDirectory in Compile).value.getPath
  runMainInCompile(confFolder, templatePaths)
}.evaluated

val copyI18nFiles = inputKey[Unit]("Copies the provided i18n files into the project to enable editing, e.g.: 'copyI18nFiles en/home.yaml de/home.yaml'")

copyI18nFiles := Def.inputTaskDyn {
  val args: Seq[String] = spaceDelimited("<arg>").parsed
  val i18nPaths: Seq[String] = args.map(filePath => "i18n/" + filePath)
  val confFolder: String = (resourceDirectory in Compile).value.getPath
  runMainInCompile(confFolder, i18nPaths)
}.evaluated

def runMainInCompile(dest: String, args: Seq[String]) = Def.taskDyn {
  (runMain in Compile in `sbt-tasks`).toTask(s" tasks.WebjarsFilesCopier $dest ${args.mkString(" ")}")
}