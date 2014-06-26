name := "cassandra-driver-spark-test"

organization := "com.datastax.cassandra"

version := "0.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
 "org.apache.spark" %% "spark-core" % "0.9.1",
 "org.apache.spark" %% "spark-streaming" % "0.9.1",
 "com.datastax.cassandra" %% "cassandra-driver-spark" % "0.9.1",
 "net.jpountz.lz4" % "lz4" % "1.2.0"
)


EclipseKeys.withBundledScalaContainers := false

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
