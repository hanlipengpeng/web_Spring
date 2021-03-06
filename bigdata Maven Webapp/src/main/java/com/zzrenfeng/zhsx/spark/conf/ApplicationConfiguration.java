package com.zzrenfeng.zhsx.spark.conf;

import java.io.Serializable;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SparkConf sparkconf(){
		SparkConf conf = new SparkConf()
			.setMaster("local[*]")
			.setAppName("wc");
		return conf;
	}
	public JavaSparkContext javaSparkContext(){
		
		return new JavaSparkContext(sparkconf());
	}
	
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
	}
	
	public String filePath(){
		return "hdfs://hadoop:9000/file/nlog.txt";
	}
	
	
	
}
