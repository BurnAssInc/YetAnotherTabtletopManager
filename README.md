## For local start required:
- JDK 21
- Running Docker

## Swagger&Docs
http://localhost:8080/swagger-ui/index.html
If you modify endpoints please describe it using sprindoc annotations as in [example](src/main/java/ru/surin/yatm/controller/api/SampleControllerApi.java)

## Unit tests
Write unit tests for every service you make

## Security
By default `dev` profile is active disabling any security restrictions  
Default username for /actuator : `user`  
Password is written in console Using generated security password: `{some-password}`  

## Database 
For development is described in [compose.yaml](compose.yaml)  
Username: `myuser`  
Password: `secret`  
DB: `mydatabase`  

-------------------> **DO NOT CREATE TABLES MANUALLY** <-------------------  
Use flyway migration. Write migration script in [directory](src/main/resources/db/migration)  
Each script in new file with template name like [V000001__create__character.sql](src%2Fmain%2Fresources%2Fdb%2Fmigration%2FV000001__create__character.sql)