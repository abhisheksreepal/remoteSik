package com.sikuli.rest.sikuliRest.actions;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.annotation.XmlRootElement;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;

import com.sikuli.rest.sikuliRest.objects.CarmelObjects;
import com.sikuli.rest.util.CommonUtil.RESOURCES;
import com.sikuli.rest.util.SikuliActions;
import com.sikuli.rest.util.exceptions.NotSupportedException;

@XmlRootElement
public class CarmelActions extends CarmelObjects {

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

	public CarmelActions() {

	}

	public CarmelActions(String actionName, String href, String description) {
		this.actionName = actionName;
		this.href = href;
		this.description = description;
	}

	public String doClickLaunchDialog(String browserData)
			throws FileNotFoundException, NotSupportedException, FindFailed,
			UnsupportedEncodingException {
		try{
			SikuliActions.click(RESOURCES.CARMEL, launchApplicationDialog,
				browserData);
		}catch(Throwable error){
			selectChromeBrowserIcon(browserData);
			SikuliActions.click(RESOURCES.CARMEL, launchApplicationDialog,
					browserData);
		}
		return "Success";
	}

	public String minimizeCarmelApp(String browserData)
			throws FileNotFoundException, NotSupportedException, FindFailed,
			UnsupportedEncodingException {
		try {
			Settings.MinSimilarity = 0.90;
			SikuliActions.click(RESOURCES.CARMEL, minimizeIcon, browserData);
			return "Success";
		} finally {
			Settings.MinSimilarity = 0.7;
		}

	}

	public String updateCarmelApp(String browserData)
			throws FileNotFoundException, NotSupportedException, FindFailed,
			UnsupportedEncodingException {
		try {
			SikuliActions.click(RESOURCES.CARMEL, update, browserData, 10);
		} catch (Throwable t) {
			return "already updated";
		}
		SikuliActions.wait(RESOURCES.CARMEL, pullingDown, browserData, 10);
		return "Success";

	}
	
	public String selectChromeBrowserIcon(String browserData)
			throws FileNotFoundException, NotSupportedException, FindFailed,
			UnsupportedEncodingException {
		SikuliActions.click(RESOURCES.CARMEL, selectChromeBrowserIcon,
				browserData);
		return "Success";

	}

}
