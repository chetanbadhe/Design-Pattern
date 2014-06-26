/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : Results.java
 * Description : A data structure to store result 
 */
package dTunesStore.util;

import java.util.ArrayList;

import dTunesStore.dataStore.MusicInfo;
import dTunesStore.util.ResultDataStore;

public class Results {
	private ArrayList<ResultDataStore> rdataStore = null;

	/**
	 * 
	 * @return : ArrayList<ResultDataStore>
	 */
	public ArrayList<ResultDataStore> getRdataStore() {
		return rdataStore;
	}

	/**
	 * 
	 * @return : void
	 */
	public void setRdataStore(ArrayList<ResultDataStore> rdataStore) {
		this.rdataStore = rdataStore;
	}

	/**
	 * 
	 * Constructor
	 */
	public Results(){
			
		rdataStore = new ArrayList<ResultDataStore>();
		Debug.println(4, "[Results()]: Result Data Structure Initialized");
	}

	/**
	 * 
	 * @return : void
	 */
	public void addRecord(MusicInfo mInfo, String sString, Integer iPresent){
		ResultDataStore rdata = new ResultDataStore();
		rdata.setSearchResultStore(mInfo);
		rdata.setIsPresent(iPresent);
		rdata.setSearchString(sString);
		rdataStore.add(rdata);
	}

	/**
	 * 
	 * @return : void
	 */
	public void displayResult(){
		try{

			String msg = "[displayResult]:\n"+this.toString();
			Debug.println(1, msg);

		}
		catch(Exception e){
			System.err.println(e.toString()+"displayResult");
			System.exit(1);
		}
		finally{

		}

	}

	/**
	 * 
	 * @return : String
	 */
	public String toString()
	{
		String msg = "";
		for(int i = 0; i< this.rdataStore.size(); i++){
			if (this.rdataStore.get(i).getIsPresent() == 1)
			{
				msg += "Keyword : "+this.rdataStore.get(i).
						getSearchString()+"\nSong Name: "+
						this.rdataStore.get(i).getSearchResultStore().
						getName() +	"\tAlbum Name: "+ this.rdataStore.
						get(i).getSearchResultStore().getAlbum()+
						"\tSinger Name: "+ this.rdataStore.get(i).
						getSearchResultStore().getSinger()+	"\tDuration:"
						+ " "+ this.rdataStore.get(i).
						getSearchResultStore().getDuration() +"\n" ;
			}
		}
		return msg;
	}
}

