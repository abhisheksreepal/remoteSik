package com.sikuli.rest.util.customStatus;

import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public abstract class AbstractStatusType implements StatusType {
	public AbstractStatusType(final Family family, final int statusCode,
			final String reasonPhrase) {
		super();

		this.family = family;
		this.statusCode = statusCode;
		this.reasonPhrase = reasonPhrase;
	}

	protected AbstractStatusType(int statusCode, final String reasonPhrase) {
		this(Family.SERVER_ERROR, statusCode, reasonPhrase);
	}

	@Override
	public Family getFamily() {
		return family;
	}

	@Override
	public String getReasonPhrase() {
		return reasonPhrase;
	}

	@Override
	public int getStatusCode() {
		return statusCode;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return reasonPhrase;
	}

	private final Family family;
	private final int statusCode;
	private final String reasonPhrase;

}
