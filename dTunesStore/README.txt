CS542 Design Patterns
Fall 2013
PROJECT Assignment 1 README FILE

Due Date: Sunday, September 28, 2013
Submission Date: Sunday, September 28, 2013
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Chetan Badhe, Yash Desai
e-mail(s): cbadhe1@binghamton.edu, ydesai1@binghamton.edu


PURPOSE:

[
	Design a data structure (or use a built-in one), for the MusicStore
	class, that stores MusicInfo records. 
	Each MusicInfo record has the following: song name, album name,
	lead singer name, duration.
	Read data,Search data,Store data/result in a single data structure 
	using multiple thread. 
  
]

PERCENT COMPLETE:

[
	We believe we have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE:

[
	N/A
]

BUGS:

[
	None
]

FILES:

[
	Included with this project are 17 files:
	build.xml, the files which is us used to compile and run project, to create tar gzip file for project.
	dataFile.txt, stores music records.
	searchFile.txt, stores search keyword.
	IThreads.java, defines an interface for threads
	MusicInfo.java, defines a type for an object that holds music data
	MusicStore.java, contains data structure to store records also responsible for searching records.  
	PopulateWorker.java, Spawns threads to read and store data from dataFile
	SearchWorker.java, spawns threads to read searchFile and perform search option.
	StoreIndex.java, defines a type to store index for data.
	Driver.java, its contains main for project.  
	Debug.java, used for debugging.
	GenerateDataFile.java, Generates data file
	ReadFile.java, Responsible for reading files.
	ResultDataStore.java, defines a data structure to store results.
	Results.java, responsible for storing results.
	README.txt, the text file you are presently reading
]

SAMPLE OUTPUT:

[
  C:\Users\yash\Dropbox\Design Patterns\dTunesStore>ant run
Buildfile: C:\Users\yash\Dropbox\Design Patterns\dTunesStore\build.xml

jar:
      [jar] Building jar: C:\Users\yash\Dropbox\Design Patterns\dTunesStore\build\jar\dTunesStore.jar

run:
     [java] [displayResult]:
     [java] Keyword : Singer1
     [java] Song Name: song1    Album Name: album1      Singer Name: Singer1	Duration: 1.0
     [java] Keyword : song57
     [java] Song Name: song57   Album Name: album57     Singer Name: Singer57	Duration: 57.0
     [java] Keyword : album197
     [java] Song Name: song197  Album Name: album197    Singer Name: Singer197	Duration: 197.0
     [java] Keyword : album143
     [java] Song Name: song143  Album Name: album143    Singer Name: Singer143	Duration: 143.0
     [java]

BUILD SUCCESSFUL
Total time: 12 seconds
]

TO COMPILE:

[
  Extract and Enter into the extracted directory
  	cd Badhe_Chetan_Desai_Yash
  	ant compile
]

TO RUN:

[
	Extract and Enter into the extracted directory, compile it
	Please type ant run to run.
]

EXTRA CREDIT:

[
  First to post a better way to create a tarzip file for submission is to make 
  it an ANT target. You can add the creation of tar and gzip in the build.xml
  file.
]

NOTES :

[
	We have stored indexes for every attribute of a record in a hashmap to make search in O(1). Hashmap<<attribute value> ,<index>>
	and we have used an arraylist to store records. Following mechanism requires 75% more space than actual.
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Chetan Badhe
Yash Desai

[
  * http://www.tutorialspoint.com/java/java_multithreading.htm

  * http://www.tutorialspoint.com/java/java_hashtable_class.htm
 
 ]

ACKNOWLEDGEMENT:

[
	During the coding process one or more of the following people may have been consulted. Their help is greatly appreciated.
	Prof. Madhusudan Govindraju, Binghamton University.
	Elif Dede, Teaching Assistant , CS542, Binghamton University.
]