/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : MusicInfo.java
 * Description : Defines a Type of an object that stores one music record. 
 */
package dTunesStore.dataStore;

import dTunesStore.util.Debug;

public class MusicInfo {
	private String name;
	private String album;
	private String singer;
	private	double duration;

	/**
	 * 
	 * constructor. 
	 */
	public MusicInfo(String mname, String malbum, String msinger, 
			double mduration){
		this.setName(mname);
		this.setAlbum(malbum);
		this.setSinger(msinger);
		this.setDuration(mduration);

		Debug.println(4, "[MusicInfo()]: Song Name: "+mname+
				" Album Name: "+malbum+" Singer Name: "+msinger+
				" mduration: "+mduration);
	}

	/**
	 * 
	 * @return : String 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return : void 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return : String 
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * 
	 * @return : void 
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * 
	 * @return : String 
	 */
	public String getSinger() {
		return singer;
	}

	/**
	 * 
	 * @return : void 
	 * */
	public void setSinger(String singer) {
		this.singer = singer;
	}

	/**
	 * 
	 * @return : double 
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * 
	 * @return : void 
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * 
	 * @return : String 
	 */
	public String toString(){
		String returnString = "[MusicInfo]: "+ getName() +" " +
				getAlbum() + " " + getSinger()+ " "+ getDuration();
		return returnString;
	}
} // end class MusicInfo

