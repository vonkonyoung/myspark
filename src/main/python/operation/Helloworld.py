
import findspark
findspark.init()
from pyspark import SparkContext,SparkConf

def f(x): print(x)

conf=SparkConf().setMaster("local[1]").setAppName("helloworld")
sc=SparkContext(conf=conf)
data=[1,2,3,5,6]
distData=sc.parallelize(data)
# distData.repartition(3)
# distData.foreach(f)
distData.cache().count()
print(distData.collect())

sc.stop()
