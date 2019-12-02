package com.smi.innothink.services;

public class AutoIncrement {
	public static String incrementId(int id,String prefix)
	
	{
		String result="";
		id++;
		System.out.println(id);
		result=prefix+id;
		return result;
	}
	
	

}
