abstract class Payment{
    public abstract void processPayment(double amount);
}

class CreditCard extends Payment{
    private String cardNumber;

    public CreditCard(String cardNumber){
        this.cardNumber = cardNumber;
    }

    private boolean validateCard(String cardNumber){
        return cardNumber.matches("\\d{16}");
    }

    public void  processPayment(double amount){
        boolean isValid = validateCard(cardNumber);
        if(isValid){
            System.out.println("Processing credit card payment of $" + amount);
        } else {
            System.out.println("Invalid credit card number.");
        }

    }

}

class UPI extends Payment{
    private String upiId;

    public UPI(String upiId){
        this.upiId = upiId;
    }

    private boolean validateUPI(String upiId){
        return upiId.matches("[a-zA-Z0-9._-]+@[a-zA-Z]+");
    }

    public void processPayment(double amount){
        boolean isValid = validateUPI(upiId);
        if(isValid){
            System.out.println("Processing UPI payment of $" + amount);
        } else {
            System.out.println("Invalid UPI ID.");
        }
    }
}

public class PaymentMethod {
    public static void main(String[] args){
        Payment creditCard = new CreditCard("1234567890123456");
        Payment upi = new UPI("user@bank");
        creditCard.processPayment(100.0);
        upi.processPayment(200.0);
    }
}
