package com.sales.genericUtils;

import java.util.Date;
import java.util.Random;
/**
 * This class contains of java related methods
 * @author TANYA
 */
public class JavaUtility {
	/**
	 * This method is use to get the random number
	 * @return
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		int randnum=ran.nextInt(1000);
		return randnum;
		}
	/**
	 * This method is fetch system data in IST format
	 * @return
	 */
	public String getSystemData() {
     Date date=new Date();
     return date.toString();
	}
	/**
	 * This method is used to fetch system data in required format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date datetime=new Date();
		String[] d = datetime.toString().split(" ");
		String day=d[0];
		String month=d[1];
		String date=d[2];
		String year=d[5];
		String finalformat=day+" "+month+" "+date+" "+year;
		return finalformat;
	}

}


