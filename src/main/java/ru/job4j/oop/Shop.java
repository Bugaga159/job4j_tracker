package ru.job4j.oop;

public class Shop {
	public static void main(String[] args) {
		LiquidationProduct product = ofLiquidationProduct("Oil", 100);
		System.out.println(product.label());
	}

	public static Product ofProduct(String name, int price) {
		return new Product(name, price);
	}

	public static LiquidationProduct ofLiquidationProduct(String name, int price) {
		return new LiquidationProduct(name, price);
	}
}
