package com.hrms.utility;

import org.apache.log4j.Logger;

public class Log {
	static Logger logger = Logger.getLogger(Log.class.getName());
	public static void info(String massage) {
		logger.info(massage);
	}
			

}
