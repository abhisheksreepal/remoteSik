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

import org.glassfish.jersey.message.internal.Statuses;
import org.sikuli.script.FindFailed;

import com.sikuli.rest.sikuliRest.actions.CarmelActions;
import com.sikuli.rest.util.customStatus.CustomStatusType;
import com.sikuli.rest.util.customStatus.CustomStatusType.STATUS;
import com.sikuli.rest.util.customloggers.CustomLogger;
import com.sikuli.rest.util.exceptions.NotSupportedException;

@Path("/carmel")
public class CarmelResource {

	Logger log = CustomLogger.getLogger(CarmelResource.class.getName());

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CarmelActions> returnApiAvailable() {
		CarmelActions actions = new CarmelActions(
				"clickLaunchApplicationDialog",
				"/clickLaunchApplicationDialog",
				"click on launch app dialog window for carmel app");
		CarmelActions actions2 = new CarmelActions("minimizeCarmelApp",
				"/minimizeCarmelApp", "minimize carmel app");
		List<CarmelActions> list = new ArrayList<>();
		list.add(actions);
		list.add(actions2);
		return list;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/clickLaunchApplicationDialog")
	public Response clickLaunchAppDialog(@QueryParam("browser") String browser) {
		CarmelActions action = new CarmelActions();
		try {
			action.doClickLaunchDialog(browser);
			action.updateCarmelApp(browser);
			log.info("Successfully clicked on App Dialog");
			return Response.status(Status.OK)
					.entity("Successfully clicked on App Dialog").build();
		} catch (FindFailed findFailed) {
			log.severe("Image Find Failed Exception " + findFailed.toString());
			return Response
					.status(Statuses.from(
							STATUS.FIND_FAILED_EXCEPTION.getValue(),
							"Image Find Failed Exception"))
					.entity(findFailed.toString()).build();
		} catch (FileNotFoundException fileNotFound) {
			log.severe("Image File not found Exception "
					+ fileNotFound.toString());
			return Response
					.status(new CustomStatusType(
							STATUS.FILE_NOT_FOUND_EXCEPTION.getValue(),
							"Image File not found Exception"))
					.entity(fileNotFound.toString()).build();
		} catch (NotSupportedException notSupported) {
			log.severe("Not supported Exception " + notSupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.NOT_SUPPORTED_EXCEPTION
							.getValue(), "Not supported Exception"))
					.entity(notSupported.toString()).build();
		} catch (UnsupportedEncodingException unsupported) {
			log.severe("Un supported encoding Exception "
					+ unsupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.UNSUPPORTED_ENCODE
							.getValue(), "Un supported encoding Exception"))
					.entity(unsupported.toString()).build();
		}
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/minimizeCarmelApp")
	public Response minimizeCarmelApp(@QueryParam("browser") String browser) {
		CarmelActions action = new CarmelActions();
		try {
			action.minimizeCarmelApp(browser);
			log.info("Successfully minimized carmel app");
			return Response.status(Status.OK)
					.entity("Successfully minimized carmel app").build();
		} catch (FindFailed findFailed) {
			log.severe("Image Find Failed Exception " + findFailed.toString());
			return Response
					.status(Statuses.from(
							STATUS.FIND_FAILED_EXCEPTION.getValue(),
							"Image Find Failed Exception"))
					.entity(findFailed.toString()).build();
		} catch (FileNotFoundException fileNotFound) {
			log.severe("Image File not found Exception "
					+ fileNotFound.toString());
			return Response
					.status(new CustomStatusType(
							STATUS.FILE_NOT_FOUND_EXCEPTION.getValue(),
							"Image File not found Exception"))
					.entity(fileNotFound.toString()).build();
		} catch (NotSupportedException notSupported) {
			log.severe("Not supported Exception " + notSupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.NOT_SUPPORTED_EXCEPTION
							.getValue(), "Not supported Exception"))
					.entity(notSupported.toString()).build();
		} catch (UnsupportedEncodingException unsupported) {
			log.severe("Un supported encoding Exception "
					+ unsupported.toString());
			return Response
					.status(new CustomStatusType(STATUS.UNSUPPORTED_ENCODE
							.getValue(), "Un supported encoding Exception"))
					.entity(unsupported.toString()).build();
		}
	}

}
