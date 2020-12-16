- This is the simple web application which can get data insight from Github repos

- Technologies and frameworks used:
  - Java 8
  - Spring framework
  - Angular 11
  - PostgreSQL 10
  - Github Api: https://docs.github.com/en/free-pro-team@latest/rest

- Live Demo: update later!!!


- Need to install:
  - Node v14.15.1 : https://nodejs.org/dist/v14.15.1/node-v14.15.1-x64.msi
  - Java 8: https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html
  - Angular CLI 11.0.4: https://cli.angular.io/
  - PostgreSQL 10.15: https://www.postgresql.org/download/
  - PgAdmin 4: https://www.pgadmin.org/download/

- Step to run/build
- Database
  - Guide from PostgreSQL: https://www.postgresql.org/docs/10/backup-dump.html
  - Use database dump from ...\ReposInsight.DB\repos_insight_db
  - Open pgAdmin 4
  - Create new database with name: github_metrics
  - Use dump command: psql -U *yourusernameforpostgre* github_metrics < *path to repos_insight_db* 

- API
  - Use IntellJ: https://www.jetbrains.com/idea/
  - Open Folder ...\ReposInsight.API by IntellJ
  - Update spring.datasource.username=*yourusernameforpostgre*, spring.datasource.password=*yourpasswordforpostgre* in application.properties file: ...\src\main\resources\application.properties
  - On menu, select Build tab -> Build Project
  - Go to main file: repos-insight/ReposInsight.API/src/main/java/com/githubtools/demo/DemoApplication.java
  - Run it.

- UI
  - Use Visual Studio Code: https://code.visualstudio.com/docs/setup/linux
  - Open Folder ...\ReposInsight.UI
  - Type the command: "npm install"  to install package
  - Type: "ng serve" or "npm start" to run
  - Navigate to http://localhost:4200/ to enjoy

<b>Note : IN THE FIRST TIME RUN THE PROJECT, NEED TO CLICK TO "SYNC LATEST DATA" TO SYNC LATEST DATA FROM GITHUB.
  THE SYNC FUNCTION WILL AUTOMATICALLY RUN EVERY SIX HOURS</b>

- Currently Fuction in App:
  - list commits weekly in latest 3 months
  - list commits monthly in latest 3 months
  - top 10 committers in latest 3 months
  - language breakdown
  - getting latest data by sync data


- Function will be implement in the future:

  - Authorize API needed
  - Add Unit Test
  - Get more data from github
  - ...
  
