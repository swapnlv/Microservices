Project Description:


------------------------------------------------------------Before Introducing Spring Cloud Dependencies to the Project------------------------------------------------------------------------

-> Created a backend for an E-comm application.
-> The application includes three services
      i) Product-Service
      ii) Order-Service
      iii) Inventory Service
-> Product Service includes following Endpoints and URL Methods:
       i)**POST** ---> http://localhost:8093//api/product - storing product information into database
       ii)**GET** ---> http://localhost:8093//api/product - Getting List of all the product stores inside database
       iii)**GET** ---> http://localhost:8093//api/product/{id} - Getting a specific product stores inside database with 'id' in the path variable
-> Order Service includes following Endpoints and URL Methods:
       i) **POST** ---> http://localhost:8094//api/order - storing order information into database
-> Inventory Service includes following Endpoints and URL Methods:
       i) **GET** ---> http://localhost:8095//api/inventory - Getting information about product if they're in stock or not.
-> Between Order Service and Inventory Service we have implemented Inter Service Communication using WebClient Class of Spring Boot WebFlux Dependency.
-> Order Service calls Inventory Service to check if the product mentioned in the Request Body is of Order Service request is in Stock by Calling the Inventory Service endpoits.
 
       
