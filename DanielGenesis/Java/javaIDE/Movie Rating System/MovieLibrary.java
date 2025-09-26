import java.util.ArrayList;

public class MovieLibrary {
    Movie movie = new Movie();
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    ArrayList<Movie> movieTitles =  new ArrayList<>();

    public void moviesTitle(String title) {
        movie.setTitle(title);
    }

    public void moviesRating(int rating) {
        movie.setRating(rating);
    }
}
