package SpringSE.collection;

import java.util.*;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;

public class ListArraySet {
	
	private		List<?> list = null;
	
	private		int[] array = null;
	
	private		Set<?> set = null;
	
	private		List<Integer> listint  = null;


	public List<Integer> getListint() {
		return listint;
	}


	public void setListint(List<Integer> listint) {
		this.listint = listint;
	}


	public List<?> getList() {
		return list;
	}


	public void setList(List<?> list) {
		this.list = list;
	}


	public int[] getArray() {
		return array;
	}


	public void setArray(int[] array) {
		this.array = array;
	}


	public Set<?> getSet() {
		return set;
	}


	public void setSet(Set<?> set) {
		this.set = set;
	}

	public void info(){
		System.out.print("\nlist\t");
		Iterator<?> ListIter = list.iterator();
		while(ListIter.hasNext()){
			System.out.print(ListIter.next()+" ");
		}
		
		System.out.print("\nset\t");
		Iterator<?> setIter = set.iterator();
		while(setIter.hasNext()){
			System.out.print(setIter.next()+" ");
		}
		
		System.out.print("\narray\t");
		for(int s:array){
			System.out.print(s+" ");
		}
		
		System.out.print("\nlistint\t");
		Iterator<Integer> intiter = listint.iterator();
		while(intiter.hasNext()){
			System.out.print(intiter.next()+" ");
		}
	}

	public static void main(String[] args) {
		ApplicationContext ctx = Context.getAppContext();
		ListArraySet test = (ListArraySet)ctx.getBean("listArraySetBean");
		test.info();
		
		ListArraySet test1 = (ListArraySet)ctx.getBean("test");
		test1.info();
	}

}
