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

### .../movieapi/Api/MovieApi.java<br>
[getAll()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java#L24) 
<br>Metoda dzięki której zwracamy listę wszystkich filmów z bazy danych<br>
[getMovie()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java#L33)
<br>Metoda która jako parametr przyjmuje "name" podany w URL'u i zwraca informacje o filmie<br>
[addMovie()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java#L43)
<br>Metoda która jako parametr przyjmuje BODY w postaci movie_name oraz movie_genre. Służy dodawaniu filmu do bazy danych.<br>
[deleteMovie()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java#L52)
<br>Metoda, która jako parametr przyjmuje "name" czyli nazwę filmu. Słuzy do usunięcia danych o filmie z bazy. W URL<br>
[editMovie()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java#L61)
<br>Metoda, która jako parametr przyjmuje "name" podany w URL, oraz BODY w postaci movie_name. Służy edycji nazwy filmu.<br>
[editGenre()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Api/MovieApi.java#L70)
<br>Metoda, która jako parametr przyjmuje "name" podany w URL, oraz BODY w postaci movie_genre. Służy edycji gatunku filmu.<br><br>
### .../movieapi/Database/DbConfig.java<br>
<br>[DbConfig()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Database/DbConfig.java#L16)
<br>Metoda, która służy do komunikacji z bazą danych, której specyfikacja znajduję się [tutaj](https://github.com/pkowalecki/MovieApi/blob/main/src/main/resources/application.properties)<br>
[JdbcTemplate()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Database/DbConfig.java#L21)
<br>Metoda, która wykorzystuje API JDBC do wykonywania operacji SQL w moim programie<br>

### .../movieapi/Model/Movie.java
<br>[Model](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Model/Movie.java) całej aplikacji wraz z getterami i setterami<br>

### .../movieapi/Service/MovieService.java
<br>[Interfejs](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieService.java), który komunikuje MovieAPI z MobieServiceImpl<br>
### .../movieapi/Api/MovieServiceImpl.java
<br>[Klasa](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieServiceImpl.java), która implementuje MovieService. W konstruktorze odwołujemy się do JdbcTemplate, które pozwala Nam na zapytania SQL<br>
<br>[getAll()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieServiceImpl.java#L24)<br> Metoda, która w rezultacie zwraca listę wszystkich elementów w bazie danych.
<br>Korzystam z zapytania SQL<br>
```
String sql = "SELECT * FROM movies";
```
<br>

[getMovieByName()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieServiceImpl.java#L37)
<br>Metoda, która przyjmuje parametr name podany w URL. Na jej podstawie wyszukuje film po nazwie.<br>
Korzystam z zapytania SQL<br>
```
 String sql = "SELECT * FROM movies WHERE movie_name=?"; <br>
```
<br>gdzie movie_name=? <- w znaku zapytania znajduje się wpisana wartość 'name'<br>
```
List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, name);
```
<br> Podawana jest nazwa jako drugi parametr w zapytaniu<br><br>
[addMovie()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieServiceImpl.java#L50) <br>
Metoda, która jako parametr przyjmuje cały obiekt Movie. <br>
Dodajemy cały obiekt do bazy danych za pomocą zapytania SQL: <br>
```
 String sql = "INSERT INTO movies VALUES (?,?,?)";
```
<br>gdzie znaki zapytania to parametry zdefiniowane w zapytaniu poniżej<br>
```
jdbcTemplate.update(sql, newMovie.getMovie_id(), newMovie.getMovie_name(), newMovie.getMovie_genre());
```
<br>

[deleteMovie()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieServiceImpl.java#L57)
<br><br>

[editName()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieServiceImpl.java#L65)
<br><br>

[editGenre()](https://github.com/pkowalecki/MovieApi/blob/main/src/main/java/pl/kowalecki/movieapi/Service/MovieServiceImpl.java#L74)
<br><br>
### src/main/resources/application.properties



