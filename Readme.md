# <center>Movie api</center>
Api, które umożliwia dodanie/usunięcie/wyświetlenie/edycję filmu w bazie danych.<br>
## Operacje na API
Endpointy wykorzystywane w aplikacji:<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/allMovies <br>
![All movies](/img/allMovies.PNG)<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/getMovie/{name} <br>
![Get one movie](/img/getMovie.PNG)<br>
**POST:** https://pkowaleckimoviesapi.herokuapp.com/movie/addMovie <br>
![Add your movie](/img/addMovie.PNG)<br>
**JSON STYLE: **<br>
{<br>
"movie_name": "Nazwa filmu",<br>
"movie_genre": "Gatunek filmu"<br>
}<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/deleteMovie/{name} <br>
![Delete movie](/img/deleteMovie.PNG)<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editMovie/{name} <br>
![Edit movie](/img/editMovie.PNG)<br>
**JSON STYLE: **<br>
{<br>
"movie_name": "Zmieniona nazwa filmu",<br>
}<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editGenre/{name} <br>
![Edit genre](/img/editGenre.PNG)<br>
**JSON STYLE: **<br>
{<br>
"movie_genre": "Zmieniony gatunek filmu",<br>
}<br>
