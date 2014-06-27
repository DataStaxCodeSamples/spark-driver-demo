spark-driver-demo
=================


install Cassandra or DataStax Enterprise

  git clone git@github.com:DataStaxCodeSamples/spark-driver-demo.git

  cd spark-driver-demo

  cd data

  wget http://seanlahman.com/files/database/lahman-csv_2014-02-14.zip

  unzip lahman-csv_2014-02-14.zip
  
  cqlsh < ../src/main/resources/cql/schema.cql 

  cqlsh < ../src/main/resources/cql/load_data.cql

  ./bin/sbt run

