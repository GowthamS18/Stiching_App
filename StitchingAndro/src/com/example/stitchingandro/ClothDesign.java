package com.example.stitchingandro;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.stitchingandro.R;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class ClothDesign extends Activity {
public TextView tv1,tv2,tv3;
public EditText ed1,ed2,ed3;
public ImageView image;
Spinner sp1;
public String result,se;
SQLiteDatabase con;

	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cloth_design);		
		
		tv1=(TextView)findViewById(R.id.tv1);
		tv2=(TextView)findViewById(R.id.tv2);
		tv3=(TextView)findViewById(R.id.tv3);
		ed1=(EditText)findViewById(R.id.ed1);
		ed2=(EditText)findViewById(R.id.ed2);
		ed3=(EditText)findViewById(R.id.ed3);		
		image = (ImageView) findViewById(R.id.imageView1);
		sp1=(Spinner) findViewById(R.id.spinner1);
		
		Intent intent = getIntent();
		tv1.setText(intent.getStringExtra("p1"));
		tv2.setText(intent.getStringExtra("p2"));
		tv3.setText(intent.getStringExtra("p3"));
		se=intent.getStringExtra("url");
		
		URL url;
		try {
			url = new URL(se);
			Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
			image.setImageBitmap(bmp);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void AddtoCart(View v)
	{
		String res=WebService.AddOrder(tv1.getText().toString(),tv3.getText().toString(),sp1.getSelectedItem().toString(),ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(),"AddOrder");
		Toast.makeText(ClothDesign.this, res.toString(), Toast.LENGTH_SHORT).show();
	}
	public void back(View v)
	{
		finish();
	}
}

