	/**
	 * Author: Goal Pioneers, Kent v. Madsen
	 * Contact: Kent.vejrup.madsen@goalpioneers.com
	 * Company: Goal-Pioneers, 41157089
	 * Links
	 ** License: MIT License(https://github.com/GoalPioneers/Shipment/blob/main/LICENSE.md)
	 ** Issues: https://github.com/GoalPioneers/Shipment/issues
	 */
	package main.java.com.goalpioneers.shipment.facade.setup;
	
	import main.java.com.goalpioneers.shipment.domain.Application;
	
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	
	
	/**
	 *
	 */
	public class SetupBuilder
	{
		/**
		 *
		 * @param application
		 */
		public SetupBuilder( Application application)
		{
			this.setBuffers(
				new ArrayList <SetupFacade>()
			);
			
			this.setApplication( application );
		}
		
		
		// Variables
		private Application application = null;
		
		private List <SetupFacade> buffers = null;
		
		
		// Functions: Public
		/**
		 *
		 */
		public final void build()
			//throws Exception
		{
			this.sortByPriority();
			this.build_by_index_range( 0, this.getBuffers().size() );
		}
		
		/**
		 *
		 * @param begin
		 * @param end
		 */
		protected void build_by_index_range(int begin, int end)
		{
			int idx;
			
			for( idx = begin;
				 idx < end;
				 idx ++)
			{
				SetupFacade facade = this.getBuffers().get( idx );
				
				if( !facade.setup() )
				{
					//throw new Exception( "Setup failed:" );
					// Figure out what's wrong
				}
			}
		}
		
		
		/**
		 *
		 * @param idx
		 * @return
		 */
		public final SetupFacade retrieveByIdentity( int idx )
		{
			return this.getBuffers().get( idx );
		}
		
		/**
		 *
		 * @param facade
		 */
		public final void add( SetupFacade facade )
		{
			if( facade.getApplication() == null )
			{
				facade.setApplication(
					this.getApplication()
				);
			}
			
			this.getBuffers().add( facade );
		}
		
		/**
		 *
		 * @param setupIdx
		 */
		public final void removeByIdentity( int setupIdx )
		{
			this.getBuffers().remove( setupIdx );
		}
		
		
		// Sort
		/**
		 *
		 */
		protected final void sortByPriority()
		{
			Collections.sort( this.getBuffers());
		}
		
		
		// Accessors
		/**
		 *
		 * @return
		 */
		public final List <SetupFacade> getBuffers()
		{
			return this.buffers;
		}
		
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
		 * @param buffers
		 */
		public final void setBuffers( List <SetupFacade> buffers )
		{
			this.buffers = buffers;
		}
		
		/**
		 *
		 * @param application
		 */
		public final void setApplication( Application application )
		{
			this.application = application;
		}
		
		/**
		 *
		 * @return
		 */
		@Override
		public final String toString()
		{
			int idx;
			
			for( idx = 0;
				 idx < this.buffers.size();
				 idx++ )
			{
				SetupFacade sf = this.buffers.get( idx );
				System.out.println( sf.getName() );
			}
			
			return super.toString();
		}
	}
