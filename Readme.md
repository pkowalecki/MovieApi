# <center>Movie api</center>
Api, które umożliwia dodanie/usunięcie/wyświetlenie/edycję filmu w bazie danych.<br>
Endpointy wykorzystywane w aplikacji:<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/allMovies <br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/getMovie/{name} <br>
**POST:** https://pkowaleckimoviesapi.herokuapp.com/movie/addMovie <br>
**JSON STYLE: **<br>
{<br>
"movie_name": "Nazwa filmu",<br>
"movie_genre": "Gatunek filmu"<br>
}<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/deleteMovie/{name} <br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editMovie/{name} <br>
**JSON STYLE: **<br>
{<br>
"movie_name": "Zmieniona nazwa filmu",<br>
}<br>
**GET:** https://pkowaleckimoviesapi.herokuapp.com/movie/editGenre/{name} <br>
**JSON STYLE: **<br>
{<br>
"movie_genre": "Zmieniony gatunek filmu",<br>
}<br>
