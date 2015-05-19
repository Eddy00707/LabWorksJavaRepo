import java.util.Vector;


public class Collection {
	private  Vector<Person> Persons = new Vector<Person>();
	
	public void SaveCollection(){
		
	}
	
	public Vector<Person> LoadCollection(){
		return null;
	}
	
	public void Add(Person person){
		this.Persons.addElement(person);
	}
	
	public void Delete(Person person){
		if(this.Persons.size() != 0){
			this.Persons.remove(person);
		}
	}
	
	public Person GetPerson(int personId){
		for(Person p : this.Persons){
			if(p.ID == personId){
				return p;
			}
		}
		return null;	//search nothing
	}
	
	public void ClearCollection(){
		this.Persons.clear();
	}

	public Vector<Person> getPersons() {
		return this.Persons;
	}

	public void setPersons(Vector<Person> persons) {
		this.Persons = persons;
	}
}
