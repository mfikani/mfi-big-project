package mfi.old_packages.toBeReviewedPkg.mfi.demoUtil;

import java.io.File;
import java.util.Calendar;

import mfi.old_packages.toBeReviewedPkg.mfi.util.dateUtil.DateUtil;
import mfi.old_packages.toBeReviewedPkg.mfi.util.fileUtil.FileUtil;

/**
 * 
 * @author mfi
 *
 */
public class DemoDateUtil {

	public static void main(String[] args) {
		int xDays = 1; 
		getFilesOlderThanXday(xDays);
	}
	
	
	/**
	 * This method is used to encode bytes using Base64
	 * 
	 * @param content
	 * @return Encoded byte[]
	 */
	
	
	/**
	 * Give a path to a folder, this file check all the folder contents ( folders or files ) and print if older than x days
	 * 
	 * @param xDays 
	 */
	private static void getFilesOlderThanXday(int xDays) {
		String srcFolder = System.getProperty("user.dir");
		String testingFolder = srcFolder+"\\src\\main\\resources\\generated\\";
		
		FileUtil.writeFileData("generated when DemoDateUtil is executed", testingFolder, "DemoDateUtil.txt");
		
		String testingPath = testingFolder;
		File file = new File(testingPath);
		System.out.println("\nLooking in: "+file.getPath()+"\n\n");
		
		if(file.isDirectory()){
			for(File f : file.listFiles()){
				boolean isOlderThanXdays = isOlderThanXdays(f,xDays);
				String fileType = (f.isDirectory())?"Folder":"File";
				System.out.println(fileType+" ["+f.getName()+"] is older than "+xDays+" : "+isOlderThanXdays+"\n");
			}
		}		
	}
	
	private static boolean isOlderThanXdays(File file, int xDays){
		DateUtil u = new DateUtil();
		
		Calendar calFile = Calendar.getInstance();
		calFile.setTimeInMillis(file.lastModified());		
		Calendar cal = Calendar.getInstance();		
		cal.add(Calendar.DATE, -xDays);
		System.out.println("Current Date: "+u.getDateAsString(Calendar.getInstance().getTime())+"\tSpecified Date: "+u.getDateAsString(cal.getTime())+"\tFile Date: "+u.getDateAsString(calFile.getTime()));
		return (cal.compareTo(calFile) > 0);
	}
}
