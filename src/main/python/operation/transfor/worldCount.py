import findspark
findspark.init()
from pyspark import  SparkContext,SparkConf

if __name__=='__main__':
    conf=SparkConf().setAppName("worldCount").setMaster("local[2]")
    sc=SparkContext(conf=conf)
    textRdd=sc.textFile("file:///C://Users//Lenovo//Desktop//hello.txt")
    mappRdd=textRdd.flatMap(lambda line:line.split(" ")).map(lambda x:(x,1))
    reduceRdd=mappRdd.reduceByKey(lambda a,b:a+b)
    sortRdd=reduceRdd.sortBy(lambda x:x[1],False)
    print(sortRdd.collect())
    print(sortRdd.take(2))
    sc.stop()