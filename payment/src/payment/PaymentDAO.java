package payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

class PaymentDAO {
    private static final String DB_URL = "";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";


    void insertPayment(Payment newPayment) {
          String sql = "INSERT INTO Payments (amount, payment_date, payment_method, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
            System.out.println("Payment inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePayment(Payment payment) {
        String sql = "UPDATE Payments SET amount = ?, payment_date = ?, payment_method = ?, status = ? WHERE payment_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setBigDecimal(1, payment.getAmount());
            pstmt.setObject(2, payment.getPaymentDate());
            pstmt.setString(3, payment.getPaymentMethod());
            pstmt.setString(4, payment.getStatus());
            pstmt.setInt(5, payment.getPaymentId());

            pstmt.executeUpdate();
            System.out.println("Payment updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Payment> viewPayments() {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payments";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Payment payment = new Payment(
                        rs.getInt("payment_id"),
                        rs.getBigDecimal("amount"),
                        rs.getTimestamp("payment_date").toLocalDateTime(),
                        rs.getString("payment_method"),
                        rs.getString("status")
                );
                payments.add(payment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
