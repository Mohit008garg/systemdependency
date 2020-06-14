package com.systemdependency.sofware;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemDependency {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("No command found");
		}else {
			String[] commands = args[0].split("\\n");
			Map<String, DependendtComponents> dependentComponentsMap = new HashMap<String, DependendtComponents>();
			List<String> installedSoftware = new ArrayList<String>();
			renderSystemDependency(commands, dependentComponentsMap, installedSoftware);
		}
	}

	private static void renderSystemDependency(String[] commands,
			Map<String, DependendtComponents> dependentComponentsMap, List<String> installedSoftware) {
		for (int commandCounter=0; commandCounter<commands.length; commandCounter++){
			
			String[] splitCommand = commands[commandCounter].split("\\s");
			
			if (splitCommand[0].equals("DEPEND")){
				takeDependCommandAction(splitCommand, dependentComponentsMap);
			}
			if(splitCommand[0].equals("INSTALL")){
				takeInstallMethodAction(dependentComponentsMap, installedSoftware, splitCommand);
			}
			if(splitCommand[0].equals("LIST")){
				takeListMethodAction(installedSoftware);
			}
			if(splitCommand[0].equals("REMOVE")){
				takeRemoveMethodAction(dependentComponentsMap, installedSoftware, splitCommand);
			}
		}
		
	}

	/**
	 * @param dependentComponentsMap
	 * @param installedSoftware
	 * @param splitCommand
	 */
	private static void takeRemoveMethodAction(Map<String, DependendtComponents> dependentComponentsMap,
			List<String> installedSoftware, String[] splitCommand) {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * @param installedSoftware
	 */
	private static void takeListMethodAction(List<String> installedSoftware) {
		System.out.println("List ");
		for(String installedSofware : installedSoftware) {
			System.out.println("  "+installedSofware);
		}
		
	}

	/**
	 * @param dependentComponentsMap
	 * @param installedSoftware
	 * @param splitCommand
	 */
	private static void takeInstallMethodAction(Map<String, DependendtComponents> dependentComponentsMap,
			List<String> installedSoftware, String[] splitCommand) {
		String componentToInstall =  splitCommand[1];
		System.out.println("Install "+ componentToInstall);
		if(dependentComponentsMap.get(componentToInstall) != null) {
			DependendtComponents dependentComponents = dependentComponentsMap.get(componentToInstall);
			boolean isSubComponentAlreadyInstalled = true;
			for(String subDependentComponent : dependentComponents.getDependentComponents()) {
				if(!installedSoftware.contains(subDependentComponent)) {					
					System.out.println("  Installing "+ subDependentComponent);
					System.out.println("  Installing "+ componentToInstall);
					isSubComponentAlreadyInstalled = false;
					installedSoftware.add(subDependentComponent);
				}
			}
			if(isSubComponentAlreadyInstalled) {
				System.out.println("  Installing "+ componentToInstall);
			}
			installedSoftware.add(componentToInstall);
			
		}else if(installedSoftware.contains(componentToInstall)) {
			System.out.println("  "+componentToInstall +" is already installed");
		}else {
			System.out.println("  Installing " + componentToInstall );
			installedSoftware.add(componentToInstall);
		}
	}

	private static void takeDependCommandAction(String[] splitCommand,
			Map<String, DependendtComponents> dependentComponentsMap) {
	
		System.out.println(Arrays.toString(splitCommand));
		List<String> dependentComponents = new ArrayList<String>();
		for(int splitCommandCounter = 2; splitCommandCounter < splitCommand.length; splitCommandCounter++) {
			dependentComponents.add(splitCommand[splitCommandCounter]);
		}
		dependentComponentsMap.put(splitCommand[1], new DependendtComponents(dependentComponents));	
	}
	
	

}
