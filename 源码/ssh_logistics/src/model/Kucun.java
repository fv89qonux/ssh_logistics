package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_Kucun")
public class Kucun implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String bianhao;
	
	private String shangpingming;
	
	private int shuliang;
	
	
	

	

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShangpingming() {
		return shangpingming;
	}

	public void setShangpingming(String shangpingming) {
		this.shangpingming = shangpingming;
	}

	public int getShuliang() {
		return shuliang;
	}

	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}


	
	
}
