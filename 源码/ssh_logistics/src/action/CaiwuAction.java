package action;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Caiwu;
import model.Dingdan;

import org.apache.struts2.ServletActionContext;

import util.Util;


import com.opensymphony.xwork2.ActionSupport;

import dao.CaiwuDao;
import dao.DingdanDao;

public class CaiwuAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;
	
	private CaiwuDao caiwuDao;
	
	private String url = "./";
	
	
	

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
	
	//财务查询
	public String caiwulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String type = request.getParameter("type");
		String  leixing = request.getParameter("leixing");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
		if(type!=null&&!"".equals(type)){
			sb.append("type like '%"+type+"%'");
			sb.append(" and ");
			sb2.append("type like '%"+type+"%'");
			sb2.append(" and ");
			request.setAttribute("type", type);
		}
		
		if(leixing!=null&&!"".equals(leixing)){
			sb.append("leixing like '%"+leixing+"%'");
			sb.append(" and ");
			sb2.append("leixing like '%"+leixing+"%'");
			sb2.append(" and ");
			request.setAttribute("leixing", leixing);
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
		int total = caiwuDao.selectBeanCount( where2);
		request.setAttribute("list", caiwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!caiwulist");
		this.setUrl("caiwu/caiwulist.jsp");
		return SUCCESS;
	}
	
	//订单财务明细
	public String caiwulist2() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
		
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
		
		sb.append(" dingdan !=null  order by id desc ");
		String where = sb.toString();
		sb2.append(" dingdan !=null  ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = caiwuDao.selectBeanCount( where2);
		request.setAttribute("list", caiwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!caiwulist2");
		this.setUrl("caiwu/caiwulist2.jsp");
		return SUCCESS;
	}
	
	private DingdanDao dingdanDao;
	
	public DingdanDao getDingdanDao() {
		return dingdanDao;
	}

	public void setDingdanDao(DingdanDao dingdanDao) {
		this.dingdanDao = dingdanDao;
	}
//对账操作
	public void duizhang() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Caiwu caiwu = caiwuDao.selectBean(" where id= "+request.getParameter("id"));
		Dingdan dingdan = caiwu.getDingdan();
		dingdan.setDuizhangzhuangtai("已对账");
		dingdanDao.updateBean(dingdan);
	
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan2("操作成功", "caiwumethod!caiwulist2","caiwulist2"));
		out.flush();
		out.close();
	}
	
	//库存财务明细
	public String caiwulist3() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
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
		
		sb.append(" kucun !=null  order by id desc ");
		String where = sb.toString();
		sb2.append(" kucun !=null ");
		String where2 = sb2.toString();
		
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = caiwuDao.selectBeanCount( where2);
		request.setAttribute("list", caiwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!caiwulist3");
		this.setUrl("caiwu/caiwulist3.jsp");
		return SUCCESS;
	}
	
	//入库财务明细
	public String caiwulist4() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
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
		
		sb.append(" churuku !=null  order by id desc ");
		String where = sb.toString();
		sb2.append(" churuku !=null  ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = caiwuDao.selectBeanCount( where2);
		request.setAttribute("list", caiwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!caiwulist4");
		this.setUrl("caiwu/caiwulist4.jsp");
		return SUCCESS;
	}
	
	//运输财务明细
	public String caiwulist5() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
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
		
		sb.append(" cheliang !=null  order by id desc ");
		String where = sb.toString();
		sb2.append(" cheliang !=null   ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = caiwuDao.selectBeanCount( where2);
		request.setAttribute("list", caiwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!caiwulist5");
		this.setUrl("caiwu/caiwulist5.jsp");
		return SUCCESS;
	}
	
	//收付利润统计
	public String caiwulist6() {
		HttpServletRequest request = ServletActionContext.getRequest();
	
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
		
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
		int total = caiwuDao.selectBeanCount( where2);
		List<Caiwu> list = caiwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where);
		double shouru = 0;
		double zhichu = 0;
		double lirun = 0;
		for(Caiwu bean:list){
			if("财务收入".equals(bean.getType())){
				shouru +=bean.getJine();
			}
			if("财务支出".equals(bean.getType())){
				zhichu +=bean.getJine();
			}
			
		}
		lirun = shouru-zhichu;
		request.setAttribute("shouru", shouru);
		request.setAttribute("zhichu", zhichu);
		request.setAttribute("lirun", lirun);
		request.setAttribute("list", list);
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!caiwulist6");
		this.setUrl("caiwu/caiwulist6.jsp");
		return SUCCESS;
	}
	
}
