## Finance API
This project is for a personal study. The main goals is experimental the follow tecnologies:
* Spring Boot
* Docker
* Relational databases
* No-relational databases
* Messages and Event Streeming plataforms

####How to run
Follow the steps

Build project

    ./gradlew clean build

Execute Flyway Migration with some of the optios for environment

    .gradlew flywayMigrate -Penv=(local|dev|qa|prod)

You can run the application in two ways:
1. Java application local

        java -jar build/finance-api-{version}.jar
    
2. Java application in a docker

        wip
