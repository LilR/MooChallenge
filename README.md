# MooChallenge

An IDE with Maven set up is recommended, and the project should be clean installed. 

The service can then be run either with an IDE with Spring Boot integration or with "mvn spring-boot:run".
The main method is in com.lilyjordan.moochallenge.MooChallengeApplication.java.

To retrieve a customer, make a GET call to http://localhost:8080/customers/{surname}, with surname being the customer to add (the customer present by default is Bob Smith).

To add further customers, rows can be added to the table by going to http://localhost:8080/h2-console/ and logging in with username sa, blank password, and JDBC URL jdbc:h2:mem:testdb, or they can be added in the class com.lilyjordan.moochallenge.init.DataInit.java.

The JUnit tests can be run by running com.lilyjordan.moochallenge.CustomerControllerTest.
The integration test is run the same way, in com.lilyjordan.moochallenge.IntegrationTest, but the service must be running as above.