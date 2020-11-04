package pl.kowalecki.movieapi.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kowalecki.movieapi.Model.Movie;
import pl.kowalecki.movieapi.Service.MovieService;

import java.util.List;

@RequestMapping("/movie")
@RestController
public class MovieApi {

    MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcome(){
        return
       "<html>\n"
       +"<h1>Movie API</h1><br>\n"
       +"Endpointy w API na których można operować:<br>\n"
       +"Aby wysyłać zapytania do aplikacji należu użyć programu do zarządzania API<br><br>\n"
       + "Lista wszystkich filmów: <br>https://pkowaleckimoviesapi.herokuapp.com/movie/allMovies <br><br>\n"
       +"Dane o konkretnym filmie: <br>https://pkowaleckimoviesapi.herokuapp.com/movie/getMovie/nazwaFilmu<br><br>\n"
       +"Dodawanie filmu: <br>https://pkowaleckimoviesapi.herokuapp.com/movie/addMovie<br><br>\n"
       +"Usuwanie filmu: <br>https://pkowaleckimoviesapi.herokuapp.com/movie/deleteMovie/nazwaFilmu<br><br>\n"
       + "Edycja filmu: <br>https://pkowaleckimoviesapi.herokuapp.com/movie/editMovie/nazwaFilmu<br><br>\n"
       +"Edycja gatunku: <br>https://pkowaleckimoviesapi.herokuapp.com/movie/editGenre/nazwaFilmu<br><br>\n"
       +"<html>";
    }
    @GetMapping("allMovies")
    public ResponseEntity<List<Movie>> getAll() {
        if(!movieService.getAll().isEmpty()) {
            return new ResponseEntity<>(movieService.getAll(),HttpStatus.FOUND) ;
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getMovie/{name}")
    public ResponseEntity<List<Movie>> getMovie(@PathVariable String name
    ){
        if (!movieService.getMovieByName(name).isEmpty()){
            return new ResponseEntity<>(movieService.getMovieByName(name),HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("addMovie")
    public ResponseEntity<HttpStatus> addMovie(@RequestBody Movie addMovie){
        if(movieService.addMovie(addMovie)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("deleteMovie/{name}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable String name){
        if(movieService.deleteMovie(name)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("editMovie/{name}")
    public ResponseEntity<HttpStatus> editMovie(@PathVariable String name, @RequestBody Movie movie){
        if(movieService.editName(movie, name)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("editGenre/{name}")
    public ResponseEntity<HttpStatus> editGenre(@PathVariable String name, @RequestBody Movie movie){
        if(movieService.editGenre(movie, name)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
