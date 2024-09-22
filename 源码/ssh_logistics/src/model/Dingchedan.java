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
@Table(name="t_Dingchedan")
public class Dingchedan implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String dingchedanhao;
	
	private String dingchexingzhi;
	
	private String yunshuxingzhi;
	
	private String lianxiren;
	
	private String dianhua;
	
	private String chuanzhen;
	
	private String youjian;
	
	private Cheliang cheliang;
	
	private Dingdan dingdan;
	
	private Date createtime;
	
	private String fenpeizhuangtai;//已分配车辆 ，未分配车辆
	
	private User user;
	
	

	
	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFenpeizhuangtai() {
		return fenpeizhuangtai;
	}

	public void setFenpeizhuangtai(String fenpeizhuangtai) {
		this.fenpeizhuangtai = fenpeizhuangtai;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDingchedanhao() {
		return dingchedanhao;
	}

	public void setDingchedanhao(String dingchedanhao) {
		this.dingchedanhao = dingchedanhao;
	}

	public String getDingchexingzhi() {
		return dingchexingzhi;
	}

	public void setDingchexingzhi(String dingchexingzhi) {
		this.dingchexingzhi = dingchexingzhi;
	}

	public String getYunshuxingzhi() {
		return yunshuxingzhi;
	}

	public void setYunshuxingzhi(String yunshuxingzhi) {
		this.yunshuxingzhi = yunshuxingzhi;
	}

	public String getLianxiren() {
		return lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getDianhua() {
		return dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getChuanzhen() {
		return chuanzhen;
	}

	public void setChuanzhen(String chuanzhen) {
		this.chuanzhen = chuanzhen;
	}

	public String getYoujian() {
		return youjian;
	}

	public void setYoujian(String youjian) {
		this.youjian = youjian;
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
	@JoinColumn(name="dingdanid")
	public Dingdan getDingdan() {
		return dingdan;
	}

	public void setDingdan(Dingdan dingdan) {
		this.dingdan = dingdan;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	

	

	
	
}
