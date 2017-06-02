package mfi.old_packages.toBeReviewedPkg.mfi.util.dateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author mfi
 *
 */
public class DateUtil {
	
	public static String getDateAsString(Date d){
		DateFormat df = new SimpleDateFormat(DateFormatUtil.FULL_DATE);
		return df.format(d);
	}
	
	public static Date getStringAsDate(String dateStr){
		DateFormat df = new SimpleDateFormat(DateFormatUtil.DD_MM_YYYY);
		Date resultDate = null;
		try{
			resultDate = df.parse(dateStr);
		}catch(ParseException pe){
			pe.printStackTrace();
		}
		return resultDate;
	}
	
	/*
	 * ex: Friday
	 */
	public static String getDayName(Date d){
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		DateFormat dayNameF = new SimpleDateFormat("EEEEEEEE");
		String dayName = dayNameF.format(d);
		System.out.println(df.format(d)+" happens to be a : "+dayName);
		return dayName;
	}
	
	/*
	 * ex: Mon Aug 01 18:30:11 EEST 2016
	 * */
	public static Date getFirstDayOfCurrentMonth(){
		Calendar d = Calendar.getInstance();
		d.set(Calendar.DAY_OF_MONTH, d.getActualMinimum(Calendar.DAY_OF_MONTH));
		System.out.println("First day of month of date [] is : "+d.getTime());
		return d.getTime();
	}
	
	/*
	 * ex: 26/8/2016
	 */
	public static String printDate(Calendar d){
		return (d == null)?"":(d.get(Calendar.DAY_OF_MONTH)+"/"+(d.get(Calendar.MONTH)+1)+"/"+d.get(Calendar.YEAR));
	}
	
	public static void main(String[] args){
		Calendar d = Calendar.getInstance();
		getDayName(d.getTime());
		getFirstDayOfCurrentMonth();
		System.out.println(printDate(d));
	}

}
