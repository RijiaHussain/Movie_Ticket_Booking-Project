package Movie_Ticket_Booking;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingSystem {

    Scanner sc = IO.sc;
    Database db = new Database();

    public void promtBooking() {
        
        System.out.println("\n1. Ongoing Movies  2.To be Released Movies ");
       int m= Integer.parseInt(sc.nextLine());
       if(m==1)
       {Database db = new Database();
        System.out.println("Here is our ongoing Movies:");
        ArrayList<Movie> arr= db.getOngoingMovies();
      
        for( int i=0;i<arr.size();i++)
        {
            System.out.print(i+1+". "+arr.get(i).getMovie()+"\t");
           
        }
        System.out.println("\nChoose your movie by entering these mention numbers:");
        int n = Integer.parseInt(sc.nextLine());
        switch (n) {
            case 1:
                kantaraDetails();
                break;
            case 2:
                brahmastra();
                break;
            case 3:
                blackPanther();
                break;
            case 4:
                blackAdam();
                break;
            default:
                System.out.println("Error Wrong command");
                break;
        }
    }
    else if(m==2){
     Database db = new Database();
     ArrayList<Movie> arr= db.tobeReleased();
     for( int i=0;i<arr.size();i++)
     {
         System.out.print(i+1+". "+arr.get(i).getMovie());
         System.out.print("\tRelease Date: "+arr.get(i).getDate());
         System.out.println("");
        
     }
    }
    else{
     System.out.println(" Wrong input");
    }
      
    }

    private void kantaraDetails() {
        ArrayList<Movie> arr= db.getallMoviedata();
        System.out.println("...Details of this movie...\n");
        System.out.println("Movie - Kantara     Duration-"+arr.get(0).getDuration());
        System.out.println("IMDb-"+arr.get(0).getIMDb()+"\tAmount- "+arr.get(0).getPrice()+" Rs");
        System.out.println("Showtimes- (11.00 AM)  (2.30 PM)  (5.30 PM)\nBuy Tickets- 1.Confirm  2.Main Menu");
        int n = Integer.parseInt(sc.nextLine());
        if (n == 1) {
            kantaraTicket();
        } else if (n == 2) {
            promtBooking();
        } else {
            System.out.println("Error enter wrong input");
        }
        // sc.close();
    }

    private void kantaraTicket() {
        
        ArrayList<Movie> arr= db.getallMoviedata();
        int  price = Integer.parseInt( arr.get(0).getPrice());
        System.out.println("Enter seat numbers");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Your total amount is:" +n*price);
        System.out.println(" Confrim - 1     Cancel -2  ");
        int con = Integer.parseInt(sc.nextLine());
        if (con == 1) {
            System.out.println("Movie: Kanatara   Duration:"+arr.get(0).getDuration()+"");
            System.out.println("Date:" + java.time.LocalDate.now());
        } else if (con == 2) {
            System.out.println("You canceled your booking ");
        }
        // sc.close();
    }

    private void brahmastra() {

        System.out.println("...Details of this movie...\n");
        ArrayList<Movie> arr= db.getallMoviedata();
        System.out.println("...Details of this movie...\n");
        System.out.println("Movie - Brahmastra     Duration-"+arr.get(1).getDuration());
        System.out.println("IMDb-"+arr.get(1).getIMDb()+"\tAmount- "+arr.get(1).getPrice()+" Rs");
        System.out.println("Showtimes- (11.00 AM)  (2.30 PM)  (5.30 PM)\nBuy Tickets- 1.Confirm  2.Main Menu");
    int n = Integer.parseInt(sc.nextLine());
        if (n == 1) {
            brahmastraTicket();
        } else if (n == 2) {
            promtBooking();
        } else {
            System.out.println("Error enter wrong input");
        }
        // sc.close();
    }

    private void brahmastraTicket() {
        ArrayList<Movie> arr= db.getallMoviedata();
        int  price = Integer.parseInt( arr.get(1).getPrice());
        System.out.println("Enter seat numbers");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Your total amount is:" + n * price);
        System.out.println(" Confrim - 1     Cancel -2  ");
        int con = Integer.parseInt(sc.nextLine());
        if (con == 1) {
            System.out.println("Movie: Brahmastra   Duration:"+arr.get(1).getDuration()+"");
            System.out.println("Date:" + java.time.LocalDate.now());
        } else if (con == 2) {
            System.out.println("You canceled your booking ");
        }
        // sc.close();

    }

    private void blackPanther() {
        System.out.println("...Details of this movie...\n");
        ArrayList<Movie> arr= db.getallMoviedata();
        System.out.println("...Details of this movie...\n");
        System.out.println("Movie - Black Panther-Wakanda Forever     Duration-"+arr.get(2).getDuration());
        System.out.println("IMDb-"+arr.get(2).getIMDb()+   "\tAmount- "+arr.get(2).getPrice()+" Rs");
        System.out.println("Showtimes- (11.00 AM)  (2.30 PM)  (5.30 PM)\nBuy Tickets- 1.Confirm  2.Main Menu");
         int n = Integer.parseInt(sc.nextLine());
        if (n == 1) {
            blackPantherTicket();
        } else if (n == 2) {
            promtBooking();
        } else {
            System.out.println("Error enter wrong input");
        }
        // sc.close();
    }

    private void blackPantherTicket() {
        ArrayList<Movie> arr= db.getallMoviedata();
        int  price = Integer.parseInt( arr.get(2).getPrice());
        System.out.println("Enter seat numbers");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Your total amount is:" + n * price);
         System.out.println(" Confrim - 1     Cancel -2  ");
        int con = Integer.parseInt(sc.nextLine());
        if (con == 1) {
            System.out.println("Movie: Black Panther-Wakanda Forever 2   Duration:"+arr.get(2).getDuration()+"");
            System.out.println("Date:" + java.time.LocalDate.now());
        } else if (con == 2) {
            System.out.println("You canceled your booking ");
        }
        // sc.close();
    }

    private void blackAdam() {

        System.out.println("...Details of this movie...\n");
        ArrayList<Movie> arr= db.getallMoviedata();
        System.out.println("...Details of this movie...\n");
        System.out.println("Movie - Black Adam     Duration-"+arr.get(3).getDuration());
        System.out.println("IMDb-"+arr.get(3).getIMDb()+"\tAmount- "+arr.get(3).getPrice()+" Rs");
        System.out.println("Showtimes- (11.00 AM)  (2.30 PM)  (5.30 PM)\nBuy Tickets- 1.Confirm  2.Main Menu");
          int n = Integer.parseInt(sc.nextLine());
        if (n == 1) {
            blackAdamTicket();
        } else if (n == 2) {
            promtBooking();
        } else {
            System.out.println("Error enter wrong input");
        }
        // sc.close();
    }

    private void blackAdamTicket() {
        ArrayList<Movie> arr= db.getallMoviedata();
        int  price = Integer.parseInt( arr.get(3).getPrice());
        System.out.println("Enter seat numbers");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Your total amount is:" + n * price);
          System.out.println(" Confrim - 1     Cancel -2  ");
        int con = Integer.parseInt(sc.nextLine());
        if (con == 1) {
            System.out.println("Movie: Black Adam   Duration:"+arr.get(3).getDuration()+"");
            System.out.println("Date:" + java.time.LocalDate.now());
        } else if (con == 2) {
            System.out.println("You canceled your booking ");
        }
        // sc.close();
    }

}
