package com.goalpioneers.shipment.configuration;


import java.util.ArrayList;
import java.util.List;


/**
 * 
 */
public class Registry 
{
	/**
	 * 
	 */
	public Registry()
	{
		if( getConfigurations() == null )
		{
			setConfigurations( 
					new ArrayList<>() 
			);
		}
	}
	
	//
	private static List<Configuration> configurations = null;
	
	//
	public static List<Configuration> getConfigurations() 
	{
		return configurations;
	}
	
	public static void setConfigurations( List<Configuration> configurations ) 
	{
		Registry.configurations = configurations;
	}
}
