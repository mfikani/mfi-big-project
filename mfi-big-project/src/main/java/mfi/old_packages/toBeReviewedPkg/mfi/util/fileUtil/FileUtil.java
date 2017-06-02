package mfi.old_packages.toBeReviewedPkg.mfi.util.fileUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	public static String readFileData(File file){
		String temp, message = null;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);
			
			temp = "";
			message = "";
			while((temp = reader.readLine()) != null){
				message += temp;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	public static void writeFileData(String strData, String filePath, String fileName){
		String content = strData;
		String path = filePath+fileName;
		File file = new File(path);
		
		System.out.println("Check File :"+path);
		
		try {
			// if file doesnt exists, then create it
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			// write in file
			bw.write(content);
			// close connection
			bw.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getUserDirectory(){
		return System.getProperty("user.dir");
	}
}
