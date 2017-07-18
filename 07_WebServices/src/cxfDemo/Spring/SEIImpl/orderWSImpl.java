package cxfDemo.Spring.SEIImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import cxfDemo.Spring.DAO.order;
import cxfDemo.Spring.SEI.orderWS;

@WebService
public class orderWSImpl implements orderWS {

	@Override
	public boolean addOrder(order o) {
		System.out.println("Service say"+o);
		return true;
	}

	@Override
	public List<order> getOrdersList() {
		List<order> list = new ArrayList<order>();
		list.add(new order("01","牛奶",10.0));
		list.add(new order("02","鸡蛋",10.0));
		list.add(new order("03","面包",10.0));
		System.out.println("service say:" + list);
		return list;
	}

	@Override
	public order getOrderById(String Id) {
		System.out.println("service say"+Id);
		return new order(Id,"lcx",9999999999.9);
	}

	@Override
	public Map<String, order> getOrdersMap() {
		Map<String, order> map = new HashMap<String, order>();
		map.put("01",new order("01","牛奶",10.0));
		map.put("02",new order("02","鸡蛋",10.0));
		map.put("03",new order("03","面包",10.0));
		System.out.println("service say:"+map);
		return map;
	}

}
