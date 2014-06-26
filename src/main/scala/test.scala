import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import com.datastax.driver.spark._
import org.apache.spark.streaming.Seconds

object test extends App {
  val sparkConf = new SparkConf(true)
  .set("cassandra.connection.host", "127.0.0.1")
  .setMaster("local[2]")
  .setAppName("spark-driver-demo")
  
  val sc = new SparkContext("local", "test", sparkConf)
  val ssc =  new StreamingContext(sparkConf, Seconds(1))
  val rdd = sc.cassandraTable("demo", "data")
  
  println("count: " + rdd.count)
  println("first: " + rdd.first)
}