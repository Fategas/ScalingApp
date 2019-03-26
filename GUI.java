import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This class will show a gui and use the existing scaleConverter class
 * to convert scales.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI extends JFrame implements ActionListener
{
    private ScaleConverter converter;
    private JButton bChange;
    private JTextField textforStartingNumber,textforStartingScale,textforWantedScale,textConverted;
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        super("SKALUJ!");
        makeFrame();
        showFrame();

    }

    public void makeFrame()
    {
        setLayout(new FlowLayout());

        bChange = new JButton("Convert");
        bChange.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int startingNumber = textforStartingNumber.getText();
                converter.setStartingNumber(startingNumber);
                int startingScale = textforStartingScale.getText();
                converter.setScaleFrom(startingScale);
                int wantedScale = textforWantedScale.getText();
                converter.setScaleTo(wantedScale);


                textConverted.setText(converter.convert());

            }
        }

        textforStartingNumber = new JTextField(5);
        textforStartingScale = new JTextField(5);
        textforWantedScale = new JTextField(5);
        textConverted = new JTextField(5);

        add(textforStartingNumber);
        add(textforStartingScale);
        add(textforWantedScale);

        add(textConverted);
        add(bChange);
    }

     public void showFrame()
     {
         setSize(200,150);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setVisible(true);
     }
}
