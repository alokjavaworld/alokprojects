package com.nt.beans;

public class ZomatoApp {
	private Zomato order;

	public ZomatoApp(Zomato order) {
   System.out.println("ZomatoAPP- 0-param");
		this.order = order;
	}

	public void order(String item, int qty) {
		//validate
		if(item.equalsIgnoreCase("chicken")) {
			order.chicken(qty);
		}else if(item.equalsIgnoreCase("pizza")) {
			order.pizza(qty);
		}else if(item.equalsIgnoreCase("momos")) {
			order.momos(qty);
		}else
			System.out.println("item not avialable");
	}//order

}//class



