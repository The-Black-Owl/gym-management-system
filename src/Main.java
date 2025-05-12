import members_management.MemberService;
import membership_plans.MembershipService;
import payment_tracking.PaymentManagement;
import reports.ReportService;
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
                    "5. Manage payments\n" +
                    "6. View reports\n" +
                    "7. Save and exit\n" +
                    "\nEnter choice[1-7]: ");
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
                    paymentTracking(sc);
                    break;
                case 5:
                    TrainerService.assignMemberToTrainer(sc);
                    break;
                case 6:
                    reportManagement(sc);
                    break;
                case 7:
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

    public static void paymentTracking(Scanner sc){
        boolean isTrackingPayment=true;
        while(isTrackingPayment){
            System.out.println("==== Track payments ====");
            System.out.println("1. Make payment");
            System.out.println("2. View  payments");
            System.out.println("3. View member payments");
            System.out.println("4. View outstanding payments");
            System.out.println("5. Exit");
            System.out.print("Choose action[1-4]: ");
            int action=sc.nextInt();
            switch (action){
                case 1:
                    PaymentManagement.makePayment(sc);
                    break;
                case 2:
                    PaymentManagement.viewAllPayments();
                    break;
                case 3:
                    PaymentManagement.viewMemberPayments(sc);
                    break;
                case 4:
                    PaymentManagement.viewMembersWhoHaveNotPaid();
                    break;
                case 5:
                    System.out.println("Completed");
                    isTrackingPayment=false;
                    break;
                default:
                    System.out.print("No valid action was taken.");
                    break;
            }
        }
    }

    public static void reportManagement(Scanner sc){
        boolean isViewingReports=true;
        while(isViewingReports){
            System.out.println("==== Track payments ====");
            System.out.println("1. Trainer report");
            System.out.println("2. Members under a plan");
            System.out.println("3. Exit");
            System.out.print("Choose action[1-3]: ");
            int action=sc.nextInt();
            switch (action){
                case 1:
                    ReportService.membersByTrainer(sc);
                    break;
                case 2:
                    ReportService.membersByMembership(sc);
                    break;
                case 3:
                    System.out.println("Completed");
                    isViewingReports=false;
                    break;
                default:
                    System.out.print("No valid action was taken.");
                    break;
            }
        }
    }
}