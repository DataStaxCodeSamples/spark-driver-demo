spark-driver-demo
=================

Download the CSV data from
cd data
wget http://seanlahman.com/files/database/lahman-csv_2014-02-14.zip
unzip lahman-csv_2014-02-14.zip

cqlsh < ../src/main/resources/cql/schema.cql 
cqlsh < ../src/main/resources/cql/load_data.cql

