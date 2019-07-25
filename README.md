# Customer XML
Spring Boot Customer Xml - MongoDB

# compile
mvn clean install
mvn clean integration-test

#run
mvn clean spring-boot:run
mongod --dbpath /Users/marcoguastalli/opt/MongoDB/m27data/db
mongod --dbpath /Users/marco27/opt/MongoDB/m27data/db
mongo --host 127.0.0.1:27017
use local
show collections
db.customers.count()
db.customers.find()
use customers

### play
mvn clean spring-boot:run

# swagger
http://localhost:8090/swagger-ui.html

##### POST
curl -X POST --header "Content-Type: application/json" --header "Accept: application/xml" -d "{
  \"age\": 27,
  \"firstname\": \"venti\",
  \"lastname\": \"sette\"
}" "http://localhost:8090/api/customer"

##### GET ALL
curl -X GET --header "Accept: application/xml" "http://localhost:8090/api/customer"
http://localhost:8090/api/customer

##### GET 1
curl -X GET --header "Accept: application/xml" "http://localhost:8090/api/customer/5c867b81b701bb21cb9f891f"
http://localhost:8090/api/customer/5c867b81b701bb21cb9f891f

##### PUT ()
curl -X PUT --header "Content-Type: application/json" --header "Accept: application/xml" -d "{
  \"age\": 43,
  \"firstname\": \"sette\",
  \"lastname\": \"venti\"
}" "http://localhost:8090/api/customer/5c867b27b701bb21cb9f891e"

##### DELETE
curl -X DELETE --header "Accept: */*" "http://localhost:8090/api/customer/5c867b81b701bb21cb9f891f"