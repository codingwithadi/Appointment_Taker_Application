package com.appointment.taker.app.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	private String resourceName;
	private String resourceFieldName;
	private int resourceId;
	
	public ResourceNotFoundException(String resourceName, String resourceFieldName, int resourceId) {
		super(String.format("Oops!! %s Not Found with %s : %s", resourceName, resourceFieldName, resourceId));
		this.resourceName = resourceName;
		this.resourceFieldName = resourceFieldName;
		this.resourceId = resourceId;
	}
	
	
	
}
