# Customer XML
Spring Boot Customer Xml

# compile
mvn clean install
mvn clean integration-test

#run
mvn clean spring-boot:run

# swagger
http://localhost:8080/swagger-ui.html

### play
get the Oracle DDBB VirtualBox IP and configure it

##### POST
curl -X POST --header "Content-Type: application/json" --header "Accept: application/xml" -d "{
  \"age\": 27,
  \"firstname\": \"venti\",
  \"lastname\": \"sette\"
}" "http://localhost:8080/api/customer"

##### GET ALL
curl -X GET --header "Accept: application/xml" "http://localhost:8080/api/customer"
http://localhost:8080/api/customer

##### GET 1
curl -X GET --header "Accept: application/xml" "http://localhost:8080/api/customer/1"
http://localhost:8080/api/customer/1

##### PUT ()
curl -X PUT --header "Content-Type: application/json" --header "Accept: application/xml" -d "{
  \"age\": 43,
  \"firstname\": \"sette\",
  \"lastname\": \"venti\"
}" "http://localhost:8080/api/customer/2"

##### DELETE
curl -X DELETE --header "Accept: */*" "http://localhost:8080/api/customer/2"