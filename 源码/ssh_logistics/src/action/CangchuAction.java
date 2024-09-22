package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Caiwu;
import model.Cangzu;
import model.ChuRuku;
import model.Dingdan;
import model.Kucun;
import model.User;

import org.apache.struts2.ServletActionContext;

import util.Util;


import com.opensymphony.xwork2.ActionSupport;

import dao.CaiwuDao;
import dao.CangzuDao;
import dao.ChuRukuDao;
import dao.DingdanDao;
import dao.KucunDao;

public class CangchuAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;
	
	private ChuRukuDao churukuDao;
	
	private KucunDao kucunDao;
	
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
	
	
	
	
	
	//商品入库列表
	public String rukulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where type=1  order by id desc "; 
		String where2 = " where type=1  "; 

		int total = churukuDao.selectBeanCount( where2);
		request.setAttribute("list", churukuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		this.setUrl("ruku/rukulist.jsp");
		return SUCCESS;
	}
	
	//跳转到商品入库页面
	public String rukuadd() {
		this.setUrl("ruku/rukuadd.jsp");
		return SUCCESS;
	}
//商品入库操作
	public void rukuadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String jiage = request.getParameter("jiage");
		String shangpingming = request.getParameter("shangpingming");
		String shuliang = request.getParameter("shuliang");
		String zhanyongmianji = request.getParameter("zhanyongmianji");
		ChuRuku  bean = new ChuRuku();;
		bean.setCreatetime(new Date());
		bean.setJiage(Double.parseDouble(jiage));
		bean.setShangpingming(shangpingming);
		bean.setShuliang(Integer.parseInt(shuliang));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser(user);
		bean.setZhanyongmianji(Double.parseDouble(zhanyongmianji));
		bean.setType(1);
		churukuDao.insertBean(bean);
		Kucun kucun = kucunDao.selectBean(" where  shangpingming='"+shangpingming+"'");
		if(kucun==null){
			kucun = new Kucun();
			kucun.setBianhao(new Date().getTime()+"");
			kucun.setShangpingming(shangpingming);
			kucun.setShuliang(Integer.parseInt(shuliang));
			kucunDao.insertBean(kucun);
		}else{
			kucun.setShuliang(kucun.getShuliang()+Integer.parseInt(shuliang));
			kucunDao.updateBean(kucun);
		}
		
		Caiwu caiwu = new Caiwu();
		caiwu.setChuruku(bean);
		caiwu.setCreatetime(new Date());
		caiwu.setJine(Double.parseDouble(jiage));
		caiwu.setType("财务支出");
		caiwu.setUser(user);
		caiwu.setLeixing("入库支出");
		caiwuDao.insertBean(caiwu);
		
		
		Caiwu caiwu2 = new Caiwu();
		caiwu2.setKucun(kucun);
		caiwu2.setCreatetime(new Date());
		//仓库面积费用  
		double feiyong =  cangzuDao.selectBeanList(0, 99, " where 1=1 ").get(0).getZujin();
		
		caiwu2.setJine(Double.parseDouble(zhanyongmianji)*feiyong);
		caiwu2.setType("财务支出");
		caiwu2.setUser(user);
		caiwu2.setLeixing("库存支出");
		caiwuDao.insertBean(caiwu2);
		
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(Util.tiaozhuan("操作成功", "cangchumethod!rukulist","rukulist"));
		out.flush();
		out.close();
		
	}

	public ChuRukuDao getChurukuDao() {
		return churukuDao;
	}

	public void setChurukuDao(ChuRukuDao churukuDao) {
		this.churukuDao = churukuDao;
	}

	public KucunDao getKucunDao() {
		return kucunDao;
	}

	public void setKucunDao(KucunDao kucunDao) {
		this.kucunDao = kucunDao;
	}
	//库存列表
	public String kucunlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shangpingming = request.getParameter("shangpingming");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
		if(shangpingming!=null&&!"".equals(shangpingming)){
			sb.append("shangpingming like '%"+shangpingming+"%'");
			sb.append(" and ");
			sb2.append("shangpingming like '%"+shangpingming+"%'");
			sb2.append(" and ");
			request.setAttribute("shangpingming", shangpingming);
		}
		
		sb.append(" 1=1 order by id desc");
		String where = sb.toString();
		sb2.append(" 1=1 ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}

		int total = kucunDao.selectBeanCount( where2);
		request.setAttribute("list", kucunDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!kucunlist");
		this.setUrl("kucun/kucunlist.jsp");
		return SUCCESS;
	}

	private DingdanDao dingdanDao;
	
	public DingdanDao getDingdanDao() {
		return dingdanDao;
	}

	public void setDingdanDao(DingdanDao dingdanDao) {
		this.dingdanDao = dingdanDao;
	}
//出库列表
	public String chukulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where shouhuozhuangtai='未发货' order by id desc "; 
		String where2 = " where shouhuozhuangtai='未发货' "; 

		int total =dingdanDao.selectBeanCount( where2);
		request.setAttribute("list", dingdanDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "cangchumethod!chukulist");
		this.setUrl("chuku/chukulist.jsp");
		return SUCCESS;
	}
	
//商品出库操作	
	public void chukudelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		Dingdan bean = dingdanDao.selectBean(" where id= "+request.getParameter("id"));
		Kucun kucun = kucunDao.selectBean(" where shangpingming = '"+bean.getHuowumingchen()+"' ");
		if(bean.getShuliang()>kucun.getShuliang()){
			bean.setShouhuozhuangtai("库存数量不够,转入订单仓库");
			dingdanDao.updateBean(bean);
			PrintWriter out = response.getWriter();
			out.print(Util.tiaozhuan2("操作失败，订单的货物数量大于库存数量，转入订单仓库", "cangchumethod!chukulist","chukulist"));
			out.flush();
			out.close();
		}else{
			bean.setShouhuozhuangtai("商品已出库，转入调度中心");
			dingdanDao.updateBean(bean);
			kucun.setShuliang(kucun.getShuliang()-bean.getShuliang());
			kucunDao.updateBean(kucun);
			
			ChuRuku churuku = new ChuRuku();
			churuku.setCreatetime(new Date());
			churuku.setJiage(bean.getJine());
			churuku.setShangpingming(bean.getHuowumingchen());
			churuku.setShuliang(bean.getShuliang());
			churuku.setType(2);
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			churuku.setUser(user);
			churuku.setDingdanhao(bean.getDingdanhao());
			churukuDao.insertBean(churuku);

			PrintWriter out = response.getWriter();
			out.print(Util.tiaozhuan2("操作成功", "cangchumethod!chukulist","chukulist"));
			out.flush();
			out.close();
		}
	}
	//出库操作
	public void chukudelete2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		Dingdan bean = dingdanDao.selectBean(" where id= "+request.getParameter("id"));
		Kucun kucun = kucunDao.selectBean(" where shangpingming = '"+bean.getHuowumingchen()+"' ");
		if(bean.getShuliang()>kucun.getShuliang()){
			bean.setShouhuozhuangtai("库存数量不够,转入订单仓库");
			dingdanDao.updateBean(bean);
			PrintWriter out = response.getWriter();
			out.print(Util.tiaozhuan2("操作失败，订单的货物数量大于库存数量，转入订单仓库", "cangchumethod!chukulist3","chukulist3"));
			out.flush();
			out.close();
		}else{
			bean.setShouhuozhuangtai("商品已出库，转入调度中心");
			dingdanDao.updateBean(bean);
			kucun.setShuliang(kucun.getShuliang()-bean.getShuliang());
			kucunDao.updateBean(kucun);
			
			ChuRuku churuku = new ChuRuku();
			churuku.setCreatetime(new Date());
			churuku.setJiage(bean.getJine());
			churuku.setShangpingming(bean.getHuowumingchen());
			churuku.setShuliang(bean.getShuliang());
			churuku.setType(2);
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			churuku.setUser(user);
			churuku.setDingdanhao(bean.getDingdanhao());
			churukuDao.insertBean(churuku);

			
			PrintWriter out = response.getWriter();
			out.print(Util.tiaozhuan2("操作成功", "cangchumethod!chukulist3","chukulist3"));
			out.flush();
			out.close();
		}
	}
	
	//出仓商品登记
	public String chukulist2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where type=2  order by id desc "; 
		String where2 = " where type=2  "; 

		int total = churukuDao.selectBeanCount( where2);
		request.setAttribute("list", churukuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "cangchumethod!chukulist2");
		this.setUrl("chuku/chukulist2.jsp");
		return SUCCESS;
	}
	//订单仓库
	public String chukulist3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where shouhuozhuangtai='库存数量不够,转入订单仓库' order by id desc "; 
		String where2 = " where shouhuozhuangtai='库存数量不够,转入订单仓库' "; 

		int total =dingdanDao.selectBeanCount( where2);
		request.setAttribute("list", dingdanDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "cangchumethod!chukulist3");
		this.setUrl("chuku/chukulist3.jsp");
		return SUCCESS;
	}
	
	//入仓出仓查询
	public String chukulist4() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String leixing = request.getParameter("leixing");
		String  shangpingming = request.getParameter("shangpingming");
		String username = request.getParameter("username");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
		if(leixing!=null&&!"".equals(leixing)){
			sb.append("type ="+Integer.parseInt(leixing)+"");
			sb.append(" and ");
			sb2.append("type ="+Integer.parseInt(leixing)+"");
			sb2.append(" and ");
			request.setAttribute("leixing", leixing);
		}
		
		if(shangpingming!=null&&!"".equals(shangpingming)){
			sb.append("shangpingming like '%"+shangpingming+"%'");
			sb.append(" and ");
			sb2.append("shangpingming like '%"+shangpingming+"%'");
			sb2.append(" and ");
			request.setAttribute("shangpingming", shangpingming);
		}
		
		if(username!=null&&!"".equals(username)){
			sb.append("user.username like '%"+username+"%'");
			sb.append(" and ");
			sb2.append("user.username like '%"+username+"%'");
			sb2.append(" and ");
			request.setAttribute("username", username);
		}
		
		if(time1!=null&&!"".equals(time1)){
			sb.append("createtime >=  '"+time1+"'");
			sb.append(" and ");
			sb2.append("createtime >=  '"+time1+"'");
			sb2.append(" and ");

			request.setAttribute("time1", time1);
		}
		
		if(time2!=null&&!"".equals(time2)){
			sb.append("createtime <  '"+time2+"'");
			sb.append(" and ");
			sb2.append("createtime <  '"+time2+"'");
			sb2.append(" and ");
			request.setAttribute("time2", time2);
		}
		
		sb.append(" 1=1  order by id desc ");
		String where = sb.toString();
		sb2.append(" 1=1  ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}

		int total = churukuDao.selectBeanCount( where2);
		request.setAttribute("list", churukuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "cangchumethod!chukulist4");
		this.setUrl("chuku/chukulist4.jsp");
		return SUCCESS;
	}
	
	
	private CangzuDao cangzuDao;



	public CangzuDao getCangzuDao() {
		return cangzuDao;
	}

	public void setCangzuDao(CangzuDao cangzuDao) {
		this.cangzuDao = cangzuDao;
	}
	
	//仓库租金列表
	public String cangzulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where 1=1  order by id desc "; 
		String where2 = " where 1=1  "; 

		int total = cangzuDao.selectBeanCount( where2);
		request.setAttribute("list", cangzuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		this.setUrl("cangzu/cangzulist.jsp");
		return SUCCESS;
	}
	
	//跳转到修改仓库租金页面
	public String cangzuupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cangzu bean = cangzuDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("cangzu/cangzuupdate.jsp");
		return SUCCESS;
	}
	
	
	//修改仓库租金操作
	public void cangzuupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cangzu bean = cangzuDao.selectBean(" where id= "+request.getParameter("id"));
		String zujin = request.getParameter("zujin");
		bean.setZujin(Double.parseDouble(zujin));
		cangzuDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan("操作成功", "cangchumethod!cangzulist","cangzulist"));
		out.flush();
		out.close();
	}
}
