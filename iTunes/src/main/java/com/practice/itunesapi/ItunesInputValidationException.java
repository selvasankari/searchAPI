package com.practice.itunesapi;

/**
 * 
 * @author Selvasankari
 *
 */
public class ItunesInputValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3328457722037107705L;

	public ItunesInputValidationException(){
		
	}
	
	public ItunesInputValidationException(String message){
		super(message);
	}
}

