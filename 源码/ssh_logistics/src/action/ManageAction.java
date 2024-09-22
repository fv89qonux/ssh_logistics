package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Caiwu;
import model.Dingdan;
import model.Kehu;
import model.Kucun;
import model.User;

import org.apache.struts2.ServletActionContext;

import util.Util;


import com.opensymphony.xwork2.ActionSupport;

import dao.CaiwuDao;
import dao.DingdanDao;
import dao.KehuDao;
import dao.KucunDao;
import dao.UserDao;

public class ManageAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;
	
	private UserDao userDao;
	
	private String url = "./";
	
	private CaiwuDao caiwuDao;

	public CaiwuDao getCaiwuDao() {
		return caiwuDao;
	}

	public void setCaiwuDao(CaiwuDao caiwuDao) {
		this.caiwuDao = caiwuDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	//程序入口
	public String index() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Util.init(request);
		return "success1";

	}
	//跳转到登录页面
	public String login2() {
		this.setUrl("login.jsp");
		return SUCCESS;

	}
//用户登录操作
	public String login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User user = userDao.selectBean(" where username = '" + username
				+ "' and password= '" + password + "' and userlock=0 and role="+role);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			this.setUrl("index");
			return "redirect";
		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('员工号或者密码错误');window.location.href='method!login2';</script>");
		}
		return null;
	}
//用户退出操作
	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		this.setUrl("login.jsp");
		return SUCCESS;
	}
//跳转到修改密码页面
	public String changepwd() {
		this.setUrl("user/user.jsp");
		return SUCCESS;
	}
//修改密码操作
	public void changepwd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");
		User bean = userDao.selectBean(" where username= '" + u.getUsername()
				+ "' and password= '" + password1 + "'");
		if (!password2.equals(password3)) {
			out.print(Util.tiaozhuan2("两次输入密码不一致", "index", ""));
			out.flush();
			out.close();
		} else if (bean != null) {
			bean.setPassword(password2);
			userDao.updateBean(bean);
			out.print(Util.tiaozhuan2("操作成功", "index", ""));
			out.flush();
			out.close();
		} else {
			out.print(Util.tiaozhuan2("原密码错误", "index", ""));
			out.flush();
			out.close();
		}
	}
	
	//用户列表
	public String userlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where userlock=0 and role=0  order by id desc "; 
		String where2 = " where userlock=0 and role=0  "; 

		int total = userDao.selectBeanCount( where2);
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		this.setUrl("user/userlist.jsp");
		return SUCCESS;
	}
	
	//删除用户操作
	public void userdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setUsername(bean.getUsername()+"_delete");
		bean.setUserlock(1);
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan2("操作成功", "method!userlist","userlist"));
		out.flush();
		out.close();
	}
	//跳转到添加用户页面
	public String useradd() {
		this.setUrl("user/useradd.jsp");
		return SUCCESS;
	}
//添加用户操作
	public void useradd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String truename = request.getParameter("truename");
		User  bean = userDao.selectBean(" where username= '"+username+"'");
		if(bean==null){
			bean = new User();
			bean.setCreatetime(new Date());
			bean.setPassword("111111");
			bean.setRole(0);
			bean.setTruename(truename);
			bean.setUsername(username);
			
			userDao.insertBean(bean);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.print(Util.tiaozhuan("操作成功", "method!userlist","userlist"));
			out.flush();
			out.close();
		}else{
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.print(Util.tiaozhuan("操作失败，该用户名已经存在", "method!userlist","userlist"));
			out.flush();
			out.close();
		}
			
		
	}
	
	//跳转到更新用户页面
	public String userupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("user/userupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新用户操作
	public void userupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		String truename = request.getParameter("truename");
		String password = request.getParameter("password");
		bean.setTruename(truename);
		bean.setPassword(password);
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan("操作成功", "method!userlist","userlist"));
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
	//订单查询页面
	public String dingdanlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dingdanhao = request.getParameter("dingdanhao");
		String  huowumingchen = request.getParameter("huowumingchen");
		String kehuxingming = request.getParameter("kehuxingming");
		String fahuodi = request.getParameter("fahuodi");
		String mudidi = request.getParameter("mudidi");
		String shouhuozhuangtai = request.getParameter("shouhuozhuangtai");
		String duizhangzhuangtai = request.getParameter("duizhangzhuangtai");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
		if(dingdanhao!=null&&!"".equals(dingdanhao)){
			sb.append("dingdanhao like '%"+dingdanhao+"%'");
			sb.append(" and ");
			sb2.append("dingdanhao like '%"+dingdanhao+"%'");
			sb2.append(" and ");
			request.setAttribute("dingdanhao", dingdanhao);
		}
		
		if(huowumingchen!=null&&!"".equals(huowumingchen)){
			sb.append("huowumingchen like '%"+huowumingchen+"%'");
			sb.append(" and ");
			sb2.append("huowumingchen like '%"+huowumingchen+"%'");
			sb2.append(" and ");
			request.setAttribute("huowumingchen", huowumingchen);
		}
		
		if(kehuxingming!=null&&!"".equals(kehuxingming)){
			sb.append("kehuxingming like '%"+kehuxingming+"%'");
			sb.append(" and ");
			sb2.append("kehuxingming like '%"+kehuxingming+"%'");
			sb2.append(" and ");
			request.setAttribute("kehuxingming", kehuxingming);
		}
		if(fahuodi!=null&&!"".equals(fahuodi)){
			sb.append("fahuodi like '%"+fahuodi+"%'");
			sb.append(" and ");
			sb2.append("fahuodi like '%"+fahuodi+"%'");
			sb2.append(" and ");
			request.setAttribute("fahuodi", fahuodi);
		}
		if(mudidi!=null&&!"".equals(mudidi)){
			sb.append("mudidi like '%"+mudidi+"%'");
			sb.append(" and ");
			sb2.append("mudidi like '%"+mudidi+"%'");
			sb2.append(" and ");
			request.setAttribute("mudidi", mudidi);
		}
		if(shouhuozhuangtai!=null&&!"".equals(shouhuozhuangtai)){
			sb.append("shouhuozhuangtai like '%"+shouhuozhuangtai+"%'");
			sb.append(" and ");
			sb2.append("shouhuozhuangtai like '%"+shouhuozhuangtai+"%'");
			sb2.append(" and ");
			request.setAttribute("shouhuozhuangtai", shouhuozhuangtai);
		}
		if(duizhangzhuangtai!=null&&!"".equals(duizhangzhuangtai)){
			sb.append("duizhangzhuangtai like '%"+duizhangzhuangtai+"%'");
			sb.append(" and ");
			sb2.append("duizhangzhuangtai like '%"+duizhangzhuangtai+"%'");
			sb2.append(" and ");
			request.setAttribute("duizhangzhuangtai", duizhangzhuangtai);
		}
		
		
		if(time1!=null&&!"".equals(time1)){
			sb.append("riqi >=  '"+time1+"'");
			sb.append(" and ");
			sb2.append("riqi >=  '"+time1+"'");
			sb2.append(" and ");
			request.setAttribute("time1", time1);
		}
		
		if(time2!=null&&!"".equals(time2)){
			sb.append("riqi <  '"+time2+"'");
			sb.append(" and ");
			sb2.append("riqi <  '"+time2+"'");
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
		int total = dingdanDao.selectBeanCount( where2);
		request.setAttribute("list", dingdanDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!dingdanlist");
		this.setUrl("dingdan/dingdanlist.jsp");
		return SUCCESS;
	}
	
	//订单管理页面
	public String dingdanlist2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String dingdanhao = request.getParameter("dingdanhao");
		String  huowumingchen = request.getParameter("huowumingchen");
		String kehuxingming = request.getParameter("kehuxingming");
		String fahuodi = request.getParameter("fahuodi");
		String mudidi = request.getParameter("mudidi");
		String shouhuozhuangtai = request.getParameter("shouhuozhuangtai");
		String duizhangzhuangtai = request.getParameter("duizhangzhuangtai");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");
		if(dingdanhao!=null&&!"".equals(dingdanhao)){
			sb.append("dingdanhao like '%"+dingdanhao+"%'");
			sb.append(" and ");
			sb2.append("dingdanhao like '%"+dingdanhao+"%'");
			sb2.append(" and ");
			request.setAttribute("dingdanhao", dingdanhao);
		}
		
		if(huowumingchen!=null&&!"".equals(huowumingchen)){
			sb.append("huowumingchen like '%"+huowumingchen+"%'");
			sb.append(" and ");
			sb2.append("huowumingchen like '%"+huowumingchen+"%'");
			sb2.append(" and ");
			request.setAttribute("huowumingchen", huowumingchen);
		}
		
		if(kehuxingming!=null&&!"".equals(kehuxingming)){
			sb.append("kehuxingming like '%"+kehuxingming+"%'");
			sb.append(" and ");
			sb2.append("kehuxingming like '%"+kehuxingming+"%'");
			sb2.append(" and ");
			request.setAttribute("kehuxingming", kehuxingming);
		}
		if(fahuodi!=null&&!"".equals(fahuodi)){
			sb.append("fahuodi like '%"+fahuodi+"%'");
			sb.append(" and ");
			sb2.append("fahuodi like '%"+fahuodi+"%'");
			sb2.append(" and ");
			request.setAttribute("fahuodi", fahuodi);
		}
		if(mudidi!=null&&!"".equals(mudidi)){
			sb.append("mudidi like '%"+mudidi+"%'");
			sb.append(" and ");
			sb2.append("mudidi like '%"+mudidi+"%'");
			sb2.append(" and ");
			request.setAttribute("mudidi", mudidi);
		}
		if(shouhuozhuangtai!=null&&!"".equals(shouhuozhuangtai)){
			sb.append("shouhuozhuangtai like '%"+shouhuozhuangtai+"%'");
			sb.append(" and ");
			sb2.append("shouhuozhuangtai like '%"+shouhuozhuangtai+"%'");
			sb2.append(" and ");
			request.setAttribute("shouhuozhuangtai", shouhuozhuangtai);
		}
		if(duizhangzhuangtai!=null&&!"".equals(duizhangzhuangtai)){
			sb.append("duizhangzhuangtai like '%"+duizhangzhuangtai+"%'");
			sb.append(" and ");
			sb2.append("duizhangzhuangtai like '%"+duizhangzhuangtai+"%'");
			sb2.append(" and ");
			request.setAttribute("duizhangzhuangtai", duizhangzhuangtai);
		}
		
		
		if(time1!=null&&!"".equals(time1)){
			sb.append("riqi >=  '"+time1+"'");
			sb.append(" and ");
			sb2.append("riqi >=  '"+time1+"'");
			sb2.append(" and ");

			request.setAttribute("time1", time1);
		}
		
		if(time2!=null&&!"".equals(time2)){
			sb.append("riqi <  '"+time2+"'");
			sb.append(" and ");
			sb2.append("riqi <  '"+time2+"'");
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
		int total = dingdanDao.selectBeanCount( where2);
		request.setAttribute("list", dingdanDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		request.setAttribute("url", "method!dingdanlist2");
		this.setUrl("dingdan/dingdanlist2.jsp");
		return SUCCESS;
	}
	
	private KucunDao kucunDao;
	
	public KucunDao getKucunDao() {
		return kucunDao;
	}

	public void setKucunDao(KucunDao kucunDao) {
		this.kucunDao = kucunDao;
	}
//跳转到添加订单页面
	public String dingdanadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Kucun> list = kucunDao.selectBeanList(0, 9999, " where 1=1 ");
		request.setAttribute("list", list);
		List<Kehu> list2 = kehuDao.selectBeanList(0, 9999, " where kehulock=0 ");
		request.setAttribute("list2", list2);
		this.setUrl("dingdan/dingdanadd.jsp");
		return SUCCESS;
	}
//添加订单操作
	public void dingdanadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fahuodi = request.getParameter("fahuodi");
		String kucunid = request.getParameter("kucun");
		Kucun kucun = kucunDao.selectBean("  where id= "+kucunid);
		String jine = request.getParameter("jine");
		String kehuid = request.getParameter("kehu");
		Kehu kehu = kehuDao.selectBean(" where id= "+kehuid);
		String liaxifangshi = request.getParameter("liaxifangshi");
		String mianji = request.getParameter("mianji");
		String mudidi = request.getParameter("mudidi");
		String shuliang = request.getParameter("shuliang");
		String tiji = request.getParameter("tiji");
		String zhongliang = request.getParameter("zhongliang");
		Dingdan  bean = new Dingdan();
		bean.setDingdanhao(new Date().getTime()+"");
		bean.setDuizhangzhuangtai("未对帐");
		bean.setFahuodi(fahuodi);
		bean.setHuowubianhao(kucun.getBianhao());
		bean.setHuowumingchen(kucun.getShangpingming());
		bean.setJine(Double.parseDouble(jine));
		bean.setKehuxingming(kehu.getKehumingcheng());
		bean.setLiaxifangshi(liaxifangshi);
		bean.setMianji(Double.parseDouble(mianji));
		bean.setMudidi(mudidi);
		bean.setRiqi(new Date());
		bean.setShouhuozhuangtai("未发货");
		bean.setShuliang(Integer.parseInt(shuliang));
		bean.setTiji(Double.parseDouble(tiji));
		bean.setZhongliang(Double.parseDouble(zhongliang));
		bean.setKehu(kehu);
		dingdanDao.insertBean(bean);
		
		kehu.setJiaoyicishu(kehu.getJiaoyicishu()+1);
		kehu.setJiaoyijine(kehu.getJiaoyijine()+Double.parseDouble(jine));
		kehuDao.updateBean(kehu);
		
		Caiwu caiwu = new Caiwu();
		caiwu.setDingdan(bean);
		caiwu.setCreatetime(new Date());
		caiwu.setJine(Double.parseDouble(jine));
		caiwu.setType("财务收入");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		caiwu.setUser(user);
		caiwu.setLeixing("订单收入");
		caiwuDao.insertBean(caiwu);
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(Util.tiaozhuan("操作成功", "method!dingdanlist","dingdanlist"));
		out.flush();
		out.close();	
		
	}
	
//跳转到更新订单页面	
	public String dingdanupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Dingdan bean = dingdanDao.selectBean(" where id= "+request.getParameter("id"));
		if("未发货".equals(bean.getShouhuozhuangtai())){
			request.setAttribute("bean", bean);
			this.setUrl("dingdan/dingdanupdate.jsp");
		}else{
			this.setUrl("dingdan/dingdanupdate2.jsp");
		}
		
		return SUCCESS;
	}
	
	
	//更新订单操作
	public void dingdanupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Dingdan bean = dingdanDao.selectBean(" where id= "+request.getParameter("id"));
		Kehu kehu = bean.getKehu();

		kehu.setJiaoyijine(kehu.getJiaoyijine()-bean.getJine());
		
		
		String fahuodi = request.getParameter("fahuodi");
		String jine = request.getParameter("jine");
		String liaxifangshi = request.getParameter("liaxifangshi");
		String mianji = request.getParameter("mianji");
		String mudidi = request.getParameter("mudidi");
		String shuliang = request.getParameter("shuliang");
		String tiji = request.getParameter("tiji");
		String zhongliang = request.getParameter("zhongliang");


		bean.setFahuodi(fahuodi);
		bean.setJine(Double.parseDouble(jine));
		bean.setLiaxifangshi(liaxifangshi);
		bean.setMianji(Double.parseDouble(mianji));
		bean.setMudidi(mudidi);
		bean.setShuliang(Integer.parseInt(shuliang));
		bean.setTiji(Double.parseDouble(tiji));
		bean.setZhongliang(Double.parseDouble(zhongliang));
		
		dingdanDao.updateBean(bean);

		kehu.setJiaoyijine(kehu.getJiaoyijine()+Double.parseDouble(jine));
		kehuDao.updateBean(kehu);
		
		Caiwu caiwu = caiwuDao.selectBean(" where  dingdan.id="+bean.getId());
		caiwu.setJine(Double.parseDouble(jine));
		caiwuDao.updateBean(caiwu);
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan("操作成功", "method!dingdanlist","dingdanlist"));
		out.flush();
		out.close();
	}
	
	//删除订单操作
	public void dingdandelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Dingdan bean = dingdanDao.selectBean(" where id= "+request.getParameter("id"));
		if("未发货".equals(bean.getShouhuozhuangtai())){
			Kehu kehu = bean.getKehu();

			kehu.setJiaoyijine(kehu.getJiaoyijine()-bean.getJine());
			kehu.setJiaoyicishu(kehu.getJiaoyicishu()-1);
			
			List<Caiwu> list = caiwuDao.selectBeanList(0, 99, " where dingdan.id= "+bean.getId());
			for(Caiwu caiwu:list){
				caiwuDao.deleteBean(caiwu);
			}
			dingdanDao.deleteBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(Util.tiaozhuan2("操作成功", "method!dingdanlist","dingdanlist"));
			out.flush();
			out.close();
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(Util.tiaozhuan2("删除失败，该订单已经进入物流配送", "method!dingdanlist","dingdanlist"));
			out.flush();
			out.close();
		}
		
	}
	
	private KehuDao kehuDao;

	public KehuDao getKehuDao() {
		return kehuDao;
	}

	public void setKehuDao(KehuDao kehuDao) {
		this.kehuDao = kehuDao;
	}
	
	
	//客户列表
	public String kehulist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pageNum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pageNum"));
			pagesize = Integer.parseInt(request.getParameter("numPerPage"));
		}
		
		String where = " where kehulock=0   order by id desc "; 
		String where2 = " where kehulock=0   "; 

		int total = kehuDao.selectBeanCount( where2);
		request.setAttribute("list", kehuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", pagesize);
		request.setAttribute("pn", currentpage);
		this.setUrl("kehu/kehulist.jsp");
		return SUCCESS;
	}
	
	//删除客户操作
	public void kehudelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kehu bean = kehuDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setKehulock(1);
		kehuDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan2("操作成功", "method!kehulist","kehulist"));
		out.flush();
		out.close();
	}
	//跳转到添加客户页面
	public String kehuadd() {
		this.setUrl("kehu/kehuadd.jsp");
		return SUCCESS;
	}
//添加客户操作
	public void kehuadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String gongsimingchen = request.getParameter("gongsimingchen");
		String kehumingcheng = request.getParameter("kehumingcheng");

		Kehu bean = new Kehu();
		bean.setCreatetime(new Date());
		bean.setGongsimingchen(gongsimingchen);
		bean.setKehumingcheng(kehumingcheng);
		kehuDao.insertBean(bean);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(Util.tiaozhuan("操作成功", "method!kehulist","kehulist"));
		out.flush();
		out.close();
			
		
	}
	
	//跳转到更新客户页面
	public String kehuupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kehu bean = kehuDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("kehu/kehuupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新客户操作
	public void kehuupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kehu bean = kehuDao.selectBean(" where id= "+request.getParameter("id"));
		String gongsimingchen = request.getParameter("gongsimingchen");
		String kehumingcheng = request.getParameter("kehumingcheng");
		bean.setGongsimingchen(gongsimingchen);
		bean.setKehumingcheng(kehumingcheng);
		kehuDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(Util.tiaozhuan("操作成功", "method!kehulist","kehulist"));
		out.flush();
		out.close();
	}
	
}
