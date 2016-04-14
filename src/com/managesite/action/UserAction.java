package com.managesite.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.managesite.entity.User;
import com.managesite.model.PublicData;
import com.managesite.model.UserInfoModel;
import com.managesite.service.SysUsersService;
import com.managesite.tools.CacheClass;
import com.managesite.tools.Functions;
public class UserAction extends AjaxActionSupport{
	private SysUsersService loginUser;
	 private Object reply=null;
	   private Map<String, Object> map;
	   private  PublicData publicData;
	   private String uname;
	   private String upass;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public SysUsersService getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(SysUsersService loginUser) {
		this.loginUser = loginUser;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String mS=request.getParameter("m");
		System.out.println(request.getParameter("m"));
		int m=-1;
		
		if (CacheClass.isEmpty(mS)||!CacheClass.checkId(mS)) {
			m=1510;
		} else {
			 m=Integer.parseInt(mS);
		}
		switch (m) {
		case Functions.USERINFO_OPERATION_LOGIN: //150 用户登录
			return getUser();

		default:
			break;
		}
		return ERROR;
	}
	public String regUser(){
		System.out.println("用户注册");
		return SUCCESS;
		
	}
	//用户登录
	public String getUser(){
		System.out.println("进入登录");
		 HttpSession session=request.getSession();
			map=new HashMap<String, Object>();
			String code=request.getParameter("code");
			String sescode=(String)session.getAttribute("rand");
			if (code==null||sescode==null||!code.equals(sescode)) {
				System.out.println("验证码不正确");
				map.put("success", false);
				map.put("er_msg", "验证码不正确");
				//return SUCCESS;
			}
			else {
				UserInfoModel user=loginUser.findUserUnit(uname, upass);
				System.out.println("else");
				if (user==null) {
				map.put("success", false);
				map.put("user", null);
				map.put("er_msg", "用户不存在");
				
				//return SUCCESS;
			}
				else if (user!=null) {
					System.out.println("user not null ");
					super.session.put("u_id", user.userid);//存放用户id
					session.setAttribute("uid", user.userid);
					session.setAttribute("uname", uname);
					session.setAttribute("urole",user.userRole);
					System.out.println("用户角色"+user.userRole);
					//session.setAttribute("urole", value);
					map.put("user", user);
					map.put("success", true);
					//return SUCCESS;
				}
			}
		map.put("user","error");
			return SUCCESS;
	}
	//用户添加优惠信息
	public String addNews() throws IOException{
		String pathString=ServletActionContext.getServletContext().getRealPath("/temp/imgs");
		 //基于文件创建一个文件输入流
		File file =new File(pathString);
		if (!file.exists()) {
			file.mkdir();
		}
		System.out.println("输出店名字"+request.getParameter("shopname"));
		FileUtils.copyFile(upload, new File(file,uploadFileName));
      /*  InputStream is = new FileInputStream(upload);  
           
        // 设置上传文件目录  
        String uploadPath = ServletActionContext.getServletContext()  
                .getRealPath("/upload");  
        File file =new File(uploadPath);
		if (!file.exists()) {
			file.mkdir();
		}
        // 设置目标文件  
        
        File toFile = new File(uploadPath, this.getUploadFileName());  
          
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile);  
  
        //设置缓存  
        byte[] buffer = new byte[1024];  
  
        int length = 0;  
  
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {  
            os.write(buffer, 0, length);  
        }  
        System.out.println("上传店名"+shopname);  
        System.out.println("上传文件名"+uploadFileName);  
        System.out.println("上传文件类型"+uploadContentType);  
        //关闭输入流  
        is.close();  
          
        //关闭输出流  
        os.close();  */
	reply="上传成功";
		return "input";
	}
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	public Object getReply() {
		return reply;
	}
	public void setReply(Object reply) {
		this.reply = reply;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
}
