package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My first java graphical interface";
    private static final int PROPORTION = 5;
    private final Controller controller = new Controller();

    private final JFrame frame = new JFrame(TITLE);

    /**
     * Creates a new SimpleGUI.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField(controller.getPath());
        textField.setEditable(false);
        canvas.add(textField, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse");
        canvas.add(browse, BorderLayout.LINE_END);
        panel.add(canvas, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        final JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("save");
        panel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * Handlers
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ingored) {
                try {
                    controller.saveString(textArea.getText());
                } catch (final IOException e) {
                   JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
        });

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ingored) {
                final JFileChooser fileChooser = new JFileChooser();
                final int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getPath());
                } else if (result == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, "error while selecting file");
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored.
     */
    public static void main(final String... args) {
       new SimpleGUIWithFileChooser().display();
    }

}
