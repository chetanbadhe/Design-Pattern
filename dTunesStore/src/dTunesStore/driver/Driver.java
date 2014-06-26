package dTunesStore.driver;

import java.io.File;

import dTunesStore.util.Debug;
import dTunesStore.util.GenerateDataFile;
import dTunesStore.util.Results;
import dTunesStore.dataStore.MusicStore;
import dTunesStore.dataStore.PopulateWorker;
import dTunesStore.dataStore.SearchWorker;

public class Driver {

	private static MusicStore musicStore = null;
	private static GenerateDataFile genearteDataFile = null;
	
	/**
	 * 
	 * @return: boolean 
	 */
	private static boolean isValidArguments(String args[]){
		if(args.length !=5){
			System.out.println("Invalid argument length. It should"
					+ "be between 5 ");
			return false;
		}
		if (Integer.parseInt(args[1]) > 5 || Integer.parseInt(args[1])
				< 1 )
		{
			System.out.println("Invalid Read Thread value, It should"
					+ " be between 1 - 5 ");
			return false;
		}
		if (Integer.parseInt(args[3]) > 5 || Integer.parseInt(args[3])
				< 1 )
		{
			System.out.println("Invalid Search Thread value, It should"
					+ " be between 1 - 5 ");
			return false;
		}
		if(Integer.parseInt(args[4]) >= 5 || Integer.parseInt(args[4])
				< 0){
			System.out.println("Invalid Debug value, It should"
					+ " be between 0 - 4 ");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return: void
	 */
	public static void main(String args[]) {
		if (isValidArguments(args)) {
			genearteDataFile = new GenerateDataFile(args[0]);
			File datafile = new File(System.getProperty("user.dir")+"//"
					+args[0]);
			Results result = new Results();
			File searchfile = new File(System.getProperty("user.dir")+"//"+
					args[2]);
			Debug.setDEBUG_VALUE(Integer.parseInt(args[4]));
			if (datafile.exists() && searchfile.exists()) {
				try {
					PopulateWorker pw = new PopulateWorker(args[0],Integer.
							parseInt(args[1].trim()));
					pw.createThread();
					musicStore = pw.getMusicStore();
					SearchWorker sw = new SearchWorker(args[2],Integer.
							parseInt(args[3].trim()));
					sw.setMusicStore(musicStore);
					Thread.currentThread();
					Thread.sleep(10000);
					sw.createThread();
					result = musicStore.getResult();
					Thread.currentThread();
					Thread.sleep(1000);
					result.displayResult();
				} catch (Exception e) {
					System.err.println(e.toString());
					System.exit(1);
				}
				finally{

				}
			}
			else{
				System.out.println("Files not found.");
				System.exit(1);
			}
		}
		else{
			System.exit(1);
		}

	} // end main(...)
} // end class Driver
