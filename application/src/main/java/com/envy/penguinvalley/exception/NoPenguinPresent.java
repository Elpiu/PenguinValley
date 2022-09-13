package com.envy.penguinvalley.exception;

public class NoPenguinPresent extends Exception {

    public NoPenguinPresent(String message) {
        super("Nessun pinguino trovato!");
    }

    public NoPenguinPresent() {
        super("Nessun pinguino trovato!");
    }

}
