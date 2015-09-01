package com.sikuli.rest.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import com.sikuli.rest.util.customloggers.CustomLogger;
import com.sikuli.rest.util.exceptions.NotSupportedException;

public class CommonUtil {

	static final Logger log = CustomLogger
			.getLogger(CommonUtil.class.getName());

	private static final String OSString = System.getProperty("os.name")
			.toLowerCase();

	private static final String OSVersion = System.getProperty("os.version")
			.toLowerCase();

	public enum OS {
		WINDOWS7, LINUX, SOLARIS, WINDOWS8, YOSEMITE, MAVERICK
	}

	public enum BROWSERS {
		CHROME, FIREFOX, IE, SAFARI7, SAFARI8
	}

	public enum RESOURCES {
		CARMEL, COMMON
	}

	public static String getImagePath(RESOURCES resource, String imageName,
			String browserData) throws FileNotFoundException,
			NotSupportedException, UnsupportedEncodingException {

		if (browserData == null) {
			log.severe("Browser query param  is missing");
			throw new NotSupportedException(
					" Browser query param cannot be null!! or it is missing");
		}
		if (!CommonUtil.isBrowserSupported(
				CommonUtil.getBrowserEnum(browserData), CommonUtil.getOSInfo())) {
			log.severe("Browser not supported -" + browserData + " for OS -"
					+ CommonUtil.getOSInfo());
			throw new NotSupportedException("Browser not supported -"
					+ browserData + " for OS -" + CommonUtil.getOSInfo());
		}

		BROWSERS browser = CommonUtil.getBrowserEnum(browserData);
		String osInfo = CommonUtil.getOSInfo().toString().toLowerCase();

		String path = SikuliActions.IMAGE_ROOT_PATH + File.separator
				+ resource.toString().toLowerCase() + File.separator + osInfo
				+ File.separator + browser.toString().toLowerCase()
				+ File.separator + imageName;

		URL iPath = CommonUtil.class.getClassLoader().getResource(path);

		if (iPath != null) {
			log.info("Returning image path ->"
					+ URLDecoder.decode(iPath.getPath(),
							StandardCharsets.UTF_8.displayName()));
			return URLDecoder.decode(iPath.getPath(),
					StandardCharsets.UTF_8.displayName());
		} else {
			log.severe("Image -" + imageName
					+ " NOT found in the following path - " + path);
			throw new FileNotFoundException("Image -" + imageName
					+ " NOT found in the following path - " + path);
		}

	}

	public static OS getOSInfo() throws NotSupportedException {
		if (OSString.equalsIgnoreCase("windows7")
				|| OSString.equalsIgnoreCase("windows 7")) {
			log.info("OS is Windows 7");
			return OS.WINDOWS7;
		} else if (OSString.equalsIgnoreCase("windows8")
				|| OSString.equalsIgnoreCase("windows 8")
				|| OSString.equalsIgnoreCase("windows 8.1")) {
			log.info("OS is Windows 8");
			return OS.WINDOWS8;
		} else if (OSVersion.contains("10.10")) {
			log.info("OS is YoseMite");
			return OS.YOSEMITE;
		} else if (OSVersion.contains("10.9")) {
			log.info("OS is Maverick");
			return OS.MAVERICK;
		} else if (OSString.indexOf("nix") >= 0 || OSString.indexOf("nux") >= 0
				|| OSString.indexOf("aix") > 0) {
			log.severe("OS -" + OSString + " Not supported");
			throw new NotSupportedException(OSString);
		} else if (OSString.indexOf("sunos") >= 0) {
			log.severe("OS -" + OSString + " Not supported");
			throw new NotSupportedException(OSString);
		} else {
			log.severe("OS -" + OSString + " Not supported");
			throw new NotSupportedException(OSString);
		}
	}

	public static BROWSERS getBrowserEnum(String browser)
			throws NotSupportedException {
		switch (browser.toLowerCase()) {
		case "chrome":
			log.info("Browser is CHROME");
			return BROWSERS.CHROME;
		case "ie":
			log.info("Browser is IE");
			return BROWSERS.IE;
		case "firefox":
			log.info("Browser is FIREFOX");
			return BROWSERS.FIREFOX;
		case "safari7":
			log.info("Browser is SAFARI7");
			return BROWSERS.SAFARI7;
		case "safari8":
			log.info("Browser is SAFARI8");
			return BROWSERS.SAFARI8;
		default:
			log.severe("browser -" + browser + " Not supported");
			throw new NotSupportedException("Invalid browser -" + browser);
		}
	}

	public static boolean isBrowserSupported(BROWSERS browser, OS os)
			throws NotSupportedException {
		switch (os) {
		case LINUX:
			log.severe("OS -" + os + " itself not supported");
			throw new NotSupportedException("OS -" + os);
		case WINDOWS7:
			switch (browser) {
			case CHROME:
				log.info("Chrome supported for " + os);
				return true;
			case FIREFOX:
				log.info("FF supported for " + os);
				return true;
			case IE:
				log.info("IE supported for " + os);
				return true;
			case SAFARI7:
				log.info("Safari7 NOT supported for " + os);
				return false;
			case SAFARI8:
				log.info("Safari8 NOT supported for " + os);
				return false;

			}
		case WINDOWS8:
			switch (browser) {
			case CHROME:
				log.info("Chrome supported for " + os);
				return true;
			case FIREFOX:
				log.info("FF supported for " + os);
				return true;
			case IE:
				log.info("IE supported for " + os);
				return true;
			case SAFARI7:
				log.info("safari7 not supported for " + os);
				return false;
			case SAFARI8:
				log.info("safari8 not supported for " + os);
				return false;

			}
		case MAVERICK:
			switch (browser) {
			case CHROME:
				log.info("Chrome supported for " + os);
				return true;
			case FIREFOX:
				log.info("FF supported for " + os);
				return true;
			case IE:
				log.info("IE NOT supported for " + os);
				return false;
			case SAFARI7:
				log.info("safari7 supported for " + os);
				return true;
			case SAFARI8:
				log.info("safari8 supported for " + os);
				return true;
			}

		case YOSEMITE:
			switch (browser) {
			case CHROME:
				log.info("Chrome supported for " + os);
				return true;
			case FIREFOX:
				log.info("FF supported for " + os);
				return true;
			case IE:
				log.info("IE NOT supported for " + os);
				return false;
			case SAFARI7:
				log.info("safari7 supported for " + os);
				return true;
			case SAFARI8:
				log.info("safari8 supported for " + os);
				return true;
			}
		case SOLARIS:
			log.severe("OS not supported  " + os);
			throw new NotSupportedException("OS -" + os);

		default:
			log.severe("OS not supported  " + os);
			throw new NotSupportedException("OS -" + os);
		}
	}

}
