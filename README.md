# A Playground Environment for Testing
This is a project for testing without affecting the source code of other projects.
Both the application and the mysql can be accessed in the local machine and the container,
and all changes will be synchronized at the same time.

For example, the following can be both accessed in the container and the local machine.
1. Source code of this project (local: ., container: /app)
2. Dependencies used in this project (managed by maven, local: /User/${USERNAME}/.m2, container: /root/.m2)
3. Mysql Database (local: localhost:13306, container: localhost:3306, see [Mysql](#mysql))

## Prerequisite
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)

## Quick Start
**Warning! Stay alert to your path while executing docker commands.**

**You must execute all docker commands under this project directory.**

### Application
Clone this project to your local machine, **do NOT clone this project in the `work` folder!**
```bash
git clone https://github.com/tszyaul6/playground-java.git
```

cd into the project root directory, and build the containers
```bash
docker compose up --build -d
```
Get inside the container, use maven to install and run the project
```bash
docker exec -it playground bash
```
```bash
mvn clean install
```
Finally, start the application
```bash
java -jar target/*.jar
```
... and your application should be up and running at http://localhost:18080/

### Mysql
If you would like to connect to the mysql, run
```bash
docker exec -it playground_mysql mysql -uroot -psecret
```
... or you may connect to the mysql with any GUI (e.g. [HeidiSQL](https://www.heidisql.com/), [DBeaver](https://dbeaver.io/)) using localhost with port 13306

## Uninstall
After finish testing code in the project, you can remove the containers
```bash
docker compose down
```
or
```bash
docker compose down -v
```
(Note that using -v flag will remove the volumes, which all data in the database will be removed.)
