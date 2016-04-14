package com.managesite.action;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import com.managesite.model.NewsModel;
import com.managesite.service.UserOperateService;
import com.managesite.tools.MyDate;
import com.managesite.tools.ReceiveData;
public class UserOperateAction extends AjaxActionSupport{
    private Object reply;
	private File upload[];
	private String uploadContentType[];
	private String uploadFileName[];
	private UserOperateService userOp;
	private ReceiveData recei;
	private Map<String, Object> data;
	
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public ReceiveData getRecei() {
		return recei;
	}
	public void setRecei(ReceiveData recei) {
		this.recei = recei;
	}
	public UserOperateService getUserOp() {
		return userOp;
	}
	public void setUserOp(UserOperateService userOp) {
		this.userOp = userOp;
	}
	public Object getReply() {
		return reply;
	}
	public void setReply(Object reply) {
		this.reply = reply;
	}
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	//用户添加优惠信息
	public String addNews() throws IOException{
		String time=new MyDate().getYMDHMS();
		System.out.println("店名字"+request.getParameter("shopname"));
		String uidString=(String) super.session.get("u_id");//用户id
		String pathString=ServletActionContext.getServletContext().getRealPath("/images/temp/add");
		File file=new File(pathString);
		if (!file.exists()) {
			file.mkdir();
		}
		String[] imgsurl=new String[upload.length];
		String temp;
		for (int i = 0; i < upload.length; i++) {
			temp=time+MyDate.getRandomN()+"."+uploadFileName[i].split("\\.")[1];//重新命名照片
			FileUtils.copyFile(upload[i], new File(file,temp));
			imgsurl[i]="images/temp/add/"+temp;
		}
		userOp.saveNews(uidString, shopname, content, n_type, imgsurl);
		reply="上传成功";
		return "uploadsuccess";
	}
	public String searchNews()
	{
		data=new HashMap<String, Object>();
		recei.statu=Integer.parseInt(request.getParameter("statu"));
		recei.user_id=(String) session.get("u_id");
		List<NewsModel> list=userOp.findUnverifyOrVeriNews(recei);
		data.put("list", list);
		return SUCCESS;
	}
//添加优惠信息
private String shopname;
private String content;
private String n_type;//优惠类型

	
public String getShopname() {
	return shopname;
}
public void setShopname(String shopname) {
	this.shopname = shopname;
}
	public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getN_type() {
	return n_type;
}
public void setN_type(String n_type) {
	this.n_type = n_type;
}
	public void test(){
		String title="shshshshhshs";
		String des="blank space 无标签";
		String t_id="5e4ba3e053b6e7a20153b6e7a6250002";
		String[] imgsString={
				"/dayday/admin/temp/1345.jpg","/dayday/test/temp/123.jpg"
		};
		userOp.saveNews("11",title,des,t_id,imgsString);
	}
	
}
