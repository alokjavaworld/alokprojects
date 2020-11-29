package com.nt.beans;

public class Kaveri implements Zomato {
	public Kaveri() {
		System.out.println("Kaveri --0-Param Constructor");
	}

	@Override
	public void chicken(int qty) {
		System.out.println("Thank You for order with us");
		System.out.println("Resturent Kaveri");
		System.out.println( "Your Butter Chicken  "+qty+ " Plates on the Way");

	}

	@Override
	public void pizza(int qty) {
		System.out.println("Thank You for order with us");
		System.out.println("Resturent Kaveri");
		System.out.println( "Your Corn Pizza  Size: "+qty+" On the way");


	}

	@Override
	public void momos(int qty) {
		System.out.println("Thank You for order with us ");
		System.out.println("Resturent Kaveri");
		System.out.println( "Your Fried Momos "+qty+ " Plates on the Way");


	}

}
