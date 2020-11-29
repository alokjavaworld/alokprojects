package com.nt.beans;

public class PunjabiKichen implements Zomato {
public PunjabiKichen() {
	System.out.println("Punjabi - 0 param");
}
	@Override
	public void chicken(int qty) {
		System.out.println("Thank You for order us");
		System.out.println("Resturent PunjabiKichen");
		System.out.println( "Your Butter Chicken  "+qty+ " Plates on the Way");
	}

	@Override
	public void pizza(int qty) {
		System.out.println("Thank You for order with  us");
		System.out.println("Resturent PunjabiKichen");
		System.out.println( "Your Corn Pizza  Size: "+qty+" On the way");

	}

	@Override
	public void momos(int qty) {
		System.out.println("Thank You for order with us ");
		System.out.println("Resturent  PunjabiKichen");
		System.out.println( "Your Fried Momos "+qty+ " Plates on the Way");
	}

}
