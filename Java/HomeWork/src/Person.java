import java.util.Vector;
import java.util.Date;

public class Person{
	private String FirstName;
	private String SecondName;
	private String Surname;
	private Vector<Payment> Payments = new Vector<Payment>();
	public int ID;

	public String getFirstName(){
		return this.FirstName;
	}

	public void setFirstName(String firstName){
		this.FirstName = firstName;
	}

	public String getSecondName(){
		return this.SecondName;
	}

	public void setSecondName(String secondName){
		this.SecondName = secondName;
	}

	public String getSurname(){
		return this.Surname;
	}

	public void setSurname(String surname){
		this.Surname = surname;
	}

	public int getPaymentCount(){
		return this.Payments.size();
	}

	public Vector<Payment> getPayments(){
		return this.Payments;
	}

	public void setPayments(Vector<Payment> payments){
		this.Payments = payments;
	}
	
	public void AddPayment(String type, float size, Date date, String info, int paymentId, int personId){
		Payment pay = new Payment();
		
		pay.ID = paymentId;
		pay.personID = personId;
		pay.setType(type);
		pay.setSize(size);
		pay.setDate(date);
		pay.setInfo(info);
		
		this.Payments.addElement(pay);
	}
	
	public void DeletePayment(int id){
		for(Payment p : this.Payments){
			if(p.ID == id){
				this.Payments.remove(p);
			}
		}
	}
	
	public void EditPayment(String type, float size, Date date, String info, int paymentId){
		for(Payment p : this.Payments){
			if(p.ID == paymentId){
				p.setType(type);
				p.setSize(size);
				p.setDate(date);
				p.setInfo(info);
			}
		}	
	}
	
	public void RemoveAllPayments(){
		this.Payments.clear();
	}
}
