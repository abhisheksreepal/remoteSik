package com.sikuli.rest.util;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import com.sikuli.rest.util.CommonUtil.RESOURCES;
import com.sikuli.rest.util.customloggers.CustomLogger;
import com.sikuli.rest.util.exceptions.NotSupportedException;

public class SikuliActions {

	static final Logger log = CustomLogger.getLogger(SikuliActions.class
			.getName());
	private static final Screen screen = new Screen();
	public static final String IMAGE_ROOT_PATH = "images";
	public static final int TIMEOUT_IN_SECONDS = 10;

	static {
		Settings.MoveMouseDelay = 1;
		log.info("Screen object --" + screen);
	}

	public static void click(Region region, RESOURCES resource,
			String imageName, String browserData, int timeout)
			throws FindFailed, FileNotFoundException,
			UnsupportedEncodingException, NotSupportedException {

		String imagePath = CommonUtil.getImagePath(resource, imageName,
				browserData);
		region.wait(new Pattern(imagePath), timeout);
		region.click(new Pattern(imagePath));
		log.info("Successfully clicked on Image -" + imageName);
	}

	public static void wait(RESOURCES resource, String imageName,
			String browserData, int timeoutInSeconds) throws FindFailed,
			FileNotFoundException, UnsupportedEncodingException,
			NotSupportedException {
		wait(screen, resource, imageName, browserData, timeoutInSeconds);
	}

	public static void wait(Region region, RESOURCES resource,
			String imageName, String browserData, int timeout)
			throws FindFailed, FileNotFoundException,
			UnsupportedEncodingException, NotSupportedException {

		String imagePath = CommonUtil.getImagePath(resource, imageName,
				browserData);
		region.wait(new Pattern(imagePath), timeout);
		log.info("Successfully waited on Image -" + imageName);
	}
	
	public static boolean isImagePresent(RESOURCES resource,
			String imageName, String browserData)
			throws  FileNotFoundException,
			UnsupportedEncodingException, NotSupportedException {

		String imagePath = CommonUtil.getImagePath(resource, imageName,
				browserData);
		try{
		screen.wait(new Pattern(imagePath), TIMEOUT_IN_SECONDS);
		log.info("Image present -" + imageName);
		return true;
		}catch(FindFailed f){
			log.info("Image not present -" + imageName);
			return false;
		}
		
	}

	public static void click(RESOURCES resource, String imageName,
			String browserData, int timeoutInSeconds) throws FindFailed,
			FileNotFoundException, UnsupportedEncodingException,
			NotSupportedException {
		click(screen, resource, imageName, browserData, timeoutInSeconds);
	}

	public static void click(RESOURCES resource, String imageName,
			String browserData) throws FindFailed, FileNotFoundException,
			UnsupportedEncodingException, NotSupportedException {
		click(screen, resource, imageName, browserData, TIMEOUT_IN_SECONDS);
	}

	public static void clickLeftByOffSet(int offset, RESOURCES resource,
			String imageName, String browserData) throws FindFailed,
			FileNotFoundException, UnsupportedEncodingException,
			NotSupportedException {
		String imagePath = CommonUtil.getImagePath(resource, imageName,
				browserData);
		Region region = screen.wait(new Pattern(imagePath), TIMEOUT_IN_SECONDS);

		region.leftAt(offset).click();
		log.info("Successfully clicked leftside of Image with offset -"
				+ offset + " and image Name -" + imageName);
	}

	public static void clickInsideparent(RESOURCES resource,
			String parentImage, String childImageName, String browserData)
			throws FindFailed, FileNotFoundException,
			UnsupportedEncodingException, NotSupportedException {

		screen.wait(
				new Pattern(CommonUtil.getImagePath(resource, parentImage,
						browserData)), TIMEOUT_IN_SECONDS);
		Region region = screen.find(new Pattern(CommonUtil.getImagePath(
				resource, parentImage, browserData)));
		region.wait(
				new Pattern(CommonUtil.getImagePath(resource, childImageName,
						browserData)), TIMEOUT_IN_SECONDS);
		click(region, resource, childImageName, browserData, TIMEOUT_IN_SECONDS);

	}

}
