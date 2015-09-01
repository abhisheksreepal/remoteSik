package com.sikuli.rest.util.customStatus;


public class CustomStatusType extends AbstractStatusType {

	public enum STATUS {
		FIND_FAILED_EXCEPTION(520), NOT_SUPPORTED_EXCEPTION(521), FILE_NOT_FOUND_EXCEPTION(
			522),UNSUPPORTED_ENCODE(523);

		private int value;

		STATUS(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return Integer.toString(this.getValue());
		}
	}
	
	public CustomStatusType(int statusCode, final String reasonPhrase) {
		super(statusCode, reasonPhrase);
	}

}
