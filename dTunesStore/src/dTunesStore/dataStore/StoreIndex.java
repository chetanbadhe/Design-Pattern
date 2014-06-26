/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : StoreIndex.java
 * Description : Type to store an index for album, song and singer
 */
package dTunesStore.dataStore;

import java.util.HashMap;

import dTunesStore.util.Debug;

public class StoreIndex {
	private HashMap<String, Integer> albumIdx = null;
	private HashMap<String, Integer> songIdx = null; 
	private HashMap<String, Integer> singerIdx = new HashMap<>();

	public StoreIndex()
	{
		albumIdx = new HashMap<>();
		songIdx = new HashMap<>();
		singerIdx = new HashMap<>();
		Debug.println(4, "[StoreIndex()]: albumIdx, songIdx, singerIdx Initialized");
	}

	/**
	 * 
	 * @return : HashMap<String, Integer>
	 */
	public HashMap<String, Integer> getAlbumIdx() {
		return albumIdx;
	}

	/**
	 * 
	 * @return : void
	 */
	public void setAlbumIdx(HashMap<String, Integer> albumIdx) {
		this.albumIdx = albumIdx;
	}

	/**
	 * 
	 * @return : HashMap<String, Integer>
	 */
	public HashMap<String, Integer> getSongIdx() {
		return songIdx;
	}
	
	/**
	 * 
	 * @return : void
	 */
	public void setSongIdx(HashMap<String, Integer> songIdx) {
		this.songIdx = songIdx;
	}
	
	/**
	 * 
	 * @return : HashMap<String, Integer>
	 */
	public HashMap<String, Integer> getSingerIdx() {
		return singerIdx;
	}
	
	/**
	 * 
	 * @return : void
	 */
	public void setSingerIdx(HashMap<String, Integer> singerIdx) {
		this.singerIdx = singerIdx;
	}

	/**
	 * 
	 * @return : void
	 */
	public void addElementIdx(String albumName, String songName, 
			String singerName, int idx)
	{
		this.getAlbumIdx().put(albumName, idx);
		this.getSongIdx().put(songName, idx);
		this.getSingerIdx().put(singerName, idx);
	}

	/**
	 * 
	 * @return : int
	 */
	public int getElementIdx(String searchString)
	{
		int idx = 0;
		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;
		try {
			idx1 = this.getAlbumIdx().get(searchString);
		}
		catch (NullPointerException n)
		{
			idx1 = this.getAlbumIdx().size() + 1;
		}
		try {
			idx2 = this.getSongIdx().get(searchString);
		}
		catch (NullPointerException n)
		{
			idx2 = getSongIdx().size() + 1;
		}
		try {
			idx3 = this.getSingerIdx().get(searchString);
		}
		catch (NullPointerException n)
		{
			idx3 = this.getSingerIdx().size() + 1;
		}

		idx = findMin(idx1, idx2, idx3);
		
		return idx;

	}

	/**
	 * 
	 * @return : int
	 */
	private int findMin(int ele1, int ele2, int ele3)
	{
		return Math.min(Math.min(ele1, ele2), ele3);
	}
	
	/**
	 * 
	 * @return : String
	 */
	public String toString()
	{
		String	msg = "Size of Album Idx : "+getAlbumIdx().size()+
				" Size of Singer Idx : "+getSingerIdx().size()+
				" Size of Song Idx : "+getSongIdx().size();
		return msg;
	}
}

