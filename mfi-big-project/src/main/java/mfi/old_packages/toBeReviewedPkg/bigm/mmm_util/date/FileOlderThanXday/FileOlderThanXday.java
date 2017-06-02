package mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.date.FileOlderThanXday;

import java.io.File;
import java.util.Calendar;

import mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.date.MfiDateUtil;
/***
 * Give a path to a folder, this file check all the folder contents ( folders or files ) and print if older than x days
 * @author mfi
 *
 */
public class FileOlderThanXday
{
	private static final boolean showLogMode = false;
	private static int xDays = 5;

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String srcFolder = System.getProperty("user.dir");
		String testingFolder = srcFolder+"\\src\\com\\bigm\\mfi";
		//testingFolder = "E:\\mfi\\mmm";
		//String testingFileName = "mfiNote.txt";
		String testingPath = testingFolder /*+ testingFileName*/;
		
		
		File file = new File(testingPath);
		System.out.println("Looking in : "+file.getPath());
		
		
		if(file.isDirectory()){
			for(File f : file.listFiles()){
				boolean isOlderThanXdays = isOlderThanXdays(f,xDays);
				String fileType = (f.isDirectory())?"Folder":"File";
				System.out.println("\n"+fileType+" ["+f.getName()+"] is older than "+xDays+" : "+isOlderThanXdays);
			}
		}
	}
	
	

	private static boolean isOlderThanXdays(File file, int nbOfDays){
		MfiDateUtil u = new MfiDateUtil();
		
		Calendar calFile = Calendar.getInstance();
		calFile.setTimeInMillis(file.lastModified());

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -nbOfDays);
		if(showLogMode){
			System.out.println("Current Date : "+(u.getDateString(Calendar.getInstance().getTime())+"\tSpecified Date : "+u.getDateString(cal.getTime()) + "\tFile Date : "+ u.getDateString(calFile.getTime())));
		}
		return (cal.compareTo(calFile) > 0);
	}
}
