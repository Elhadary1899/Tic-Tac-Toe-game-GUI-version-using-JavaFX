package org.example.test;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface Checkable {

    public abstract char XorO();
    public abstract void setAlert();
    public abstract boolean detectWinner();
    public abstract void changeToWinner(ActionEvent event) throws IOException;

}
