package mfi.old_packages.toBeReviewedPkg.mfi.demoUtil;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//import com.sun.org.apache.xerces.internal.impl.xs.dom.DOMParser;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import mfi.old_packages.toBeReviewedPkg.mfi.util.fileUtil.FileUtil;
import mfi.old_packages.toBeReviewedPkg.mfi.util.parsersUtil.DOMParserUtil;


public class DemoDOMParserUtil {

	public static void main(String[] args) {
		/*
		 <?xml version="1.0" encoding="UTF-8"?>
			<Company>
				<Name>My Company</Name>
				<Executive type="CEO">
					<LastName>Smith</LastName>
					<FirstName>Jim</FirstName>
					<street>123 Main Street</street>
					<city>Mytown</city>
					<state>NY</state>
					<zip>11234</zip>
				</Executive>
			</Company> 
		 * */
		
		String myXML = "";
		myXML += "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
		myXML +=	"<Company>";
		myXML +=		"<Name>My Company</Name>";
		myXML +=		"<Executive type=\"CEO\">";
		myXML +=			"<LastName>Smith</LastName>";
		myXML +=			"<FirstName>Jim</FirstName>";
		myXML +=			"<street>123 Main Street</street>";
		myXML +=			"<city>Mytown</city>";
		myXML +=			"<state>NY</state>";
		myXML +=			"<zip>11234</zip>";
		myXML +=		"</Executive>";
		myXML +=	"</Company>";
		
		System.out.println("XML : \n\n");
		System.out.println(myXML);
	
		String filePath = FileUtil.getUserDirectory()+"\\src\\main\\resources\\generated\\";
		System.out.println(">>> "+filePath);
		String fileName = "DemoDOMParserUtil.xml";
		
		FileUtil.writeFileData(myXML, filePath, fileName);
		
		//Parsing
		try{
			DOMParser parser = new DOMParser();
			parser.parse(filePath+fileName);
			Document doc = parser.getDocument();
			
			// Get the document's root XML node
			NodeList root = doc.getChildNodes();
			
			// Navigate down the hierarchy to get to the CEO node
			Node comp = DOMParserUtil.getNode("Company", root);
			Node exec = DOMParserUtil.getNode("Executive", comp.getChildNodes());
			String execType = DOMParserUtil.getNodeAttr("type", exec);
			
			// Load the executive's data from the XML
			NodeList nodes 		= exec.getChildNodes();
			String lastName 	= DOMParserUtil.getNodeValue("LastName"	, nodes);
			String firstName 	= DOMParserUtil.getNodeValue("FirstName", nodes);
			String street 		= DOMParserUtil.getNodeValue("street"	, nodes);
			String city			= DOMParserUtil.getNodeValue("city"		, nodes);
			String state		= DOMParserUtil.getNodeValue("state"	, nodes);
			String zip			= DOMParserUtil.getNodeValue("zip"		, nodes);
			
			
			System.out.println("\n\n");
			System.out.println("Executive Information:");
			System.out.println("Type: "+execType);
			System.out.println(lastName+", "+firstName);
			System.out.println(street);
			System.out.println(city+", "+state+" "+zip );
			
			
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(SAXException e1){
			e1.printStackTrace();
		}
	}

}
