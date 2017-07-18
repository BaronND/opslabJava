package com.opslab.business.service.impl;

import com.opslab.business.BusinessConstant;
import com.opslab.business.service.ShuangSeQiuService;
import com.opslab.util.RandomUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 双色球
 */
@Service("shuangSeQiuService")
public class ShuangSeQiuServiceImpl  implements ShuangSeQiuService {
    private static Logger logger = Logger.getLogger(ShuangSeQiuServiceImpl.class);

    @Resource(name = "sqlSession")
    private SqlSession session;


    @Override
    public int[] redRandom() {
        List<Integer> reds = new ArrayList<Integer>();
        while (reds.size() <= 6) {
            int i = RandomUtil.randomItem(BusinessConstant.RED_ARRAY);
            if (reds.contains(i)) {
                continue;
            } else {
                reds.add(i);
            }
        }
        reds.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return new int[]{reds.get(0), reds.get(1), reds.get(2), reds.get(3), reds.get(4), reds.get(5)};
    }


    public int blueRandom() {
        return RandomUtil.randomItem(BusinessConstant.BLUE_ARRY);
    }

    public int[] random() {
        int[] result = new int[7];
        int[] reds = redRandom();
        for (int i = 0; i < 6; i++) {
            result[i] = reds[i];
        }
        result[6] = blueRandom();
        return result;
    }

    @Override
    public Map<String, List<Integer>> random(int redlen, int bluelen) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> reds = new ArrayList<Integer>(redlen);
        while (reds.size() < redlen) {
            int i = RandomUtil.randomItem(BusinessConstant.RED_ARRAY);
            if (reds.contains(i)) {
                continue;
            } else {
                reds.add(i);
            }
        }
        reds.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        List<Integer> blues = new ArrayList<Integer>(bluelen);
        while (blues.size() < bluelen) {
            int i = RandomUtil.randomItem(BusinessConstant.BLUE_ARRY);
            if (blues.contains(i)) {
                continue;
            } else {
                blues.add(i);
            }
        }
        blues.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        map.put("red", reds);
        map.put("blue", blues);
        return map;
    }


    public Map<String, Map<Integer, Integer>> randomCount(int i) {
        Map<String, Map<Integer, Integer>> map = new HashMap<>();

        //red
        Map<Integer, Integer> red = new HashMap<>();
        Map<Integer, Integer> blue = new HashMap<>();
        for (int j = 0; j < i * 6; j++) {
            int r = RandomUtil.randomItem(BusinessConstant.RED_ARRAY);
            if (red.containsKey(r)) {
                int v = red.get(r);
                red.put(r, v + 1);
            } else {
                red.put(r, 1);
            }
            if (j % 6 == 0) {
                int b = RandomUtil.randomItem(BusinessConstant.BLUE_ARRY);
                if (blue.containsKey(b)) {
                    int v = blue.get(b);
                    blue.put(b, v + 1);
                } else {
                    blue.put(b, 1);
                }
            }
        }

        map.put("red", red);
        map.put("blue", blue);
        return map;
    }

    @Override
    public int[] redRandom(Double[] ratio) {
        List<Integer> reds = new ArrayList<Integer>();
        while (reds.size() <= 6) {
            int i = RandomUtil.randomItem(BusinessConstant.RED_ARRAY, ratio);
            if (reds.contains(i)) {
                continue;
            } else {
                reds.add(i);
            }
        }
        reds.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return new int[]{reds.get(0), reds.get(1), reds.get(2), reds.get(3), reds.get(4), reds.get(5)};
    }

    @Override
    public int blueRandom(Double[] ratio) {
        return RandomUtil.randomItem(BusinessConstant.BLUE_ARRY, ratio);
    }

    @Override
    public int[] random(Double[] redRatio, Double[] blueRatio) {
        int[] result = new int[7];
        int[] reds = redRandom(redRatio);
        for (int i = 0; i < 6; i++) {
            result[i] = reds[i];
        }
        result[6] = blueRandom(blueRatio);
        return result;
    }

    @Override
    public Map<String, Map<Integer, Integer>> randomCount(Double[] redRatio, Double[] blueRatio, int i) {
        Map<String, Map<Integer, Integer>> map = new HashMap<>();

        //red
        Map<Integer, Integer> red = new HashMap<>();
        Map<Integer, Integer> blue = new HashMap<>();
        for (int j = 0; j < i * 6; j++) {
            int r = RandomUtil.randomItem(BusinessConstant.RED_ARRAY, redRatio);
            if (red.containsKey(r)) {
                int v = red.get(r);
                red.put(r, v + 1);
            } else {
                red.put(r, 1);
            }
            if (j % 6 == 0) {
                int b = RandomUtil.randomItem(BusinessConstant.BLUE_ARRY, blueRatio);
                if (blue.containsKey(b)) {
                    int v = blue.get(b);
                    blue.put(b, v + 1);
                } else {
                    blue.put(b, 1);
                }
            }
        }

        map.put("red", red);
        map.put("blue", blue);
        return map;
    }


    public Map<String, Map<Integer, Integer>> realCount() {
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Integer> red = new HashMap<>();
        Map<Integer, Integer> blue = new HashMap<>();


        List<Object> objects = session.selectList("com.opslab.system.model.ShuangSeQiu.list");
        objects.stream().forEach(obj -> {
            Map map1 = (Map) obj;
            for (int i = 1; i < 7; i++) {
                Integer redball = Integer.parseInt((String) map1.get("red" + i));
                if (red.containsKey(redball)) {
                    int v = red.get(redball);
                    red.put(redball, v + 1);
                } else {
                    red.put(redball, 1);
                }
            }
            Integer blueball = Integer.parseInt((String) map1.get("blue"));
            if (blue.containsKey(blueball)) {
                int v = blue.get(blueball);
                blue.put(blueball, v + 1);
            } else {
                blue.put(blueball, 1);
            }
        });


        map.put("red", red);
        map.put("blue", blue);
        return map;
    }
}
