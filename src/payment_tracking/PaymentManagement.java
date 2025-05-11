package payment_tracking;

import members_management.Member;
import members_management.MemberService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PaymentManagement {
    public static HashMap<String, ArrayList<Payment>> paymentsMadeByMember=new HashMap<>();
    public static HashMap<String,Payment> payments=new HashMap<>();
    //make payment
    public static void makePayment(Scanner sc){
        System.out.println("==== Make payment ====");
        System.out.print("Enter member ID: ");
        String memberID=sc.next();
        Member member=MemberService.members.get(memberID);
        System.out.print("=== Choose Payment Type ====\n" +
                "1. Card\n" +
                "2. Cash\n" +
                "3. EFT\n" +
                "Enter payment type: ");
        int paymentChoice=sc.nextInt();
        switch(paymentChoice){
            case 1:
                Payment paymentCash=new Payment(PaymentType.cash,member.getPlan().getType());
                addMembershipPayment(memberID,paymentCash);
                System.out.println("Member "+member.getName()+" payment has been complete.");
                break;
            case 2:
                Payment paymentCard=new Payment(PaymentType.card,member.getPlan().getType());
                addMembershipPayment(memberID,paymentCard);
                System.out.println("Member "+member.getName()+" payment has been complete.");
                break;
            case 3:
                Payment paymentEFT=new Payment(PaymentType.EFT,member.getPlan().getType());
                addMembershipPayment(memberID,paymentEFT);
                System.out.println("Member "+member.getName()+" payment has been complete.");
                break;
            default:
                System.out.println("No valid payment option was selected.");
                break;
        }
    }
    //view payments
    public static ArrayList<Payment> viewAllPayments(){
        return new ArrayList<>(payments.values());
    }
    //view members who have not paid
    public static ArrayList<Member> viewMembersWhoHaveNotPaid(){
        ArrayList<Member> defaultingMembers=new ArrayList<>();
        for(String memberID:MemberService.members.keySet()){
            if(!paymentsMadeByMember.containsKey(memberID)){
                defaultingMembers.add(MemberService.members.get(memberID));
            }
        }
        return defaultingMembers;
    }
    //Track payments made by member
    public static ArrayList<Payment> viewMemberPayments(Scanner sc){
        System.out.println("==== View Payments made by member");
        System.out.print("Enter member ID: ");
        String memberID=sc.next();
        return paymentsMadeByMember.get(memberID);
    }
    //add payment
    private static void addMembershipPayment(String memberID, Payment payment){
        if(!paymentsMadeByMember.containsKey(memberID)){
            paymentsMadeByMember.put(memberID,new ArrayList<Payment>());
        }
        paymentsMadeByMember.get(memberID).add(payment);
        payments.put(payment.getPaymentID(),payment);
    }
}
