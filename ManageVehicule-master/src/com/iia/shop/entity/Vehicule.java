package com.iia.shop.entity;
import java.io.Serializable;

public class Vehicule implements Serializable {
	private int id;
	private String marque;
	private int year;
	private int speed;
	private String model;
	private String color;
	private double price;

	public Vehicule() {
		super();
	}

	public Vehicule(int id, String marque, int year, int speed, String model, String color, double price) {
		super();
		this.id = id;
		this.marque = marque;
		this.year = year;
		this.speed = speed;
		this.model = model;
		this.color = color;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void start() {
	}

	public void stop() {
	}

	public void speedUp(int speed) {
		this.speed = this.speed + speed;
	}

	public void speedDown(int speed) {
		this.speed = this.speed - speed;
	}

	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + ", year=" + year + ", speed=" + speed + ", model=" + model + ", color="
				+ color + ", price=" + price + "]";
	}

	

	
}
