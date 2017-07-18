package cxfDemo.Spring.SEI;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import cxfDemo.Spring.DAO.order;


@WebService
public interface orderWS {
	@WebMethod
	public boolean addOrder(
			@WebParam(name="orderInstance")
			order o);
	
	public List<order> getOrdersList();
	
	public order  getOrderById(
			@WebParam(name="order_id")
			String Id);
	
	public Map<String, order> getOrdersMap();
}
