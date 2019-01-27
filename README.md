# spring-cloud-starter
This is a demo project to demonstrate how we can develop microservices using Spring Cloud. Here some of the useful services are implemented by Spring cloud, we have just created one small project for each of them to utilize their benefits. 
* Eureka server is used for discovery and service registry. 
* Config server is used for central configuration server. 
* Zipkin server along with Sleuth is used for distributed tracing of cross-service invocations. 
* Zuul Proxy  is used as API Gateway.

We have implemented three very small microservices by ourselves. 
* Animal service in intended to provide information for a bunch of animals. 
* Bird service will provide information for a bunch of birds. 
* Jungle service will call those two services and provide some combined result. 

### How to Run
At first build all the modules. From the root of the project, execute the following command:

`$ mvn clean install`

We can deploy and start all the modules in docker by using the following command:

`$ docker-compose up --build --force-recreate`
