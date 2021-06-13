import org.apache.spark.{SparkConf, SparkContext}

object RddTest {

  def main(args: Array[String]): Unit = {

   
    val conf = new SparkConf()
      .setMaster("local[1]")
      .setAppName("WordCount");
    val sc = new SparkContext(conf)
    val rdd1=sc.parallelize(1 to 9,3)
    val rdd2=rdd1.map(x=>x*2)
    println(rdd2.collect().mkString(","))
    sc.stop()
//    createRdd(sc)



  }

  def createRdd(sc:SparkContext): Unit ={
    val data=Array(1,2,3,4,5,6,7,8,9)
    val distData=sc.parallelize(data,3)
    println(distData.take(3).mkString(","))
    sc.stop()
  }
}
