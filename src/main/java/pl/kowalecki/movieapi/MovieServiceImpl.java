package pl.kowalecki.movieapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MovieServiceImpl implements MovieService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Movie> getAll() {
        List<Movie> movieList = new ArrayList<>();
        String sql = "SELECT * FROM movies";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(element -> movieList.add(new Movie(
                (Integer) element.get("movie_id"),
                String.valueOf(element.get("movie_name")),
                String.valueOf(element.get("movie_genre"))
        )));
        return movieList;
    }

    @Override
    public boolean addMovie(Movie movie) {
        Movie newMovie = new Movie(movie.getMovie_id(), movie.getMovie_name(), movie.getMovie_genre());
        String sql = "INSERT INTO movies VALUES (?,?,?)";
        jdbcTemplate.update(sql, newMovie.getMovie_id(), newMovie.getMovie_name(), newMovie.getMovie_genre());
        return true;
    }

    @Override
    public boolean deleteMovie(String name) {
        String sql = "DELETE FROM movies WHERE movie_name=?";
        jdbcTemplate.update(sql, name);
        return true;
    }

    @Override
    public boolean editName(Movie movie, String name) {
        Movie newMovie = new Movie(movie.getMovie_id(), movie.getMovie_name(), movie.getMovie_genre());
        String sql = "UPDATE movies SET movie_name=? WHERE movie_name=?";
        this.jdbcTemplate.update(sql, newMovie.getMovie_name(), name);
        return true;

    }

    @Override
    public boolean editGenre(Movie movie, String name) {
        Movie newMovie = new Movie(movie.getMovie_id(), movie.getMovie_name(), movie.getMovie_genre());
        String sql = "UPDATE movies SET movie_genre=? WHERE movie_name=?";
        this.jdbcTemplate.update(sql, newMovie.getMovie_genre(), name);
        return true;
    }
}