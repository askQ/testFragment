package com.example.testfragment;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.Toast;

public class Preview extends Activity {
	ArrayList<MyObject> arrayList;
	ListView ListView_here;
	Gallery gallery;
    Myadapter adapter;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.preview);
	        Intent intent = getIntent();
	     //   ArrayList<MyObject> arrayList = new ArrayList<MyObject>(); 
	     //   arrayList =(ArrayList<MyObject>)getIntent().getSerializableExtra("arrayList");
	        ArrayList<MyObject> arrayList=(ArrayList<MyObject>)getIntent().getSerializableExtra("arrayList");
	        gallery =  (Gallery) findViewById(R.id.gallery);
//	       Toast.makeText(getApplicationContext(),arrayList.toString(), 1).show();
	 //       ListView_here= (ListView) findViewById(R.id.listView);
    			        adapter = new Myadapter(getApplicationContext(), arrayList);
	
    			        gallery.setAdapter(adapter);
	    		
    			        gallery.setBackgroundColor(Color.BLUE);
	 //       ArrayList<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>(); 
	       
	        Button button = (Button)findViewById(R.id.button);
	  	  button.setOnClickListener(new OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View arg0) {
	  				  Intent intent = new Intent();
	  		            intent.setClass(Preview.this,MainActivity.class);
	  		            startActivity(intent);
	  		            finish();

	  			}
	  		});
	        
	    }
	
	
}
