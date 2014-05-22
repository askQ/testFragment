package com.example.testfragment;

import android.net.Uri;

public class MyObject {
	String  titleFromEdittext;
    String UriFroFramgnet;
    String DetailFromEdittext;
	/*
	 this object to save  some property  that you get from fragment 
	 */
	public MyObject(String titleFrom, String DetailFrom,String Urifrom) {
		 titleFromEdittext=titleFrom;
		 UriFroFramgnet=Urifrom;
		 DetailFromEdittext=DetailFrom;
	}
}
