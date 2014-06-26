/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : MusicStore.java
 * Description : Contains data structure to store music data, methods to add/display/search Records.
 */
package dTunesStore.dataStore;

import java.util.ArrayList;

import dTunesStore.util.Debug;
import dTunesStore.util.Results;

public class MusicStore {

	private ArrayList<MusicInfo> musicstore= null;
	private StoreIndex storeIdx = null;
	private Results result = null;
	private static int idx = 0;

	/**
	 * 
	 * constructor. 
	 */
	public MusicStore(){
		musicstore = new ArrayList<MusicInfo>();
		result =  new Results();
		storeIdx = new StoreIndex();
		Debug.println(4, "[MusicStore()]: musicstore, results, storeIdx"
				+ " Initialized");
	}

	/**
	 * 
	 * @return Results
	 */
	public Results getResult() {
		return result;
	}

	/**
	 * 
	 * @return : void
	 */
	public void setResult(Results result) {
		this.result = result;
	}

	/**
	 * 
	 * @return : ArrayList<MusicInfo>
	 */
	public ArrayList<MusicInfo> getMusicstore() {
		return musicstore;
	}

	/**
	 * 
	 * @return : void
	 */
	public void setMusicstore(ArrayList<MusicInfo> musicstore) {
		this.musicstore = musicstore;
	}

	/**
	 * 
	 * @return : String
	 */
	public String displayData(MusicInfo musicInfo){
		String returnString = " Name:"+musicInfo.getName()+" Album:"
				+musicInfo.getAlbum()+" Singer:"+musicInfo.getSinger()
				+" Duration:"+musicInfo.getDuration()+"\n";
		return returnString;
	}

	/**
	 * 
	 * @return : void
	 */
	public void displayData(MusicStore musicStore){
		for(int i=0;i<musicStore.getMusicstore().size();i++ ){
			displayData(musicStore.getMusicstore().get(i));
		}
	}

	/**
	 * 
	 * @return : void
	 */
	public void addRecord(MusicInfo musicInfo){
		boolean isPresent  = false;
		for(MusicInfo o : this.getMusicstore()){
			if(o.getName().equals(musicInfo.getName()))
				isPresent=true;
		}
		if(isPresent==false)
		{
			musicstore.add(musicInfo);
			storeIdx.addElementIdx(musicInfo.getAlbum(), musicInfo.getName(), musicInfo.getSinger(), idx++);
			//System.out.println(storeIdx.getAlbumIdx().size()+" "+idx);
		}
	}

	/**
	 * 
	 * @return : boolean
	 */
	public static boolean isNumber(String string) {
		try {
			Double.parseDouble(string);
		} catch (Exception e) {

			return false;
		}
		finally{

		}
		return true;
	}

	/**
	 * 
	 * @return : void
	 */
	public synchronized void searchRecord(String sname){
		//System.out.println("Music store : "+sname);
		try {
			int idx = storeIdx.getElementIdx(sname);
			//System.out.println("Search Result------------"+storeIdx.getElementIdx(sname));
			if ( idx < storeIdx.getAlbumIdx().size())
			{
				result.addRecord(getMusicstore().get(idx), sname, 1);
				Debug.println(2, "[searchRecord]: Searh Result is added for keyword:"+sname);
			} 
			else
			{
				result.addRecord(null, sname, 0);
				Debug.println(2, "[searchRecord]: Searh Result is added for keyword:"+sname);
			}
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
			System.exit(1);
		}
	}

	/**
	 * @return : String
	 */
	public String toString(){
		String returnString = "[MusicStore]: ";
		for(int i=0;i<this.getMusicstore().size();i++ ){
			
			returnString += displayData(this.getMusicstore().get(i));
		}
		return returnString;
	}
} // end class MusicStore

