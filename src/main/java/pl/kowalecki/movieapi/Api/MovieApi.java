package pl.kowalecki.movieapi.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<HttpStatus> getMovie(@PathVariable String name, Movie movie
    ){
        if (movieService.getMovieByName(movie, name)){
            return new ResponseEntity<>(HttpStatus.FOUND);
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