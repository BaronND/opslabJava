package com.opslab.hadoop.mapreduce.wordcount;

import com.opslab.hadoop.mapreduce.Map;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by neptune on 2016/12/28 0028.
 */
public class WordCount extends Map {
    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    public void map(
            Object o, Text text, OutputCollector<Text, IntWritable>
            outputCollector, Reporter reporter) throws IOException {

        StringTokenizer itr = new StringTokenizer(text.toString());
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken());
            outputCollector.collect(word, one);
        }
    }
}
