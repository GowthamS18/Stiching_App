package com.example.stitchingandro;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ViewStatus extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_status);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_status, menu);
		return true;
	}

}
