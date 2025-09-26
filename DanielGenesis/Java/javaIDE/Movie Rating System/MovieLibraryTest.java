import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieLibraryTest {

    @Test
    public void testToGetMovieTitle() {
        Movie movie = new Movie();
        movie.setTitle("Mission Impossible");
        assertEquals("Mission Impossible", movie.getTitle());
    }

    @Test
    public void testToGetRatingForCurrentMovie() {
        Movie movie = new Movie();
        movie.setRating(5);
        assertEquals(5.0, movie.getRating());
    }
}
