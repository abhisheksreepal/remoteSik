package com.sikuli.rest.util.customloggers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class CustomLogger {

	private static final String LOG_HTML_FILE = "sikuliRest.html";
	private static final String LOG_FILE = "sikuliRest.log";
	private static final boolean doYouWantLogfileAsFile = true;

	private static Logger log;

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		CustomLogger.log = log;
	}

	public static Logger getLogger(String className) {

		if (log == null) {
			Logger log = Logger.getLogger(className);
			addFileHandler(log);
			setLog(log);
			return getLog();
		} else {
			return getLog();
		}

	}

	private static void addFileHandler(Logger log) {
		try {
			if (!doYouWantLogfileAsFile) {
				File file = new File(LOG_HTML_FILE);
				String path = file.getAbsolutePath();
				path = path.replaceAll("bin", "logs");
				log.info("PATH ------>" + path);

				Handler handle = new FileHandler(path, false);
				handle.setFormatter(new CustomFormatter());
				log.addHandler(handle);
			} else {
				File file = new File(LOG_FILE);
				String path = file.getAbsolutePath();
				path = path.replaceAll("bin", "logs");
				log.info("PATH ------>" + path);
				Handler handle = new FileHandler(path, false);
				handle.setFormatter(new Formatter() {

					@Override
					public String format(LogRecord record) {
						return new Date().toString() + " [" + record.getLevel()
								+ "]" + "  :  " + record.getSourceClassName()
								+ " -:- " + record.getSourceMethodName()
								+ " -:- " + record.getMessage() + "\n";
					}
				});
				log.addHandler(handle);
			}

		} catch (IOException e) {
			log.severe("File NOT found. Hence log file will not be created and pushed to default console."
					+ e.getMessage());
		}

	}
}
