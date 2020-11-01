# Movie api
Api, które umożliwia dodanie/usunięcie/wyświetlenie/edycję filmu w bazie danych.
Połączenie z bazą danych wykonane zostało poprzez JDBC - Java DataBase Connectivity.
## Operacje na API

**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/allMovies 
![All movies](/img/allMovies.PNG)
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/getMovie/{name}
![Get one movie](/img/getMovie.PNG)
**POST:** https://pkowaleckimoviesapi.herokuapp.com/movie/addMovie 
**JSON STYLE: **
```
{
"movie_name": "Nazwa filmu",
"movie_genre": "Gatunek filmu"
}
```
![Add your movie](/img/addMovie.PNG)
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/deleteMovie/{name}
![Delete movie](/img/deleteMovie.PNG)
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editMovie/{name}
**JSON STYLE: **
```
{
"movie_name": "Zmieniona nazwa filmu",
}
```
![Edit movie](/img/editMovie.PNG)
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editGenre/{name}
**JSON STYLE: **
```
{
"movie_genre": "Zmieniony gatunek filmu",
}
```
![Edit genre](/img/editGenre.PNG)

## Zawartość aplikacji
ResponseEntity - klasa która w odpowiedzi daje status HTTP
Przykład opisany poniżej w POSTMAN zwwróci nam status ***202 ACCEPTED***
przykład:
```
public ResponseEntity<HttpStatus>...(...){
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
}
````

@RequestMapping("/movie") - określa ścieżkę na której dostępna jest cała aplikacja
pkowaleckimoviesapi.herokuapp.com/***movie***/...
@GetMapping("example") - adnotacja, która przyjmuje żądanie GET do aplikacji
@PostMapping("example") - adnotacja, która  która przyjmuje żądanie POST do aplikacji
pkowaleckimoviesapi.herokuapp.com/movie/***example***
@PathVariable  - adnotacja, która bezpośrednio w ścieżce ustawia żądanie
przykład:
pkowaleckimoviesapi.herokuapp.com/movie/***name***
```
@GetMapping("example/{name}")
    public ResponseEntity<List<Movie>> getMovie(@PathVariable String name){...}
```
@RequestBody - adnotacja, którą stosujemy w przypadku przesłania żądania poprzez body.
przykład:
pkowaleckimoviesapi.herokuapp.com/movie/***addMovie***
```
@PostMapping("addMovie")
    public ResponseEntity<HttpStatus> addMovie(@RequestBody Movie addMovie){...}
```
W moim przypadku wysyłam obiekt JSON z wykorzystaniem metody POST:
```
{
"movie_name": "Nazwa filmu",
"movie_genre": "Gatunek filmu"
}
```
Po wysłaniu takiego żądania do mojej bazy danych dodany zostanie film z podanymi wyżej informacjami.

.../movieapi/Api/MovieApi.java
[getAll()](src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java)
getMovie()
addMovie()
deleteMovie()
editMovie()
editGenre()
.../movieapi/Database/DbConfig.java

.../movieapi/Model/Movie.java
--Model całej aplikacji
.../movieapi/Service/MovieService.java

.../movieapi/Api/MovieServiceImpl.java
