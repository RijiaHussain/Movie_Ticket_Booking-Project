package Movie_Ticket_Booking;


public class Movie {
  
    private String movie;
public String getMovie() {
    return movie;
}
public void setMovie(String movie) {
    this.movie = movie;
}
    private String Price;
    public String getPrice() {
        return Price;
    }
    public void setPrice(String price) {
        Price = price;
    }
    private String Duration;
    public String getDuration() {
        return Duration;
    }
    public void setDuration(String duration) {
        Duration = duration;
    }
    private String IMDb;
    public String getIMDb() {
        return IMDb;
    }
    public void setIMDb(String iMDb) {
        IMDb = iMDb;
    }
    private String screening_Start;
    public String getScreening_Start() {
        return screening_Start;
    }
    public void setScreening_Start(String screening_Start) {
        this.screening_Start = screening_Start;
    }
    private String screening_End;
    
    public String getScreening_End() {
        return screening_End;
    }
    public void setScreening_End(String screening_End) {
        this.screening_End = screening_End;
    }
public Movie(String movie,String Price,String Duration,String IMDb,String screening_Start, String screening_End)
{

  this.movie = movie ;
  this.Price=Price;
  this.Duration=Duration;
  this.IMDb=IMDb;
  this.screening_Start=screening_Start;
  this.screening_End=screening_End;
}
private String Date;


public String getDate() {
    return Date;
}
public void setDate(String date) {
    Date = date;
}
public Movie(String movie) {
    this.movie=movie;

}
public Movie(String movie2, String date) {
    this.movie= movie2;
    this.Date= date;
}





}
