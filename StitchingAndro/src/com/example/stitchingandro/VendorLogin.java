package com.example.stitchingandro;

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

public class VendorLogin extends Activity {
	public Button b1,b2,b3;
	public String login;
	public EditText e1,e2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vendor_login);
		
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
         
        b2.setOnClickListener(new View.OnClickListener() 
        {	    	
          @Override	
      	  public void onClick(View arg)
      	    {
      	    	startActivity(new Intent(VendorLogin.this,VendorRegistration.class));
      	    }  		
  		});
        
        b3.setOnClickListener(new View.OnClickListener() 
        {	    	
          @Override	
      	  public void onClick(View arg)
      	    {
      	    	finish();
      	    	System.exit(0);
      	    }	  		
  		});
        
        b1.setOnClickListener(new View.OnClickListener() 
        {    	
          @Override	
          @SuppressLint("NewApi")	
      	  public void onClick(View arg)
      	    {
        	  if (android.os.Build.VERSION.SDK_INT >= 9) {
					StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
					StrictMode.setThreadPolicy(policy);
				}
        	  login=WebService.stulogincheck(e1.getText().toString(),e2.getText().toString(),"vendorlogin");
        	  if(login.equals("ok"))
        	  {
        		  Toast.makeText(getApplication(),"Login Success",Toast.LENGTH_SHORT).show();
        		  Intent i=new Intent(VendorLogin.this,VendorHome.class);
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
