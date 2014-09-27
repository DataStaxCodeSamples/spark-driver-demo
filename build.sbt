name := "cassandra-driver-spark-test"

organization := "com.datastax.cassandra"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
 "org.apache.spark" %% "spark-core" % "0.9.1",
 "org.apache.spark" %% "spark-streaming" % "0.9.1",
 "net.jpountz.lz4" % "lz4" % "1.2.0",
 "com.datastax.spark" % "spark-cassandra-connector_2.10" % "1.1.0-alpha1"
)


EclipseKeys.withBundledScalaContainers := false

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
