 docker images --quiet --filter=dangling=true | xargs docker rmi -f
 
 
 remove all stop containers
 ------------------------
 docker rm $(docker ps -a -q)
 
 
 docker remove all unused images
 ===========
 docker image prune -a
 
 
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=app_user -e MYSQL_PASSWORD=test123 -e MYSQL_DATABASE=projects_api_db -p 3306:3306  -d mysql:5.7

https://cloudnweb.dev/2019/11/how-to-run-mongodb-as-a-docker-container-in-development/

docker run -d -p 27017:27017 -v /Users/chathuranga/Projects:/data/db --name mongodb mongo:4.2.2
