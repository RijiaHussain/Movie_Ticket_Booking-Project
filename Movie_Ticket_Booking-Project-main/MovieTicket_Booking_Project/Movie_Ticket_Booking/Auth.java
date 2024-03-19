package Movie_Ticket_Booking;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class Auth {
    Database db = new Database();
    private String currentUser;
    Scanner sc = IO.sc;
    public String getCurrentUser() {
        return currentUser;
    }

    // Frontend page data
    public void promtAuth() {
        {
            System.out.println(".........Wellcome to our online Movie Ticket Booking Portal........");
            System.out.println("Create your login profile to book your seat");
            System.out.println("1. Login       2. Sign up");
            int ls = Integer.parseInt(sc.nextLine());
            if (ls == 2) {
                signupForm();
            } else if (ls == 1) {
                loginForm();
            }
        }
    }

    // Login form
    public void loginForm() {
        System.out.println("Enter your email");
        String cureentmail = sc.nextLine();
        System.out.println("Enter your password");
        String currentpassword = sc.nextLine();
        String inputHashpassword = this.getHashpassword(currentpassword);
        String getOriginalUser = db.getOriginalUser(cureentmail, inputHashpassword);

        if (cureentmail.equals(getOriginalUser)) {

            System.out.println(".Login Sucessful.");
            this.currentUser = getOriginalUser;
        } else {
            System.out.println("Login failed\n invalid email or password");

        }

    }

    // Inputs for sign up User
    public void signupForm() {
        User user = new User();
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        System.out.println("Enter your email:");
        String email = sc.nextLine();
        System.out.println("Enter your phone:");
        String phone = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        System.out.println("confirm your details/n");
        System.out.println("Name: " + name + "\nPassword: " + password + "\nEmail: " + email + "\nPhone: " + phone);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        System.out.println("Type Y to confirm or type N to not confirm your details(Y/N):");
        String s = sc.nextLine();
        if (s.equalsIgnoreCase("Y")) {
            name = user.getName();
            email = user.getEmail();
            phone = user.getPhone();
            password = this.sethasPassword(password);
            try {

                Database data = new Database();
                BookingSystem booking = new BookingSystem();
                String st = "insert into Userlogindata values('" + name + "','" + email + "','" + phone + "','"
                        + password + "')";
                data.statement.executeUpdate(st);
                data.statement.close();
                data.connection.close();
                System.out.println("--------Wellcome " + name + "--------");
                System.out.println("Your profile created now start your booking");
                booking.promtBooking();
            } catch (SQLException e)

            {
                System.out.println(" Error: An account with email" + email + " is already taken");
            }
        } else {
            System.out.println("You cancelled your profile creation");
        }
    }

    // set hashPassword of sign up user
    public String sethasPassword(String password) {

        try {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(password.getBytes());
            byte[] result = messagedigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {

                sb.append(String.format("%02x", b));
            }
            String p = sb.toString();
            return p;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return null;
    }

    // get hashpasswor of login user
    public String getHashpassword(String currentpassword) {

        try {

            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(currentpassword.getBytes());
            byte[] result = messagedigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : result) {

                sb.append(String.format("%02x", b));
            }
            String p = sb.toString();
            return p;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return null;
    }

}
