package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class will show a Graphical interface and use the existing ScaleConverter class
 * to convert scales.
 * Users will be able to chose the initial number, the original scale
 * and the scale they want to have this number converted into.
 * It should display a textarea that will show the converted number after clicking submit.
 *
 * TODO: bug fixes.
 * change layout around to make it more plesant to read
 *
 * @author Dawid Michniuk
 * @version 1.15
 */
public class GUI extends JFrame
{
    //initialize variables
    private JTextField textforStartingNumber,textforStartingScale,textforWantedScale,textConverted;
    private JButton bChange;
    private int startingScale,wantedScale;
    private double startingNumber;
    /**
     * Calls JFrame's constructor which allows us to set the window's name.
     * it then makes the frame and shows it to the user using an appropriate method.
     */
    public GUI()
    {
        //window label
        super("SCALE!");
        makeFrame();
        showFrame();
        JOptionPane.showMessageDialog(new JFrame(),
                "First textarea is for the diameter.\nSecond Textarea is the starting scale.\n"
                + "Third one is the scale you want to convert your and the last one is the result.");
    }
    /**
    * When the button is pressed, it should getText (numbers in this case) inside every textarea,
    * use ScaleConverter's appropriate method to set and then convert to set scale
    * and set this as a text in textConverted textarea (which I somehow will disable as area user can type in)
    *
    * Textareas are set to width of 5 and then added to the container, so is the bChange (buttonChange).
    */
    private void makeFrame()
    {
        setLayout(new FlowLayout());

        textforStartingNumber = new JTextField(5);
        textforStartingScale = new JTextField(5);
        textforWantedScale = new JTextField(5);
        
        textConverted = new JTextField(5);
        textConverted.setEditable(false);
        JScrollPane scrollArea = new JScrollPane(textConverted);

        bChange = new JButton("Convert");
        //when button is pressed to this:
        bChange.addActionListener((ActionEvent e) -> {
            //save text from textform
            try {
                double startingNumber1 = Double.parseDouble(textforStartingNumber.getText());
                int startingScale1 = Integer.parseInt(textforStartingScale.getText());
                int wantedScale1 = Integer.parseInt(textforWantedScale.getText());
                if (startingNumber1 > 0 && startingScale1 > 0 && wantedScale1 > 0) {
                    double convertedNumber = (startingNumber1 * startingScale1) / wantedScale1;
                    textConverted.setText( "" + convertedNumber);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "At least one input is empty or zet to zero or below that!");
                }
            }catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(new JFrame(), "You didn't add something!");
            }
        });

        add(textforStartingNumber);
        add(textforStartingScale);
        add(textforWantedScale);

        add(bChange);
        add(scrollArea);

    }
    /**
    * Simply sets the size of the window, what it should do when users clicks close
    * (By default it would run in the background, this forces it to actually close the program)
    * Location will be the center of the screen, and only then it will become visible to the user.
    */
     private void showFrame()
     {
         setSize(400,90);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setVisible(true);
     }
}
