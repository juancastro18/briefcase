For running the application in your local environment you should have the next:
1.Java 1.8.0
2.Internet connection for the DB.
3.Google chrome browser

Run the java application and latter go to meetme folder and open index.html

Technologies:
1.Java
2.Spring
3.JDBC
4.Hibernate
5.Mysql
6.twitter4j
7.JUnit
8.Java Script
9.Jquery
10.Bootstrap

I spend 7 hours in the backend side and 1.5 on the frontend side, I tried to use all the good practice that I know

These are the endpoints:
1.{host}/briefcase/getBriefCase/{id} GET -> get briefcase
2.{host}/briefcase/update POST object:
{
    "id": {id}, // should existing id in the DB
    "pathImage": "",
    "name": "",
    "lastName": "",
    "description": "",
    "userTwitter": ""}
