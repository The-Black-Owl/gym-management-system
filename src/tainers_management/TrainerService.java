package tainers_management;

import members_management.Member;
import members_management.MemberService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrainerService {
    public static final HashMap<String,Trainer> trainers=new HashMap<>();

    public static void createTrainer(Scanner sc){
        System.out.println("==== Add Trainer ====");
        System.out.print("Enter trainer name: ");
        String name=sc.next();
        System.out.print("Enter id number");
        String idnumber=sc.next();
        System.out.print("Enter contact");
        String contact=sc.next();
        Trainer trainer=new Trainer(idnumber,name,contact);
        trainers.put(trainer.getId(),trainer);
        System.out.println("Trainer "+trainer.getName()+" has been added.");
    }

    public static void updateTrainer(Scanner sc){
        System.out.println("==== Update trainer information ====");
        System.out.print("Enter trainer ID number: ");
        String id=sc.next();
        Optional.ofNullable(trainers.get(id)).ifPresentOrElse(trainer->{
            System.out.println("What do you want to update? \n1.Name\n2. Contact Info\n3. Contact & name");
            int parameter=sc.nextInt();
            switch(parameter){
                case 1:
                    System.out.print("Enter name: ");
                    String name= sc.next();
                    trainer.setName(name);
                    System.out.println("Trainer name updated.");
                    break;
                case 2:
                    System.out.print("Enter contact: ");
                    String contact= sc.next();
                    trainer.setName(contact);
                    System.out.println("Trainer contact updated.");
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String name2= sc.next();
                    System.out.print("Enter contact: ");
                    String contact2= sc.next();
                    trainer.setName(contact2);
                    trainer.setName(name2);
                    System.out.println("Trainer name and contact updated.");
                    break;
                default:
                    System.out.println("No valid choice made.");
            }
        },()->{
            System.out.print("The trainer you are looking for does not exist. Do you want to add this trainer?[y/n]");
            String option= sc.next();
            switch (option){
                case "y":
                    createTrainer(sc);
                    break;
                case "n":
                    System.out.println("No update was made");
                    break;
                default:
                    System.out.println("No valid action was taken");
                    break;
            }
        });
    }

    public static void deleteTrainer(Scanner sc){
        System.out.println("==== Update trainer information ====");
        System.out.print("Enter trainer ID number: ");
        String id=sc.next();
        Optional.of(trainers).ifPresentOrElse(trainer -> {
            trainers.remove(id);
            System.out.println("Trainer has been removed.");
        },()->{
            System.out.println("Trainer does not exist");
        });
    }

    public static void assignMemberToTrainer(Scanner sc){
        System.out.println("==== Assign member to  trainer ====");
        System.out.print("Enter trainer ID number: ");
        String id=sc.next();
        Optional.ofNullable(trainers.get(id)).ifPresentOrElse(trainer->{
            System.out.print("Enter member id: ");
            String memberID=sc.next();
            Optional.ofNullable(MemberService.members.get(memberID)).ifPresentOrElse(member -> {
                member.setTrainer(trainer);
                trainer.addMember(member);
            },()->{
                System.out.print("Member ID is invalid, please verify if input is correct");
            });
        },()->{
            System.out.println("Trainer does not exist. Please verify trainer ID is correct");
        });
    }

    public static  List<Trainer> searchTrainerByName(Scanner sc){
        System.out.print("=== Search trainer by name ===\nPlease enter trainer name: ");
        String name=sc.next();
        return trainers.values().stream()
                .filter(trainer -> name.equalsIgnoreCase(trainer.getName()))
                .collect(Collectors.toList());
    }

    public static void deactivateTrainer(Scanner sc){
        System.out.print("=== Deactivate trainer ===\nEnter trainer ID: ");
        String id=sc.next();
        Optional.ofNullable(trainers.get(id)).ifPresentOrElse(trainer->{
            trainer.setActive(false);
        },()->{
            System.out.println("Trainer does not exist");
        });
    }

    public static void activateTrainer(Scanner sc){
        System.out.print("=== Activate trainer ===\nEnter trainer ID: ");
        String id=sc.next();
        Optional.ofNullable(trainers.get(id)).ifPresentOrElse(trainer->{
            trainer.setActive(true);
        },()->{
            System.out.println("Trainer does not exist");
        });
    }

    public static List<Trainer> getAllActiveTrainers(){
        return trainers.values().stream()
                .filter(Trainer::isActive)
                .collect(Collectors.toList());
    }

    public static List<Trainer> getAllInactiveTrainers(){
        return trainers.values().stream()
                .filter(trainer->!trainer.isActive())
                .collect(Collectors.toList());
    }
}
