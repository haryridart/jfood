/**
 * <h1>Food Order App with Object Oriented Programming<h1>
 * CashInvoice Class digunakan untuk processing invoice data jika custonmer menggunakan cash untuk pembayra
 * CashInvoice merupakan subclass dari Invoice Class
 * @author Hary Ridart
 * @version 2020-03-12
 */
package haryridart.jfood;
import java.util.*;
import java.text.SimpleDateFormat;
public class CashInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private static PaymentType PAYMENT_TYPE = PaymentType.Cash;
    private int deliveryFee;

    /**
     * Merupakan constructor dari Class Food untuk membuat Food
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer)
    {
        // initialise instance variables
        super(id,foods,customer);
        setTotalPrice();

    }
    /**
     * Merupakan method overload dari method ClashlessInvoice
     */
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee)
    {

        super(id,foods,customer);
        this.deliveryFee = deliveryFee;
        setTotalPrice();

    }
    public CashInvoice(int id, ArrayList<Food> foods, Customer customer, int deliveryFee, InvoiceStatus invoiceStatus, Date date, int totalPrice)
    {
        // initialise instance variables
        super (id, foods, customer, invoiceStatus, date, totalPrice);
        this.deliveryFee = deliveryFee;
    }
    /**
     * Method ini digunakan untuk mengembalikan nilai PAYMENT_TYPE
     * @return Method ini mengembalikan nilai PAYMENT_TYPE
     */
    public PaymentType getPaymentType() {
        return PAYMENT_TYPE;
    }
    /**
     * Method ini digunakan untuk mengembalikan promo
     * @return Method ini mengembalikan nilai promo
     */
    public int getDeliveryFee()
    {
        return deliveryFee;
    }
    /**
     * Method ini digunakan untuk menetapkan promo
     * @return Method ini tidak mengembalikan nilai.
     */
    public void setDeliveryFee (int deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }
    /**
     * Method ini digunakan untuk menetapkan nilai dengan ketentuan tertentu
     * @return Method ini tidak mengembalikan nilai.
     */
    public void setTotalPrice() {
        int totalFoodPrice = 0;
        for (int i = 0; i < getFoods().size(); i++) {
            totalFoodPrice = totalFoodPrice + getFoods().get(i).getPrice();
        }
        if (deliveryFee != -1) {
            super.totalPrice = totalFoodPrice + deliveryFee;
        } else {
            super.totalPrice = totalFoodPrice;
        }
    }
    /**
     * Method ini digunakan untuk mencetak data CashlessInvoice
     * @return Method ini tidak mengembalikan nilai.
     */

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String foods = "";
        for(Food foodList : getFoods())
        {
            foods = foods + foodList.getName() + ", ";
        }
        foods = foods.substring(0, foods.length() - 2);

        return "============INVOICE CASH============"+
                "\nID :" + super.getId()+
                "\nFoods :"  + foods+
                "\nDate :" + sdf.format(super.getDate().getTime())+
                "\nCustomer :" + super.getCustomer().getName()+
                "\nDelivery Fee :" + getDeliveryFee()+
                "\nTotal price :" + totalPrice+
                "\nStatus :" + super.getInvoiceStatus()+
                "\nPayment Type :" + getPaymentType();
    }
}

