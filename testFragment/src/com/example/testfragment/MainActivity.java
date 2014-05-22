package com.example.testfragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity implements Comunicator {
 
	ImageView imageView;
	TextView tv,tv1;
	//ListView ListView_here;
	Gallery View_here;
	ArrayList<MyObject> arrayList;
	//ImageSwitcher imageSwitcher;
	Myadapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView) findViewById(R.id.imageView1);
		
		tv = (TextView) findViewById(R.id.textView1);
		tv1= (TextView) findViewById(R.id.textView2);
		arrayList = new ArrayList<MyObject>();
//		ListView_here= (ListView) findViewById(R.id.listView);
		View_here =  (Gallery) findViewById(R.id.gallery);
		Toast.makeText(getApplicationContext(),arrayList.size(), 1).show();
		adapter = new Myadapter(getApplicationContext(), arrayList);
	//	Toast.makeText(getApplicationContext(), adapter.getCount(), 1).show();
		View_here.setAdapter(adapter);
		
		View_here.setBackgroundColor(Color.BLUE);

		
		View_here.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override         
			public boolean onItemLongClick(AdapterView<?> av, View v, final int pos, long id)
			            {
			             Object listItem = View_here.getItemAtPosition(pos);
			                Toast.makeText(MainActivity .this, "The long clicked item is " + pos, Toast.LENGTH_LONG).show();
	
			                Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
			                alertDialogBuilder.setTitle("Delete item");
			                alertDialogBuilder.setMessage("Are you sure?");
			                alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			                    public void onClick(DialogInterface dialog,int id) {
			                    	arrayList.remove(pos);
			        				adapter.notifyDataSetChanged();
			                    }
			                  });
			                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
			                    public void onClick(DialogInterface dialog,int id) {
			                            dialog.cancel();		
			                    }	
			                });
			                AlertDialog alertDialog = alertDialogBuilder.create();	
			                alertDialog.show();
			                return true; //false will also trigger OnItemClick!
			            }	
			       });


		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialogFragment dialogFragment = new dialogFragment();
				dialogFragment.show(getFragmentManager(), "hello :)) ");
			}
		});
	}

	@Override
	public void doSomeThing(String text, String Text1,Uri uri) {

		if (uri !=null) {
			imageView.setImageURI(uri);
		}
			tv.setText(text);
			tv1.setText(Text1);
			
	}
	
	@Override
	public void save(String title, String detail,String uri_s_from ){
		arrayList.add(new MyObject(title,detail,uri_s_from));
		//	Toast.makeText(getApplicationContext(), uri_s_from, 1).show();
		/*
		Map<String,String> map = new HashMap<String,String>();
		  map.put("Title",title);
		  map.put("detail",detail);
	      map.put("Uri_string", uri_s_from);
		  list.add(map);*/
		 
	}
}
