import findspark
findspark.init()

import pyspark.sql.functions as F
import gc
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
    # spark_session.sql("select * from user_profile limit 2").show()
    basic_content=spark_session.sql("select a.article_id, a.channel_id, a.title, b.content from news_article_basic a inner join news_article_content b on a.article_id=b.article_id where a.article_id=116636")
    basic_content.registerTempTable("temparticle")
    channel_basic_content=spark_session.sql("select t.*, n.channel_name from temparticle t left join news_channel n on t.channel_id=n.channel_id")
    spark_session.sql("use article")
    sentence_df = channel_basic_content.select("article_id", "channel_id", "channel_name", "title", "content", \
                                           F.concat_ws(
                                             ",",
                                             channel_basic_content.channel_name,
                                             channel_basic_content.title,
                                             channel_basic_content.content
                                           ).alias("sentence")
                                          )
    del basic_content
    del channel_basic_content
    gc.collect()

    # sentence_df.write.insertInto("article_data1")

