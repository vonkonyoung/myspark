import findspark
findspark.init()
from pyspark import SparkConf,SparkContext

if __name__ == '__main__':
    conf=SparkConf().setMaster("local[2]").setAppName("spark2021")
    sc=SparkContext(conf=conf)

    def my_map():
        data=[1,2,3,4,5]
        rdd1=sc.parallelize(data)
        rdd2=rdd1.map(lambda x:x*2)
        print(rdd2.collect())

    def my_map2():
        data=["dog","cat","lion","panda","dog","cat","dog"]
        rdd1=sc.parallelize(data)
        rdd2=rdd1.map(lambda x:(x,1))
        print(rdd2.collect())

    def my_filter():
        data=[1,2,3,4,5]
        rdd1=sc.parallelize(data)
        rdd2=rdd1.map(lambda x:x*2)
        filterRdd=rdd2.filter(lambda x:x>5)
        print(filterRdd.collect())

    def my_filter2():
        print(sc.parallelize([1,2,3,4,5]).map(lambda x:x*2).filter(lambda x:x>5).collect())

    def flatMap():
        data=["hello spark","hello world","hello world"]
        rdd=sc.parallelize(data)
        print(rdd.flatMap(lambda line:line.split(" ")).collect())


    def my_groupBy():
        data=["hello spark","hello world","hello world"]
        rdd= sc.parallelize(data)
        mapRdd=rdd.flatMap(lambda line:line.split(" ")).map(lambda x:(x,1))
        groupByRdd=mapRdd.groupByKey()
        mapRdd.groupBy()
        print(groupByRdd.collect())
        print(groupByRdd.map(lambda x:{x[0]:list(x[1])}).collect())

    def my_reduceByKey():
        print(sc.parallelize(["hello world","hello spark","hello fengjr"]).flatMap(lambda line:line.split(" ")).map(lambda x:(x,1)).reduceByKey(lambda a,b:a+b).sortBy(lambda x:x[1]).collect())

    def union():
        a=sc.parallelize([1,2,3])
        b=sc.parallelize([3,4,5])
        c=a.union(b)
        print(c.collect())
        print(c.distinct().collect())

    def my_join():
         a=sc.parallelize([("A","a1"),("B","b1"),("C","c1")])
         b=sc.parallelize([("A","a2"),("B","b2")])
         print(a.join(b).collect())
         print(a.rightOuterJoin(b).collect())
         print(a.leftOuterJoin(b).collect())


    def my_action():
         data=[1,2,3,4,5,6,7,8,9.10]
         rdd=sc.parallelize(data)
         print(rdd.count())
         print(rdd.take(3))
         print(rdd.max())
         print(rdd.collect())
         print(rdd.reduce(lambda a,b:a+b))
         print(rdd.foreach(lambda x:print(x)))







    #
    # my_filter()
    # my_filter2()
    # flatMap()
    # my_groupBy()
    # my_reduceByKey()
    # union()
    # my_join()
    my_action()
    sc.stop()
