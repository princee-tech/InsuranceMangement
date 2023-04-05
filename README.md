Introduction of project(InsurancePolcyMangement)
This is an insurance management platform built using Spring Boot and Java that allows users to manage insurance policies, clients, and claims.



Client management: create,retrive,update, and delete clients.
Policy management:retrive, Create, update, and delete policies for clients.
Claims management: Allow clients to file claims and process them.retrive, Create, update, and delete claim for clients.

Structure:
The project is structured into the following packages:
Go to Spring Intializer For Create the project.

com.Insurance.insurance: contains the main application class and configuration files.
com.Insurancee.entity: contains the entities .
com.Insurancee.payload: contains the data transfer objects for provide extra securty.
com.Insurancee.insurance.controller: contains the REST API controllers.
 com.Insurance..repository: contains the Spring Data JPA repositories.
com.Insurance..service: contains the business logic and services.
com.Insurance..Exceprion: contains the exception .
flow of the project
 whenever we are using the API we have postman
 Postman calls the controller layer .
 controller layer calls the service layer .
 service layer calls the repository layer.
 repository layer interact with database.
Note: We will use conept of payload i will create Dto classes (the best security we will create the seperate class as called as a dto )
Technologies Used
Spring Boot
Java 17
Spring Web
Spring Data JPA
mysql Services
lombok
Spring boot DevTools
How to Run Locally
To run the platform locally, follow these steps
Open the project in your IDE and wait for dependencies to be installed.
Run the application class: InsuranceApplication.
Open the application in your browser: http://localhost:9092
go to postman ( ere we can perform crud operations);
