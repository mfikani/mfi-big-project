package mfi.tech.java.routing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/*
 6
2
10.0.0.1 255.0.0.0
192.168.0.1 255.255.255.0
1
10.0.0.2 255.0.0.0
3
192.168.0.2 255.255.255.0
212.220.31.1 255.255.255.0
212.220.35.1 255.255.255.0
1
212.220.31.2 255.255.255.0
2
212.220.35.2 255.255.255.0
195.38.54.65 255.255.255.224
1
195.38.54.94 255.255.255.224
1 6 
 * */
public class RoutingNotFinished {

	private static int fromComputer = 0;
	private static int toComputer = 0;
	private static String parthStr = "";
	
	public static void main(String[] args) {
		HashMap<String, ArrayList> interfacesMap = new HashMap();
		
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Computer> computersList = new ArrayList<>();
		try{
			int N = sc.nextInt();
			for(int i=0;i<N;i++){
				Computer computer = new Computer();
				computer.nbr = i+1;
				int interfaceNbr = sc.nextInt();		
				sc.nextLine();
				computer.interfaceNbr = interfaceNbr;
				NetInterface netInterface = null;
				for(int j=0;j<interfaceNbr;j++){
					String tempInterface = sc.nextLine();
					//				System.out.println("Computer["+i+"] : J["+j+"] :  tempInterface = "+tempInterface);
					String[] tempInterfaceArr = tempInterface.split(" ");
					if(tempInterfaceArr != null && tempInterfaceArr.length == 2){
						netInterface  = new NetInterface(validAddr(tempInterfaceArr[0]),validAddr(tempInterfaceArr[1]));
						computer.addInterface(netInterface);
						if(interfacesMap.get(netInterface.netAddress) != null){
							(interfacesMap.get(netInterface.netAddress)).add(computer);
						}else{
							ArrayList lt = new ArrayList();
							lt.add(computer);
							interfacesMap.put(netInterface.netAddress, lt);
						}
					}
				}
				computersList.add(computer);
			}
			fromComputer = sc.nextInt();
			toComputer = sc.nextInt();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sc.close();
		
		
		
		for(int i = 0;i < computersList.size();i++){
			Computer c = computersList.get(i);
			System.out.println();
			for(int j=0;j<c.interfaceNbr;j++){
				NetInterface netInterface = c.interfaces.get(j); 
				System.out.println((i+1)+" : "+/*netInterface.ip+" "+netInterface.subnet+" >> "+*/netInterface.netAddress);
			}
		}
		
		ArrayList<NetInterface> tempList = new ArrayList();
		Set takenComputers = new HashSet();
		
		String paths = "";
		Computer beginComputer = computersList.get(fromComputer-1);
		if(beginComputer != null){
//			Computer c = beginComputer;
//			while(c != null && !takenComputers.contains(c)){
//				takenComputers.add(c);
//				tempList = c.interfaces;
//				paths += c.nbr+" ";
//				System.out.println(paths);
//				for(NetInterface ni : tempList){
//					c = interfacesMap.get(ni.netAddress);
//				}
//			}
//			processChildren(interfacesMap , beginComputer, takenComputers);
			
			miled(interfacesMap , beginComputer, takenComputers);
		}
		System.out.println(paths);
	}
	private static Computer miled(HashMap<String, ArrayList> interfacesMap , Computer beginComputer, Set takenComputers){
		ArrayList<NetInterface> tempList;
		Computer destinationComputer = null;
		Computer c = beginComputer;
		if(c != null){
			System.out.println("c : "+c.nbr);
			tempList = c.interfaces;
			takenComputers.add(c);
			for(NetInterface ni : tempList){
				ArrayList<Computer> lt = interfacesMap.get(ni.netAddress);
				for(Computer cc : lt){
					if(cc.nbr == toComputer){
						destinationComputer = cc;
						break;
					}
				}
			}
			if(destinationComputer != null){
				return destinationComputer;
			}else{
				for(NetInterface ni : tempList){
					ArrayList<Computer> lt = interfacesMap.get(ni.netAddress);
					for(Computer cc : lt){
						if(!takenComputers.contains(cc)){
							return miled(interfacesMap , cc, takenComputers);
						}
					}
				}
			}
		}else{
			return destinationComputer;
		}
		return destinationComputer;
	}
	
	private static Computer processChildren(HashMap<String, Computer> interfacesMap , Computer beginComputer, Set takenComputers){
		ArrayList<NetInterface> tempList = new ArrayList();
		String paths = "";
		Computer c = beginComputer;
		while(c != null && !takenComputers.contains(c)){
			takenComputers.add(c);
			tempList = c.interfaces;
			paths += c.nbr+" ";
			System.out.println(paths);
			for(NetInterface ni : tempList){
				c = interfacesMap.get(ni.netAddress);
				return (processChildren(interfacesMap, c, takenComputers));
			}
		}
		return c;
	}
	
	private static String validAddr(String ip) throws Exception{
		String globablErrorStr = "ip or subnet format is wrong";
		if(ip == null){
			throw new Exception(globablErrorStr);
		}
		String[] ar = ip.split("\\.");
		if(ar == null || ar.length != 4){
			throw new Exception(globablErrorStr);
		}
		int x;
		for(int i=0;i<ar.length;i++){
			try{
				x = Integer.parseInt(ar[i]);
			}catch(Exception e){
				throw new Exception(globablErrorStr);
			}
			if(x < 0 || x > 255){
				throw new Exception(globablErrorStr);
			}
		}
		return ip;
	}
}

class Computer{
	int nbr;
	int interfaceNbr;
	ArrayList<NetInterface> interfaces = new ArrayList();
	
	public void addInterface(NetInterface e){
		interfaces.add(e);
	}
}
class NetInterface{
	String ip;
	String subnet;
	String netAddress;
	
	NetInterface(String ip, String subnet){
		this.ip = ip;
		this.subnet = subnet;
		netAddress = getNetInterface(ip, subnet);
	}
	
	private static String getNetInterface(String ipAddr, String mask){
		String networkAddr="";
		String[] ipAddrParts=ipAddr.split("\\.");
		String[] maskParts=mask.split("\\.");
		for(int i=0;i<4;i++){
			int x=Integer.parseInt(ipAddrParts[i]);
			int y=Integer.parseInt(maskParts[i]);
			int z=x&y;
			networkAddr+=z+".";
		}
		networkAddr = networkAddr.substring(0,networkAddr.length()-1);
		return networkAddr;
	}
}