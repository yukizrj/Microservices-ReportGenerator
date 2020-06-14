# Microservices-ReportGenerator
simple microservice spring boot projects - api


### Ports

projects include spring cloud config, eureka, zuul api gateway, client, generator(which calls client)

| Project Name | Ports |
| ------ | ------ |
| spring-cloud-server | 8888 |
| eureka-server | 8761 |
| zuul-api-gateway | 8765 |
| transactions-client | 9090 |
| report-generator | 8100 |

### Start Apps Order

 - spring-cloud-server
 - eureka-server
 - zuul-api-gateway
 - transactions-client or report-generator
 
### Useful Urls

check tables [http://localhost:9090/h2-console]

eureka [http://localhost:8761]

actuator [http://localhost:9090/actuator]
