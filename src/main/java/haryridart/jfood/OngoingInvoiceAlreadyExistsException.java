package haryridart.jfood;
/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * This OngoingInvoiceAlreadyExistsException Class is used to handle error input
 * if ongoing invoice already exist in database
 * <p>
 * @author Hary Teguh Gurun Gala Ridart
 * @version 2020-06-06
 */
public class OngoingInvoiceAlreadyExistsException extends Exception
{
    private Invoice invoice_error;
    /**
     * This is constructor for object of class OngoingInvoiceAlreadyExistsException
     * <p>
     * Updates or changes value of invoice_error when create objects
     * @param invoice_input - first parameter value of constructor
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input){
        super(" Ongoing Invoice : ");
        this.invoice_error=invoice_input;
    }
    /**
     * This is getMesage method that is used to print error message
     * @return about error message
     */
    public String getExMessage(){
        return super.getMessage() + invoice_error.getFoods()
                + " already Exist and ordered by: " + invoice_error.getCustomer().getName();
    }
}
