package action;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Caiwu;
import model.Cheliang;
import model.Diaodu;
import model.Dingchedan;
import model.Dingdan;
import model.User;

import org.apache.struts2.ServletActionContext;

import util.Util;


import com.opensymphony.xwork2.ActionSupport;

import dao.CaiwuDao;
import dao.CheliangDao;
import dao.DiaoduDao;
import dao.DingchedanDao;
import dao.DingdanDao;

public class DiaoduAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;
	
	private CheliangDao cheliangDao;
	

	private String url = "./";
	
	private CaiwuDao caiwuDao;

	

	public CaiwuDao getCaiwuDao() {
		return caiwuDao;
	}

	public void setCaiwuDao(CaiwuDao caiwuDao) {
		this.caiwuDao = caiwuDao;
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

	public CheliangDao getCheliangDao() {
		return cheliangDao;
	}

	public void setCheliangDao(CheliangDao cheliangDao) {
		this.cheliangDao = cheliangDao;
	}
	//车辆列表
	public String chelianglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where chelianglock=0   order by id desc "; 
		String where2 = " where chelianglock=0   ";

		int total = cheliangDao.selectBeanCount( where2);
		request.setAttribute("list", cheliangDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "diaodumethod!chelianglist");
		this.setUrl("cheliang/chelianglist.jsp");
		return SUCCESS;
	}
	
	//删除车辆操作
	public void cheliangdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cheliang bean = cheliangDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setChepai(bean.getChepai()+"_delete");
		bean.setChelianglock(1);
		cheliangDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan2("操作成功", "diaodumethod!chelianglist","chelianglist"));
		out.flush();
		out.close();
	}
	//跳转到添加车辆页面
	public String cheliangadd() {
		this.setUrl("cheliang/cheliangadd.jsp");
		return SUCCESS;
	}
//添加车辆操作
	public void cheliangadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String chengyungongsi = request.getParameter("chengyungongsi");
		String chepai = request.getParameter("chepai");
		String chexing = request.getParameter("chexing");
		String guihao = request.getParameter("guihao");
		Cheliang  bean = cheliangDao.selectBean(" where chepai= '"+chepai+"'");
		if(bean==null){
			bean = new Cheliang();
			bean.setChengyungongsi(chengyungongsi);
			bean.setChepai(chepai);
			bean.setChexing(chexing);
			bean.setCreatetime(new Date());
			bean.setGuihao(guihao);
			bean.setDiaoduzhuangtai("未调度");
			cheliangDao.insertBean(bean);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.print(Util.tiaozhuan("操作成功", "diaodumethod!chelianglist","chelianglist"));
			out.flush();
			out.close();
		}else{
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.print(Util.tiaozhuan("操作失败，该车牌号已经存在", "diaodumethod!chelianglist","chelianglist"));
			out.flush();
			out.close();
		}
			
		
	}
	
	//跳转到更新车辆页面
	public String cheliangupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cheliang bean = cheliangDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("cheliang/cheliangupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新车辆操作
	public void cheliangupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cheliang bean = cheliangDao.selectBean(" where id= "+request.getParameter("id"));
		String chengyungongsi = request.getParameter("chengyungongsi");
		String chexing = request.getParameter("chexing");
		String guihao = request.getParameter("guihao");
		bean.setChengyungongsi(chengyungongsi);
		bean.setChexing(chexing);
		bean.setGuihao(guihao);
		cheliangDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan("操作成功", "diaodumethod!chelianglist","chelianglist"));
		out.flush();
		out.close();
	}
	
	private DingdanDao dingdanDao;
	
	public DingdanDao getDingdanDao() {
		return dingdanDao;
	}

	public void setDingdanDao(DingdanDao dingdanDao) {
		this.dingdanDao = dingdanDao;
	}
//配送列表
	public String peisonglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where shouhuozhuangtai='商品已出库，转入调度中心' order by id desc "; 
		String where2 = " where shouhuozhuangtai='商品已出库，转入调度中心' "; 

		int total =dingdanDao.selectBeanCount( where2);
		request.setAttribute("list", dingdanDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "diaodumethod!peisonglist");
		this.setUrl("diaodu/peisonglist.jsp");
		return SUCCESS;
	}
	
	
	private DingchedanDao dingchedanDao;



	public DingchedanDao getDingchedanDao() {
		return dingchedanDao;
	}

	public void setDingchedanDao(DingchedanDao dingchedanDao) {
		this.dingchedanDao = dingchedanDao;
	}
	//跳转到添加订车单页面
	public String dingchedanadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", request.getParameter("id"));
		this.setUrl("diaodu/dingchedanadd.jsp");
		return SUCCESS;
	}
	
	//添加订车单操作
	public void dingchedanadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Dingdan dingdan = dingdanDao.selectBean(" where id=  "+request.getParameter("id"));
		String chuanzhen = request.getParameter("chuanzhen");
		String dianhua = request.getParameter("dianhua");
		String dingchexingzhi = request.getParameter("dingchexingzhi");
		String lianxiren = request.getParameter("lianxiren");
		String youjian = request.getParameter("youjian");
		String yunshuxingzhi = request.getParameter("yunshuxingzhi");
		Dingchedan  bean = new Dingchedan();
		bean.setChuanzhen(chuanzhen);
		bean.setCreatetime(new Date());
		bean.setDianhua(dianhua);
		bean.setDingchedanhao(new Date().getTime()+"");
		bean.setDingchexingzhi(dingchexingzhi);
		bean.setDingdan(dingdan);
		bean.setLianxiren(lianxiren);
		bean.setYoujian(youjian);
		bean.setYunshuxingzhi(yunshuxingzhi);
		bean.setFenpeizhuangtai("未分配车辆");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser(user);
		dingchedanDao.insertBean(bean);
		dingdan.setDingchedangeshu(dingchedanDao.selectBeanCount(" where dingdan.id ="+dingdan.getId()));
		dingdanDao.updateBean(dingdan);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(Util.tiaozhuan("操作成功", "diaodumethod!peisonglist","peisonglist"));
		out.flush();
		out.close();
	}
	//调度列表
	public String diaodulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		String where = " where fenpeizhuangtai='未分配车辆' order by fenpeizhuangtai desc,id desc "; 
		String where2 = " where fenpeizhuangtai='未分配车辆' "; 
		int total =dingchedanDao.selectBeanCount( where2);
		request.setAttribute("list", dingchedanDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "diaodumethod!diaodulist");
		this.setUrl("diaodu/diaodulist.jsp");
		return SUCCESS;
	}
	
	private DiaoduDao diaoduDao;



	public DiaoduDao getDiaoduDao() {
		return diaoduDao;
	}

	public void setDiaoduDao(DiaoduDao diaoduDao) {
		this.diaoduDao = diaoduDao;
	}
	//跳转到调度页面
	public String diaoduadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("list", cheliangDao.selectBeanList(0, 9999, " where diaoduzhuangtai='未调度' and chelianglock=0"));
		this.setUrl("diaodu/diaoduadd.jsp");
		return SUCCESS;
	}
	//调度操作
	public void diaoduadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Dingchedan dingchedan = dingchedanDao.selectBean(" where id=  "+request.getParameter("id"));
		String cheliang = request.getParameter("cheliang");
		String xianluming = request.getParameter("xianluming");
		String yaoqiudaidashijian = request.getParameter("yaoqiudaidashijian");
		String yunshufeiyong = request.getParameter("yunshufeiyong");
		String chengyungongsi = request.getParameter("chengyungongsi");
		Diaodu  bean = new Diaodu();
		Cheliang cheliangs = cheliangDao.selectBean(" where id= "+cheliang);
		bean.setCheliang(cheliangs);
		bean.setChengyungongsi(chengyungongsi);
		bean.setCreatetime(new Date());
		bean.setDiaoduzhuangtai("未调度");
		bean.setDingchedan(dingchedan);
		bean.setDingdan(dingchedan.getDingdan());
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser(user);
		bean.setXianluming(xianluming);
		bean.setYaoqiudaidashijian(yaoqiudaidashijian);
		bean.setYunshufeiyong(Double.parseDouble(yunshufeiyong));
		diaoduDao.insertBean(bean);
		
		dingchedan.setCheliang(cheliangs);
		dingchedan.setFenpeizhuangtai("已分配车辆");
		dingchedanDao.updateBean(dingchedan);
		
		Caiwu caiwu = new Caiwu();
		caiwu.setCheliang(cheliangs);
		caiwu.setCreatetime(new Date());
		caiwu.setJine(Double.parseDouble(yunshufeiyong));
		caiwu.setType("财务支出");
		caiwu.setUser(user);
		caiwu.setLeixing("车辆运输支出");
		caiwuDao.insertBean(caiwu);
		
		
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(Util.tiaozhuan("操作成功", "diaodumethod!diaodulist","diaodulist"));
		out.flush();
		out.close();
	}
	
	//调度中心
	public String diaodulist2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		String where = " where diaoduzhuangtai='未调度' order by id desc "; 
		String where2 = " where diaoduzhuangtai='未调度' "; 
		int total =diaoduDao.selectBeanCount( where2);
		request.setAttribute("list", diaoduDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "diaodumethod!diaodulist2");
		this.setUrl("diaodu/diaodulist2.jsp");
		return SUCCESS;
	}
	
	//已调度操作
	public void diaoduupdate() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Diaodu bean = diaoduDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setDiaoduzhuangtai("已调度");
		bean.setDiaoduriqi(Util.getTime());
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser2(user);
		diaoduDao.updateBean(bean);
		Dingdan dingdan = bean.getDingdan();
		dingdan.setShouhuozhuangtai("商品已配送");
		dingdanDao.updateBean(dingdan);
		Cheliang cheliang = bean.getCheliang();
		cheliang.setDiaoduzhuangtai("已调度");
		cheliangDao.updateBean(cheliang);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan2("操作成功", "diaodumethod!diaodulist2","diaodulist2"));
		out.flush();
		out.close();
	}
	//完成调度操作
	public void diaoduupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Diaodu bean = diaoduDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setDiaoduzhuangtai("完成调度");
		bean.setDiaoduriqi(Util.getTime());
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser3(user);
		diaoduDao.updateBean(bean);
		Dingdan dingdan = bean.getDingdan();
		dingdan.setShouhuozhuangtai("完成配送");
		dingdanDao.updateBean(dingdan);
		Cheliang cheliang = bean.getCheliang();
		cheliang.setDiaoduzhuangtai("未调度");
		cheliangDao.updateBean(cheliang);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan2("操作成功", "diaodumethod!diaodulist3","diaodulist3"));
		out.flush();
		out.close();
	}
	
	//调度反馈
	public String diaodulist3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		String where = " where diaoduzhuangtai!='未调度' order by  diaoduzhuangtai desc ,id desc "; 
		String where2 = " where diaoduzhuangtai!='未调度' "; 
		int total =diaoduDao.selectBeanCount( where2);
		request.setAttribute("list", diaoduDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "diaodumethod!diaodulist3");
		this.setUrl("diaodu/diaodulist3.jsp");
		return SUCCESS;
	}
	
}
