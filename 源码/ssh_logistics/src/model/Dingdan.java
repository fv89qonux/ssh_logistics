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
@Table(name="t_Dingdan")
public class Dingdan implements Serializable{

	private static final long serialVersionUID = -7141419035239709511L;

	private long id;
	
	private String dingdanhao;//订单号
	
	private String kehuxingming;//客户名
	
	private Date riqi;//日期
	
	private String liaxifangshi;//联系方式
	
	private String fahuodi;//发货地
	
	private String mudidi;//目的地
	
	private double jine;//金额
	
	private String huowubianhao;//货物编号
	
	private String huowumingchen;//货物名称
	
	private int shuliang;//数量
	
	private double mianji;//面积
	
	private double tiji;//体积
	
	private double zhongliang;//重量

	private String shouhuozhuangtai;//收货状态  未发货，  库存数量不够,转入订单仓库，    商品已出库，转入调度中心    ,商品已配送  ,完成配送
	
	private String duizhangzhuangtai;//对账状态   未对帐 ,已对账
	
	private int dingchedangeshu;
	
	private Kehu kehu;
	

	@ManyToOne
	@JoinColumn(name="kehuid")
	public Kehu getKehu() {
		return kehu;
	}

	public void setKehu(Kehu kehu) {
		this.kehu = kehu;
	}

	public int getDingchedangeshu() {
		return dingchedangeshu;
	}

	public void setDingchedangeshu(int dingchedangeshu) {
		this.dingchedangeshu = dingchedangeshu;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDingdanhao() {
		return dingdanhao;
	}

	public void setDingdanhao(String dingdanhao) {
		this.dingdanhao = dingdanhao;
	}

	public String getKehuxingming() {
		return kehuxingming;
	}

	public void setKehuxingming(String kehuxingming) {
		this.kehuxingming = kehuxingming;
	}

	public Date getRiqi() {
		return riqi;
	}

	public void setRiqi(Date riqi) {
		this.riqi = riqi;
	}

	public String getLiaxifangshi() {
		return liaxifangshi;
	}

	public void setLiaxifangshi(String liaxifangshi) {
		this.liaxifangshi = liaxifangshi;
	}

	public String getFahuodi() {
		return fahuodi;
	}

	public void setFahuodi(String fahuodi) {
		this.fahuodi = fahuodi;
	}

	public String getMudidi() {
		return mudidi;
	}

	public void setMudidi(String mudidi) {
		this.mudidi = mudidi;
	}

	public double getJine() {
		return jine;
	}

	public void setJine(double jine) {
		this.jine = jine;
	}

	public String getHuowubianhao() {
		return huowubianhao;
	}

	public void setHuowubianhao(String huowubianhao) {
		this.huowubianhao = huowubianhao;
	}

	public String getHuowumingchen() {
		return huowumingchen;
	}

	public void setHuowumingchen(String huowumingchen) {
		this.huowumingchen = huowumingchen;
	}

	public int getShuliang() {
		return shuliang;
	}

	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}

	public double getMianji() {
		return mianji;
	}

	public void setMianji(double mianji) {
		this.mianji = mianji;
	}

	public double getTiji() {
		return tiji;
	}

	public void setTiji(double tiji) {
		this.tiji = tiji;
	}

	public double getZhongliang() {
		return zhongliang;
	}

	public void setZhongliang(double zhongliang) {
		this.zhongliang = zhongliang;
	}

	public String getShouhuozhuangtai() {
		return shouhuozhuangtai;
	}

	public void setShouhuozhuangtai(String shouhuozhuangtai) {
		this.shouhuozhuangtai = shouhuozhuangtai;
	}

	public String getDuizhangzhuangtai() {
		return duizhangzhuangtai;
	}

	public void setDuizhangzhuangtai(String duizhangzhuangtai) {
		this.duizhangzhuangtai = duizhangzhuangtai;
	}

	
	
}
