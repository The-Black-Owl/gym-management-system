package payment_tracking;

import membership_plans.MembershipPlan;
import membership_plans.MembershipType;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Payment {
    private static int serialCounter = 1; // static to keep incrementing across objects
    private final String paymentID;
    private final double amount;
    private final PaymentType paymentType;
    private final LocalDateTime paymentDate;
    private final MembershipType membershipType;

    public Payment( PaymentType paymentType, MembershipType membershipType) {
        this.paymentID = String.format("PAY%04d", serialCounter++);
        this.amount = new MembershipPlan(membershipType).getPrice();
        this.paymentType = paymentType;
        this.paymentDate = LocalDateTime.now();
        this.membershipType = membershipType;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public String paymentSummery() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", amount=" + amount +
                ", paymentType=" + paymentType +
                ", paymentDate=" + paymentDate +
                ", membershipType=" + membershipType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentID, payment.paymentID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(paymentID);
    }
}
