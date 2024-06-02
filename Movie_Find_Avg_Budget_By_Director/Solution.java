import java.util.Scanner;

class Movie {
    private int movieId;
    private String director;
    private int rating;
    private int budget;

    public Movie(int movieId, String director, int rating, int budget) {
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Movie[] movies = new Movie[4];
        for (int i = 0; i < 4; i++) {
            int movieId = Integer.parseInt(scanner.nextLine());
            String director = scanner.nextLine();
            int rating = Integer.parseInt(scanner.nextLine());
            int budget = Integer.parseInt(scanner.nextLine());
            movies[i] = new Movie(movieId, director, rating, budget);
        }

        String director = scanner.nextLine();
        int rating = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        int avgBudget = findAvgBudgetByDirector(movies, director);
        System.out.println(avgBudget > 0 ? avgBudget : "Sorry - The given director has not yet directed any movie");

        Movie movie = getMovieByRatingBudget(movies, rating, budget);
        System.out.println(movie != null ? movie.getMovieId() : "Sorry - No movie is available with the specified rating and budget requirement");

        scanner.close();
    }

    public static int findAvgBudgetByDirector(Movie[] movies, String director) {
        int totalBudget = 0;
        int count = 0;
        for (Movie movie : movies) {
            if (movie.getDirector().equalsIgnoreCase(director)) {
                totalBudget += movie.getBudget();
                count++;
            }
        }
        return count > 0 ? totalBudget / count : 0;
    }

    public static Movie getMovieByRatingBudget(Movie[] movies, int rating, int budget) {
        for (Movie movie : movies) {
            if (movie.getRating() == rating && movie.getBudget() == budget && budget % rating == 0) {
                return movie;
            }
        }
        return null;
    }
}
