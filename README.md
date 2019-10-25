Magisterka

docker run -ti --rm -p 8080:8080 backend:1.0
/home java -jar backend-docker.jar


docker run -ti -p 8081:8081 --rm frontend:1.0
/home/frontend# node server.js