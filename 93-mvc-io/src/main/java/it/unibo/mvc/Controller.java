package it.unibo.mvc;

import java.util.List;

/**
 * this Interface must model a simple controller responsible of I/O access. 
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {
    /**
     * Sets the next string to print.
     *
     * @param s the string to set
     * @throws IllegalArgumentException if the provided string is null
     */
    void setStringToPrint(String s);

    /**
     * Gets the next string to print.
     *
     * @return the current string
     */
    String getCurrentString();

    /**
     * Gets the history of printed strings.
     *
     * @return a list of previously printed strings
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     *
     * @throws IllegalStateException if the current string is unset
     */
    void printCurrentString();
}
