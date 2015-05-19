import java.util.Vector;


public class PersonLogic {
	private Collection collection = new Collection();
	
	public PersonLogic(){
		
	}
	
	public void AddPerson(String firstName, String secondName, String surname, int personId){
		Person p = new Person();
		
		p.ID = personId;
		p.setFirstName(firstName);
		p.setSecondName(secondName);
		p.setSurname(surname);
		
		this.collection.Add(p);
		
		//return p;	//not necessary
	}
	
	public void DeletePerson(int ID){
		if(this.collection.getPersons().size() != 0){
			Person p = this.collection.GetPerson(ID);
			
			this.collection.Delete(p);
		}
	}
	
	public void EditPerson(String firstName, String secondName, String surname, int id){
		Vector<Person> vecP = this.collection.getPersons();
		
		for(Person p : vecP){
			if(p.ID == id){
				p.setFirstName(firstName);
				p.setSecondName(secondName);
				p.setSurname(surname);
				
				//return p;
			}
		}
		
		//return null;
	}
	
	public void RemoveAllPersons(){
		this.collection.ClearCollection();
	}
	
	public Vector<Person> GetPersons(){
		return this.collection.getPersons();
	}
	
	public Person GetPerson(int id){
		return this.collection.GetPerson(id);
	}
	
	public void AddPayment(Payment payment, int personId){
		Vector<Person> vecP = this.collection.getPersons();
		
		for(Person p : vecP){
			if(p.ID == personId){
				p.getPayments().add(payment);
			}
		}
	}
	
	public void DeletePayment(int paymentId, int personId){
		Vector<Person> vecP = this.collection.getPersons();
		
		for(Person p : vecP){
			if(p.ID == personId){
				Vector<Payment> vecPay = p.getPayments();
				
				for(Payment p1 : vecPay){
					if(p1.ID == paymentId){
						vecPay.remove(p1);
						p.setPayments(vecPay);
					}
				}
			}
		}
	}
}
