package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Caiwu")
public class Caiwu implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String type;//财务支出，财务收入
	
	private Cheliang cheliang;
	
	private ChuRuku churuku;
	
	private Kucun kucun;
	
	private double jine;//金额
	
	private Date createtime;
	
	private User user;
	
	private Dingdan dingdan;
	
	private String leixing;//订单收入
	
	

	
	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	@ManyToOne
	@JoinColumn(name="dingdanid")
	public Dingdan getDingdan() {
		return dingdan;
	}

	public void setDingdan(Dingdan dingdan) {
		this.dingdan = dingdan;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name="cheliangid")
	public Cheliang getCheliang() {
		return cheliang;
	}

	public void setCheliang(Cheliang cheliang) {
		this.cheliang = cheliang;
	}

	@ManyToOne
	@JoinColumn(name="churukuid")
	public ChuRuku getChuruku() {
		return churuku;
	}

	public void setChuruku(ChuRuku churuku) {
		this.churuku = churuku;
	}

	@ManyToOne
	@JoinColumn(name="kucunid")
	public Kucun getKucun() {
		return kucun;
	}

	public void setKucun(Kucun kucun) {
		this.kucun = kucun;
	}

	public double getJine() {
		return jine;
	}

	public void setJine(double jine) {
		this.jine = jine;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	

	
	
}
