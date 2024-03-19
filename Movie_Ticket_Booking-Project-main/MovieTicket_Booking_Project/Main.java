import Movie_Ticket_Booking.Auth;
import Movie_Ticket_Booking.BookingSystem;
import Movie_Ticket_Booking.Database;

public class Main {
     public static void main(String[] args) {
          Auth auth = new Auth();
          auth.promtAuth();

          if (auth.getCurrentUser() != null) {
               Database db = new Database();
               String name = db.getUserName(auth.getCurrentUser());
               BookingSystem booking = new BookingSystem();
               System.out.print("<<<<< Wellcome "+name+" >>>>>");
               booking.promtBooking();

          }
     }

}
