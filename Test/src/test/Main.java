package test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;



public class Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Double ds = 1 / 35d *  0.002953693290491991 ;

		//System.out.println("" + ds.toString());
		NumberFormat formatter = new DecimalFormat("###.###########");  
		   
		String f = formatter.format(4.9734025714285714285714285714286e-4);  
		//System.out.println("" + f);
		print(f);
		String key = "12-15-1420744965057";
		byte[] b = key.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(key.getBytes("UTF8"));
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
			print(hashtext);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void print(String arg0) {
		System.out.println("" + arg0);
	}
	private static void print(int arg0) {
		print(String.valueOf(arg0));
	}
	private static void print(double arg0) {
		print(String.valueOf(arg0));
	}
	
	private static double getDistance(double lat1, double lon1, double lat2,
			double lon2) {
		double latA = Math.toRadians(lat1);
		double lonA = Math.toRadians(lon1);
		double latB = Math.toRadians(lat2);
		double lonB = Math.toRadians(lon2);
		double cosAng = (Math.cos(latA) * Math.cos(latB) * Math
				.cos(lonB - lonA)) + (Math.sin(latA) * Math.sin(latB));
		double ang = Math.acos(cosAng);
		double dist = ang * 6371;
		return dist;
	}
}
