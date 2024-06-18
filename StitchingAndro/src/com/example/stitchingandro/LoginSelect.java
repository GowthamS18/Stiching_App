package com.example.stitchingandro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class LoginSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_select);
		
		
	}
	
	public void vendor (View v)
	{
		startActivity(new Intent(LoginSelect.this,VendorLogin.class));	      
	}
	public void customer (View v)
	{
		startActivity(new Intent(LoginSelect.this,CustLogin.class));	      
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_select, menu);
		return true;
	}

}
