package com.example.stitchingandro;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class UpdateStatus extends Activity {
	String userid;
	private TextView tv1;
	private TextView tv2;
	Spinner sp1;
	EditText ed1,ed2;
	private TextView tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_status);
		Intent ii = getIntent();
		userid = ii.getStringExtra("userid");
		sp1 = (Spinner) findViewById(R.id.spinner1);
		
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);
		tv5 = (TextView) findViewById(R.id.tv5);
		tv6 = (TextView) findViewById(R.id.tv6);
		tv7 = (TextView) findViewById(R.id.tv7);
		tv8 = (TextView) findViewById(R.id.tv8);
		tv9 = (TextView) findViewById(R.id.tv9);
		ed1 = (EditText) findViewById(R.id.ed1);
		ed2 = (EditText) findViewById(R.id.ed2);
        if (android.os.Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
		String getsub=WebService.getList(userid,"getOrderID");
        String[] str1=null;
        //Toast.makeText(StuHomenew.this, "Data Save successfully...", Toast.LENGTH_LONG).show();
       if (getsub.toString()!="") {
          str1 = getsub.split("#");
          ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, str1);
          dataAdapter.setDropDownViewResource(R.layout.spinner_item);
         sp1.setAdapter(dataAdapter);
      }  
       
       sp1.setOnItemSelectedListener(new OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
               // your code here	            	
           	
           	 if (android.os.Build.VERSION.SDK_INT >= 9) {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
           	 }           	 
           	 String data=WebService.getList(sp1.getSelectedItem().toString(),"getoneOrderDetails");		
	         if (!data.equals(""))
		     {
	        	String[] listss= data.split("#");		
	        	int xx= listss.length;	    
	        	String[] list = listss[0].split(",");
     	        tv1.setText(list[2].toString());
     	        tv2.setText(list[3].toString());
     	        tv3.setText(list[4].toString());
     	        tv4.setText(list[5].toString());
     	        tv5.setText(list[6].toString());
     	        tv6.setText(list[7].toString());
     	        tv7.setText(list[8].toString());  
     	        tv8.setText(list[9].toString());
    	        tv9.setText(list[10].toString());     	  
 	        }         
		   	 else
		   	 {
		   		 Toast.makeText(UpdateStatus.this,"No Records Found", Toast.LENGTH_LONG).show();  
		   		 tv1.setText("");
		   		 tv2.setText("");
		   		 tv3.setText("");
     	       	 tv4.setText("");
     	       	 tv5.setText("");
     	       	 tv6.setText("");
     	       	 tv7.setText("");
     	       	 tv8.setText("");
    	       	 tv9.setText("");
		   	 }
	     }	   
           @Override
           public void onNothingSelected(AdapterView<?> parentView) {
               // your code here
           }

       });
	}
	public void updateStatus(View v)
	{
		String res=WebService.UpdateStatus(sp1.getSelectedItem().toString(),ed1.getText().toString(),ed2.getText().toString(),"UpdateStatus");
		Toast.makeText(UpdateStatus.this, res.toString(), Toast.LENGTH_SHORT).show();
	}

	public void back(View v)
	{
		finish();
	    System.exit(0);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_measurements, menu);
		return true;
	}

}
