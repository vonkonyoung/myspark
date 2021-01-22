package cn.core

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

/**
 * @author Administrator
 */
object WordCount {
  
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local[1]")
        .setAppName("WordCount");
    val sc = new SparkContext(conf)

//    val lines = sc.textFile("hdfs://spark1:9000/spark.txt", 1);
    val lines = sc.textFile("file:///C://Users//fengjr//Desktop/工作进展.txt", 1);
    val words = lines.flatMap { line => line.split(" ") }
    val pairs = words.map { word => (word, 1) }
    val wc = pairs.reduceByKey { _ + _ }

    wc.foreach(wc => println(wc._1 + " appeared " + wc._2 + " times."))
  }
  
}