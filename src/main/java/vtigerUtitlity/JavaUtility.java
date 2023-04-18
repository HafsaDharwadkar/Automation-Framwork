package vtigerUtitlity;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
		
		/**
		 * This method will return random number
		 * @return
		 */
		public int getRandomNumber()
		{
			Random r=new Random();
			return r.nextInt(10000);
		}
		
		/** 
		 * this method will return system date in particular format
		 * @return
		 */
		public String getDate()
		{
			Date d=new Date();
			String[] darr = d.toString().split(" ");
			String Date=darr[2];
			String mon=darr[1];
			String year=darr[5];
			String time=darr[3];
		   String datavalue = Date+"-"+mon+"-"+year+"-"+time;
		   return datavalue;
		}
}
