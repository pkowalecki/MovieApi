package pl.kowalecki.movieapi.Service;

import pl.kowalecki.movieapi.Model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();
    boolean getMovieByName(Movie movie, String name);
    boolean addMovie (Movie movie);
    boolean deleteMovie(String name);
    boolean editName(Movie movie, String name);
    boolean editGenre(Movie movie, String name);
}