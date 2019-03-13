# Toki Games Flights API
Flight aggregator API to search over available flights. 
There are two available flight’s providers:
- https://obscure-caverns-79008.herokuapp.com/cheap 
- https://obscure-caverns-79008.herokuapp.com/business

## How to run application

- Go to project path in terminal
- Type `./gradlew bootRun`

### Get all flights
```sh
/api/flights
```
## Tech
The API is build using Java and Spring boot.
### Local Installation
#### Prerequisites:
- JDK 8
- Apache Maven

#### Start using API
https://localhost:8080/api/flights

## Filtering - Request
 
To filter returned fields, you can add "fields" as request parameter as shown below.
 
 `GET /api/flights?fields=type,departureTime`
 
## Pagination - Request
 
Pagination is implemented as default feature. All you need to do set "page" or/and "per_page" request parameters to get how much you want.
 
 `GET /api/flights?page=1&per_page=5`
  
## Sorting - Request
 
Sorting is implemented for departureTime and arrivalTime. You need to set "sort" request parameter to have sorted data.
 
 `GET /api/flights?sort=departureTime`  
 
Note: 8080 is the default port.
