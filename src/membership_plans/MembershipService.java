package membership_plans;

import members_management.MemberService;

import java.util.Optional;
import java.util.Scanner;

public class MembershipService {
    public static MembershipPlan choosePlan(Scanner sc){
        System.out.println("==== Gym Memberships ====");
        System.out.println("1. Month to month");
        System.out.println("2. Two years");
        System.out.println("3. One year");
        System.out.println("4. Day to day");
        System.out.print("Select membership plan [1-4]: ");
        try{
            int plan=sc.nextInt();
            switch (plan) {
                case 1:
                    MembershipPlan membershipPlan = new MembershipPlan(MembershipType.month_to_month);
                    System.out.println("The plan you chose: " + membershipPlan.planSummary());
                    return membershipPlan;
                case 2:
                    MembershipPlan membershipPlan2 = new MembershipPlan(MembershipType.two_years);
                    System.out.println("The plan you chose: " + membershipPlan2.planSummary());
                    return membershipPlan2;
                case 3:
                    MembershipPlan membershipPlan3 = new MembershipPlan(MembershipType.annual);
                    System.out.println("The plan you chose: " + membershipPlan3.planSummary());
                    return membershipPlan3;
                case 4:
                    MembershipPlan membershipPlan4 = new MembershipPlan(MembershipType.pay_per_visit);
                    System.out.println("The plan you chose: " + membershipPlan4.planSummary());
                    return membershipPlan4;
                default:
                    System.out.println("No valid plan chosen");
                    break;

            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    public static void assignMemberToPlan(Scanner sc){
        System.out.println("==== Assign membership to plan ===");
        System.out.print("Enter member ID: ");
        try{
            String idNumber = sc.next();
            Optional.ofNullable(MemberService.members.get(idNumber))
                            .ifPresentOrElse(member ->member.setPlan(choosePlan(sc))
                                    ,()->System.out.println("Member not found."));
        }catch (Exception e){
            System.out.println("Invalid input");
        }
    }

    public static void displayPlanDetails(Scanner sc){
        System.out.println("==== Display plan details ===");
        try{
            Optional.ofNullable(choosePlan(sc)).ifPresent(plan -> System.out.print(plan.planSummary()));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
