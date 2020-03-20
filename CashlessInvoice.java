
/**
 * Write a description of class CashlessInvoice here.
 *
 * @author Hary Ridart
 * @version 2020-03-12
 */
import java.util.Calendar;
import java.util.GregorianCalendar; 
import java.util.regex.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.SimpleDateFormat;  
import java.util.Date; 
public class CashlessInvoice extends Invoice
{
    // instance variables - replace the example below with your own
    private final static PaymentType PAYMENT_TYPE = PaymentType.Cashless;
    private Promo promo;

    /**
    * Merupakan constructor dari Class Food untuk membuat Food
    * @param id merupakan id makanan(Food)
    * @param name merupakan nama dari makanan.
    * @param seller merupakan informasi Seller makanan(Food)
    * @param price merupakan harga dari makanan(Food).
    * @param category merupakan kategori makanan(Food).
    * @return Constructor tidak mengembalikan nilai.
    */
    public CashlessInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus)
    {
        // initialise instance variables
        super(id,food,customer,invoiceStatus);
    }
    /**
    * Merupakan method overload dari method ClashlessInvoice 
    * @param id merupakan id Invoice
    * @param date merupakan date dari makanan.
    * @param customerr merupakan customer yang dicatat invoice
    * @param invoiceStatus merupakan status Invoice
    * @param promo merupakan objek promo yang digunakan
    * @return Constructor tidak mengembalikan nilai.
    */
    public CashlessInvoice(int id, Food food, Customer customer,
    InvoiceStatus invoiceStatus, Promo promo)
    {
        // put your code here
        super(id,food,customer,invoiceStatus);
        this.promo = promo;
        
    }
    /**
    * Method ini digunakan untuk mengembalikan nilai PAYMENT_TYPE
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai PAYMENT_TYPE
    */
    public PaymentType getPaymentType()
    {
         return PAYMENT_TYPE;
    }
    /**
    * Method ini digunakan untuk mengembalikan promo
    * @param Tidak ada parameter yang digunakan pada method ini.
    * @return Method ini mengembalikan nilai promo
    */
    public Promo getPromo()
    {
        return promo;
    }
    /**
    * Method ini digunakan untuk menetapkan promo
    * @param parameter promo
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setPromo (Promo promo)
    {
        this.promo = promo;
    }
    /**
    * Method ini digunakan untuk menetapkan nilai dengan ketentuan tertentu
    * @param tidak ada parameter yang digunakan
    * @return Method ini tidak mengembalikan nilai.
    */
    public void setTotalPrice()
    {
        if(promo != null && promo.getActive() == true && 
        getFood().getPrice() >= promo.getMinPrice())
        {
             
            super.totalPrice = getFood().getPrice() - getPromo().getDiscount();
        }
        else
        {
            super.totalPrice = getFood().getPrice();
        }
    }
    /**
    * Method ini digunakan untuk mencetak data CashlessInvoice
    * @param tidak ada parameter yang digunakan
    * @return Method ini tidak mengembalikan nilai.
    */
    @Override
    public String toString()
    {
        return "=========INVOICE========="+
            "ID: " + getId() +
            "Date: " + super.getFood().getName()+
            "Customer: "+ super.getCustomer().getName()+
            "Total Price: " + getTotalPrice()  +
            "Status: " + getInvoiceStatus()+
            "Payment: " +  getPaymentType();
    }
}
