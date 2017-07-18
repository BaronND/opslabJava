package com.opslab.business.service;

import com.opslab.system.annotion.ServiceMethod;

import java.util.List;
import java.util.Map;

/**
 * 双色球
 */
public interface ShuangSeQiuService {


    @ServiceMethod(value = "随机6个红球")
    public int[] redRandom();

    @ServiceMethod(value = "随机一个篮球")
    public int blueRandom();

    @ServiceMethod(value = "随机一注")
    public int[] random();

    @ServiceMethod(value = "随机一注")
    public Map<String, List<Integer>> random(int redlen, int bluelen);

    @ServiceMethod(value = "随机N次,返回各个值出现的占比")
    public Map<String, Map<Integer, Integer>> randomCount(int i);

    @ServiceMethod(value = "按照一定的比例随机6个红球")
    public int[] redRandom(Double[] ratio);

    @ServiceMethod(value = "按照一定的比例随机1个篮球")
    public int blueRandom(Double[] ratio);

    @ServiceMethod(value = "按照一定的比例随机1一注")
    public int[] random(Double[] redRatio, Double[] blueRatio);

    @ServiceMethod(value = "按照一定的比例随机N次,返回各个值出现的占比")
    public Map<String, Map<Integer, Integer>> randomCount(Double[] redRatio, Double[] blueRatio, int i);

    @ServiceMethod(value = "获取历史各个数值出现的比例")
    public Map<String, Map<Integer, Integer>> realCount();
}
