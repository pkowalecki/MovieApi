# Movie api
Api, które umożliwia dodanie/usunięcie/wyświetlenie/edycję filmu w bazie danych.<br>
Połączenie z bazą danych wykonane zostało poprzez JDBC - Java DataBase Connectivity.<br>
## Operacje na API

**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/allMovies<br>
![All movies](/img/allMovies.PNG)<br><br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/getMovie/{name}<br>
![Get one movie](/img/getMovie.PNG)<br><br>
**POST:** https://pkowaleckimoviesapi.herokuapp.com/movie/addMovie<br>
**JSON STYLE:**<br>
```
{
"movie_name": "Nazwa filmu",
"movie_genre": "Gatunek filmu"
}
```
![Add your movie](/img/addMovie.PNG)<br><br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/deleteMovie/{name}<br>
![Delete movie](/img/deleteMovie.PNG)<br><br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editMovie/{name}<br>
**JSON STYLE:**
```
{
"movie_name": "Zmieniona nazwa filmu",
}
```
![Edit movie](/img/editMovie.PNG)<br><br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editGenre/{name}<br>
**JSON STYLE:**<br>
```
{
"movie_genre": "Zmieniony gatunek filmu",
}
```

![Edit genre](/img/editGenre.PNG)<br><br>

## Zawartość aplikacji
**ResponseEntity** - klasa która w odpowiedzi daje status HTTP<br>
Przykład opisany poniżej w POSTMAN zwwróci nam status **202 ACCEPTED**<br>
przykład:<br>
```
public ResponseEntity<HttpStatus>...(...){
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
}
```
**@RequestMapping("/movie"**) - określa ścieżkę na której dostępna jest cała aplikacja<br>
pkowaleckimoviesapi.herokuapp.com/**movie**/...<br><br>
**@GetMapping("example")** - adnotacja, która przyjmuje żądanie GET do aplikacji<br><br>
**@PostMapping("example")** - adnotacja, która  która przyjmuje żądanie POST do aplikacji<br>
pkowaleckimoviesapi.herokuapp.com/movie/**example**<br><br>
**@PathVariable**  - adnotacja, która bezpośrednio w ścieżce ustawia żądanie<br>
przykład:<br>
pkowaleckimoviesapi.herokuapp.com/movie/**name**<br>
```
@GetMapping("example/{name}")
    public ResponseEntity<List<Movie>> getMovie(@PathVariable String name){...}
```
<br><br>
**@RequestBody** - adnotacja, którą stosujemy w przypadku przesłania żądania poprzez body.<br>
przykład:<br>
pkowaleckimoviesapi.herokuapp.com/movie/**addMovie**<br>
```
@PostMapping("addMovie")
    public ResponseEntity<HttpStatus> addMovie(@RequestBody Movie addMovie){...}
```
<br>
W moim przypadku wysyłam obiekt JSON z wykorzystaniem metody POST:<br>
```
{
"movie_name": "Nazwa filmu",
"movie_genre": "Gatunek filmu"
}
```
<br>
Po wysłaniu takiego żądania do mojej bazy danych dodany zostanie film z podanymi wyżej informacjami.<br><br>

.../movieapi/Api/MovieApi.java<br>
![getAll()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java#L24) <br>
getMovie()<br>
addMovie()<br>
deleteMovie()<br>
editMovie()<br>
editGenre()<br>
.../movieapi/Database/DbConfig.java<br>
<br>
.../movieapi/Model/Movie.java<br>
--Model całej aplikacji<br>
.../movieapi/Service/MovieService.java<br>
<br>
.../movieapi/Api/MovieServiceImpl.java<br>
<br>
