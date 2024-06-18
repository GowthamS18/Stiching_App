package com.example.stitchingandro;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class VendorHome extends Activity {
String userid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vendor_home);
		
		Intent ii = getIntent();
		userid = ii.getStringExtra("userid");
	}
	public void vieworders (View v)
	{
		Intent ii = new Intent(VendorHome.this,ViewOrders.class);
		ii.putExtra("userid", userid);
		startActivity(ii);	      
	}
	public void viewmeasurements (View v)
	{
		Intent ii = new Intent(VendorHome.this,ViewMeasurements.class);
		ii.putExtra("userid", userid);
		startActivity(ii);		      
	}
	public void viewpayments (View v)
	{
		Intent ii = new Intent(VendorHome.this,ViewPayments.class);
		ii.putExtra("userid", userid);
		startActivity(ii);
	}
	public void updatestatus (View v)
	{
		Intent ii = new Intent(VendorHome.this,UpdateStatus.class);
		ii.putExtra("userid", userid);
		startActivity(ii);
	}
	public void logout (View v)
	{		
		startActivity(new Intent(VendorHome.this,LoginSelect.class));	      
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vendor_home, menu);
		return true;
	}
}
