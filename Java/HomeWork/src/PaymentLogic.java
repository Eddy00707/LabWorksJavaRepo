import java.sql.Date;
import java.util.Vector;


public class PaymentLogic {
	private PersonLogic personLogic;
	
	public PaymentLogic(){
		this.personLogic = new PersonLogic();
	}
	
	public void AddPayment(String type, float size, String date, String info, int personId, int paymentId){
		Payment pay = new Payment();
		
		pay.ID = paymentId;
		pay.PersonID = personId;
		pay.setType(type);
		pay.setSize(size);
		pay.setDate(date);
		pay.setInfo(info);
		
		this.personLogic.AddPayment(pay, personId);
		
		//return pay;
	}
	
	public void DeletePayment(int id, int personId){
		this.personLogic.DeletePayment(id, personId);
	}
	
	public void EditPayment(String type, float size, String date, String info, int personId, int paymentId){
		Person pers = this.personLogic.GetPerson(personId);
		Vector<Payment> pays = pers.getPayments();
		
		for(Payment p : pays){
			if(p.ID == paymentId){
				p.setType(type);
				p.setSize(size);
				p.setDate(date);
				p.setInfo(info);
				
				//return p;
			}
		}	
		
		//return null;
	}
	
	public void RemoveAllPayments(int personId){
		Person p = this.personLogic.GetPerson(personId);
		Vector<Payment> pt = p.getPayments();
		
		pt.clear();
		
		p.setPayments(pt);
	}
}
