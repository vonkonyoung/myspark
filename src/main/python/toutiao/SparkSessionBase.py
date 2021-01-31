from pyspark import SparkContext,SparkConf
from pyspark.sql import SparkSession

class SparkSessionBase(object):
    SPARK_APP_NAME=None
    SPARK_URL="local[1]"
    SPARK_EXECUTOR_MEMORY = "2g"
    SPARK_EXECUTOR_CORES = 2
    SPARK_EXECUTOR_INSTANCES = 2
    ENABLE_HIVE_SUPPORT = False

    def _create_spark_session(self):
        #1、创建配置
        '''给spark程序创建初始化spark session'''
        conf=SparkConf()
        config=(
            ("spark.app.name", self.SPARK_APP_NAME),  # 设置启动的spark的app名称，没有提供，将随机产生一个名称
            ("spark.executor.memory", self.SPARK_EXECUTOR_MEMORY),  # 设置该app启动时占用的内存用量，默认2g
            ("spark.master", self.SPARK_URL),  # spark master的地址
            ("spark.executor.cores", self.SPARK_EXECUTOR_CORES),  # 设置spark executor使用的CPU核心数，默认是1核心
            ("spark.executor.instances", self.SPARK_EXECUTOR_INSTANCES)
        )
        conf.setAll(config)
        #读取配置初始化
        if self.ENABLE_HIVE_SUPPORT:
            return SparkSession.builder.config(conf=conf).enableHiveSupport().getOrCreate()
        else:
            return SparkSession.builder.config(conf=conf).getOrCreate()


