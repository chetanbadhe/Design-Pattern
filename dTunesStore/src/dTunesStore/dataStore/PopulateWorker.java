/**
 * Subject : CS542 - Programming Design Pattern
 * Homework : 1
 * Author : Chetan Badhe, Yash Desai.
 * File Name : PopulateWorker.java
 * Description : Spawns thread to read dataFile and store in a data structure.
 */

package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dTunesStore.util.Debug;
import dTunesStore.util.ReadFile;

public class PopulateWorker implements IThreads {
	private BufferedReader br = null;
	private int numthreads = 0;
	private MusicStore musicStore = null;
	private ReadFile readfile = null;

	/**
	 * 
	 * constructor
	 */
	public PopulateWorker(String fname, int thread) {
		Debug.println(4, "[PopulateWorker():] Data File Name :"+fname+
				" No. of Search Thread:"+thread );
		try{
			br = new BufferedReader(new FileReader(
					System.getProperty("user.dir")+"//"+fname));
			musicStore = new MusicStore();
			readfile = new ReadFile();
			//numrecords = countRecords(fname);
			numthreads = thread;
		}
		catch(Exception e){
			System.err.println(e.toString());
			System.exit(1);
		}
		finally{

		}
	}

	/**
	 * 
	 * @return: MusicStore
	 */
	public MusicStore getMusicStore() {
		return musicStore;
	}

	/**
	 * 
	 * @return: void
	 */
	public void setMusicStore(MusicStore musicStore) {
		this.musicStore = musicStore;
	}

	/**
	 * 
	 * @return: void
	 */
	public void run() {
		String threadname = Thread.currentThread().getName();
		Debug.println(3, "[run]: PopulateWorkerThread: "+threadname);

		String readLine;
		try {
			while((readLine=readfile.readfile(br))!=null){
				//System.out.println(threadname + " "+readLine);
				String[] str =readLine.split(" ");
				dTunesStore.dataStore.MusicInfo musicInfo = new MusicInfo(
						str[0].toString().trim(),str[1].toString().
						trim(),str[2].toString().trim(),Double
						.parseDouble(str[3].trim()));
				synchronized(musicStore){
					musicStore.addRecord(musicInfo);
				}					
			}
		} catch (Exception e) {
			System.err.println(e.toString());
			System.exit(1);
		}
		finally{

		}
	} 

	/**
	 * 
	 * @return: String
	 */
	public String toString(){
		String returnString = "[PopulateWorker]: Size of WorkerRecords "
				+ "MusicStore "+ this.getMusicStore().getMusicstore()
				.size()+ " Number of Populate thread "+ this.numthreads;
		return returnString;
	}

	/**
	 * 
	 * @return: int
	 */
	public int countRecords(String fname){
		int count = 0;
		try {

			BufferedReader br = new BufferedReader(new FileReader(
					System.getProperty("user.dir")+"//"+fname));
			while(br.readLine()!=null){
				count++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e.toString());
			System.exit(1);
		}
		finally{

		}
		return count;
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
				thread.join();
			}
		} catch (Exception e) {
			System.err.println(e.toString() + "startPopulateWorker"
					+ "Thread()");
			System.exit(1);
		}
		finally{

		}
		
	}
} // end class PopulateWorker

