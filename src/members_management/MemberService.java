package members_management;

import tainers_management.Trainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MemberService {
    public static List<Member> membersList=new ArrayList<>();
    public static HashMap<String,Member> members=new HashMap<>();

    public static void addMember(Scanner sc){
        System.out.println("=== Add member ====");
        System.out.print("Enter member name: ");
        String name= sc.next();
        System.out.print("Enter member age: ");
        int age=sc.nextInt();
        System.out.print("Enter member national ID: ");
        String idNumber= sc.next();
        System.out.print("Enter member contact: ");
        String contact=sc.next();
        Member member=new Member(idNumber,name,age,contact);
        System.out.println("New member has been added:\n"+member.memberDetails());
    }

    public static void viewMemberSummary(Scanner sc){
        System.out.print("Enter member ID: ");
        String idNumber=sc.next();
        System.out.println("=== Member complete details ===");
        if(members.containsKey(idNumber)){
            members.get(idNumber).memberSummary();
        }else{
            System.out.println("Member does not exist.");
        }

    }

    public static void updateMember(Scanner sc){
        System.out.println("==== Update member details ====");
        System.out.print("Enter member id: ");
        String id=sc.next();
        if(members.containsKey(id)){
            Member member=members.get(id);
            System.out.println("What do you want to update? \n1.Name\n2. Contact Info\n3. Contact & name");
            int parameter=sc.nextInt();
            switch(parameter){
                case 1:
                    System.out.print("Enter name: ");
                    String name= sc.next();
                    member.setName(name);
                    System.out.println("member name updated.");
                    break;
                case 2:
                    System.out.print("Enter contact: ");
                    String contact= sc.next();
                    member.setName(contact);
                    System.out.println("member contact updated.");
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String name2= sc.next();
                    System.out.print("Enter contact: ");
                    String contact2= sc.next();
                    member.setName(contact2);
                    member.setName(name2);
                    System.out.println("member name and contact updated.");
                    break;
                default:
                    System.out.println("No valid choice made.");
            }
        }else{
            System.out.println("member does not exist.");
        }
    }

    public static void deleteMember(Scanner sc){
        try{
            System.out.println("==== Remove member ====");
            System.out.print("Enter member ID: ");
            String idNumber=sc.next();
            members.remove(idNumber);
            System.out.println("Member has been removed.");
        } catch (Exception e) {
            throw new RuntimeException("Member not found.");
        }
    }

    public static List<Member> viewMembers(){
        membersList.addAll(members.values());
        return membersList;
    }

    public static Member searchMemberByIDNumber(Scanner sc){
        System.out.print("Enter member ID: ");
        String id=sc.next();
        return members.get(id);
    }
}
