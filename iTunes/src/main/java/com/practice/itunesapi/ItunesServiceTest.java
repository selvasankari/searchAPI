/**
 * 
 */
package com.practice.itunesapi;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.itunesapi.ItunesResponse.Result;

/**
 * @author Selvasankari
 *
 * Written Unit test..
 * 	1. To Validate Service Inputs
 *  2. To Validate Service Exception for Bad Request
 *  3. Validate Service Response for Provided Search Term, Country, Limit and Media inputs
 */
public class ItunesServiceTest {

	@Test(expectedExceptions=ItunesInputValidationException.class)
	public void validateInput() throws ItunesInputValidationException, ItunesServiceException{
		ItunesServiceInvoker.invoke(null, 0, null, null);
	}
	
	
	@Test(expectedExceptions=ItunesServiceException.class)
	public void validateBadRequest() throws ItunesInputValidationException, ItunesServiceException{
		ItunesServiceInvoker.invoke("Michael+Jackson", 5, "US", "Music");
	}
	
	
	@Test
	public void validateResponse() throws ItunesInputValidationException, ItunesServiceException{
		int actualLimit = 5;
		
		ItunesResponse itunesResponse = ItunesServiceInvoker.invoke("Michael+Jackson", actualLimit, "US", "music");
		//Checking the data is not null
		Assert.assertTrue(itunesResponse!=null);
		//Checking the limit functionality
		Assert.assertEquals(actualLimit, itunesResponse.getResultCount());
		
		List<Result> results = itunesResponse.getResults();
	
		for(Result result : results)
		{
			//Checking Country
			Assert.assertEquals("USA", result.getCountry());
			//Checking Term in the ArtistName 
			Assert.assertEquals("Michael Jackson", result.getArtistName());
			//Checking MediaType
			Assert.assertTrue(result.getpreviewUrl().contains("Music"));
			
		}
		
		
		
		
	}
}
