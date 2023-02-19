# TESoS
Test Engine for System-of-Systems, is a tool created to help derivate test requisites of System-of-Systems based on a mKAOS model.

## System Requirements
Node - 16.18.0

Angular -14.2.10

Java - 11.0.17

Apache Maven - 3.6.3

mySQL - 8.0.32

Spring-Boot


## Instalation

### Client
Move to the client folder
```bash
cd client/
```
Install dependencies
```bash
cd npm install
```
Run angular server 
```bash
ng serve
```


### Server
Move to the server folder
```bash
cd server/
```
Move to resources folder
```bash
cd /src/main/resources/
```

Open application.properties

Update your database username and password

```
spring.datasource.username=<YOUR_USERNAME>
spring.datasource.password=<YOUR_PASSWORD>
```

Make sure your mysql server is running

Run spring server
``` bash
cd mvn spring-boot:run
```

## Open Aplication
To access TESoS open a web browser and type http://localhost:4200/

The home page has a set of instructions on how to use the tool


## Notes
- The models from the example of International Master SoS belonging to EDUFYSoS are available in the folder examples
- Depending on how many models are uploaded the system may take a while to process
