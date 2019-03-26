/**
 * This class will calculate how long something
 * done in 1 scale will be in an another scale.
 *
 * TODO: lambda function for converter to make it faster on multicore PCs, port it to android.
 *
 * @author Dawid Michniuk
 * @version 0.04a
 */
public class ScaleConverter
{
    //initialize variables
    private double startingNumber,convertedNumber;
    private int scaleFrom,scaleTo;

    /**
    * Empty constructor since we don't need to do anything.
    */
    public ScaleConverter()
    {
        //Nothing to set here.
    }

    /**
    * Tries to set the new value, will catch an error (probably if param is not int)
    * @param scaleFrom - the starting scale we want to convert FROM.
    */
    public void setScaleFrom(int scaleFrom)
    {
        try
        {
            this.scaleFrom = scaleFrom;
        }
        catch(Exception e)
        {
            System.out.println("Error!" + e);
        }
    }

    /**
    * Tries to set the new value, will catch an error (probably if param is not int)
    * @param scaleTo - scale we want to convert the number INTO.
    */
    public void setScaleTo(int scaleTo)
    {
        try
        {
            this.scaleTo = scaleTo;
        }
        catch(Exception e)
        {
            System.out.println("Error!" + e);
        }
    }
    /**
    * Tries to set the new value, will catch an error (probably if param is not int)
    * @param startingNumber - the starting number we want to convert to a different scale.
    */
    public void setStartingNumber(int startingNumber)
    {
        try
        {
            this.startingNumber = startingNumber;
        }
        catch(Exception e)
        {
            System.out.println("Error!" + e);
        }
    }

    /**
    * Tries to convert the current value in current scale to a different scale.
    * 1) Set the number to the 1:1 version (what's inside the brackets)
    * 2) Divide it by scaleTo to make in 1:scaleTo.
    * 3) return
    *
    * If at any point it encounters an error, the exception is hanlded by printing text to terminal.
    * @return convertedNumber. -1 if it encounters a problem.
    */
    public double convert()
    {
        try
        {
            convertedNumber = (startingNumber * scaleFrom) / scaleTo;
            return convertedNumber;
        }
        catch(Exception e)
        {
            System.out.println("This will probably print if you set scaleTo to zero!");
            System.out.println("Just for debugging: " + e);
            return -1;
        }
    }
}
