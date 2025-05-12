package tainers_management;

import members_management.Member;
import members_management.MemberService;

import java.util.HashMap;
import java.util.Scanner;

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
        if(trainers.containsKey(id)){
            Trainer trainer=trainers.get(id);
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
        }else{
            System.out.println("Trainer does not exist.");
        }
    }

    public static void deleteTrainer(Scanner sc){
        System.out.println("==== Update trainer information ====");
        System.out.print("Enter trainer ID number: ");
        String id=sc.next();
        trainers.remove(id);
        System.out.println("Trainer has been removed.");
    }

    public static void assignMemberToTrainer(Scanner sc){
        System.out.println("==== Assign member to  trainer ====");
        System.out.print("Enter trainer ID number: ");
        String id=sc.next();
        Trainer trainer=trainers.get(id);
        System.out.print("Enter member id: ");
        String memberID=sc.next();
        Member member= MemberService.members.get(memberID);
        member.setTrainer(trainer);
        trainer.addMember(member);
    }
}
