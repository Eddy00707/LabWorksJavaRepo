import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;


public class Collection {
	private  Vector<Person> Persons = new Vector<Person>();
	
	public void SaveCollection(String path){
		ReadWrite fileManager = new ReadWrite(path);
		
		fileManager.SaveCollection(this.Persons);
	}
	
	public Vector<Person> LoadCollection(String path) throws FileNotFoundException, IOException, ParseException{
		ReadWrite fileManager = new ReadWrite(path);
		
		return fileManager.LoadCollection();
	}
	
	public void AddPerson(String firstName, String secondName, String surname, int personId){
		Person p = new Person();
		
		p.ID = personId;
		p.setFirstName(firstName);
		p.setSecondName(secondName);
		p.setSurname(surname);
		
		this.Persons.addElement(p);
	}
	
	public void Delete(Person person){
		if(this.Persons.size() != 0){
			this.Persons.remove(person);
		}
	}
	
	public void Delete(int id){
		for(Person p : this.Persons){
			if(p.ID==id){
				this.Persons.remove(p);
			}
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
	
	public void EditPerson(String firstName, String secondName, String surname, int id){
		for(Person p : this.Persons){
			if(p.ID == id){
				p.setFirstName(firstName);
				p.setSecondName(secondName);
				p.setSurname(surname);
			}
		}
	}
	
	public void ReplacePerson(Person person){
		for(int i = 0; i < this.Persons.size(); i++){
			if(this.Persons.elementAt(i).ID == person.ID){
				this.Persons.set(i, person);
			}
		}
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
	
	public int Size(){
		return this.Persons.size();
	}
}
