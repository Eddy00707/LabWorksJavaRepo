import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class MainClass {
	private static Scanner scan;
	
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		Collection dataBase = new Collection();
		int choose = 0;
		scan = new Scanner(System.in);
		String path = "D:/SkyDrive/3 курс/!2 cemester/!COMPLETED/Java/HomeWork/data.txt";
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
            	
            	dataBase.AddPerson(name, secondName, surname, clientId);
            	
            	System.out.println("New client successfully added!");            	
            	clientId++;
            	break;
            }
            case 2:{
            	System.out.println("Input client id for removed from data base:");
            	
            	int id = scan.nextInt();
            	
            	//Person p = dataBase.GetPerson(id);
            	dataBase.Delete(id);    	
            	
            	System.out.println("Client with id " +id+ " was removed from data base!");
            	break;
            }
            case 3:{
            	System.out.println("Input name, surname, second name and id of the client for edit:");
            	String newName = scan.next();
            	String newSurname = scan.next();
            	String newSecondName = scan.next();
            	int personId = scan.nextInt();
            	
            	dataBase.EditPerson(newName, newSecondName, newSurname, personId);
            	//dataBase.SetPerson(editClient);
            	
            	System.out.println("Client was successfully edited!");
            	break;
            }
            case 4:{
            	System.out.println("All clients was removed from data base!");
            	dataBase.ClearCollection();
            	break;
            }
            case 5:{            	
            	if(dataBase.Size() != 0){	            	
	            	System.out.println("Input size, type, date and info of the payment. Also input the client id:");
	            	System.out.println("Date must be in format: dd-MMM-yy");
	            	float size = scan.nextFloat();
	            	String type = scan.next();
	            	String date = scan.next();
	            	
	            	DateFormat format = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
	            	Date realDate = format.parse(date);
	            	
	            	String info = scan.next();
	            	int personId = scan.nextInt();
	            		            	
	            	Person person = dataBase.GetPerson(personId);
	            	person.AddPayment(type, size, realDate, info, paymentId, personId);
	            	
	            	dataBase.ReplacePerson(person);
	            	
	            	paymentId++;	
	            	System.out.println("New payment successfully added to " + personId + " client");
            	}
            	else{
            		System.out.println("No clients in data base!");
            	}
            	
            	break;
            }
            case 6:{
            	if(dataBase.Size() != 0){
	            	System.out.println("Input payment id and person id for deleting payment:");	            	
	            	int payId = scan.nextInt();
	            	int personId = scan.nextInt();
	            	            	
	            	Person person = dataBase.GetPerson(personId);
	            	person.DeletePayment(payId);
	            	
	            	dataBase.ReplacePerson(person);
	            	
	            	System.out.println("Payment " + paymentId + " successfully deleted from person " + personId);
            	}
            	else{
            		System.out.println("No clients in data base!");
            	}
            	
            	break;
            }
            case 7:{
            	if(dataBase.Size() != 0){
	            	System.out.println("Input size, type, date, info, person and payment id for edit payment:");
	            	System.out.println("Date must be in format: dd-MMM-yy");
	            	
	            	float newSize = scan.nextFloat();
	            	String newType = scan.next();
	            	String newDate = scan.next();
	            	String newInfo = scan.next();
	            	int newPersonId = scan.nextInt();
	            	int newPaymentId = scan.nextInt();
	            	
	            	DateFormat format = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
	            	Date realDate = format.parse(newDate);
	            	
	            	Person person = dataBase.GetPerson(newPersonId);
	            	person.EditPayment(newType, newSize, realDate, newInfo, newPaymentId);
	            	
	            	dataBase.ReplacePerson(person);
	            	
	            	System.out.println("Payment " + newPaymentId + " was successfully edit!");
            	}
            	else{
            		System.out.println("No clients in data base!");
            	}
            	
            	break;
            }
            case 8:{
            	if(dataBase.Size() != 0){
	            	System.out.println("Input person id and all his payments will be removed");
	            	
	            	int personId = scan.nextInt();
	            	
	            	Person person = dataBase.GetPerson(personId);	            	
	            	person.RemoveAllPayments();
	            	
	            	dataBase.ReplacePerson(person);
	            	
	            	System.out.println("All payments for " + personId + " person was removed successfully!");
            	}
            	else{
            		System.out.println("No clients in data base!");
            	}
            	
            	break;
            }
            case 9:{
            	if(dataBase.Size() != 0){
	            	System.out.println("All clients with payments:");
	            	
	            	Vector<Person> persons = dataBase.getPersons();
	            	
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
		                		System.out.println("Payment info: " + pt.getInfo());
		            		}
	            		}
	            	}
            	}
            	else{
            		System.out.println("No clients in data base!");
            	}
            	
            	break;
            }
            case 10:{
            	if(dataBase.Size() != 0){
            		System.out.println("Data base successfully saved!");
            		dataBase.SaveCollection(path);
            	}
            	else{
            		System.out.println("No clients in data base!");
            	}
            	
            	break;
            }
            case 11:{
            	if(dataBase.Size() != 0)
            		System.out.println("Data base will be rewrited!");
            	
            	Vector<Person> pers = dataBase.LoadCollection(path);
            	dataBase.ClearCollection();
            	dataBase.setPersons(pers);
            	
            	System.out.println("Data base successfully loaded!");
            	break;
            }
            case 12:
            	System.exit(0);
            }
		}
	}
}
