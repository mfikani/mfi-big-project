package mfi.old_packages.toBeReviewedPkg.mfi.util.loadingPropertyFileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import mfi.old_packages.exceptions.PropertyDefinitionsNotSetException;

/**
 * Read anyFile.properties file
 * @author mfi
 *
 */
public class PropertyFileUtil {
	
	private Properties properties;
	private String PropertyFileName;
	
	public PropertyFileUtil(String PropertyFileName){
		properties = new Properties();
		this.PropertyFileName = PropertyFileName;
	}
	
	/**
	 * Retrieve property value for parameter key <br />
	 * if the key does not exist or value is empty <br />
	 * throws an exception <br />
	 * 
	 * @param key
	 * @return key value
	 * @throws PropertyDefinitionsNotSetException
	 */
	public String getProperty(String key)throws PropertyDefinitionsNotSetException{
		try{
			InputStream in = getClass().getClassLoader().getResourceAsStream(PropertyFileName);
			System.out.println(in);
			properties.load(in);
		}catch(IOException io){
			//io.printStackTrace();
			String errorStr = "["+this.getClass().getName()+"] property file ["+PropertyFileName+"] does not exists in folder ressources";
			return errorStr;
		}
		if(properties.getProperty(key) == null || properties.getProperty(key).length() == 0){
			throw new PropertyDefinitionsNotSetException("key ["+key+"] does not have value in property ["+PropertyFileName+"]");
		}
		return properties.getProperty(key);
	}
}
