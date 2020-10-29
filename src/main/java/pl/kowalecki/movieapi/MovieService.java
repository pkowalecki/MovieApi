package pl.kowalecki.movieapi;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();
    boolean addMovie (Movie movie);
    boolean deleteMovie(String name);
    boolean editName(Movie movie, String name);
    boolean editGenre(Movie movie, String name);
}