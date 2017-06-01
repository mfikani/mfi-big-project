package mfi.tech.java.other.checkDomains;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CheckDomains {
	public static void main(String[] args) {
		CheckDomains m = new CheckDomains();
		
//		Whois w = new Whois();
//		String[] urls = {"www.facebook.com","www.google.com"};
//		w.doWhois(urls);
		
		
		List alphabeticList = m.getAlphabetList(97,(97+26), false);
		int n = 3; // 1 or 2 or 3
		if(n == 1){
			//COMMENT: checking www.a.com , www.b.com ... 
			m.printList(alphabeticList);
			m.checkingCombinationsDomains(alphabeticList);
		}else if(n == 2){
			//COMMENT: checking www.aa.com, www.ab.com ... 
			List twoDigitPermutationsList = m.getTwoDigitPermutations(alphabeticList, false);
			m.printList(twoDigitPermutationsList);
			m.checkingCombinationsDomains(twoDigitPermutationsList);
		}else if(n == 3){
			//COMMENT: checking www.aaa.com, www.aab.com ...
			List threeDigitPermutationsList = m.getThreeDigitPermutations(alphabeticList, false);
			m.printList(threeDigitPermutationsList);
			m.checkingCombinationsDomains(threeDigitPermutationsList);
		}else{
			System.out.println("Wrong value for n, should be between 1 and 3");
		}
		
		
		//COMMENT: make ping in java
//		m.pingExample("zz.com");
		
		//COMMENT: display Character of code of 0 ->500
//		m.displayNcharaters(500);
		
//		System.out.println("Display Capital Alphabet characters code:");
//		m.getAlphabetList(65, (65+26), true);
	}
	public void checkingCombinationsDomains(List lt){
		for(int i=0;i<lt.size();i++){
			domainExists("www."+lt.get(i)+".com");
		}
	}
	public void printList(List lt){
		System.out.println(lt.size()+" permutations:\n"+lt);
	}
	public void domainExists(String url){
		boolean domainExists = true;
		try {
			InetAddress address = InetAddress.getByName(url);
			System.out.println(address.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			domainExists = false;
			System.out.println(url+" does not exists");
		}
	}
	
	public void pingExample(String url) {
		System.out.println("Ping :"+url);
		try{
			InetAddress address = InetAddress.getByName(url);
//			InetAddress address = InetAddress.getByAddress(url.getBytes());
			boolean isReachable = false;
			int time = 0;
			int counter = 0;
			long begin = System.currentTimeMillis();
			List<String> traceList = new ArrayList<String>();
			while(!isReachable && time < 10000){
				isReachable = address.isReachable(time);
				traceList.add("Time("+time+") : isReachable = "+isReachable+" ("+(counter+1)+") times");
				//Thread.sleep(100);
				counter++;
				time = (int) (System.currentTimeMillis() - begin);
			}
			for(String s : traceList){
				System.out.println(s);
			}
		} catch (Exception e){
			System.out.println(url+" is not valid.\n\n");
			e.printStackTrace();
		}
	}
	
	private void displayNcharaters(int n){
		getAlphabetList(0,n,true);
	}
	private List getAlphabetList(int from, int to, boolean doPrint){
		List res = new ArrayList();
		String s = "";
		for(int i = from;i < to;i++){
			s = Character.toString((char)(i));
			if(doPrint){
				System.out.println("String (or char) ["+s+"] have code : "+s.codePointAt(0));
			}
			res.add(s);
		}
		return res;
	}
	private static List getTwoDigitPermutations(List lt, boolean doPrint){
		List res = new ArrayList();
		String s = "";
		for(int i = 0;i<lt.size();i++){
			for(int j=0;j<lt.size();j++){
				s = lt.get(i)+""+lt.get(j);
				if(doPrint){
					System.out.println(s);
				}
				res.add(s);
			}
		}
		return res;
	}
	private static List getThreeDigitPermutations(List lt, boolean doPrint){
		List res = new ArrayList();
		String s = "";
		for(int i=0;i<lt.size();i++){
			for(int j=0;j<lt.size();j++){
				for(int k=0;k<lt.size();k++){
					s = lt.get(i)+""+lt.get(j)+""+lt.get(k);
					if(doPrint){
						System.out.println(s);
					}
					res.add(s);
				}
			}
		}
		return res;
	}

}

class Whois
{
	/**
	 * Method main
	 *
	 * The Truth is Out There!
	 *
	 * @param args Command line arguments
	 */
	public void doWhois(String[] args)
	{
		// Display usage if there are no command line arguments
		if (args.length < 1)
		{
			System.out.println("Usage: java Whois query[@<whois.server>]");

			return;
		}

		// Default server is whois.geektools.com
		String server = "whois.geektools.com";

		// Default server port is 43
		int port = 43;

		// Load the properties file.
		try
		{
			final FileInputStream in = new FileInputStream("Whois.properties");
			final Properties app = new Properties();

			app.load(in);

			// Get the server property
			server = (app.getProperty("server", server));

			// Get the port property
			try
			{
				port = Integer.parseInt(app.getProperty("port"));
			}
			catch (NumberFormatException e)
			{
				// Do nothing!
			}

			in.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			// Do nothing!
		}
		catch (IOException e)
		{
			System.err.println("Whois: an error occurred while loading the properties file: " + e);
		}

		// Build the whois query using command line arguments
		final StringBuffer buff = new StringBuffer(args[0]);

		for (int i = 1; i < args.length; i++)
		{
			buff.append(" " + args[i]);
		}

		// Convert string buffer to string
		String query = buff.toString();

		// The whois server can be specified after "@"
		// e.g.: query@whois.networksolutions.com
		final int at = query.lastIndexOf("@");
		final int len = query.length();

		if ((at != -1))
		{
			// Remove the @ if last character in query
			// e.g.: john@doe.com@
			if (at == (len - 1))
			{
				query = query.substring(0, len - 1);
			}
			else
			{
				// The whois server is specified after "@"
				server = query.substring(at + 1, len);
				// The whois query is specified before "@"
				query = query.substring(0, at);
			}
		}

		try
		{
			// Establish connection to whois server & port
			final Socket connection = new Socket(server, port);
			final PrintStream out =
					new PrintStream(connection.getOutputStream());
			final BufferedReader in = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			String line = "";

			// Send the whois query
			out.println(query);
			// Display the whois server's address & port
			System.out.println("[" + server + ":" + port + "]");

			// Read/display the query's result
			while ((line = in.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (java.net.UnknownHostException e)
		{
			// Unknown whois server
			System.err.println("Whois: unknown host: " + server);

			return;
		}
		catch (IOException e)
		{
			// Could not connect to whois server
			System.err.println("Whois: " + e);

			return;
		}
	}
}
