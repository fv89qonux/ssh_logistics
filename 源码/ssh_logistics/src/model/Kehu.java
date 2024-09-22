package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_Kehu")
public class Kehu implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String kehumingcheng;
	
	private String gongsimingchen;
	
	private double jiaoyijine;
	
	private int jiaoyicishu;
	
	private Date createtime;
	
	private int kehulock;
	
	

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKehumingcheng() {
		return kehumingcheng;
	}

	public void setKehumingcheng(String kehumingcheng) {
		this.kehumingcheng = kehumingcheng;
	}

	public String getGongsimingchen() {
		return gongsimingchen;
	}

	public void setGongsimingchen(String gongsimingchen) {
		this.gongsimingchen = gongsimingchen;
	}

	public double getJiaoyijine() {
		return jiaoyijine;
	}

	public void setJiaoyijine(double jiaoyijine) {
		this.jiaoyijine = jiaoyijine;
	}

	public int getJiaoyicishu() {
		return jiaoyicishu;
	}

	public void setJiaoyicishu(int jiaoyicishu) {
		this.jiaoyicishu = jiaoyicishu;
	}

	public int getKehulock() {
		return kehulock;
	}

	public void setKehulock(int kehulock) {
		this.kehulock = kehulock;
	}

	

	

	
	
}
