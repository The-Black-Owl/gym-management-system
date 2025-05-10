package membership_plans;

public class MembershipPlan {
    private final MembershipType type;
    private double price;
    private int durationMonths;

    public MembershipPlan(MembershipType type) {
        this.type = type;
        switch(type){
            case annual:
                this.durationMonths=12;
                this.price=300;
                break;
            case two_years:
                this.durationMonths=24;
                this.price=150;
                break;
            case month_to_month:
                this.durationMonths=1;
                this.price=250;
                break;
            case pay_per_visit:
                this.durationMonths=0;
                this.price=50;
                break;
        }
    }

    public MembershipType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public String planSummary() {
        return type + " - " + durationMonths + " month(s), Price: ZAR " + price;
    }

    @Override
    public String toString() {
        return "MembershipPlan{" +
                "type=" + type +
                ", price=" + price +
                ", durationMonths=" + durationMonths +
                '}';
    }
}
