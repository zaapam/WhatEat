package com.zaapam.ginaraidee.models;

public class FoodItem {

	private int id;
	private String name;
	private boolean isBreakfast;
	private boolean isLunch;
	private boolean isDinner;
	
	public FoodItem(int id, String name, boolean is_breakfast, boolean is_lunch, boolean is_dinner) {
		// TODO Auto-generated constructor stub
		this.id =  id;
		this.name = name;
		this.isBreakfast = is_breakfast;
		this.isLunch = is_lunch;
		this.isDinner = is_dinner;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isBreakfast() {
		return isBreakfast;
	}

	public boolean isLunch() {
		return isLunch;
	}

	public boolean isDinner() {
		return isDinner;
	}
}
