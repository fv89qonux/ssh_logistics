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
@Table(name="t_ChuRuku")
public class ChuRuku implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String shangpingming;
	
	private User user;
	
	private int shuliang;
	
	private double jiage;
	
	private Date createtime;
	
	private double zhanyongmianji;
	
	private String dingdanhao;
	
	private int type;//1表示入库，2表示出库
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getZhanyongmianji() {
		return zhanyongmianji;
	}

	public void setZhanyongmianji(double zhanyongmianji) {
		this.zhanyongmianji = zhanyongmianji;
	}

	public void setJiage(double jiage) {
		this.jiage = jiage;
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

	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getJiage() {
		return jiage;
	}

	public String getDingdanhao() {
		return dingdanhao;
	}

	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}

	
	
}
