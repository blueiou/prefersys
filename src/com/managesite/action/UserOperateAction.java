package com.managesite.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.managesite.service.UserOperateService;

public class UserOperateAction extends AjaxActionSupport{
   private Object reply;
	private File upload[];
	private String uploadContentType[];
	private String uploadFileName[];
	private UserOperateService userOp;
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
		/*String userid=(String)*/
		this.session.get("");
		String pathString=ServletActionContext.getServletContext().getRealPath("/images/temp/add");
		File file=new File(pathString);
		if (file.exists()) {
			file.mkdir();
		}
		for (int i = 0; i < upload.length; i++) {
			System.out.println("店名字"+request.getParameter("shopname"));
			FileUtils.copyFile(upload[i], new File(file,uploadFileName[i]));
		}
		reply="上传成功";
		return "input";
	}
	
	
}
