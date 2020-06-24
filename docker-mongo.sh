docker run --name some-mongo -p 27017:27017 -e MONGO_INITDB_DATABASE=testDb  -e  MONGO_INITDB_ROOT_USERNAME=admin  -e  MONGO_INITDB_ROOT_PASSWORD=admin -d mongo:latest
