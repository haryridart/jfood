package haryridart.jfood;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This FoodNotFoundException Class is used to handle error input if food not found
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class FoodNotFoundException extends Exception
{
    private int food_error;
    /**
     * This is constructor for object of class FoodNotFoundException
     * <p>
     * Updates or changes value of food_error when create objects
     * @param food_input - first parameter value of constructor
     */
    public FoodNotFoundException(int food_input) {
        super("Food ID : ");
        this.food_error=food_input;
    }
    /**
     * This is getMesage method that is used to print error message
     * @return about error message
     */
    public String getExMessage()
    {
        return super.getMessage() + food_error + " not found.";
    }
}
