# Test Fullstack (JAVA)
 A simple API Java test, with angular frontEnd

## Requirements

- Java 1.7+
- Tomcat 7.0
- NPM 2.14 or higher
- MySQL
- Maven

## Install

Enter to directory project and install depdndencies

```shell
cd test_fullstack/
npm install
```

Install maven dependencies
```shell
mvn install
```

Import/Create DB
```shell
mysql -u root -p < database.txt
```

Run grunt for generate js and css builds
```shell
node_modules/.bin/grunt build
```

## Usage

Import in Eclipse or Generate WAR and Run Tomcat Server

Now open your browser and navigate to http://localhost:8080/test_fullstack or
http://localhost:8080/test_fullstack/api/inventory {GET, POST, DELETE, PUT},
http://localhost:8080/test_fullstack/api/types {GET}
