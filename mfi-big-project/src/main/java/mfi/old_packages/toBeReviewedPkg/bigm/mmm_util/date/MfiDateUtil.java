package mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MfiDateUtil 
{
	public static String getDateString(Date d){
		DateFormat df = new SimpleDateFormat(MfiDateFormat.full_date);
		return df.format(d);
	}
	
	public static Date getStringAsDate(String dateStr){
		DateFormat df = new SimpleDateFormat(MfiDateFormat.DD_MM_YYYY);
		Date resultDate = null;
		try
		{
			resultDate = df.parse(dateStr);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return resultDate;
	}
}
