package com.practice.itunesapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * 
 * @author Selvasankari
 *
 */
public class ItunesServiceInvoker {

	private static final String SERVICE_ENDPOINT="https://itunes.apple.com/search";
	
	enum Media{
		movie, podcast, music, musicVideo, audiobook, shortFilm, tvShow, software, ebook;
	}
	
	public static void main(String[] args) throws ItunesInputValidationException, ItunesServiceException {
		ItunesResponse itunesResponse = invoke("michael+jackson", 5, "US", "music");
		System.out.println(itunesResponse);
	}
	
	/**
	 * Helper Method to invoke iTunes Service API
	 * @param term
	 * @param limit
	 * @param country
	 * @param media
	 * @return
	 * @throws ItunesInputValidationException
	 * @throws ItunesServiceException
	 */
	public static ItunesResponse invoke(String term, int limit, String country, String media) throws ItunesInputValidationException, ItunesServiceException{
		ItunesResponse itunesResponse = null;
		//Validate the Input fields
		validateInput(term,limit,country,media);
		//Frame the Service URL for given input fields
		String serviceURL = frameServiceUrl(term, limit, country, media);
		//Invoke the Service for the URL framed
		String httpResponse = invokeService(serviceURL);
		//Parse the HTTP Response to Itunes Response
		itunesResponse = extracted(itunesResponse, httpResponse);
		return itunesResponse;
	}

	/**
	 * Create the Itunes Response object from the Http Response
	 * @param itunesResponse
	 * @param httpResponse
	 * @return
	 * @throws ItunesServiceException
	 */
	private static ItunesResponse extracted(ItunesResponse itunesResponse,
			String httpResponse) throws ItunesServiceException {
		try {
			Gson gson = new Gson();
			itunesResponse = gson.fromJson(httpResponse, ItunesResponse.class);
		} catch (JsonSyntaxException e) {
			throw new ItunesServiceException("Invalid Service Response Format Returned " + httpResponse);
		}
		return itunesResponse;
	}

	private static String invokeService(String serviceURL) throws ItunesServiceException{
		try{
			URL url = new URL(serviceURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responseCode = con.getResponseCode();
			
			//Check for HTTP Status Code for successful execution of service
			if(responseCode!=200){
				throw new ItunesServiceException("Service returned Failure Status Code");
			}
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
	 
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		}catch(IOException ex){
			throw new ItunesServiceException(ex.getMessage());
		}
	}

	/**
	 * Helper Method to validate Service Input parameters
	 * @param term
	 * @param limit
	 * @param country
	 * @param media
	 * @throws IllegalArgumentException
	 */
	private static void validateInput(String term, int limit, String country,
			String media) throws ItunesInputValidationException{
		if(term==null || term.isEmpty()){
			throw new ItunesInputValidationException("Search Term cannot be NULL");
		}
		
		//check if URL is encoded or not length check
		
		//if Limit isn't specified , default it to 50, as it's required field
		if(limit <0 || limit >200){
			limit = 50;
		}
		
		//if Country code isn't valid, default it to US.
		if(country!=null && country.length()!=2){
			country="US";
		}
		
		boolean validMediaFormat = false;
		if(media!=null){
			for (Media mediaIter : Media.values()) {
		        if (mediaIter.name().equals(media)) {
		        	validMediaFormat = true;
		        	break;
		        }
		    }
		}
		//If Media format isnt valid , use default value.
		if(!validMediaFormat){
			media = "music";
		}
		
		
	}

	
	/**
	 * Helper method to frame the Service URL.
	 * @param term
	 * @param limit
	 * @param country
	 * @param media
	 * @return
	 */
	private static String frameServiceUrl(String term, int limit, String country,
			String media) {
		StringBuilder serviceUrl = new StringBuilder();
		serviceUrl.append(SERVICE_ENDPOINT).append("?");
		if(term!=null){
			serviceUrl.append("term=").append(term);
		}
		if(limit>0){
			serviceUrl.append("&limit=").append(limit);
		}
		if(country!=null){
			serviceUrl.append("&country=").append(country);
		}
		if(media!=null){
			serviceUrl.append("&media=").append(media);
		}
		return serviceUrl.toString();
	}
	
}
