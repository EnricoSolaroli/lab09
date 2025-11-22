package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A simple implementation of the {@link Controller} interface.
 * It manages a single string state, maintains a history of printed strings, 
 * and prints the current string to the standard output.
 */
public final class SimpleController implements Controller {

    private String currentString = "";
    private final List<String> historyStrings = new ArrayList<>();

    @Override
    public void setStringToPrint(final String s) {
        this.currentString = Objects.requireNonNull(s, "The string cannot be null");
    }

    @Override
    public String getCurrentString() {
        return this.currentString;
    }

    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(this.historyStrings);
    }

    @Override
    public void printCurrentString() {
        if (this.currentString.isEmpty()) {
            throw new IllegalStateException("Cannot print: the string is null");
        }
        System.out.println(this.currentString); //NOPMD
        this.historyStrings.add(this.currentString);
    }
}
