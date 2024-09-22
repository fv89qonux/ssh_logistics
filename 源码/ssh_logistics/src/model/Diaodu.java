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
@Table(name="t_Diaodu")
public class Diaodu implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private Dingdan dingdan;
	
	private Cheliang cheliang;
	
	private Dingchedan dingchedan;
	
	private Date createtime;
	
	private String chengyungongsi;
	
	private String xianluming;
	
	private String yaoqiudaidashijian;
	
	private String diaoduzhuangtai;//调度状态  未调度 ,已调度,完成调度
	
	private String diaoduriqi;
	
	private double yunshufeiyong;
	
	private User user;//生成调度操作员1
	
	private User user2;//已调度操作员2
	
	private User user3;//完成调度操作员3
	
	
	
	@ManyToOne
	@JoinColumn(name="user3id")
	public User getUser3() {
		return user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	@ManyToOne
	@JoinColumn(name="user2id")
	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getChengyungongsi() {
		return chengyungongsi;
	}

	public void setChengyungongsi(String chengyungongsi) {
		this.chengyungongsi = chengyungongsi;
	}

	public String getDiaoduzhuangtai() {
		return diaoduzhuangtai;
	}

	public void setDiaoduzhuangtai(String diaoduzhuangtai) {
		this.diaoduzhuangtai = diaoduzhuangtai;
	}

	@ManyToOne
	@JoinColumn(name="dingdanid")
	public Dingdan getDingdan() {
		return dingdan;
	}

	public void setDingdan(Dingdan dingdan) {
		this.dingdan = dingdan;
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
	@JoinColumn(name="dingchedanid")
	public Dingchedan getDingchedan() {
		return dingchedan;
	}

	public void setDingchedan(Dingchedan dingchedan) {
		this.dingchedan = dingchedan;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getXianluming() {
		return xianluming;
	}

	public void setXianluming(String xianluming) {
		this.xianluming = xianluming;
	}

	public String getYaoqiudaidashijian() {
		return yaoqiudaidashijian;
	}

	public void setYaoqiudaidashijian(String yaoqiudaidashijian) {
		this.yaoqiudaidashijian = yaoqiudaidashijian;
	}

	public String getDiaoduriqi() {
		return diaoduriqi;
	}

	public void setDiaoduriqi(String diaoduriqi) {
		this.diaoduriqi = diaoduriqi;
	}

	public double getYunshufeiyong() {
		return yunshufeiyong;
	}

	public void setYunshufeiyong(double yunshufeiyong) {
		this.yunshufeiyong = yunshufeiyong;
	}

	

	
	
}
