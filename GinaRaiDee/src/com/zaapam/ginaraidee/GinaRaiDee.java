package com.zaapam.ginaraidee;

import com.zaapam.ginaraidee.models.FoodManager;

import android.app.Application;

public class GinaRaiDee extends Application {

	private FoodManager foodManager;
	
	public GinaRaiDee() {
		// TODO Auto-generated constructor stub
		this.foodManager = new FoodManager(this);
	}
	
	public FoodManager getFoodManager() {
		return this.foodManager;
	}
}
