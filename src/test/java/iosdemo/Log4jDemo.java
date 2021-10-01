package iosdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jDemo {

	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	@Test
	public void Log4j() {

		System.out.println("\n  Hello world...! \n");

		logger.debug("This is an debug message");
		logger.info("This is an information message");
		logger.error("This is an error message");
		logger.warn("This is an warning message");
		logger.fatal("This is an fatal message");


		System.out.println("\n  Completed...! ");
	}
}
