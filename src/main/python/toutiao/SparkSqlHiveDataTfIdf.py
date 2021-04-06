import findspark
findspark.init()
from pyspark.sql import SparkSession,HiveContext


def segmenttation(partitions):
    import os
    import re

    import jieba
    import jieba.analyse
    import jieba.posseg as pseg
    import codecs

    abspath = "D:\\BaiduNetdiskDownload\\12.推荐系统\\01.黑马头条推荐系统项目\\data\\words"

    # 结巴加载用户词典
    userDict_path = os.path.join(abspath, "ITKeywords.txt")
    jieba.load_userdict(userDict_path)

    # 停用词文本
    stopwords_path = os.path.join(abspath, "stopwords.txt")

    def get_stopwords_list():
        """返回stopwords列表"""
        stopwords_list = [i.strip()
                          for i in codecs.open(stopwords_path).readlines()]
        return stopwords_list





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
    # spark_session.sql("show databases").show()
    spark_session.sql("use article")
    spark_session.sql("show tables").show()
    article_dataframe =spark_session.sql("select * from article_data limit 20")
    article_dataframe.rdd.mapPartitions(segmenttation).toDF(["article_id", "channel_id", "words"])


