/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : ResultDataStore.java
 * Description : Type to store search result
 */
package dTunesStore.util;

import dTunesStore.dataStore.MusicInfo;

public class ResultDataStore {
	private MusicInfo searchResultStore= null;
	private String searchString= null;
	private Integer isPresent= null;
	/**
	 * 
	 * MusicInfo
	 */
	public MusicInfo getSearchResultStore() {
		return searchResultStore;
	}
	
	/**
	 * 
	 * @return : void
	 */
	public void setSearchResultStore(MusicInfo searchResultStore) {
		this.searchResultStore = searchResultStore;
	}
	
	/**
	 * 
	 * @return : String
	 */
	public String getSearchString() {
		return searchString;
	}
	
	/**
	 * 
	 * @return : void
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	/**
	 * 
	 * @return : Integer
	 */
	public Integer getIsPresent() {
		return isPresent;
	}
	
	/**
	 * 
	 * @return : void
	 */
	public void setIsPresent(Integer isPresent) {
		this.isPresent = isPresent;
	}
	
	/**
	 * 
	 * @return : String
	 */
	public String toString()
	{
		String msg = " Search String: "+getSearchString()+" Present Flag: "+
				getIsPresent()+" Album Name:"+getSearchResultStore().getAlbum()+
				" Singer Name:"+getSearchResultStore().getSinger()+
				" Song Name:"+getSearchResultStore().getName();
		
		return msg;
	}
	

}
