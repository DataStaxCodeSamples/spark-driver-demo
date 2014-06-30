spark-driver-demo
=================

The code in this repo, and the instructions below use the new Cassandra/Spark integration open sourced by datastax.

See https://github.com/riptano/spark-driver for more details

It uses a set of csv files containing historical MLB statistics. loads them int using the cqlsh COPY command, and then demonstrates use of spark from scala, joins from shark (using DataStax Enterprise), 

# set up
if the spark driver is not yet on maven,  
```
git clone https://github.com/riptano/spark-driver

cd spark-driver

sbt publishLocal #this installs it into the local .m2 directory and allow maven (and sbt) to treat it as it were publicly published

cd ..
```

install Cassandra or DataStax Enterprise
```
  git clone git@github.com:DataStaxCodeSamples/spark-driver-demo.git

  cd spark-driver-demo
  
  cd data

  wget http://seanlahman.com/files/database/lahman-csv_2014-02-14.zip

  unzip lahman-csv_2014-02-14.zip
  
  cqlsh < ../src/main/resources/cql/schema.cql 

  cqlsh < ../src/main/resources/cql/load_data.cql
  
  cd ..

  ./bin/sbt run #runs src/main/scala/test.scala
```

if you have dse
```
  dse shark
  
  use cassandra_spark_mlbdata;

shark> select master.*,schoolsplayers.schoolid from master join schoolsplayers where schoolsplayers.playerid=master.playerid limit 50;

 
  dse spark

  val allstarful = sc.cassandraTable("demo", "allstarfull")

  println("count: " + allstarful.count)

 
```

with either dse or cassandra


```
cqlsh> select count(*) from cassandra_spark_mlbdata.appearances_by_player_year limit 10000000;

    count
   -------
    98146

(1 rows)
```

```
sbt consoleQuick
:paste
 val sparkConf = new SparkConf(true)
  .set("cassandra.connection.host", "127.0.0.1")
  .setMaster("local[2]")
  .setAppName("spark-driver-demo")
  
  val sc = new SparkContext("local[2]", "test", sparkConf)
  val allstarful = sc.cassandraTable("cassandra_spark_mlbdata", "allstarfull")
^D
```
how is my data divided up?
```
 allstarful.partitions;
res5: Array[org.apache.spark.Partition] = Array(CassandraPartition(0,Set(/127.0.0.1),Vector(CqlTokenRange(token("playerid") > -1759687600836599613), CqlTokenRange(token("playerid") <= -1759687600836599613)),1920))
```
