package reports;

import members_management.MemberService;
import membership_plans.MembershipType;
import tainers_management.TrainerService;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReportService {
    public static void membersByTrainer(Scanner sc){
        System.out.println("=== Trainer Report ===");
        System.out.print("Enter trainer ID: ");
        String trainerID=sc.next();
        try{
            Optional.ofNullable(TrainerService.trainers.get(trainerID))
                            .ifPresentOrElse(trainer ->
                                        System.out.println("=== Trainer members ===\n" +
                                                "Trainer ID:"+trainer.getId()+
                                                "\nTrainer name: "+trainer.getName()+
                                                "\nMembers: \n"+trainer.getMembers())
                                    ,
                                    ()->System.out.println("Trainer not found."));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void membersByMembership(Scanner sc){
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
                    MemberService.membersList.stream()
                            .filter(member -> MembershipType.month_to_month.equals(member.getPlan().getType()))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;
                case 2:
                    MemberService.membersList.stream()
                            .filter(member -> MembershipType.two_years.equals(member.getPlan().getType()))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);

                    break;
                case 3:
                    MemberService.membersList.stream()
                            .filter(member -> MembershipType.annual.equals(member.getPlan().getType()))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;
                case 4:
                    MemberService.membersList.stream()
                            .filter(member -> MembershipType.pay_per_visit.equals(member.getPlan().getType()))
                            .collect(Collectors.toList())
                            .forEach(System.out::println);

                    break;
                default:
                    System.out.print("The plan you have chosen does not exist.");
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
