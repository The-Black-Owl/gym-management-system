package reports;

import members_management.Member;
import members_management.MemberService;
import membership_plans.MembershipType;
import tainers_management.Trainer;
import tainers_management.TrainerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReportService {
    //list member under each trainer
    public static void membersByTrainer(Scanner sc){
        System.out.println("=== Trainer Report ===");
        System.out.print("Enter trainer ID: ");
        String trainerID=sc.next();
        try{
            Trainer trainer= TrainerService.trainers.get(trainerID);
            System.out.println("=== Trainer members ===\n" +
                    "Trainer ID:"+trainer.getId()+
                    "\nTrainer name: "+trainer.getName()+
                    "\nMembers: \n"+trainer.getMembers());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //list members by membership
    public static List<Member> membersByMembership(Scanner sc){
        System.out.println("=== Members by plan ===");
        System.out.println("1. Month to month");
        System.out.println("2. Two years");
        System.out.println("3. One year");
        System.out.println("4. Day to day");
        System.out.print("Select membership plan [1-4]: ");
        try{
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    return MemberService.membersList.stream()
                            .filter(member ->MembershipType.month_to_month.equals(member.getPlan().getType()))
                            .collect(Collectors.toList());
                case 2:
                    return MemberService.membersList.stream()
                            .filter(member ->MembershipType.two_years.equals(member.getPlan().getType()))
                            .collect(Collectors.toList());
                case 3:
                    return MemberService.membersList.stream()
                            .filter(member ->MembershipType.annual.equals(member.getPlan().getType()))
                            .collect(Collectors.toList());
                case 4:
                    return MemberService.membersList.stream()
                            .filter(member ->MembershipType.pay_per_visit.equals(member.getPlan().getType()))
                            .collect(Collectors.toList());
                default:
                    System.out.print("The plan you have chosen does not exist.");
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
