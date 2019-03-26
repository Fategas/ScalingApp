import java.util.Scanner;

/**
 * This class will calculate how long something
 * done in 1 scale will be in another scale.
 *
 * @author Dawid Michniuk
 * @version 0.01a
 */
public class ScaleConverter
{
    private Scanner keyboard;
    private double startingNumber,convertedNumber;
    private int scaleFrom,scaleTo;
    public ScaleConverter()
    {
        startingNumber=0;
        convertedNumber=0;
        scaleFrom=0;
        scaleTo=0;
        keyboard = new Scanner(System.in);
    }

    public void setScaleFrom(int scaleFrom)
    {
        try
        {
            this.scaleFrom = scaleFrom;
        }
        catch(Exception e)
        {
            System.out.println("Numer podaj pajacu!");
        }
    }
    public void setScaleTo(int scaleTo)
    {
        try
        {
            this.scaleTo = scaleTo;
        }
        catch(Exception e)
        {
            System.out.println("Numer podaj pajacu!");
        }
    }
    public void setStartingNumber(int startingNumber)
    {
        try
        {
            this.startingNumber = startingNumber;
        }
        catch(Exception e)
        {
            System.out.println("Numer podaj pajacu!");
        }
    }
    public void setConvertedNumber(int convertedNumber)
    {
        try
        {
            this.convertedNumber = convertedNumber;
        }
        catch(Exception e)
        {
            System.out.println("Numer podaj pajacu!");
        }
    }

    public void convert()
    {
            convertedNumber = (startingNumber * scaleFrom) / scaleTo;
            System.out.println(startingNumber + " przemienione to: " + convertedNumber + "." );
    }
}
