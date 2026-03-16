eureka:
  client:
    register-with-eureka: true
    fetchRegistry: true
    serviceUrl:
      defaultZone: http://localhost:8700/eureka
  instance:
    hostname: localhost
    
server:
  port: 8092
  
spring:
  application:
    name: CS01-BookService