package com.test.automation.cucumber.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log4JUtility {

	private Logger log=null;
	protected static Log4JUtility ob=null;
	
	
	private Log4JUtility() {
		
	}
	
	public static Log4JUtility getInstance() {
		if(ob==null) {
			ob=new Log4JUtility();
		}
		return ob;
	}
	
	public Logger getLogger() {
		if(log==null)
		log=(Logger) LogManager.getLogger(Log4JUtility.class);
		
		return log;
	}
	
	//***********reusable methods**********************88888
	
	public void logInfoText(String data)
	{
		log.info(data);
	}
	
	public void logErrorText(String data)
	{
		log.error(data);
	}
}
