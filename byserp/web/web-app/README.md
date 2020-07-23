##### Set enviroment variable when run intelijide on "prod" profile

spring.profiles.active=prod;DOMAIN_SERVER=http://123.27.2.59:2003;CLIENT_ID=acme;CLIENT_SECRET=acmesecret;AUTH_SERVER=http://123.27.2.59:2004;LOG_PATH=D:\eoffice\log

java -jar web-app-0.0.1-SNAPSHOT.jar 
\ --spring.profiles.active=prod 
\ --PORT=2003 
\ --DOMAIN_SERVER=http://123.27.2.59:2003
\ --CLIENT_ID=acme 
\ --CLIENT_SECRET=acmesecret 
\ --AUTH_SERVER=http://192.168.2.6:2004 
\ --AUTH_SERVER_PUBLIC=http://123.27.2.59:2004
\ --LOG_PATH=D:\eoffice\log


java -jar web-app-0.0.1-SNAPSHOT.jar --spring.profiles.active=default --PORT=2003 --DOMAIN_SERVER=http://123.27.2.59:2003 --CLIENT_ID=acme --CLIENT_SECRET=acmesecret --AUTH_SERVER=http://192.168.2.6:2004 --AUTH_SERVER_PUBLIC=http://123.27.2.59:2004 --LOG_PATH=D:\eoffice\log