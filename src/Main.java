import members_management.MemberService;
import membership_plans.MembershipPlan;
import membership_plans.MembershipService;
import membership_plans.MembershipType;
import tainers_management.Trainer;
import tainers_management.TrainerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        consoleUI(sc);
    }

    public static void consoleUI(Scanner sc){
        boolean run=true;
        while(run){
            System.out.println("==== Gym management system");
            System.out.print("1. Manage members\n" +
                    "2. Manage trainers\n" +
                    "3. Manage membership plans\n" +
                    "4. Assign members to trainers\n" +
                    "5. View reports\n" +
                    "6. Save and exit\n" +
                    "\nEnter choice[1-6]: ");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    memberManagementActions(sc);
                    break;
                case 2:
                    trainerManagementActions(sc);
                    break;
                case 3:
                    planManagementActions(sc);
                    break;
                case 4:
                    TrainerService.assignMemberToTrainer(sc);
                    break;
                case 5:
                    System.out.println("In development");
                    break;
                case 6:
                    System.out.println("Thank you for using the system.");
                    run=false;
                    break;
                default:
                    System.out.println("No valid choice was made.");
                    break;
            }
        }
    }

    public static void memberManagementActions(Scanner sc){
        boolean train=true;
        while(train){
            System.out.println("==== Manage member ====");
            System.out.println("1. Add member");
            System.out.println("2. Update member");
            System.out.println("3. Delete member");
            System.out.println("4. View member");
            System.out.println("5. Exit");
            System.out.print("Choose action[1-4]: ");
            int action=sc.nextInt();
            switch (action){
                case 1:
                    MemberService.addMember(sc);
                    break;
                case 2:
                    MemberService.updateMember(sc);
                    break;
                case 3:
                    MemberService.deleteMember(sc);
                    break;
                case 4:
                    System.out.println("Members:\n"+MemberService.viewMembers());
                    break;
                case 5:
                    train=false;
                    break;
                default:
                    System.out.print("No valid action was taken.");
                    break;
            }
        }
    }

    public static void trainerManagementActions(Scanner sc){
        boolean train=true;
        while(train){
            System.out.println("==== Manage Trainers ====");
            System.out.println("1. Add trainer");
            System.out.println("2. Update trainer");
            System.out.println("3. Delete trainer");
            System.out.println("4. Exit");
            System.out.print("Choose action[1-4]: ");
            int action=sc.nextInt();
            switch (action){
                case 1:
                    TrainerService.createTrainer(sc);
                    break;
                case 2:
                    TrainerService.updateTrainer(sc);
                    break;
                case 3:
                    TrainerService.deleteTrainer(sc);
                    break;
                case 4:
                    train=false;
                    break;
                default:
                    System.out.print("No valid action was taken.");
                    break;
            }
        }
    }

    public static void planManagementActions(Scanner sc){
        boolean train=true;
        while(train){
            System.out.println("==== Manage plans ====");
            System.out.println("1. Assign plan to member");
            System.out.println("2. Display plan details");
            System.out.println("3. Exit");
            System.out.print("Choose action[1-3]: ");
            int action=sc.nextInt();
            switch (action){
                case 1:
                    MembershipService.assignMemberToPlan(sc);
                    break;
                case 2:
                    MembershipService.displayPlanDetails(sc);
                    break;
                case 3:
                    System.out.println("Completed");
                    train=false;
                    break;
                default:
                    System.out.print("No valid action was taken.");
                    break;
            }
        }
    }

}