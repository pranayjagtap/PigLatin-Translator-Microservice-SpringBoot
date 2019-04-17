# PigLatin-Translator-Microservice-SpringBoot




Pranay's Pig Lating translator

Steps to utilize service using a terminal:

A] Host the API.
1. Open terminal and run the below command 
java -jar piglatinApi.jar

--This will host API on 8080 portal (8080 portal must be open and not being used by any other service)

B]. Open terminal and run below command for client

javac JavaClient.java
java JavaClient

--Client will be up and ready to make API calls to the pigLatin API service.

Select 1 to enter the english text and then enter the text you want to translate.
Client will make an API call to the service and reply would be displayed as a simple translated text.
Press 1 to enter nother text and 2 to exit from client program.


C] Test Suite.
1. Open the terminal and enter the below command
java -jar testSuite.jar

 

Steps to utilize service using an IDE(Eclipse/STS):
1. Load the project as existing maven project
2. Once the project is built, run the project as Spring boot application
3. Run JavaClient as a Java application separately.
4. Run PigLatinApplicationTests.java as Java applicattion or JUnit in IDE.

--Test cases are for all edge cases and other considerations are bundled in 1 JUnit class which can be run on IDE as a simple Java program in the imported project.

Tests are availbale in the tests folder.


Application can also be tested by hosting the end points and using Postmail to make a GET request to
http://localhost:8080/translate
with key =reqstring
and value = <String to be translated>


Considerations made during designing client:
Client can make GET requests to the API with string parameter being passed.
Multiple instances of client can run.

Design decisions:
All edge cases are handled.
Spring boot is used to create a REST api allowing a client to send requests.
API end point:
http://localhost:8080/translate
Sample request:
http://localhost:8080/translate?reqstring=Some%20string%20tobe%20converted

A simple string parameter is passed. With little changes you can change to send JSON object instead as per requirement.
