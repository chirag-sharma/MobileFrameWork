package com.factory;

import com.dataProvider.ConfigDataProvider;

public class DataProviderFactory {
	
	public static ConfigDataProvider getconfig() {
		return new ConfigDataProvider();
	}

}
