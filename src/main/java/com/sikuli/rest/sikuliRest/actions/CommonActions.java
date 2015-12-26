package com.sikuli.rest.sikuliRest.actions;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlRootElement;

import org.sikuli.script.FindFailed;

import com.sikuli.rest.sikuliRest.objects.CommomObjects;
import com.sikuli.rest.util.CommonUtil.RESOURCES;
import com.sikuli.rest.util.SikuliActions;
import com.sikuli.rest.util.customloggers.CustomLogger;
import com.sikuli.rest.util.exceptions.NotSupportedException;

@XmlRootElement
public class CommonActions extends CommomObjects {

	static final Logger log = CustomLogger.getLogger(CommonActions.class
			.getName());

	private String actionName;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String href;
	private String description;

	public CommonActions() {

	}

	public CommonActions(String actionName, String href, String description) {
		this.actionName = actionName;
		this.href = href;
		this.description = description;
	}

	// Handle all safari browsers versions. Also if it is minimzed or
	// maximized!!
	public String clearSafariCache(String browserData) throws FindFailed,
			FileNotFoundException, NotSupportedException,
			UnsupportedEncodingException {
		if (browserData == null) {
			log.severe("Browser query param  is missing");
			throw new NotSupportedException(
					" Browser query param cannot be null!! or it is missing");
		}
		switch (browserData.toLowerCase()) {
		case "safari7":
			SikuliActions.click(RESOURCES.COMMON, safari7Header, browserData);
			SikuliActions.click(RESOURCES.COMMON, safari7PreferencesMenuItem,
					browserData);

			SikuliActions.click(RESOURCES.COMMON, safari7PrivacyButton,
					browserData);

			SikuliActions.click(RESOURCES.COMMON,
					safari7RemoveAllWebSiteButton, browserData);

			SikuliActions.click(RESOURCES.COMMON, safari7RemoveNowButton,
					browserData);
			SikuliActions.click(RESOURCES.COMMON, safari7ClosePreferenceButton,
					browserData);
			return "Success";
		case "safari8":
			SikuliActions.click(RESOURCES.COMMON, safari8Header, browserData);

			SikuliActions.click(RESOURCES.COMMON, safari8PreferencesMenuItem,
					browserData);

			SikuliActions.click(RESOURCES.COMMON, safari8PrivacyButton,
					browserData);

			SikuliActions.click(RESOURCES.COMMON,
					safari8RemoveAllWebSiteButton, browserData);

			SikuliActions.click(RESOURCES.COMMON, safari8RemoveNowButton,
					browserData);
			SikuliActions.click(RESOURCES.COMMON, safari8ClosePreferenceButton,
					browserData);
			return "Success";
		default:
			log.severe("Invalid browser -" + browserData
					+ ". Supported browsers are safari7 and safari8");
			throw new NotSupportedException("Invalid browser -" + browserData
					+ ". Supported browsers are safari7 and safari8");
		}
	}

	public String closeConfirmDialogWindow(String browserData, String options)
			throws FindFailed, FileNotFoundException, NotSupportedException,
			UnsupportedEncodingException {

		if (options == null) {
			log.severe("option query param  is missing");
			throw new NotSupportedException("option query param  is missing");
		}

		if (options.equalsIgnoreCase("yes") || options.equalsIgnoreCase("y")) {
			SikuliActions.click(RESOURCES.COMMON, yesOption, browserData);
			return "Success";
		} else if (options.equalsIgnoreCase("no")
				|| options.equalsIgnoreCase("n")) {
			SikuliActions.click(RESOURCES.COMMON, noOption, browserData);
			return "Success";
		} else {
			log.severe("option can be 'Yes' OR 'N0'");
			throw new NotSupportedException("option can be 'Yes' OR 'N0'");
		}
	}
	
	public String clickAllowBlockForMicroPhoneCameraOption(String browserData, String options)
			throws FindFailed, FileNotFoundException, NotSupportedException,
			UnsupportedEncodingException {
		if (browserData == null) {
			log.severe("Browser query param  is missing");
			throw new NotSupportedException(
					" Browser query param cannot be null!! or it is missing");
		}
		switch (browserData.toLowerCase()) {
		case "chrome":
			if (options == null) {
				log.severe("option query param  is missing");
				throw new NotSupportedException("option query param  is missing");
			}

			if (options.equalsIgnoreCase("yes") || options.equalsIgnoreCase("y")) {
				SikuliActions.click(RESOURCES.COMMON, allowCameraMicrophone, browserData);
				return "Success";
			} else if (options.equalsIgnoreCase("no")
					|| options.equalsIgnoreCase("n")) {
				SikuliActions.click(RESOURCES.COMMON, blockCameraMicrophone, browserData);
				return "Success";
			} else {
				log.severe("option can be 'Yes' OR 'N0'");
				throw new NotSupportedException("option can be 'Yes' OR 'N0'");
			}
		default:
			log.severe("Invalid browser -" + browserData
					+ ". Supported browser is chrome");
			throw new NotSupportedException("Invalid browser -" + browserData
					+ ". Supported browser is chrome");
		}
	}
	
	public String closeCameraMicrophoneOption(String browserData)
			throws FindFailed, FileNotFoundException, NotSupportedException,
			UnsupportedEncodingException {
		if (browserData == null) {
			log.severe("Browser query param  is missing");
			throw new NotSupportedException(
					" Browser query param cannot be null!! or it is missing");
		}
		switch (browserData.toLowerCase()) {
		case "chrome":
			SikuliActions.click(RESOURCES.COMMON, closeCameraMicrophoneDialog, browserData);
			return "Success";
		default:
			log.severe("Invalid browser -" + browserData
					+ ". Supported browser is chrome");
			throw new NotSupportedException("Invalid browser -" + browserData
					+ ". Supported browser is chrome");
		}
	}
	
	public String alwaysAllowFromMediaSettings(String browserData)
			throws FindFailed, FileNotFoundException, NotSupportedException,
			UnsupportedEncodingException {
		if (browserData == null) {
			log.severe("Browser query param  is missing");
			throw new NotSupportedException(
					" Browser query param cannot be null!! or it is missing");
		}
		switch (browserData.toLowerCase()) {
		case "chrome":
			SikuliActions.click(RESOURCES.COMMON, alwaysAllowCameraIconFromMediaSettings, browserData);
			SikuliActions.click(RESOURCES.COMMON, alwaysAllowCameraOptionFromMediaSettings, browserData);
			SikuliActions.click(RESOURCES.COMMON, alwaysAllowCameraFromMediaSettingsDone, browserData);
			return "Success";
		default:
			log.severe("Invalid browser -" + browserData
					+ ". Supported browser is chrome");
			throw new NotSupportedException("Invalid browser -" + browserData
					+ ". Supported browser is chrome");
		}
	}
	
	public String validatePeopleStream(String browserData,String role)
			throws FindFailed, FileNotFoundException, NotSupportedException,
			UnsupportedEncodingException {
		if (browserData == null) {
			log.severe("Browser query param  is missing");
			throw new NotSupportedException(
					" Browser query param cannot be null!! or it is missing");
		}
		if (role == null) {
			log.severe("Role query param  is missing");
			throw new NotSupportedException(
					" Role query param cannot be null!! or it is missing");
		}
		switch (browserData.toLowerCase()) {
		case "firefox":
			switch(role){
			case "moderator":
			case "panelist":
			case "attendee":
				boolean fromYosemite = SikuliActions.isImagePresent( RESOURCES.COMMON, peopleStreamOnFirefoxYosemite, browserData);
				if(fromYosemite){
					return "Success";
				}
				//TODO --> Capture all images and uncomment below lines
				/*boolean fromWindow7 = SikuliActions.isImagePresent( RESOURCES.COMMON, peopleStreamOnPanelistOnFirefoxWindows7, browserData);
				if(fromWindow7){
					return "Success";
				}
				boolean fromWindow8 = SikuliActions.isImagePresent( RESOURCES.COMMON, peopleStreamOnPanelistOnFirefoxWindows8, browserData);
				if(fromWindow8){
					return "Success";
				}
				boolean fromMaverick = SikuliActions.isImagePresent( RESOURCES.COMMON, peopleStreamOnPanelistOnFirefoxMaverick, browserData);
				if(fromMaverick){
					return "Success";
				}*/
				throw new FindFailed("People stream not recived on role"+role);
			default:
					throw new NotSupportedException("Invalid role -"+role);
			}
			
		default:
			log.severe("Invalid browser -" + browserData
					+ ". Supported browser is firefox for now");
			throw new NotSupportedException("Invalid browser -" + browserData
					+ ". Supported browser is firefox for now");
		}
	}

}
