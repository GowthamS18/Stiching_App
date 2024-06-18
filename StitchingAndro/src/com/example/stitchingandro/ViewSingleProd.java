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
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewSingleProd extends Activity {
	public TextView t1,t2,t3,t4;
	public EditText edQty;
	public ImageView image;
	public String result,se;
	SQLiteDatabase con;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_single_prod);
con =  this.openOrCreateDatabase("shop", MODE_PRIVATE, null);
		
		
		t1=(TextView)findViewById(R.id.textView2);
		t2=(TextView)findViewById(R.id.textView3);
		t3=(TextView)findViewById(R.id.textView6);
		edQty=(EditText)findViewById(R.id.editText1);
		t4=(TextView)findViewById(R.id.textView4);
		image = (ImageView) findViewById(R.id.imageView1);
		
		Intent intent = getIntent();
		t1.setText(intent.getStringExtra("bagid"));
		t2.setText(intent.getStringExtra("bagname"));
		t3.setText(intent.getStringExtra("price"));
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
		
		
		edQty.addTextChangedListener(new TextWatcher() {

			    public void onTextChanged(CharSequence s, int start, int before,
			            int count) {
			       
				    if(!s.equals("") && count>0)
		            { 
	        	
			        	//do your work here }
			        	float totamt = Float.valueOf(edQty.getText().toString()) * Float.parseFloat((String) t3.getText());
						t4.setText(Float.toString(totamt));
				
		            }
				    else
				    	t4.setText("0.00");
			    }
			    public void beforeTextChanged(CharSequence s, int start, int count,
			            int after) {

			    }

			    public void afterTextChanged(Editable s) {
			    	 
					
		        }
			});
		 
		//call();
	}
	public void AddtoCart(View v)
	{
		con.execSQL("INSERT INTO cart (prodid,prodname,price,qty,amt) Values ('"+ t1.getText() +"','"+ t2.getText() +"','"+ t3.getText() +"','"+ edQty.getText() +"','"+ t4.getText() +"');");
		Toast.makeText(ViewSingleProd.this, "Added Successfully", Toast.LENGTH_SHORT).show();
	}
	public void back(View v)
	{
		finish();
	}
	 @SuppressLint("NewApi")	
	public void call()
	{
		 if (android.os.Build.VERSION.SDK_INT >= 9) {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
			}
		
		result=WebService.getuser(se.toString(),"getuser");
		String[] s=result.split(",");
		
       t1.setText(s[0].toString());
       t2.setText(s[1].toString());
       t3.setText(s[2].toString());
       t4.setText(s[3].toString());
      
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_single_prod, menu);
		return true;
	}

}
