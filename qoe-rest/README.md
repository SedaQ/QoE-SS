# QoE REST API

This is short documentation for testing and using REST API in QoE project.
QoE has HATEOAS API for easy navigation and usage.

### Prerequisites

The project was built and tested with these version of mvn and JDK, so if you have any unexpected troubles let us know.

```
Apache Maven 3.3.9
Java version: 1.8.0_101, vendor: Oracle Corporation
```

### Installing & running the project
Clone the master branch of this project to your directory via command

```
git clone https://github.com/SedaQ/QoE-SS.git
```

After succesfully build, change directory to rest module and run tomcat via:

```
> cd qoe-rest
> ...\qoe-rest\mvn tomcat7:run

```

### Testing
For easy testing purpose in GUI I recommend you to use Advanced REST client for Chrome browser. https://advancedrestclient.com/
You can also use Curl or Postman.

### GET example commands
#### Questionary
```
~/rest/hateos/questionaries
```
Posibility of filtering and searching via REST API
```
~/rest/hateos/questionaries?search=age==24;school==zakladni
```
Notation for searching is written in EBNF notation [ISO 14977](http://www.cl.cam.ac.uk/~mgk25/iso-14977.pdf)

### POST example commands
#### User 
Requires: email, password
```
POST ~/users
curl -X POST -i -H "Content-Type: application/json" 
--data '{"email":"pavelseda@email.cz","password":"EncryptedPassword123"}'
http://localhost:8080/rest/hateos/users
```

#### Questionary
Requires: age, gender, school, userConnection
```
POST ~/questionaries
curl -X POST -i -H "Content-Type: application/json" 
--data '{"age":"24","gender":"muz","school":"stredni_skola","userConnection":"mobilni_data"}' http://localhost:8080/rest/hateos/questionaries
```
or with reference to user entity send this type of data with JSON inner object user:
```
{"age":"29","gender":"muze","school":"stredni_skolaa","userConnection":"mobilnieee_data","user":{"id":"1"}}
```
#### Mos
Requires: mosValue
```
POST ~/mos
curl -X POST -i -H "Content-Type: application/json" 
--data '{"mosValue":"5"}' 
http://localhost:8080/rest/hateos/mos
```
or with reference to questionary, scenario, video entities send this type of data with JSON inner objects..
```
{"mosValue":"2","questionary":{"id":"1"}, "scenario":{"id":"2"},"video":{"id":"9"}}
```


