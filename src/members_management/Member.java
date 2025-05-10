package members_management;

import membership_plans.MembershipPlan;
import tainers_management.Trainer;

import java.util.Objects;

public class Member {
    private String Id;
    private String name;
    private int age;
    private String contact;
    private MembershipPlan plan;
    private Trainer trainer;

    public Member(String id, String name, int age, String contact) {
        Id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public void setPlan(MembershipPlan plan) {
        this.plan = plan;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String memberDetails() {
        return "Member{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                '}';
    }

    public String memberSummary() {
        return "Member{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                ", plan=" + plan +
                ", trainer=" + trainer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(Id, member.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
