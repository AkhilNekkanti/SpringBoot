# SpringBoot

1. Clone the project
3. Install Maven, Docker, Java 17, IntelliJ.
4. Import the project using IntelliJ
5. Build the project 
6. Make sure using JDK 17 otherwise check the same in project structure.
7. Run the project
8. Hit the endpoint to perform the CRUD operations.


Endpoint: http://localhost:8080/api/v1/items

request type- post  endpoint - http://localhost:8080/api/v1/items
Body - {
        "name": "Mobile",
        "category": "Gadget",
        "cost": 1200
       }
     
request type- get  endpoint - http://localhost:8080/api/v1/items
response - [
    {
        "name": "Mobile",
        "category": "Gadget",
        "cost": 1200,
        "id": 1
    }
]

request type- Delete  endpoint - http://localhost:8080/api/v1/items/1


1. Created a table item which contains itemid, name, category and price in Postgresql using Docker.
2. Itemid is the primary key and generated sequentially with allocation size 1.
3. In order to delete an item we need to mention the id in the endpoint.

       

