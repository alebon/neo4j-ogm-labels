lazy val commonSettings = Seq(
  organization := "net.ersocon",
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.11.8"
)

name := "neo4j-ogm-labels"

version := "1.0.0-SNAPSHOT"

startYear := Some(2016)

fork := true

parallelExecution in Test := false

// COMMONS LOGGING VERSION
lazy val commonsLoggingVersion   = "1.2"

// COMMONS LOGGING DEPENDENCIES
libraryDependencies ++= Seq(
  "commons-logging" % "commons-logging" % commonsLoggingVersion
)

// LOGBACK VERSION
lazy val logbackVersion = "1.1.7"

// LOGBACK DEPENDENCIES
libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % logbackVersion
)

// JODA TIME VERSION
lazy val jodaTimeVersion = "2.9.4"

// JODA TIME DEPENDENCY
libraryDependencies += "joda-time" % "joda-time" % jodaTimeVersion

// NEO4J VERSION
lazy val neo4jVersion = "3.0.2"

// NEO4J DEPENDENCIES
libraryDependencies ++= Seq(
  "org.neo4j" % "neo4j" % neo4jVersion,
  "org.neo4j" % "neo4j-kernel" % neo4jVersion,
  "org.neo4j" % "neo4j-kernel" % neo4jVersion % Test classifier "tests",
  "org.neo4j" % "neo4j-io" % neo4jVersion,
  "org.neo4j" % "neo4j-io" % neo4jVersion % Test classifier "tests",
  "org.neo4j.app" % "neo4j-server" % neo4jVersion % Test classifier "tests",
  "org.neo4j.test" % "neo4j-harness" % neo4jVersion % Test,
  "org.neo4j.test" % "neo4j-harness" % neo4jVersion % Test classifier "tests"
)

// NEO4J OGM VERSION
lazy val neo4jOgmVersion   = "2.0.4"

// NEO4J OGM DEPENDENCIES
libraryDependencies ++= Seq(
  "org.neo4j" % "neo4j-ogm-core" % neo4jOgmVersion exclude("org.neo4j", "neo4j"),
  "org.neo4j" % "neo4j-ogm-bolt-driver" % neo4jOgmVersion exclude("org.neo4j", "neo4j"),
  "org.neo4j" % "neo4j-ogm-embedded-driver" % neo4jOgmVersion exclude("org.neo4j", "neo4j")
)

// NEO4J OGM TEST DEPENDENCIES
libraryDependencies ++= Seq(
  "org.neo4j" % "neo4j-ogm-test" % neo4jOgmVersion  % Test,
  "com.sun.jersey" % "jersey-core" % "1.19.1"  % Test,
  "com.sun.jersey" % "jersey-server" % "1.19.1"  % Test
)

// SCALA-TEST VERSION
val scalaTestVersion = "2.2.6"

// SCALA-TEST DEPENDENCY
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test
)

resolvers ++= Seq(
  "Scala Tools Releases" at "http://scala-tools.org/repo-releases/",
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Public" at "http://oss.sonatype.org/content/groups/public",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
  "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Jetty Eclipse" at "http://repo1.maven.org/maven2/",
  "JCenter" at "http://jcenter.bintray.com/",
  "apache.repo" at "https://repository.apache.org/content/repositories/snapshots/"
)

resolvers += Resolver.mavenLocal

lazy val rootProject = (project in file(".")).
  settings(commonSettings: _*)
