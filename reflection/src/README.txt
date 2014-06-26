CS542 Design Patterns
Fall 2013
PROJECT Assignment 1 README FILE

Due Date: Sunday, November 10, 2013
Submission Date: Sunday, November 10, 2013
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Chetan Badhe
e-mail(s): cbadhe1@binghamton.edu


PURPOSE:

[
	Design two Java classes MyAllTypesFirst and MyAllTypesSecond with data members that have names and types as shown in the serialized format shown in the file MyAllTypes.txt. These two classes should have the appropriate setX and getX methods.
  
]

PERCENT COMPLETE:

[
	I believe I have completed 100% of this project.
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
	reflection
    MyAllTypes.txt      
	src
		README.txt  
		build.xml
		reflection
			driver:
				driver.java

			serDeser:
				Deserialize.java   
				Serialize.java       
				Strategy.java
				DeserializeTypes.java
				SerializePredefined.java
				Serialization.java    
				SerializeTypes.java

			util:
				ClassNames.java  
				Debug.java
				MyAllTypesFirst.java 
				MyAllTypesSecond.java

]

SAMPLE OUTPUT:

[
bingsuns2% ant run MyAllTypes.txt MyAllTyoesCopy.txt 0
Buildfile: build.xml

jar:
    [mkdir] Created dir: /u0/users/7/cbadhe1/ant/reflection/build/jar
      [jar] Building jar: /u0/users/7/cbadhe1/ant/reflection/build/jar/reflection.jar

run:
     [java] Unique MyAllTypesFirst = 4 Unique MyAllTypesSecond = 9

]

TO COMPILE:

[
  Extract and Enter into the extracted directory
  	cd Chetan_Badhe
  	ant compile
]

TO RUN:

[
	Extract and Enter into the extracted directory, compile it
	Please type ant run to run.
]

EXTRA CREDIT:

[
  N/A
]

NOTES :

[
	I have used Strategy pattern for serialization.
	0- Unique Instances
	1- Object Array
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Chetan Badhe


[

 
]

ACKNOWLEDGEMENT:

[
	During the coding process one or more of the following people may have been consulted. Their help is greatly appreciated.
	Prof. Madhusudan Govindraju, Binghamton University.
	Elif Dede, Teaching Assistant , CS542, Binghamton University.
]