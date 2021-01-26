import findspark
findspark.init()
from pyspark.sql import SparkSession

if __name__== '__main__':
    spark=SparkSession.builder.appName("mysqlSQL").getOrCreate()
    df=spark.read.json("people.json")
    df.createOrReplaceTempView("people")
    sqlDF=spark.sql("select * from people")
    sqlDF.show()
    # df.show()
    # df.printSchema()

    # df.select("name").show()
    # df.select()
    # print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
