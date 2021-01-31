import findspark
findspark.init()
from pyspark.sql import SparkSession,HiveContext

if __name__== '__main__':
    # spark=SparkSession.builder.appName("mysqlSQL").getOrCreate()
    # df=spark.read.json("people.json")
    # df.createOrReplaceTempView("people")
    # sqlDF=spark.sql("select * from people")
    # sqlDF.show()

    # _SPARK_HOST = "local[1]"
    _SPARK_HOST = "spark://192.168.1.137:7077"
    _APP_NAME = "test"
    spark_session = SparkSession.builder.master(_SPARK_HOST).appName(_APP_NAME).getOrCreate()
    hive_context = HiveContext(spark_session)
    # 生成查询的SQL语句，这个跟hive的查询语句一样，所以也可以加where等条件语句
    hive_database = "toutiao"
    hive_table = "user_basic"
    hive_read = "select * from {}.{}".format(hive_database, hive_table)
    # 通过SQL语句在hive中查询的数据直接是dataframe的形式
    read_df = hive_context.sql(hive_read)
    read_df.show()

    # data = [
    #     (1, "3", "145"),
    #     (1, "4", "146"),
    #     (1, "5", "25"),
    #     (1, "6", "26"),
    #     (2, "32", "32"),
    #     (2, "8", "134"),
    #     (2, "8", "134"),
    #     (2, "9", "137")
    # ]
    # df = spark_session.createDataFrame(data, ['id', "test_id", 'camera_id'])
    # # method one，default是默认数据库的名字，write_test 是要写到default中数据表的名字
    # df.registerTempTable('test_hive')
    # hive_context.sql("create table default.write_test select * from test_hive")