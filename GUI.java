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
 * @version 0.01a
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
    }
    /**
    * When the button is pressed, it should getText (numbers in this case) inside every textarea,
    * use ScaleConverter's appropriate method to set and then convert to set scale
    * and set this as a text in textConverted textarea (which I somehow will disable as area user can type in)
    *
    * Textareas are set to width of 5 and then added to the container, so is the bChange (buttonChange).
    */
    public void makeFrame()
    {
        setLayout(new FlowLayout());

        textforStartingNumber = new JTextField(5);
        textforStartingScale = new JTextField(5);
        textforWantedScale = new JTextField(5);
        textConverted = new JTextField(5);

        bChange = new JButton("Convert");
        bChange.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                double startingNumber =
                Double.parseDouble(textforStartingNumber.getText());

                int startingScale =
                Integer.parseInt(textforStartingScale.getText());

                int wantedScale =
                Integer.parseInt(textforWantedScale.getText());


                if(startingNumber != 0 && startingScale != 0 && wantedScale != 0)
                {
                    double convertedNumber = (startingNumber*startingScale) / wantedScale;
                    textConverted.setText( "" + convertedNumber);
                }

            }
        });


        add(textforStartingNumber);
        add(textforStartingScale);
        add(textforWantedScale);
        
        add(bChange);
        add(textConverted);
        
    }

    /**
    * Simply sets the size of the window, what it should do when users clicks close
    * (By default it would run in the background, this forces it to actually close the program)
    * Location will be the center of the screen, and only then it will become visible to the user.
    */
     public void showFrame()
     {
         setSize(400,100);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setVisible(true);
     }
}
