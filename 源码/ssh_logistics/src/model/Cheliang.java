package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_Cheliang")
public class Cheliang implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String chepai;
	
	private String chexing;
	
	private String guihao;
	
	private String chengyungongsi;
	
	private String diaoduzhuangtai;//调度状态    未调度 ,已调度
	
	private int chelianglock;
	
	private Date createtime;
	
	

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getChelianglock() {
		return chelianglock;
	}

	public void setChelianglock(int chelianglock) {
		this.chelianglock = chelianglock;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChepai() {
		return chepai;
	}

	public void setChepai(String chepai) {
		this.chepai = chepai;
	}

	public String getChexing() {
		return chexing;
	}

	public void setChexing(String chexing) {
		this.chexing = chexing;
	}

	public String getGuihao() {
		return guihao;
	}

	public void setGuihao(String guihao) {
		this.guihao = guihao;
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

	

	
	
}
