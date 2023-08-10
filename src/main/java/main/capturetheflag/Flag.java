package main.capturetheflag;

public class Flag {

    private boolean captured = false;

    public Flag () {

    }

    // Check if the flag is already captured
    public boolean isCaptured() {
        return captured;
    }

    // When the flag was brought into the opponents base
    public void capture() {
        captured = true;
    }

    // When the flag was brought back to the base
    public void recapture() {
        captured = false;
    }

}
