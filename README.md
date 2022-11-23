# Amenity Reservation System

This app was created with Bootify.io - more documentation [can be found here](https://bootify.io/docs/). Feel free to contact us for further questions.


An amenity reservation system where users/residents can log in and reserve a time to use a service such as fitness center, pool, or sauna in a hypothetical apartment complex. Each amenity will have a certain capacity (number of people that can use the service at the same time) so that people can make use of the amenities safely during the Covid-19 pandemic. Whole development process and technical decisions has been explained in this tutorial:

https://www.freecodecamp.org/news/spring-boot-tutorial-build-fast-modern-java-app/


## Development

During development it is recommended to use the profile `local`. In IntelliJ, `-Dspring.profiles.active=local` can be added in the VM options of the Run Configuration after enabling this property in "Modify options".

Update your local database connection in `application.yml` or create your own `application-local.yml` file to override settings for development.

Lombok must be supported by your IDE. For this, in IntelliJ install the Lombok plugin and enable annotation processing - [learn more](https://bootify.io/intellij/spring-boot-with-lombok.html).

After starting the application it is accessible under `localhost:8080`.

## Build

The application can be built using the following command:

```
mvnw clean package
```

The application can then be started with the following command - here with the profile `production`:

```
java -Dspring.profiles.active=production -jar ./target/amenity-reservation-system-0.0.1-SNAPSHOT.jar
```
## Technologies
* Spring Boot
* Thymeleaf
* Hibernate
* Swagger
* Spring Security
* Bootify
* Maven
* JPA
* H2 In-Memory Database
* Bootstrap

## Use Cases / User Stories
* Users should be able to log in.
* We will assume that the accounts of residents are pre-created and there will be no sign-up feature.
* Users should be able to view their reservations.
* Users should be able to create new reservations by selecting the amenity type, date, and time.
* Only logged-in users should be able to see the reservations page and create reservations.
* We should check the capacity and only create new reservations if the current number of reservations does not exceed the capacity.

## Further readings

* [Maven docs](https://maven.apache.org/guides/index.html)  
* [Spring Boot reference](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)  
* [Spring Data JPA reference](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)  
