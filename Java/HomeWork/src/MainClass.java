import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;
import java.util.Vector;
import java.lang.Thread;

public class MainClass {
	private static Scanner scan;
	
	public static void main(String[] args) {
		PersonLogic personLogic = new PersonLogic();
		PaymentLogic paymentLogic = new PaymentLogic();
		int choose = 0;
		scan = new Scanner(System.in);
		//ReadWrite readerWriter = null;
		//Thread fileThread = null;
		
		int clientId = 0;
		int paymentId = 0;
		
		while(true){
			System.out.println("\nChose the action:");
			System.out.println("1 - Add new client");
            System.out.println("2 - Remove client");
            System.out.println("3 - Edit client");
            System.out.println("4 - Remove all clients");
            System.out.println("5 - Add new payment");
            System.out.println("6 - Remove payment");
            System.out.println("7 - Edit payment");
            System.out.println("8 - Remove all payments for client");
            System.out.println("9 - Show all");
            System.out.println("10 - Save in file");
            System.out.println("11 - Load from file");
            System.out.println("12 - Exit");
            
            choose = scan.nextInt();
            
            switch(choose){
            case 1:{
            	System.out.println("Input name, surname and second name of the client:");
            	String name = scan.next();
            	String surname = scan.next();
            	String secondName = scan.next();
            	
            	personLogic.AddPerson(name, secondName, surname, clientId);
            	
            	clientId++;
            	break;
            }
            case 2:{
            	System.out.println("Input client id for removed from data base:");
            	
            	personLogic.DeletePerson(scan.nextInt());
            	
            	System.out.println("Client was removed from data base:");
            	break;
            }
            case 3:{
            	System.out.println("Input name, surname and second name of the client for edit:");
            	String newName = scan.next();
            	String newSurname = scan.next();
            	String newSecondName = scan.next();
            	int personId = scan.nextInt();
            	
            	personLogic.EditPerson(newName, newSecondName, newSurname, personId);       	
            	break;
            }
            case 4:{
            	System.out.println("All clients removed from data base:");
            	personLogic.RemoveAllPersons();
            	break;
            }
            case 5:{
            	System.out.println("Input size, type, date, info and id of the payment. Also input id of the client:");
            	
            	float size = scan.nextFloat();
            	String type = scan.next();
            	String date = scan.next();
            	String info = scan.next();
            	int personId = scan.nextInt();
            	
            	paymentLogic.AddPayment(type, size, date, info, personId, paymentId);
            	
            	paymentId++;
            	
            	break;
            }
            case 6:{
            	System.out.println("Input person id and payment id");
            	int personId = scan.nextInt();
            	int payId = scan.nextInt();
            	
            	paymentLogic.DeletePayment(payId, personId);
            	
            	System.out.println("Payment " + paymentId + " deleted from person " + personId);
            	
            	break;
            }
            case 7:{
            	System.out.println("Input size, type, date, info and person and payment id for edit payment");
            	
            	float newSize = scan.nextFloat();
            	String newType = scan.next();
            	String newDate = scan.next();
            	String newInfo = scan.next();
            	int newPersonId = scan.nextInt();
            	int newPaymentId = scan.nextInt();
            	
            	paymentLogic.EditPayment(newType, newSize, newDate, newInfo, newPersonId, newPaymentId);
            	
            	break;
            }
            case 8:{
            	System.out.println("Input person id and all payments will be removed");
            	
            	int personId = scan.nextInt();
            	
            	paymentLogic.RemoveAllPayments(personId);
            	
            	break;
            }
            case 9:{
            	System.out.println("All clients with payments:");
            	
            	Vector<Person> persons = personLogic.GetPersons();
            	
            	for(Person p : persons){
            		System.out.println("Id: " + p.ID);
            		System.out.println("Name: " + p.getFirstName());
            		System.out.println("Surname: " + p.getSurname());
            		System.out.println("Second name: " + p.getSecondName());
            		
            		Vector<Payment> payments = p.getPayments();
            		
            		if(payments.size() != 0){
            			System.out.println("Client payments:");
            			
	            		for(Payment pt : payments){
	            			System.out.println("Id: " + pt.ID);
	                		System.out.println("Payment type: " + pt.getType());
	                		System.out.println("Size: " + pt.getSize());
	                		System.out.println("Date: " + pt.getDate());
	                		System.out.println("Payment info" + pt.getInfo());
	            		}
            		}
            	}
            	
            	break;
            }
            case 10:
            case 11:
            case 12:
            	System.exit(0);
            }
		}
	}
}
