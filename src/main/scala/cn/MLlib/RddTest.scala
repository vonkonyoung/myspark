import org.apache.spark.{SparkConf, SparkContext}

object RddTest {

  def main(args: Array[String]): Unit = {

    val data=Array(1,2,3,4,5,6,7,8,9)
    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("WordCount");
    val sc = new SparkContext(conf)
    val distData=sc.parallelize(data,3)
    println(distData.take(3).mkString(","))

  }
}
