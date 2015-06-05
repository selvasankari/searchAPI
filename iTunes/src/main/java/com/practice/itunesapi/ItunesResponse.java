package com.practice.itunesapi;

import java.util.Date;
import java.util.List;
/**
 * 
 * @author Selvasankari
 *
 */
public class ItunesResponse {

	private int resultCount;
	//private String country;
	
	public int getResultCount() {
		return resultCount;
	}

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	private List<Result> results;
	
	static class Result{
		public String getWrapperType() {
			return wrapperType;
		}
		public void setWrapperType(String wrapperType) {
			this.wrapperType = wrapperType;
		}
		public String getKind() {
			return kind;
		}
		public void setKind(String kind) {
			this.kind = kind;
		}
		public String getArtistId() {
			return artistId;
		}
		public void setArtistId(String artistId) {
			this.artistId = artistId;
		}
		public String getCollectionId() {
			return collectionId;
		}
		public void setCollectionId(String collectionId) {
			this.collectionId = collectionId;
		}
		public String getArtistName() {
			return artistName;
		}
		public void setArtistName(String artistName) {
			this.artistName = artistName;
		}
		public String getCollectionName() {
			return collectionName;
		}
		public void setCollectionName(String collectionName) {
			this.collectionName = collectionName;
		}
		public String getTrackName() {
			return trackName;
		}
		public void setTrackName(String trackName) {
			this.trackName = trackName;
		}
		public String getCollectionCensoredName() {
			return collectionCensoredName;
		}
		public void setCollectionCensoredName(String collectionCensoredName) {
			this.collectionCensoredName = collectionCensoredName;
		}
		public String getTrackCensoredName() {
			return trackCensoredName;
		}
		public void setTrackCensoredName(String trackCensoredName) {
			this.trackCensoredName = trackCensoredName;
		}
		public Double getCollectionPrice() {
			return collectionPrice;
		}
		public void setCollectionPrice(Double collectionPrice) {
			this.collectionPrice = collectionPrice;
		}
		public Double getTrackPrice() {
			return trackPrice;
		}
		public void setTrackPrice(Double trackPrice) {
			this.trackPrice = trackPrice;
		}
		public Date getReleaseDate() {
			return releaseDate;
		}
		public void setReleaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
		}
		public Integer getDiscCount() {
			return discCount;
		}
		public void setDiscCount(Integer discCount) {
			this.discCount = discCount;
		}
		public Integer getDiscNumber() {
			return discNumber;
		}
		public void setDiscNumber(Integer discNumber) {
			this.discNumber = discNumber;
		}
		public Integer getTrackCount() {
			return trackCount;
		}
		public void setTrackCount(Integer trackCount) {
			this.trackCount = trackCount;
		}
		public Integer getTrackNumber() {
			return trackNumber;
		}
		public void setTrackNumber(Integer trackNumber) {
			this.trackNumber = trackNumber;
		}
		public Long getTrackTimeMillis() {
			return trackTimeMillis;
		}
		public void setTrackTimeMillis(Long trackTimeMillis) {
			this.trackTimeMillis = trackTimeMillis;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getPrimaryGenreName() {
			return primaryGenreName;
		}
		public void setPrimaryGenreName(String primaryGenreName) {
			this.primaryGenreName = primaryGenreName;
		}
		public String getArtistViewUrl() {
			return artistViewUrl;
		}
		public void setArtistViewUrl(String artistViewUrl) {
			this.artistViewUrl = artistViewUrl;
		}
		public String getTrackViewUrl() {
			return trackViewUrl;
		}
		public void setTrackViewUrl(String trackViewUrl) {
			this.trackViewUrl = trackViewUrl;
		}
		
		public String getpreviewUrl() {
			return previewUrl;
		}
		public void setpreviewUrl(String previewUrl) {
			this.previewUrl = previewUrl;
		}
		private String wrapperType;
		private String kind;
		private String artistId;
		private String collectionId;
		private String artistName;
		private String collectionName;
		private String trackName;
		private String collectionCensoredName;
		private String trackCensoredName;
		private Double collectionPrice;
		private Double trackPrice;
		private Date releaseDate;
		private Integer discCount;
		private Integer discNumber;
		private Integer trackCount;
		private Integer trackNumber;
		private Long trackTimeMillis;
		private String country;
		private String currency;
		private String primaryGenreName;
		private String artistViewUrl;
		private String trackViewUrl;
		private String previewUrl;
	}
}
