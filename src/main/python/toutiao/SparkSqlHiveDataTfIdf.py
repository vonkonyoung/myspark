import findspark
findspark.init()
from pyspark.sql import SparkSession,HiveContext


def segmenttation(partition):
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

# 所有的停用词列表
    stopwords_list = get_stopwords_list()

    # 分词
    def cut_sentence(sentence):
        """对切割之后的词语进行过滤，去除停用词，保留名词，英文和自定义词库中的词，长度大于2的词"""
        # print(sentence,"*"*100)
        # eg:[pair('今天', 't'), pair('有', 'd'), pair('雾', 'n'), pair('霾', 'g')]
        seg_list = pseg.lcut(sentence)
        seg_list = [i for i in seg_list if i.flag not in stopwords_list]
        filtered_words_list = []
        for seg in seg_list:
            # print(seg)
            if len(seg.word) <= 1:
                continue
            elif seg.flag == "eng":
                if len(seg.word) <= 2:
                    continue
                else:
                    filtered_words_list.append(seg.word)
            elif seg.flag.startswith("n"):
                filtered_words_list.append(seg.word)
            elif seg.flag in ["x", "eng"]:  # 是自定一个词语或者是英文单词
                filtered_words_list.append(seg.word)
        return filtered_words_list

    for row in partition:
        sentence = re.sub("<.*?>", "", row.sentence)    # 替换掉标签数据
        words = cut_sentence(sentence)
        yield row.article_id, row.channel_id, words

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
    article_dataframe =spark_session.sql("select * from article_data limit 5")
    # spark_session.sql("select * from article_data limit 5").show()
    article_dataframe.rdd.mapPartitions(segmenttation).toDF(["article_id", "channel_id", "words"]).show()


