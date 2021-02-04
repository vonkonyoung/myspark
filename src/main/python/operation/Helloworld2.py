
import findspark
findspark.init()
from pyspark import SparkContext,SparkConf
from pyspark import SparkConf

def printData(x):print("输出元素为%d：",x)
conf = SparkConf().setAppName("miniProject").setMaster("local[*]")
sc=SparkContext.getOrCreate(conf)
rdd=sc.parallelize([1,2,3,4,5])
rdd1=rdd.map(lambda r:r+10)
rdd1.repartition(3)
rdd1.foreach(printData)
print(rdd1.collect())

sc.stop()
