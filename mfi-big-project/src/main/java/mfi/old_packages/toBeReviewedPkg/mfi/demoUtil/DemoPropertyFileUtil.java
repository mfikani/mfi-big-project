package mfi.old_packages.toBeReviewedPkg.mfi.demoUtil;

import mfi.old_packages.toBeReviewedPkg.mfi.util.fileUtil.FileUtil;
import mfi.old_packages.toBeReviewedPkg.mfi.util.loadingPropertyFileUtil.PropertyFileUtil;

public class DemoPropertyFileUtil {

	public static void main(String[] args) {
		
		String propertyContent = "";
		propertyContent += "firstName=miled";
		propertyContent += "\n"+"lastName=fikani";
		propertyContent += "\n"+"countryCode=LB";
		propertyContent += "\n"+"countryName=Lebanon";
		propertyContent += "\n"+"countryCurrency=LL";
		propertyContent += "\n"+"countryLanguage=AR";
		
		System.out.println("DemoPropertyFileUtil : \n\n");
		System.out.println(propertyContent);

		String filePath = FileUtil.getUserDirectory()+"\\src\\main\\resources\\generatedPropertyFiles\\";
		
		
		String fileName = "DemoPropertyFileUtil.properties";
		
		FileUtil.writeFileData(propertyContent, filePath, fileName);
		
		// using the methods written below
		//doLoading();
		
		//*************************
		// using PropertyFileUtil
		//*************************
		String testType = "";
		/*
		 test1 	: error : wrong path
		 test2 	: error : wrong property key
		 test3 	: successful
		 */
		
		testType = "test3";
		
		
		
		if("test1".equals(testType)){
			PropertyFileUtil propertyFileUtil1 = new PropertyFileUtil("\\generated\\DemoPropertyFileUtil.properties");
			try{
				System.out.println(propertyFileUtil1.getProperty("name"));
			} catch (Exception e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(">>> error : wrong path");
		}else if("test2".equals(testType)){
			PropertyFileUtil propertyFileUtil2 = new PropertyFileUtil("\\generatedPropertyFiles\\DemoPropertyFileUtil.properties");
			try{
				System.out.println(propertyFileUtil2.getProperty("name"));
			} catch (Exception e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(">>> error : wrong property key");
		}else if("test3".equals(testType)){
			PropertyFileUtil propertyFileUtil3 = new PropertyFileUtil("\\DemoPropertyFileUtil.properties");
			try{
				System.out.println("firstName : "+propertyFileUtil3.getProperty("firstName"));
			} catch (Exception e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(">>> successful");
		}else{
			System.out.println("wrong test type");
		}
	}

}
