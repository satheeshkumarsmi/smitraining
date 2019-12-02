package com.smi.innothink.services;

public class AutoIncrement {
	public static String incrementId(String id)
	
	{
		String result="";
		System.out.println(id);
		int i=Integer.parseInt(id.substring(11));
		i++;
		System.out.println(i);
		result=id.substring(0,11)+i;
		return result;
	}
	
	

}
