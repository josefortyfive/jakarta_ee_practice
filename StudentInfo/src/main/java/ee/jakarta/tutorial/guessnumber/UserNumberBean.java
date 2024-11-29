package ee.jakarta.tutorial.guessnumber;

import java.io.Serializable;
import java.util.Random;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class UserNumberBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int MINIMUM = 0;
    private static final int MAXIMUM = 10;

    private int randomInt;
    private Integer userNumber;
    private String response;

    @PostConstruct
    public void init() {
        randomInt = new Random().nextInt(MAXIMUM + 1);
        // Print number to server log.
        System.out.println("Duke's number: " + randomInt);
    }

    public void guess() {
        if (userNumber.compareTo(randomInt) != 0) {
            response = "Sorry, " + userNumber + " is incorrect.";
        }
        else {
            response = "Yay! You got it!";
        }
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public String getResponse() {
        return response;
    }

    public int getMinimum() {
        return MINIMUM;
    }

    public int getMaximum() {
        return MAXIMUM;
    }
}