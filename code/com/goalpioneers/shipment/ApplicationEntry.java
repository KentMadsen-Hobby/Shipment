/**
 * Author: Goal Pioneers, Kent v. Madsen
 * Contact: Kent.vejrup.madsen@goalpioneers.com
 * Company: Goal-Pioneers, 41157089
 * Links
 ** License: MIT License(https://github.com/GoalPioneers/Shipment/blob/main/LICENSE.md)
 ** Issues: https://github.com/GoalPioneers/Shipment/issues
 */
package com.goalpioneers.shipment;

import com.goalpioneers.shipment.domain.Application;
import com.goalpioneers.shipment.facade.setup.SetupBuilder;
import com.goalpioneers.shipment.facade.setup.SetupFacade;
import com.goalpioneers.shipment.facade.setup.arguments.SetupByArguments;
import com.goalpioneers.shipment.facade.setup.cache.SetupByCache;
import com.goalpioneers.shipment.facade.setup.configuration.SetupByConfiguration;


/**
 * @author Kent v. Madsen
 * @author Goal Pioneers
 */
public class ApplicationEntry
{
	//
	public ApplicationEntry()
	{
		this( null );
	}
	
	/**
	 * 
	 */
	public ApplicationEntry( String[] arguments )
	{
		this.setApplication( 
			new Application() 
		);
		
		this.setBuilder(
			new SetupBuilder(
				this.getApplication()
			)
		);
		
		if( !( arguments == null ) )
		{
			// Set params
			SetupFacade sf = new SetupByArguments();
			this.getBuilder().add( sf );
		}
		
		this.getBuilder().add( new SetupByConfiguration() );
		this.getBuilder().add( new SetupByCache() );
		this.getBuilder().add( new SetupByArguments() );
		
		this.getBuilder().build();
	}


	// Variables
	private Application application = null;
	
	private SetupBuilder builder = null;
	
	
	// code
	/**
	 * The applications 3 phases. with specific purposes in mind.
	 */
	public final void run()
	{
		application.initialise();
		application.execution();
		application.clean();
	}
	
	
	// Accessors
	/**
	 * 
	 * @return
	 */
	public final Application getApplication() 
	{
		return this.application;
	}
	
	
	/**
	 * 
	 * @param application
	 */
	protected final void setApplication( Application application ) 
	{
		this.application = application;
	}
	
	/**
	 *
	 * @return
	 */
	public final SetupBuilder getBuilder()
	{
		return this.builder;
	}
	
	/**
	 *
	 * @param builder
	 */
	public final void setBuilder( SetupBuilder builder )
	{
		this.builder = builder;
	}
	
	// Entries
	/**
	 * 
	 * @param arguments
	 */
	public static void main( String[] arguments )
	{
		int size_of_args = arguments.length;
		ApplicationEntry entry = null;

		if( size_of_args == 0 )
		{
			entry = new ApplicationEntry();
		}
		else
		{
			entry = new ApplicationEntry( arguments );
		}

		entry.run();
	}
}
