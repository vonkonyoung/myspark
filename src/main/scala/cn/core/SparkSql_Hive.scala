import org.apache.spark.sql.SparkSession

object SparkSql_Hive {


  def main(args: Array[String]): Unit = {
    //创建SparkSession对象
    val spark = SparkSession.builder()
      .appName(this.getClass.getSimpleName)
      .master("local[*]")
      .config("dfs.client.use.datanode.hostname", "true")
      .enableHiveSupport()
      .getOrCreate()
    //指定库名
    val sql1 = "use toutiao"
    spark.sql(sql1)
    //查看该库下的表结构
    val sql2 = "show tables"
    spark.sql(sql2).show()
    //读取hivemydb库下per表
    val sql3 = "select * from toutiao.user_basic"
    spark.sql(sql3).show()
  }
}

