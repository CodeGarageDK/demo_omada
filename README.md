DEMO_OMADA

Description:
    - Little simple demo-project doing 4 tests on the Omada homepage.

Technologies:
    - Spring Boot
    - Maven
    - Selenium
    - Cucumber
    - JUnit 5

Preconditions:
    - Java JDK (eg. OpenJDK 17 - https://java.tutorials24x7.com/blog/how-to-install-openjdk-17-on-windows)
    - Maven (https://maven.apache.org/install.html) - or use the wrapper .\mvnw instead of mvn

Run:
    - in terminal, from the root (Where your pom.xml is) of the project type:

        mvn clean install

    OR

        mvn test
		
    OR

        mvn test -Dbrowser=edge -Dcucumber.filter.tags="@test1 or @test2"

    OR

        mvn test "-Dspring.profiles.active=dev"