package payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Payment{

    
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
        PaymentDAO paymentDAO = new PaymentDAO();
        int choice;

        do {
            System.out.println("Payment Menu:");
            System.out.println("1. Add Payment");
            System.out.println("2. Update Payment");
            System.out.println("3. View Payments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Payment
                    System.out.print("Enter amount: ");
                    BigDecimal amount = scanner.nextBigDecimal();
                    System.out.print("Enter payment method: ");
                    String method = scanner.next();
                    System.out.print("Enter status: ");
                    String status = scanner.next();
                    Payment newPayment = new Payment(0, amount, LocalDateTime.now(), method, status);
                    paymentDAO.insertPayment(newPayment);
                    break;

                case 2:
                    // Update Payment
                    System.out.print("Enter payment ID to update: ");
                    int paymentId = scanner.nextInt();
                    System.out.print("Enter new amount: ");
                    BigDecimal newAmount = scanner.nextBigDecimal();
                    System.out.print("Enter new payment method: ");
                    String newMethod = scanner.next();
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.next();
                    Payment updatedPayment = new Payment(paymentId, newAmount, LocalDateTime.now(), newMethod, newStatus);
                    paymentDAO.updatePayment(updatedPayment);
                    break;

                case 3:
                    // View Payments
                    List<Payment> payments = paymentDAO.viewPayments();
                    for (Payment payment : payments) {
                        System.out.println(payment);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    Payment(int aInt, BigDecimal bigDecimal, LocalDateTime toLocalDateTime, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    BigDecimal getAmount() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    Object getPaymentDate() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    String getPaymentMethod() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    String getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    int getPaymentId() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
  }
 