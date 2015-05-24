import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

public class ReadWrite{
	private String path;
	
	public ReadWrite(String path){
		this.path = path;
	}
	
	public void SaveCollection(Vector<Person> collection){
		Writer writer = null;
        try {
            writer = new FileWriter(this.path);
            for (int i = 0; i<collection.size(); i++) {
            	writer.write("Client");
            	writer.write("\n");
            	writer.write(Integer.toString(collection.elementAt(i).ID));
            	writer.write("\n");
            	writer.write(collection.elementAt(i).getFirstName());
            	writer.write("\n");
            	writer.write(collection.elementAt(i).getSurname());
            	writer.write("\n");
            	writer.write(collection.elementAt(i).getSecondName());
            	writer.write("\n");
            	Vector<Payment> payments = collection.elementAt(i).getPayments();

            	for(Payment p : payments){
                	writer.write("Payment");
                	writer.write("\n");
                	writer.write(Integer.toString(p.ID));
                	writer.write("\n");
            		writer.write(p.getType());
                	writer.write("\n");
                	writer.write(Float.toString(p.getSize()));
                	writer.write("\n");
                	writer.write(p.getDate().toString());
                	writer.write("\n");
                	writer.write(p.getInfo());
                	writer.write("\n");
                	writer.write(Integer.toString(p.personID));
                	writer.write("\n");
            	}
            }
            writer.flush();
        } 
       catch (IOException  e) {
        	System.err.println(e);
        } 
        finally {
            if (writer != null) {
                try {
                    writer.close();
                } 
                catch (IOException ex) {
                }
            }
        }
	}
	
	public Vector<Person> LoadCollection() throws FileNotFoundException, IOException, ParseException{
        Vector<Person> collection = new Vector<Person>();       
        File file = new File(this.path);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        int id=0;
        String name="";
        String surName="";
        String secondName="";
        String line = null;

        while ((line = br.readLine()) != null){     	 	
        	if(line.equals("Client")){
	        	id = Integer.parseInt(br.readLine());
	        	name = line = br.readLine();
	        	surName = line = br.readLine();
	        	secondName = line = br.readLine();
	        	
	            Person client = new Person();
	        	client.ID=id;
	        	client.setFirstName(name);
	        	client.setSecondName(secondName);
	        	client.setSurname(surName);
	        	
	        	collection.addElement(client);
        	}

        	if(line.equals("Payment")){
        		int pId = Integer.parseInt(br.readLine());
	        	String type = br.readLine();
	        	float size = Float.parseFloat(br.readLine());
	        	String date = br.readLine();
	        	DateFormat format = new SimpleDateFormat("EE MMM dd HH:mm:ss", Locale.ENGLISH);
	        	Date realDate = format.parse(date);
	        	String info = br.readLine();
	        	int persId = Integer.parseInt(br.readLine());
	    		
	        	for(Person p : collection){
	        		if(p.ID == persId){
	    	    		p.AddPayment(type, size, realDate, info, pId, persId);
	        		}
	        	}
        	}
        }
        
        br.close();
		
		return collection;
	}
}