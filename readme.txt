Read Me
Purpose: educational course offered in TCE IT 2016

AjaxExample
http://localhost:8080/Servlet2xExample/AjaxExample.html

Session Management Example
http://localhost:8080/Servlet2xExample/Servlet2xSessionManagementExample

JAX-WS Notes
------------
http://localhost:8080/SampleJAX-WS-Project/services/MathService?wsdl

http://localhost:8080/SampleJAX-WS-Project/servlet/AxisServlet


wsimport –keep <URL>
Import resultant into your project
In the wsdl file look for 
wsdl:service
And then wsdl:port 
Invoke the Contract into your code

Maven - Create a project
------------------------
#maven project jdbc-mongo

mvn archetype:generate -DgroupId=example.tce.cloud.mongodbJDBC -DartifactId=mongodbJDBC -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn archetype:generate -DgroupId=example.tce.cloud.mongodb -DartifactId=mongodbJDBCSample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


maven commands

mvn archetype:generate -DgroupId=example.tce.it.cloud -DartifactId=CommonUtils -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn eclipse:eclipse

mvn package

#create a web app
mvn archetype:generate -DgroupId=edu.tce.it.servlet2 -DartifactId=HelloWorldServlet2 -DarchetypeArtifactId=maven-archetype-webapp 

#project structure
 |-- src
 |   `-- main
 |       `-- java
 |           |-- resources
 |           |-- webapp
 |           |   `-- WEB-INF
 |           |       `-- web.xml
 |           `-- index.jsp
  `-- pom.xml



