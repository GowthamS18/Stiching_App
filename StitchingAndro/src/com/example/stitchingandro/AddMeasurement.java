package com.example.stitchingandro;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddMeasurement extends Activity {
	public TextView tv1,tv2,tv3;
	public EditText ed1,ed2,ed3;
	public ImageView image;
	Spinner sp1;
	public String result,se;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_measurement);

		tv1=(TextView)findViewById(R.id.tv1);
		tv2=(TextView)findViewById(R.id.tv2);
		tv3=(TextView)findViewById(R.id.tv3);
		ed1=(EditText)findViewById(R.id.ed1);
		ed2=(EditText)findViewById(R.id.ed2);
		sp1=(Spinner)findViewById(R.id.spinner1);
		
		Intent intent = getIntent();
		tv1.setText(intent.getStringExtra("p1"));
		tv2.setText(intent.getStringExtra("p2"));
		tv3.setText(intent.getStringExtra("p3"));	
	}
	public void AddtoCart(View v)
	{
		String res=WebService.AddMeasurements(tv1.getText().toString(),tv2.getText().toString(),tv3.getText().toString(),sp1.getSelectedItem().toString(),ed1.getText().toString(),ed2.getText().toString(),"AddMeasurements");
		Toast.makeText(AddMeasurement.this, res.toString(), Toast.LENGTH_SHORT).show();
	}
	public void back(View v)
	{
		finish();
	}
}
