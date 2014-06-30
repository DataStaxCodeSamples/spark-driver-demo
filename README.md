spark-driver-demo
=================

# set up
if the spark driver is not yet on maven,  
```
git clone https://github.com/DataStaxCodeSamples/spark-driver

cd spark-driver

sbt publishLocal #this install it into the local .m2 directory

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

  ./bin/sbt run #runs src/main/scala/test.scala
```

== if you have dse
```
  dse spark
  
  use cassandra_spark_mlbdata;

shark> select master.*,schoolsplayers.schoolid from master join schoolsplayers where schoolsplayers.playerid=master.playerid limit 50;
```
Time taken: 4.146 second

 
  dse spark

  println("count: " + allstarful.count)

  val allstarful = sc.cassandraTable("demo", "allstarfull")


### with either dse or cassandra


**cqlsh>** select count(*) from cassandra_spark_mlbdata.appearances_by_player_year limit 10000000;

    count
   -------
    98146

(1 rows)

```
sbt consoleQuick
:paste
 val sparkConf = new SparkConf(true)
  .set("cassandra.connection.host", "127.0.0.1")
  .setMaster("local[2]")
  .setAppName("spark-driver-demo")
  
  val sc = new SparkContext("local[2]", "test", sparkConf)
  val allstarful = sc.cassandraTable("demo", "allstarfull")
^D
```
how is my data divided up?
 allstarful.partitions;
res5: Array[org.apache.spark.Partition] = Array(CassandraPartition(0,Set(/127.0.0.1),Vector(CqlTokenRange(token("playerid") > -1759687600836599613), CqlTokenRange(token("playerid") <= -1759687600836599613)),1920))
