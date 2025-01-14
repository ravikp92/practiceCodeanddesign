package src.main.java.com.example.demo.designquestions.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterController {
    static Map<City, List<Theater>> cityVsTheatre;
    static List<Theater> allTheatre;

    TheaterController() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }


    static void addTheatre(Theater theater, City city) {

        allTheatre.add(theater);

        List<Theater> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theater);
        cityVsTheatre.put(city, theatres);
    }


    static Map<Theater, List<Show>> getAllShow(Movie movie, City city) {

        //get all the theater of this city

        Map<Theater, List<Show>> theatreVsShows = new HashMap<>();

        List<Theater> theatres = cityVsTheatre.get(city);

        //filter the theatres which run this movie

        for(Theater theater : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theater.getShows();

            for(Show show : shows) {
                if(show.movie.getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theater, givenMovieShows);
            }
        }

        return theatreVsShows;
    }

}
