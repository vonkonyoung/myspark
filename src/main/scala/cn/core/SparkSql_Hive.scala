import org.apache.spark
import org.apache.spark.sql.SparkSession

object SparkSql_Hive {


  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Java Spark Hive Example")
      .master("local[*]")
      .config("spark.sql.warehouse.dir","/user/hive/warehouse")
      .config("hive.metastore.uris", "thrift://hadoop-master:9083")
      .enableHiveSupport()
      .getOrCreate();
    spark.sql("show databases").show();
    val sql1 = "use default"
    spark.sql(sql1)
    //查看该库下的表结构
    val sql2 = "show tables"
    spark.sql(sql2).show()
    val sql3 = "use toutiao"
    spark.sql(sql3)
    //查看该库下的表结构
    val sql4 = "show tables"
    spark.sql(sql4).show()

    //创建SparkSession对象
//    val spark = SparkSession.builder()
//      .appName(this.getClass.getSimpleName)
//      .master("local[*]")
//      .config("dfs.client.use.datanode.hostname", "true")
//      .enableHiveSupport()
//      .getOrCreate()
//    //指定库名
//    val sql1 = "use toutiao"
//    spark.sql(sql1)
//    //查看该库下的表结构
//    val sql2 = "show tables"
//    spark.sql(sql2).show()
//    //读取hivemydb库下per表
//    val sql3 = "select * from toutiao.user_basic"
//    spark.sql(sql3).show()
  }
}

