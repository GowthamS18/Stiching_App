package com.example.stitchingandro;

import com.example.stitchingandro.R;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.view.Menu;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustLogin extends Activity {
	public Button b1,b2,b3;
	public String login;
	public EditText e1,e2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cust_login);
		 	b2=(Button)findViewById(R.id.exit);
	        b3=(Button)findViewById(R.id.loginbutton);
	        b1=(Button)findViewById(R.id.button1);
	        e1=(EditText)findViewById(R.id.username);
	        e2=(EditText)findViewById(R.id.password);
	         
	        b1.setOnClickListener(new View.OnClickListener() 
	        {	    	
	          @Override	
	      	  public void onClick(View arg)
	      	    {
	      	    	startActivity(new Intent(CustLogin.this,CustRegister.class));
	      	    }
	  		
	  		});
	        
	        b2.setOnClickListener(new View.OnClickListener() 
	        {	    	
	          @Override	
	      	  public void onClick(View arg)
	      	    {
	      	    	finish();
	      	    	System.exit(0);
	      	    }	  		
	  		});
	        
	        b3.setOnClickListener(new View.OnClickListener() 
	        {    	
	          @Override	
	          @SuppressLint("NewApi")	
	      	  public void onClick(View arg)
	      	    {
	        	  if (android.os.Build.VERSION.SDK_INT >= 9) {
						StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
						StrictMode.setThreadPolicy(policy);
					}
	        	  login=WebService.stulogincheck(e1.getText().toString(),e2.getText().toString(),"userlogin");
	        	  if(login.equals("ok"))
	        	  {
	        		  Toast.makeText(getApplication(),"Login Success",Toast.LENGTH_SHORT).show();
	        		  Intent i=new Intent(CustLogin.this,NewOrder.class);
	        	    	i.putExtra("userid",e1.getText().toString());
	        	    	startActivity(i);	        	    	
	        	  }
	        	  else
	        	  {
	        		  Toast.makeText(getApplication(),"Login Failed",Toast.LENGTH_SHORT).show();	        		 
	        	  }	        	  
	      	    }
	  		
	  		});
	    }  
	    
	}
