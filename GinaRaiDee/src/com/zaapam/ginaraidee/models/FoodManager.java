package com.zaapam.ginaraidee.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONObject;

import android.content.Context;
import android.content.res.AssetManager;

public class FoodManager {

	private Context context;
	private AssetManager assets;
	private JSONObject data;
	private ArrayList<FoodItem> breakfastList;
	private ArrayList<FoodItem> lunchList;
	private ArrayList<FoodItem> dinnerList;
	
	public FoodManager(Context context) {
		this.context = context;
		this.assets = this.context.getAssets();
		this.breakfastList = new ArrayList<FoodItem>();
		this.lunchList = new ArrayList<FoodItem>();
		this.dinnerList = new ArrayList<FoodItem>();
	}
	
	public void load() throws Exception {
		InputStream in = this.assets.open("foods.json");
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8")); 
	    StringBuilder responseStrBuilder = new StringBuilder();

	    String inputStr;
	    while ((inputStr = streamReader.readLine()) != null)
	        responseStrBuilder.append(inputStr);
	    
	    this.data = new JSONObject();
	}
}
