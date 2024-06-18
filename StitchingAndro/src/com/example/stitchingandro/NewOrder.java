package com.example.stitchingandro;


import android.R.color;
import android.R.integer;
import android.R.string;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.stitchingandro.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class NewOrder extends Activity  {

	public String[] arr1= new String[41];
	public String[] arr2= new String[41];
	public String[] arr3= new String[41];
	public String[] arr4= new String[41];
	public String[] arr5= new String[41];
	public String[] arr6= new String[41];
	public String[] arr7= new String[41];
	public String[] arr8= new String[41];
	public String[] arr9= new String[41];
	
	public Button b1,b2,b3;
	public String login;
	public Spinner sp1,sp2;
	public EditText e1;
	public String s,result,result1;
	public ListView lv;
	String provider;
	String userid;	
	public int rowcount=0;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_order);
		
		Intent ii = getIntent();
		userid = ii.getStringExtra("userid");
	     	b1=(Button)findViewById(R.id.button1);
	     	 b1.setOnClickListener(new View.OnClickListener() 
		        {		    	
		          @Override	
		      	  public void onClick(View arg)
		      	    {
		        	  Intent i = new Intent(NewOrder.this,MyOrders.class);
		        	  i.putExtra("userid", userid);
		      	    	startActivity(i);
		      	    }
		  		});	    
	     	 
			b2=(Button)findViewById(R.id.exit);
	        sp1=(Spinner)findViewById(R.id.spinner1);	      
	        sp2=(Spinner)findViewById(R.id.spinner2);	      
	        b2.setOnClickListener(new View.OnClickListener() 
	        {	    	
	          @Override	
	      	  public void onClick(View arg)
	      	    {
	      	    	finish();
	      	    	System.exit(0);
	      	    }
	  		});	    
	     
	        
	        lv = (ListView) findViewById(R.id.listView1);    	
	        sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
	            @Override
	            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	                // your code here	            	
	            	
	            	 if (android.os.Build.VERSION.SDK_INT >= 9) {
							StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
							StrictMode.setThreadPolicy(policy);
						}
	            	 
		        	 String data=WebService.getVendors(sp1.getSelectedItem().toString(),sp2.getSelectedItem().toString(),"getVendors");		
		        	 
		        	 // Toast.makeText(getApplication(),login,Toast.LENGTH_LONG).show();
		        	 if (!data.equals(""))
				     {
		        	 String[] listss= data.split("#");		
		        	 int xx= listss.length;
		    
		    	 int iRows = listss.length;
	        	 rowcount=iRows;
	        
	        	 arr1 = new String[iRows];
	        	 arr2 = new String[iRows];
	        	 arr3 = new String[iRows];
	        	 arr4= new String[iRows];	 
	        	 arr5= new String[iRows];
	        	 arr6 = new String[iRows];
	        	 arr7= new String[iRows];	 
	        	 arr8= new String[iRows];
	        	 arr9= new String[iRows];
      	        int i=0;
      	        // looping through all rows and adding to list
      	        for (i=0;i<listss.length;i++) {
      	           String[] ListItems = listss[i].toString().split(",");
      	        	
	      	         arr1[i]=ListItems[0].toString();
	      	         arr2[i]=ListItems[1].toString();
	      	         arr3[i]=ListItems[3].toString();
	      	         arr4[i]=ListItems[4].toString();	
	      	         arr5[i]=ListItems[5].toString();
	      	         arr6[i]=ListItems[6].toString();
	      	         arr7[i]=ListItems[7].toString();	
	      	         arr8[i]=ListItems[10].toString();
	      	         arr9[i]=ListItems[11].toString();
      	            //	i++;	      	        	
      	        }  
      	      lv.setAdapter(new ImageAdapter(getApplicationContext())); 
            }
        	 else
        	 {
        		 Toast.makeText(NewOrder.this,"No Records Found", Toast.LENGTH_LONG).show();  
        		 lv.setAdapter(null); 
        	 }
		     }	   
	            @Override
	            public void onNothingSelected(AdapterView<?> parentView) {
	                // your code here
	            }

	        });
	        	    
	      lv.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	            	TextView tv1=(TextView) view.findViewById(R.id.tv1);
	            	TextView tv2=(TextView) view.findViewById(R.id.tv2);
	            	TextView tv3=(TextView) view.findViewById(R.id.tv3);
	            	String url =WebService.URLimg +arr9[position];
	    				            	
	            //	Toast.makeText(UserHome.this,tv.getText(), Toast.LENGTH_LONG).show();             
	               Intent ij = new Intent(NewOrder.this, ClothDesign.class);
	               ij.putExtra("p1",tv2.getText());
	               ij.putExtra("p2",tv3.getText());
	               ij.putExtra("p3",userid);
	               ij.putExtra("url",url);
	               startActivityForResult(ij,500);
	            }
	        });	
	    }	

	private class ImageAdapter extends BaseAdapter
	{		
		private Context ctx;
		private TextView tv1;
		private TextView tv2;
		private TextView tv3,tv4,tv5,tv6,tv7,tv8;
		private ImageView image;
		private LayoutInflater layoutInflater;
		
		public ImageAdapter(Context context)
		{
			this.ctx= context;
			layoutInflater = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
			
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return rowcount;
		}
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {				
				ViewGroup onerow = (ViewGroup) layoutInflater.inflate(R.layout.onevendor, null); 	
				
				tv1 = (TextView) onerow.findViewById(R.id.tv1);
				tv2 = (TextView) onerow.findViewById(R.id.tv2);
				tv3 = (TextView) onerow.findViewById(R.id.tv3);				
				tv4 = (TextView) onerow.findViewById(R.id.tv4);
				tv5 = (TextView) onerow.findViewById(R.id.tv5);
				tv6 = (TextView) onerow.findViewById(R.id.tv6);				
				tv7 = (TextView) onerow.findViewById(R.id.tv7);
				tv8 = (TextView) onerow.findViewById(R.id.tv8);
				image = (ImageView) onerow.findViewById(R.id.ivIcon);
				URL url;
				try {
					url = new URL( WebService.URLimg +arr9[position]);
					Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
					image.setImageBitmap(bmp);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tv1.setText(arr1[position]);
				tv2.setText(arr2[position]);			
				tv3.setText(arr3[position]);
				tv4.setText(arr4[position]);
				tv5.setText(arr5[position]);
				tv6.setText(arr6[position]);			
				tv7.setText(arr7[position]);
				tv8.setText(arr8[position]);
				//position++;
				return onerow;
		}
	}
}



	