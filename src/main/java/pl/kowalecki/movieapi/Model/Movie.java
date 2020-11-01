package pl.kowalecki.movieapi.Model;

import javax.persistence.Id;

public class Movie {

    @Id
    int movie_id;
    String movie_name;
    String movie_genre;

    public Movie() {
    }

    public Movie(int movie_id, String movie_name, String movie_genre) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_genre = movie_genre;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", movie_name='" + movie_name + '\'' +
                ", movie_genre='" + movie_genre + '\'' +
                '}';
    }
}


