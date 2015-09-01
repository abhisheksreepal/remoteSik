package com.sikuli.rest.sikuliRest.resources;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.sikuli.script.FindFailed;

import com.sikuli.rest.sikuliRest.actions.CommonActions;
import com.sikuli.rest.util.customStatus.CustomStatusType;
import com.sikuli.rest.util.customStatus.CustomStatusType.STATUS;
import com.sikuli.rest.util.customloggers.CustomLogger;
import com.sikuli.rest.util.exceptions.NotSupportedException;

@Path("/common")
public class CommonResource {

	Logger log = CustomLogger.getLogger(CommonResource.class.getName());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CommonActions> returnApiAvailable() {
		CommonActions actions = new CommonActions("clearSafariCache",
				"/clearSafariCache", "clear Safari cache");
		CommonActions actions2 = new CommonActions(
				"closePostEventConfirmationDialog",
				"/closePostEventConfirmationDialog",
				"close post confirm dialog window by selecting yes or no");
		List<CommonActions> list = new ArrayList<>();
		list.add(actions);
		list.add(actions2);
		return list;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/clearSafariCache")
	public Response clearSafariCache(@QueryParam("browser") String browser) {
		CommonActions action = new CommonActions();
		try {
			action.clearSafariCache(browser);
			log.info("Successfully cleared safari cache");
			return Response.status(Status.OK)
					.entity("Successfully cleared safari cache").build();
		} catch (FindFailed findFailed) {
			log.severe(findFailed.toString());
			return Response
					.status(new CustomStatusType(STATUS.FIND_FAILED_EXCEPTION
							.getValue(), "Image Find Failed Exception"))
					.entity(findFailed.toString()).build();
		} catch (FileNotFoundException fileNotFound) {
			log.severe(fileNotFound.toString());
			return Response
					.status(new CustomStatusType(
							STATUS.FILE_NOT_FOUND_EXCEPTION.getValue(),
							"Image File not found Exception"))
					.entity(fileNotFound.toString()).build();
		} catch (NotSupportedException notSupported) {
			log.severe(notSupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.NOT_SUPPORTED_EXCEPTION
							.getValue(), "Not supported Exception"))
					.entity(notSupported.toString()).build();
		} catch (UnsupportedEncodingException unsupported) {
			log.severe(unsupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.UNSUPPORTED_ENCODE
							.getValue(), "Un supported encoding Exception"))
					.entity(unsupported.toString()).build();
		}
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/closePostEventConfirmationDialog")
	public Response closePostEventConfirmationDialog(
			@QueryParam("browser") String browser,
			@QueryParam("option") String option) {
		CommonActions action = new CommonActions();
		try {
			action.closeConfirmDialogWindow(browser, option);
			log.info("CLicked yes option");
			return Response
					.status(Status.OK)
					.entity("Successfully closed confirmation dialog window with option -"
							+ option).build();
		} catch (FindFailed findFailed) {
			log.severe(findFailed.toString());
			return Response
					.status(new CustomStatusType(STATUS.FIND_FAILED_EXCEPTION
							.getValue(), "Image Find Failed Exception"))
					.entity(findFailed.toString()).build();
		} catch (FileNotFoundException fileNotFound) {
			log.severe(fileNotFound.toString());
			return Response
					.status(new CustomStatusType(
							STATUS.FILE_NOT_FOUND_EXCEPTION.getValue(),
							"Image File not found Exception"))
					.entity(fileNotFound.toString()).build();
		} catch (NotSupportedException notSupported) {
			log.severe(notSupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.NOT_SUPPORTED_EXCEPTION
							.getValue(), "Not supported Exception"))
					.entity(notSupported.toString()).build();
		} catch (UnsupportedEncodingException unsupported) {
			log.severe(unsupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.UNSUPPORTED_ENCODE
							.getValue(), "Un supported encoding Exception"))
					.entity(unsupported.toString()).build();
		}
	}

}
