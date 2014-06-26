/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : SearchWorker.java
 * Description : Spawns Search thread to search records.
 */

package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import dTunesStore.util.Debug;
import dTunesStore.util.ReadFile;


public class SearchWorker implements IThreads {
	private BufferedReader br = null;
	private int numthreads = 0;
	private MusicStore musicStore = null;
	private List<String> searchString = null;
	private ReadFile readfile = null;
	
	/**
	 * 
	 * Constructor
	 */
	public SearchWorker(String fname, int thread) {
		Debug.println(4, "[SearchWorker()]: Search File Name :"+fname+
				" No. of Search Thread:"+thread );
		try{
			br = new BufferedReader(new FileReader(
					System.getProperty("user.dir")+"//"+fname));
			searchString = new ArrayList<String>();
			numthreads = thread;
			readfile = new ReadFile();
		}
		catch(Exception e){
			System.err.println(e.toString());
			System.err.println("SearchWorker");
			System.exit(1);
		}
		finally{

		}
	}

	/**
	 * 
	 * @return : MusicStore
	 */
	public MusicStore getMusicStore() {
		return musicStore;
	}

	/**
	 * 
	 * @return : void
	 */
	public void setMusicStore(MusicStore musicStore) {
		this.musicStore = musicStore;
	}

	/**
	 * 
	 * @return  : void
	 */
	public void run() {
		String threadname = Thread.currentThread().getName();
		Debug.println(3, "[run]: SearchWorkerThread: "+threadname);
		String readLine;
		//System.out.println(threadname);
		try {

			while((readLine=this.readfile.readfile(this.getBr()))!= 
					null){
				//System.out.println(threadname);
				searchString.add(readLine);
				getMusicStore().searchRecord(readLine);
				Thread.currentThread();
				Thread.sleep(10);
			}
		} catch (Exception e) {
			System.err.println(e.toString());
			System.exit(1);
		}
		finally{
		}
	} // end run(...)

	/**
	 * 
	 * @return : List<String>
	 */
	public List<String> getSearchString() {
		return searchString;
	}

	/**
	 * 
	 * @return : void
	 */
	public void setSearchString(List<String> searchString) {
		this.searchString = searchString;
	}

	/**
	 * 
	 * @return : BufferedReader
	 */
	public BufferedReader getBr() {
		return br;
	}

	/**
	 * 
	 * @return : void
	 */
	public void setBr(BufferedReader br) {
		this.br = br;
	}

	/**
	 * 
	 * @return: String
	 */
	public String toString(){
		String returnString = "[SearchWorker]: Size of SearchRecords"
				+ " MusicStore "+ this.getSearchString().size()+
				" Number of Search thread "+ this.numthreads;
		return returnString;
	}

	/**
	 * 
	 * @return : void
	 */
	@Override
	public void createThread() {
		try {
			List<Thread> threadArray= new ArrayList<Thread>();
			Thread thread= null;
			for (int i = 0; i < this.numthreads; i++) {
				thread = new Thread(this,"thread"+i);
				threadArray.add(thread);
			}
			for (int i = 0; i < this.numthreads; i++) {
				thread = threadArray.get(i);
				thread.start();
			}
		} catch (Exception e) {
			System.err.println(e.toString());
			System.err.println("startSearchWorkerThread");
			System.exit(1);
		}
		finally{

		}
		
	}
} // end class SearchWorker

