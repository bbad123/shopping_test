package kr.co.sptek.member.common;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	/**
	 * 
	 */
	public Utility() {
		super();
	}

	public static String toMD5(String str) {
		StringBuffer outStr = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hash = md.digest(str.getBytes());
			 
			int onebyte;
			int i = 0;

			outStr = new StringBuffer( hash.length * 2);
			 
			while( i < hash.length ) {
				onebyte = ((0x000000ff& hash[i]) | 0xffffff00);
				outStr.append( Integer.toHexString( onebyte ).substring( 6 )) ;
				i++ ;
			}

		} catch (Exception e) {}

		return outStr.toString();
	}
	
	public static String getTimePartition(int gapSec){
		
		//SMS Partition info : Current Time - 5 Minute
		long currentTime = System.currentTimeMillis();		
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmm");

		String nowTime = dayTime.format(new Date(currentTime));
		String nowTemp = nowTime.substring(nowTime.length()-1, nowTime.length());

		if((Integer.parseInt(nowTemp)/5) == 0){
			nowTime = nowTime.substring(0, nowTime.length()-1) + "0";
		}else {
			nowTime = nowTime.substring(0, nowTime.length()-1) + "5";
		}
		
		long beforeTime = currentTime - (gapSec * 1000 * 60);
		String preTime = dayTime.format(new Date(beforeTime));
		String preTemp = preTime.substring(preTime.length()-1, preTime.length());

		if((Integer.parseInt(preTemp)/5) == 0){
			preTime = preTime.substring(0, preTime.length()-1) + "0";
		}else {
			preTime = preTime.substring(0, preTime.length()-1) + "5";
		}
		
		return preTime + "00," + nowTime + "00";
	}
	
	public static String getDayPartition(){
		
		//SMS Partition info : Current Time - 5 Minute
		long currentTime = System.currentTimeMillis();		
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmm");

		String nowTime = dayTime.format(new Date(currentTime));
		String nowTemp = nowTime.substring(nowTime.length()-1, nowTime.length());

		if((Integer.parseInt(nowTemp)/5) == 0){
			nowTime = nowTime.substring(0, nowTime.length()-1) + "0";
		}else {
			nowTime = nowTime.substring(0, nowTime.length()-1) + "5";
		}
		
		String preTime = nowTime.substring(0, 8);

		return preTime + "000000," + nowTime + "00";
	}	

}
