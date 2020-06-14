package com.systemdependency.sofware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemDependency {

	public static void main(String[] args) {
		String commands = "DEPEND TELNET TCPIP NETCARD\r\n" + 
				"DEPEND TCPIP NETCARD\r\n" + 
				"DEPEND DNS TCPIP NETCARD\r\n" + 
				"DEPEND BROWSER TCPIP HTML\r\n" + 
				"INSTALL NETCARD\r\n" + 
				"INSTALL TELNET\r\n" + 
				"INSTALL foo\r\n" + 
				"REMOVE NETCARD\r\n" + 
				"INSTALL BROWSER\r\n" + 
				"INSTALL DNS\r\n" + 
				"LIST\r\n" + 
				"REMOVE TELNET\r\n" + 
				"REMOVE NETCARD\r\n" + 
				"REMOVE DNS\r\n" + 
				"REMOVE NETCARD\r\n" + 
				"INSTALL NETCARD\r\n" + 
				"REMOVE TCPIP\r\n" + 
				"REMOVE BROWSER\r\n" + 
				"REMOVE TCPIP\r\n" + 
				"END";
		
		System.out.println(args[0].split("\\s")[1]);
		Map<String, DependendtComponents> dependentComponentsMap = new HashMap<String, DependendtComponents>();
		List<String> installedSoftware = new ArrayList<String>();
	}

}
