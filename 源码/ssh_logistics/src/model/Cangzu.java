package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_Cangzu")
public class Cangzu implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private double zujin;
	
	



	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getZujin() {
		return zujin;
	}

	public void setZujin(double zujin) {
		this.zujin = zujin;
	}

	

	

	
	
}
