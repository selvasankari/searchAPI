package com.practice.itunesapi;

/**
 * 
 * @author Selvasankari
 *
 */
public class ItunesServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2612280551867906975L;

	public ItunesServiceException(){
		
	}
	
	public ItunesServiceException(String message){
		super(message);
	}
}
