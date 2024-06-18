package com.example.stitchingandro;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.example.stitchingandro.R;
import com.example.stitchingandro.R.layout;
import com.example.stitchingandro.R.menu;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class VendorRegistration extends Activity {
	private Button b1,b2,b3;
	public String cal,s,res;
	Spinner sp1,sp2,sp3;
	public EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
	ImageView iv1;	  
	Bitmap bitmap;
	int SELECT_PICTURE = 200;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vendor_registration);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		e3=(EditText) findViewById(R.id.editText3);
		e4=(EditText) findViewById(R.id.editText4);
		e5=(EditText) findViewById(R.id.editText5);		
		sp1=(Spinner) findViewById(R.id.spinner1);
		sp2=(Spinner) findViewById(R.id.spinner2);
		sp3=(Spinner) findViewById(R.id.spinner3);
		e6=(EditText) findViewById(R.id.editText6);
		e7=(EditText) findViewById(R.id.editText7);
		e8=(EditText) findViewById(R.id.editText8);
		iv1 =(ImageView) findViewById(R.id.imageView1);

		b1=(Button)findViewById(R.id.Button1);
		b2=(Button)findViewById(R.id.imageButton1);
		b3=(Button)findViewById(R.id.imageButton2);
		b2.setOnClickListener(new OnClickListener() {			 
			@Override
			@SuppressLint("NewApi")
			public void onClick(View v) {
				 if (android.os.Build.VERSION.SDK_INT >= 9) {
						StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
						StrictMode.setThreadPolicy(policy);
					}			
				 try {
					res=WebService.vendorregister(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString(),e7.getText().toString(),sp1.getSelectedItem().toString(),sp2.getSelectedItem().toString(),sp3.getSelectedItem().toString(),e8.getText().toString(),fileToBase64(e8.getText().toString()),"vendorregister");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 Toast.makeText(getApplication(),res.toString(),Toast.LENGTH_SHORT).show();
  			} 
		});
		b3.setOnClickListener(new OnClickListener() {			 
			@Override
			@SuppressLint("NewApi")
			public void onClick(View v) {
				finish();
  			} 
		});
		
		 b1.setOnClickListener(new View.OnClickListener() {
	            @Override
	            @SuppressLint("NewApi")
	            public void onClick(View v) {
	                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	                StrictMode.setThreadPolicy(policy);
	                imageChooser();
	            }
	        });		
	}
    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {
        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                String selectedImagePath;
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                e8.setText(selectedImagePath);
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    iv1.setImageURI(selectedImageUri);
                }
            }         
        }
    }

    // UPDATED!
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Video.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }


    public static String fileToBase64(String path) throws IOException {
        byte[] bytes = fileToByteArray(path);
        return  Base64.encodeToString(bytes, Base64.NO_WRAP);
    }

    public static byte[] fileToByteArray(String path) throws IOException {
        File imagefile = new File(path);
        byte[] data = new byte[(int) imagefile.length()];
        FileInputStream fis = new FileInputStream(imagefile);
        fis.read(data);
        fis.close();
        return data;
    }
    public String encodeTobase64(Bitmap image)
    {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stu_register, menu);
		return true;
	}

}
