package com.zaapam.ginaraidee.models;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;

public class FoodMananger {

	private Context context;
	private AssetManager assets;
	
	public void FoodManager(Context context) {
		this.context = context;
		this.assets = this.context.getAssets();
	}
	
	public void load() throws Exception {
		InputStream in = this.assets.open("foods.json");
	}
}
