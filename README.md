[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-orange.svg)](https://sonarcloud.io/dashboard?id=PrinsVarshney_prime-numbers-api)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=PrinsVarshney_prime-numbers-api&metric=alert_status)](https://sonarcloud.io/dashboard?id=PrinsVarshney_prime-numbers-api) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=PrinsVarshney_prime-numbers-api&metric=coverage)](https://sonarcloud.io/dashboard?id=PrinsVarshney_prime-numbers-api)


# Prime Numbers API

RESTful API providing prime numbers.

The application is deployed on Heroku, and can be accessed as following -

   [Swagger](https://prime-numbers-api-by-prins.herokuapp.com/swagger-prime-numbers.html)

   [Generate prime numbers with Default Algorithm](https://prime-numbers-api-by-prins.herokuapp.com/prime-numbers-api/v1/primes/10)
   
   [Generate prime numbers with Brute Force Algorithm](https://prime-numbers-api-by-prins.herokuapp.com/prime-numbers-api/v1/primes/10?provided-algorithm=brute-force)
   
   [Generate prime numbers with Optimized Brute Force Algorithm](https://prime-numbers-api-by-prins.herokuapp.com/prime-numbers-api/v1/primes/10?provided-algorithm=optimized-brute-force)
   
   [Generate prime numbers with Stream Algorithm](https://prime-numbers-api-by-prins.herokuapp.com/prime-numbers-api/v1/primes/10?provided-algorithm=stream)
   
   [Generate prime numbers with Sieve Of Eratosthenes Algorithm](https://prime-numbers-api-by-prins.herokuapp.com/prime-numbers-api/v1/primes/10?provided-algorithm=sieve-of-eratosthenes)
    

## Prerequisites
- JDK 8 +
- Maven 3.x

## Setup

Clone the repository:
```bash
https://github.com/PrinsVarshney/prime-numbers-api.git
```

Go inside the folder:
```bash
cd prime-numbers-api
```

Run the application:
```bash
mvn clean install spring-boot:run
```

Access Swagger UI:
```bash
http://localhost:8090/swagger-prime-numbers.html
```

## Tests

Generate Prime Numbers:
  (by default it uses Sieve-Of-Eratosthenes Algorithm - this can be changed editing [application.yaml](https://github.com/PrinsVarshney/prime-numbers-api/blob/main/src/main/resources/application.yaml))
```bash
http://localhost:8090/prime-numbers-api/v1/primes/10
```

Generate prime numbers with Brute Force Algorithm:
```bash
http://localhost:8090/prime-numbers-api/v1/primes/10?provided-algorithm=brute-force
```

Similarly other algorithms can be used/switched to, available ones are -
```bash
http://localhost:8090/prime-numbers-api/v1/primes/10?provided-algorithm=brute-force
http://localhost:8090/prime-numbers-api/v1/primes/10?provided-algorithm=optimized-brute-force
http://localhost:8090/prime-numbers-api/v1/primes/10?provided-algorithm=stream
http://localhost:8090/prime-numbers-api/v1/primes/10?provided-algorithm=sieve-of-eratosthenes
```
 
## XML or JSON Reponse

The application provides response in JSON and XML. You can get specific response format setting Accept request header as "application/xml" or "application/json" 

## Performance Tuning

1) Currently the algorithms are limited to a specific number - these are configured in [application.yaml](https://github.com/PrinsVarshney/prime-numbers-api/blob/main/src/main/resources/application.yaml) - and can be tuned based on underlying infrastructure.

2) The application is designed in such a way that new algorithm(s) can be added and configured to make it future ready.



