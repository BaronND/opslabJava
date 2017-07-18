package SpringSE.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class MapBean {
	private Map<Integer, TestVO> testMap;

	public Map<Integer, TestVO> getTestMap() {
		return testMap;
	}

	public void setTestMap(Map<Integer, TestVO> testMap) {
		this.testMap = testMap;
	}
	
	public static void main(String[] args) {
		ApplicationContext appContext = Context.getAppContext();
		MapBean maptest = (MapBean) appContext.getBean("testMap");
		Iterator<Entry<Integer, TestVO>> iterator = maptest.getTestMap().entrySet().iterator();
		Entry<Integer, TestVO> entry;
		while(iterator.hasNext()){
			entry =iterator.next();
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		
		MapBean maptest1 = (MapBean) appContext.getBean("testMap1");
		Iterator<Entry<Integer, TestVO>> iterator1 = maptest1.getTestMap().entrySet().iterator();
		Entry<Integer, TestVO> entry1;
		while(iterator1.hasNext()){
			entry1 =iterator1.next();
			System.out.println(entry1.getKey()+"\t"+entry1.getValue());
		}
		
		MapBean maptest2 = (MapBean) appContext.getBean("testMap2");
		Iterator<Entry<Integer, TestVO>> iterator2 = maptest2.getTestMap().entrySet().iterator();
		Entry<Integer, TestVO> entry2;
		while(iterator2.hasNext()){
			entry2 =iterator2.next();
			System.out.println(entry2.getKey()+"\t"+entry2.getValue());
		}
	}
}
