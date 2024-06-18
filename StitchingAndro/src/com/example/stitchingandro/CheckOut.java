package com.example.stitchingandro;

import com.example.stitchingandro.R;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
public class CheckOut extends Activity {
	public ListView lv;
	public SQLiteDatabase con;
	public String[] prodid = new String[41];
	public String[] prodname = new String[41];
	public String[] price = new String[41];
	public String[] qty= new String[41];
	public String[] amt= new String[41];
	public int rowcount=0;
	TextView tv,tvtot;
	public String delid="";
	String products="";
	String username;
	EditText ed1,ed2,ed3;
	float total =0;
	String res;
	AlertDialog.Builder builder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check_out);
		Intent ii = getIntent();
		username = ii.getStringExtra("userid");
		tv = (TextView) findViewById(R.id.textView1);
		ed1 = (EditText) findViewById(R.id.editText1);
		ed2 = (EditText) findViewById(R.id.editText2);
		ed3 = (EditText) findViewById(R.id.editText3);
		
		tv.setText(username);
		con = this.openOrCreateDatabase("shop", MODE_PRIVATE, null);		
		String selectQuery = "SELECT * FROM cart ";
        Cursor cursor = con.rawQuery(selectQuery, null);
       
        prodid = new String[cursor.getCount()];
        prodname = new String[cursor.getCount()];
        price = new String[cursor.getCount()];
        qty= new String[cursor.getCount()];
        amt= new String[cursor.getCount()];
    	
    	rowcount=cursor.getCount();    	
    	 builder = new AlertDialog.Builder(this);
    	
        int i=0;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	prodid[i]=cursor.getString(1);
            	prodname[i]=cursor.getString(2);
            	price[i]=cursor.getString(3);
            	qty[i]=cursor.getString(4);
            	amt[i]=cursor.getString(5);    
            	total+= Float.parseFloat(cursor.getString(5));
            	i++;
            	products += cursor.getString(1) +"$" + cursor.getString(2) +"$" + cursor.getString(3) +"$" + cursor.getString(4) +"$" + cursor.getString(5) +"#"; 
            } while (cursor.moveToNext());
        }
        
        tvtot = (TextView) findViewById(R.id.tot);
        tvtot.setText(String.valueOf(total));
        
		lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(new ImageAdapter(getApplicationContext()));
		lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	TextView tv=(TextView) parent.findViewById(R.id.p1);           	
            	  delid = tv.getText().toString();
            	builder.setMessage("Are you sure want to Remove this Item?").setPositiveButton("Yes", dialogClickListener)
        	    .setNegativeButton("No", dialogClickListener).show();
   
            	/*Intent ij = new Intent(CheckOut.this, ViewSingleProd.class);
            	ij.putExtra("bugid",tv.getText());
            	startActivityForResult(ij,500); */
            }
        });			
	}

	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
	    @Override
	    public void onClick(DialogInterface dialog, int which) {
	        switch (which){
	        case DialogInterface.BUTTON_POSITIVE:	        	
	            //Yes button clicked
	        	con.execSQL("delete from cart where prodid='" + delid +"';");	
	        	Toast.makeText(CheckOut.this,"Removed Successfully", Toast.LENGTH_SHORT).show();    
	        	 Intent i = new Intent(CheckOut.this,CheckOut.class);
	        	  i.putExtra("userid", username);
	      	    	startActivity(i);
	            break;

	        case DialogInterface.BUTTON_NEGATIVE:
	            //No button clicked
	            break;
	        }
	    }
	};
	
	@SuppressLint("NewApi")
	public void Confirmorder(View v)
	{		
		 if (android.os.Build.VERSION.SDK_INT >= 9) {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
			}	
		 if (!products.equals(""))
		 {
			 res=WebService.confirmorder(username,products,String.valueOf(total),ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(),"confirmorder");
			// Toast.makeText(getApplication(),res.toString(),Toast.LENGTH_SHORT).show();
			 Toast.makeText(CheckOut.this, "Order Confirmed Successfully", Toast.LENGTH_SHORT).show();
		 }
		 else
		 {
			 Toast.makeText(getApplication(),"No Items to Place Order!",Toast.LENGTH_SHORT).show();
		 }
		
	}
	public void onback(View v)
	{
		finish();
	}
	
	public void onClear(View v)
	{
		con.execSQL("delete from cart;");	
    	Toast.makeText(CheckOut.this,"Cart Cleared Successfully", Toast.LENGTH_SHORT).show();    
    	finish();
	}
	private class ImageAdapter extends BaseAdapter
	{ 		
		private Context ctx;
		private TextView tv1;
		private TextView tv2;
		private TextView tv3;
		private TextView tv4;
		private TextView tv5;		
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
			ViewGroup onerow = (ViewGroup) layoutInflater.inflate(R.layout.onebug1, null);
			tv1 = (TextView) onerow.findViewById(R.id.p1);
			tv2 = (TextView) onerow.findViewById(R.id.p2);
			tv3 = (TextView) onerow.findViewById(R.id.p3);
			tv4 = (TextView) onerow.findViewById(R.id.p4);
			tv5 = (TextView) onerow.findViewById(R.id.p5);
	
			tv1.setText(prodid[position]);
			tv2.setText(prodname[position]);			
			tv3.setText(price[position]);
			tv4.setText(qty[position]);         
			tv5.setText(amt[position]);
			
			return onerow;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_out, menu);
		return true;
	}

}
