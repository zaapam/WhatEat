package com.zaapam.ginaraidee.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class FoodManager {

	public static int BREAKFAST = 1;
	public static int LUNCH = 2;
	public static int DINNER = 3;
	
	private Context context;
	private AssetManager assets;
	private JSONObject data;
	private ArrayList<FoodItem> foodList;
	private ArrayList<FoodItem> breakfastList;
	private ArrayList<FoodItem> lunchList;
	private ArrayList<FoodItem> dinnerList;
	private Random rand;
	
	public FoodManager(Context context) {
		this.context = context;
		this.breakfastList = new ArrayList<FoodItem>();
		this.lunchList = new ArrayList<FoodItem>();
		this.dinnerList = new ArrayList<FoodItem>();
		this.foodList = new ArrayList<FoodItem>();
		this.rand = new Random();
	}
	
	public void load() throws Exception {
		InputStream in = this.context.getAssets().open("foods.json");
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8")); 
	    StringBuilder responseStrBuilder = new StringBuilder();

	    String inputStr;
	    while ((inputStr = streamReader.readLine()) != null)
	        responseStrBuilder.append(inputStr);
	    
	    this.data = new JSONObject(responseStrBuilder.toString());
	    
	    JSONArray arr = this.data.getJSONArray("foods");
	    for (int i = 0 ; i < arr.length() ; i++) {
	    	JSONObject obj = arr.getJSONObject(i);
	    	boolean b = (obj.getInt("breakfast") == 1) ? true : false;
	    	boolean l = (obj.getInt("lunch") == 1) ? true : false;
	    	boolean d = (obj.getInt("dinner") == 1) ? true : false;
	    	FoodItem f = new FoodItem(obj.getInt("id"), obj.getString("name"), b, l, d);
	    	this.foodList.add(f);
	    	
	    	if (b)
	    		this.breakfastList.add(f);
	    	
	    	if (l)
	    		this.lunchList.add(f);
	    	
	    	if (d)
	    		this.dinnerList.add(f);
	    }
	    
	    Log.d("GRD", responseStrBuilder.toString());
	    Log.d("GRD", "LOAD FOOD DATA COMPLETE");
	}
	
	public FoodItem randomFood() {
		int rnd = rand.nextInt(foodList.size());
		
		return foodList.get(rnd);
	}
	
	public FoodItem randomFood(int type) {
		
		ArrayList<FoodItem> foods;
		
		switch (type) {
			case 1:
				foods = breakfastList;
				break;
				
			case 2:
				foods = lunchList;
				break;
				
			case 3:
				foods = dinnerList;
				break;
	
			default:
				foods = foodList;
				break;
		}
		
		int rnd = rand.nextInt(foods.size());
		
		return foods.get(rnd);
	}
}
