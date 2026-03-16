eureka:
  client:
    register-with-eureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://localhost:8700/eureka
  instance:
    hostname: localhost
    
server:
  port: 8093
  
spring:
  application:
    name: CS02-OrderService