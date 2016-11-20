package com.changcai.test.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PropertiesUtil {
	
	public static HashMap<String,String> readFromStringArray(Path path) {
		
		HashMap<String,String> kv = new HashMap<String,String>();
		
		List<String> lineList = Collections.emptyList();
		try {
		lineList = java.nio.file.Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		String[] s = lineList.toArray(new String[0]);
		
		for(int i=0;i<s.length;i++){
			String temp = s[i];
			if(!temp.trim().startsWith("#")){
				String t[] = temp.split("\t");
				String k = t[0];
				String v = t[1];
				kv.put(k, v);				
			}
		}
		return kv;
	}
	
	public static Path path= new File("src/res/properties").toPath();
	public static HashMap<String,String> kv = readFromStringArray(path);

	public static String getSite() {
		return kv.get("Site");
	}
	
	
	public static String getSqlURL() {
		return kv.get("MySQL");
	}
	
//	TestOK.
//	public static void main(String args[]) {
//		System.out.println(getSite());
//	}
}
