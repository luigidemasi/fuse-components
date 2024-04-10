Apache Camel IBM CICS component
-------------------------------
This Apache Camel component allows you to deal with IBM CICS mainframe system.

Build
-----
To be able to build the component, you have to add the IBM CTG client jar file into your local Maven repository using:

--
mvn install:install-file -DgroupId=com.ibm -DartifactId=ctgclient -Dversion=9.2 -Dpackaging=jar -Dfile=/path/to/ctg.jar
--

Then, you can use the regular:

--
mvn clean install
--
