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
  
  val sc = new SparkContext("127.0.0.1", "test", sparkConf)
  val ssc =  new StreamingContext(sparkConf, Seconds(1))
  val allstarful = sc.cassandraTable("demo", "allstarfull")
  
  //println("count: " + rdd.count)
  
  //allstarful.foreach(println(_))
//  println("first: " + rdd.first)
}