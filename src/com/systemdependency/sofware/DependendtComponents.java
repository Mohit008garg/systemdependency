package com.systemdependency.sofware;

import java.util.ArrayList;
import java.util.List;

public class DependendtComponents {
	
	private List<String> dependentComponents =  new ArrayList<String>();
	
	public DependendtComponents(List<String>components) {
		this.dependentComponents = components;
	}
	
	public List<String> getDependentComponents() {
		return dependentComponents;
	}

}
