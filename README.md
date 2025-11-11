# Auto-generated ReadmeGenerator application from ReadmeGenerator db schema

This application is JEE in the backend using H2 in memory data for testing. The generated code comes with a docker
build file for generating a docker image

## Instruction

All instructions should be run in a terminal

### Clone the project

```git clone https://github.com/gmai2006/ReadmeGeneratortest.git```

### Format the source code and build the ReadmeGeneratortest

```gradle spotlessApply build copyReact buildAll```

### Create a Docker image that contains Wildfly and the ReadmeGeneratortest WAR file. You must have Docker installed

```sudo docker build --tag=ReadmeGeneratortest .```

### Run the docker image

```sudo docker run -p 8080:8080 -p 9990:9990 -it ReadmeGeneratortest```

### View the generate application

```http://127.0.0.1:8080/ReadmeGeneratortest/```

### Load data from Excel into the DB

```Initially, the database is empty.  To load the test data from Excel into DB run http://127.0.0.1:8080/ReadmeGeneratortest/rest/admin/loadata```

# Development

## Prerequisites

- Install OpenJDK. Skip this step if you have JDK installed already
- sudo apt update
- sudo apt install default-jdk
- java -version
- Install Wildfly. Skip this step if you have Wildfly installed already
-
WILDFLY_RELEASE=$(curl -s https://api.github.com/repos/wildfly/wildfly/releases/latest|grep tag_name|cut -d '"' -f 4) echo $
WILDFLY_RELEASE
- wget https://github.com/wildfly/wildfly/releases/download/${WILDFLY_RELEASE}/wildfly-${WILDFLY_RELEASE}.tar.gz
- tar -xvf wildfly-${WILDFLY_RELEASE}.tar.gz
- cd ./wildfly{WILDFLY_RELEASE}/bin
- ./standalone.sh