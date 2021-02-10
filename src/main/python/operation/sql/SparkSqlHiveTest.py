import findspark
findspark.init()
from pyspark.sql import SparkSession,HiveContext

if __name__== '__main__':
    # spark=SparkSession.builder.appName("mysqlSQL").getOrCreate()
    # df=spark.read.json("people.json")
    # df.createOrReplaceTempView("people")
    # sqlDF=spark.sql("select * from people")
    # sqlDF.show()

    _SPARK_HOST = "local[1]"
    # _SPARK_HOST = "spark://192.168.1.137:7077"
    _APP_NAME = "test"
    spark_session = SparkSession\
        .builder.master(_SPARK_HOST)\
        .appName(_APP_NAME)\
        .enableHiveSupport()\
        .config("hive.metastore.uris", "thrift://hadoop-master:9083")\
        .config("spark.sql.warehouse.dir","/user/hive/warehouse")\
        .getOrCreate()
    # hive_context = HiveContext(spark_session)
    spark_session.sql("show databases").show()
    spark_session.sql("use toutiao")
    spark_session.sql("show tables").show()
    spark_session.sql("select * from user_profile limit 2").show()


