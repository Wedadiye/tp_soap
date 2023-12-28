package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @XmlElement
    private int id;
    @XmlElement
    private String nom;
    @XmlElement
    private String email;
    
    @XmlElement
    private String adress;
	
	public Employee(int id, String nom ,String email , String adress  ) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.nom=nom;
		this.email=email;
		this.adress=adress;


	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String name) {
		this.nom= name;
	}
	

   
}
