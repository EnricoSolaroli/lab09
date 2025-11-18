package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAUL_STRING = "output.txt";
    private File currentFile;

    /**
     * constructor of the class.
     *
     */

    public Controller() {
        final String userHome = System.getProperty("user.home");
        final String separetor = System.getProperty("file.separator");
        this.currentFile = new File(userHome + separetor + DEFAUL_STRING);
    }

    /**
     * set a new destination file.
     * 
     * @param file the new file where data will be saved.
     */
    public void setCurrentFile(final File file) {
        if (file == null) {
            throw new IllegalArgumentException("File can't be null");
        } else {
            this.currentFile = file;
        }
    }

    /**
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * @return the path of the current file as a String
     */
    public String getPath() {
        return this.currentFile.getPath();
    }

    /**
     * Saves the content to the current file.
     *
     * @param input the String to save
     * @throws IOException if an I/O error occurs
     */
    public void saveString(final String input) throws IOException {
       try (PrintStream out = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            out.println(input);
       }
    }
}
