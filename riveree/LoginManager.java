package riveree;

public class LoginManager {
    private static String loggedInUserEmail; // Store the email of the logged-in user

    public static void setLoggedInUserEmail(String email) {
        loggedInUserEmail = email;
    }

    public static String getLoggedInUserEmail() {
        return loggedInUserEmail;
    }
}
