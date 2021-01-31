import org.apache.spark.{SparkConf, SparkContext, rdd}

object SimpleApp {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Simple Application").setMaster("spark://192.168.1.137:7077")
    val sc = new SparkContext(conf)
    val arr=Array(1,2,3,4,5)
    val arrRdd=sc.parallelize(arr)
//    val logData = sc.textFile(logFile, 2).cache()
    val numAs = arrRdd.map(num=>num).count()
//    val numBs = logData.filter(line => line.contains("b")).count()
//    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }

}
