# money-transfer-application

## Running the project

To run the project, follow the instructions below:
* Build the jar file

```bash
./mvnw clean package
```

* Build API and MySQL docker containers with docker-compose:

```bash
docker-compose up --build
```

* Run the bash script to test the API money transfer feature:

```bash
./application_test.sh 
```

## Completing the project

This section describes the steps I took to complete this project, my thought process and some difficulties I ran into along the way.

### Step 1: Spring Initializr

I used Spring Initializr to manually initialize the project. When I entered the service, I:
* selected Maven for dependency injection, 
* selected Java as the programming language and
* selected the following three dependencies:
    * Spring Web
    * Spring Data JPA
    * MySQL Driver.

The service generated a ZIP file which contained my project and the Maven tools that helped me:
* package my project into executable jar files,
* generate build information and
* run my Spring Boot application.

### Step 2: Setting up the MySQL Database

This mainly consisted of telling Spring Boot to use MySQL and defining connection attributes in ``src/main/resources/application.properties``. Initially, to test things out, I created a database on the local host. If you go into ``application.properties``, you can see these attributes commented out under 'Test Version'. Later on, during the containerization process, I used this file to point Spring Boot into creating a database in the MySQL docker container. These attributes are in the ``application.properties`` file under 'Final Version'.

### Step 3: Creating Entity Models, Repositories, Controllers and Exception Handlers

I started by creating an Account class, which defines Accounts in the system. Then, I created an AccountRepository class, which is a Spring Data JPA repository that handles the database interactions like creating, reading, updating and deleting records.

To test whether the interactions were working well, I created a LoadDatabase class which preloaded some data into the database.

Then I moved on to creating the Controller, which handles all the HTTP requests like adding a new account, listing all accounts, updating accounts and deleting them.

To create the money transfer feature, I created a TransferRequest class which stores the ID of the account sending the funds, the account receiving the funds and the amount of money being transferred. In the account controller class, I created a method which handles the HTTP PUT operation specific to the transfer request. This method is meant to handle a command like the one below:

```
curl -X PUT 0.0.0.0:8080/transfer -H 'Content-type:application/json' -d '{"accountFromID": 1, "accountToID": 2, "amount": 5000}'
```

The method takes a TransferRequest class as input and handles the withdrawals and deposits of the accounts. The method also updates the accounts in the database with the new balances.

Finally, I created a two Exception Handling classes:
* One stops the money transfer process if there are insufficient funds in the account sending the funds.
* The other gives a NOT FOUND error if the user tries to retrieve an account which does not exist. 

### Step 4: Dockerization

The solution here was to create two docker containers: one to hold the API program and the other to hold the MySQL database. I linked these two using docker-compose.

The main difficulty here was getting the two containers to communicate. I realised this could be done by pointing the Java program to the MySQL container in the ``application.properties`` file and by creating a docker network which the two containers shared.

Another problem I encountered was that the Java app build would fail during test phase of Maven. Providing ``spring.datasource.url=jdbc:mysql://localhost:3306/app_accounts_db`` in the ``application.properties`` file would work well because the database was on the localhost and actually existed. But providing ``spring.datasource.url=jdbc:mysql://mysql_db:3306/ellamfar_app_db`` would fail because the database did not exist yet and would only exist inside a docker container, whereas the Maven tests were executed outside the container. The Maven tests needed an in memory database. Therefore, I overrided the properties the ``application.properties`` file directly in the test class:

```
@SpringBootTest(properties = { 
	"spring.datasource.url=jdbc:mysql://localhost:3306/app_accounts_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false",
	"spring.datasource.username=moneytransfer_user" })
```

This creates a database on the localhost specifically for the Maven Tests.

## Future Amendments

1. Better security. At the moment, Docker is being run with root priviledges. An important improvement to the Dockerfile would be to run the application as a non-root user. Also, the program may be exposed to SQL injection attacks. An improvement would be to only allow certain priviledges to the user associated with the database.

2. The LoadDatabase class preloads those two accounts everytime the program is launched. I would amend it to only run once.

3. Create a web page for the program.