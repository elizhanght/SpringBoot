package com.xunheyun.utils;

public class LogUtils {

	private static LogUtils _instance;
	
	public StringBuffer _sb = new StringBuffer();
	
	public static LogUtils getInstance(){
		
		if (_instance == null) {
			_instance = new LogUtils();
		}
		return _instance;
	}

}
