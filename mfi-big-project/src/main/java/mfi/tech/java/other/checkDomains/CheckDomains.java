package mfi.tech.java.other.checkDomains;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class CheckDomains {
	public static void main(String[] args) {
		CheckDomains m = new CheckDomains();
		
		List alphabeticList = m.getAlphabetList(97,(97+26), false);
		int n = 2; // 1 or 2 or 3
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
//		m.pingExample("www.facebook.com");
		
		//COMMENT: display Character of code of 0 ->500
//		m.displayNcharaters(500);
		
//		System.out.println("Display Capital Alphabet characters code:");
//		m.getAlphabetList(65, 90, true);
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
