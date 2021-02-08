package cn.study.core;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 本地测试的worldcount 程序
 */
public class WordCountLocal {
    public static void main(String[] args) {
        SparkConf conf=new SparkConf()
                .setAppName("wordCountLocal")
                .setMaster("local");
        JavaSparkContext sc=new JavaSparkContext(conf);
        JavaRDD<String> lines=sc.textFile("file:///C:\\Users\\fengjr\\Desktop\\账号.txt");
        JavaRDD<String> worlds=lines.flatMap(new FlatMapFunction<String, String>() {

            @Override
            public Iterable<String> call(String line) throws Exception {
                return Arrays.asList(line.split(" "));
            }
        });
        JavaPairRDD<String,Integer> pairs = worlds.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String word) throws Exception {
                return new Tuple2<String,Integer>(word,1);
            }
        });
        JavaPairRDD<String,Integer> reduceRdd=pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer num1, Integer num2) throws Exception {
                return num1+num2;
            }
        });
        reduceRdd.foreach(new VoidFunction<Tuple2<String, Integer>>() {
            @Override
            public void call(Tuple2<String, Integer> tuple2) throws Exception {
                System.out.println("key:"+tuple2._1+",value:"+tuple2._2);
            }
        });
//        lines.cache();

    }
}
