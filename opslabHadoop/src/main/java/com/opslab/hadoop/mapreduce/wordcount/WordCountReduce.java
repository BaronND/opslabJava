package com.opslab.hadoop.mapreduce.wordcount;

import com.opslab.hadoop.mapreduce.Reduce;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by neptune on 2016/12/28 0028.
 */
public class WordCountReduce extends Reduce {
    private IntWritable result = new IntWritable();

    public void reduce(Text text, Iterator<IntWritable> iterator, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next().get();
        }
        result.set(sum);
        outputCollector.collect(text, result);
    }
}
