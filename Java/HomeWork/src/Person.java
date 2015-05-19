import java.util.Vector;

public class Person {
	private String FirstName;
	private String SecondName;
	private String Surname;
	private int PaymentCount;	//not necessary
	private Vector<Payment> Payments = new Vector<Payment>();
	public int ID;

	public String getFirstName(){
		return this.FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getSecondName() {
		return this.SecondName;
	}

	public void setSecondName(String secondName) {
		this.SecondName = secondName;
	}

	public String getSurname() {
		return this.Surname;
	}

	public void setSurname(String surname) {
		this.Surname = surname;
	}

	public int getPaymentCount() {
		return this.PaymentCount;
	}

	public void setPaymentCount(int paymentCount) {
		this.PaymentCount = paymentCount;
	}

	public Vector<Payment> getPayments() {
		return this.Payments;
	}

	public void setPayments(Vector<Payment> payments) {
		this.Payments = payments;
	}
}
