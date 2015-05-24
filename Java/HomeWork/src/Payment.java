import java.util.Date;

public class Payment {
	private String Type;
	private float Size;
	private Date Date;
	private String Info;
	public int ID;
	public int personID;
	
	public String getType(){
		return this.Type;
	}

	public void setType(String type){
		this.Type = type;
	}

	public float getSize(){
		return this.Size;
	}

	public void setSize(float size){
		this.Size = size;
	}

	public Date getDate(){
		return this.Date;
	}

	public void setDate(Date date){
		this.Date = date;
	}

	public String getInfo(){
		return this.Info;
	}

	public void setInfo(String info){
		this.Info = info;
	}
}
