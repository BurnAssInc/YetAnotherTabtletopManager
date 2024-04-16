## For local start required:
- JDK 21
- Running Docker

## Security
Default username for /actuator : `user`  
Password is written in console Using generated security password: `{some-password}`  

## Database 
For development is described in [compose.yaml](compose.yaml)  
Username: `myuser`  
Password: `secret`  
DB: `mydatabase`  

-------------------> **DO NOT CREATE TABLES MANUALLY** <-------------------  
Use flyway migration. Write migration script in [directory](src/main/resources/db/migration)  
Each script in new file with template name like `V000001_create_character.sql`