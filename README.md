# expense-tracker-api




/*** DOCKER COMMANDS ***/

// to download a postgres container
% docker pull postgres

//to run postgresdb on port 5432
% docker container run --name postgresdb -e POSTGRES_PASSWORD=admin -d -p 5432:5432 postgres
//to check running docker containers
% docker container ls

// to copy files to inside docker image postgresdb
% docker cp expensetracker_db.sql postgresdb:/ 

//to execute sql commands on postgresdb
%  docker container exec -it postgresdb psql -U postgres

// for docker terminal 
 % docker container exec -it postgresdb bash
 // to run psql inside docker terminal
 # psql -U postgres --file expensetracker_db.sql
//inside postgresdb commands 
# \connect expensetrackerdb
# select * from et_users;

//Login to save container info 
% docker login



/***** POSTMAN API CALL *****/

POST: http://localhost:8080/api/users/register

BODY: 
  RAW JSON: 
{
    "firstName": "abhilash",
    "lastName": "gd",
    "email": "abhilashgd@abhilashgd.com",
    "password": "test123"
}
