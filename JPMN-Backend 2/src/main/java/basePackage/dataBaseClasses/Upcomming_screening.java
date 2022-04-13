package basePackage.dataBaseClasses;

public class Upcomming_screening {
    private long movie_ID;
    private String title;
    private String studio;
    private String screening_date;
    private String saloon;
    private String avalible_tickets;

    public long getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(long movie_ID) {
        this.movie_ID = movie_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getScreening_date() {
        return screening_date;
    }

    public void setScreening_date(String screening_date) {
        this.screening_date = screening_date;
    }

    public String getSaloon() {
        return saloon;
    }

    public void setSaloon(String saloon) {
        this.saloon = saloon;
    }

    public String getAvalible_tickets() {
        return avalible_tickets;
    }

    public void setAvalible_tickets(String avalible_tickets) {
        this.avalible_tickets = avalible_tickets;
    }

    public Upcomming_screening(long movie_ID, String title, String studio, String screening_date, String saloon, String avalible_tickets) {
        this.movie_ID = movie_ID;
        this.title = title;
        this.studio = studio;
        this.screening_date = screening_date;
        this.saloon = saloon;
        this.avalible_tickets = avalible_tickets;
    }
    
    public Upcomming_screening(String title, String studio, String screening_date, String saloon) {
        this.title = title;
        this.studio = studio;
        this.screening_date = screening_date;
        this.saloon = saloon;
    }

    @Override
    public String toString() {
        return "Upcomming_screening{" +
                "movie_ID=" + movie_ID +
                ", title='" + title + '\'' +
                ", studio='" + studio + '\'' +
                ", screening_date='" + screening_date + '\'' +
                ", saloon='" + saloon + '\'' +
                ", avalible_tickets=" + avalible_tickets +
                '}';
    }
}
