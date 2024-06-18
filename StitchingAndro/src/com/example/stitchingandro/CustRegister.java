package com.example.stitchingandro;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

import com.example.stitchingandro.R;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CustRegister extends Activity {
	private Button b1,b2;
	public String cal,s,res;
	Spinner sp1;
	public EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cust_register);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		e3=(EditText) findViewById(R.id.editText3);
		e4=(EditText) findViewById(R.id.editText4);
		e5=(EditText) findViewById(R.id.editText5);		
		sp1=(Spinner) findViewById(R.id.spinner1);
		e6=(EditText) findViewById(R.id.editText6);
		e7=(EditText) findViewById(R.id.editText7);
		e8=(EditText) findViewById(R.id.editText8);
		

		b1=(Button)findViewById(R.id.imageButton1);
		b2=(Button)findViewById(R.id.imageButton2);
		b1.setOnClickListener(new OnClickListener() {			 
			@Override
			@SuppressLint("NewApi")
			public void onClick(View v) {
				 if (android.os.Build.VERSION.SDK_INT >= 9) {
						StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
						StrictMode.setThreadPolicy(policy);
					}			
				 res=WebService.register(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),sp1.getSelectedItem().toString(),e6.getText().toString(),e7.getText().toString(),e8.getText().toString(),"register");
				 Toast.makeText(getApplication(),res.toString(),Toast.LENGTH_SHORT).show();
  			}
 
		});
		b2.setOnClickListener(new OnClickListener() {			 
			@Override
			@SuppressLint("NewApi")
			public void onClick(View v) {
				finish();
  			}
 
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stu_register, menu);
		return true;
	}

}
