<%@ page language="java" import="java.util.*"%>
<%@ page pageEncoding="gbk" contentType="image/jpeg" import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%!
//�ڸ�����Χ�ڻ�������ɫ
Color  getRandColor(int fc,int bc){
   Random  random=new Random();
   if(fc>255) fc=255;
   if(bc>255) bc=255;
   int r=fc+random.nextInt(bc-fc);
   int g=fc+random.nextInt(bc-fc);
   int b=fc+random.nextInt(bc-fc);
   return  new Color(r,g,b);
}
 %>
<%  
    
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires",0);
     //���ڴ��д���ͼ��
    int width=70, height=25;
      BufferedImage  image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
     //���ͼ��������
       Graphics  g=image.getGraphics();
       //���������
       Random  random=new Random();
       //�趨����
       g.setColor(getRandColor(200,250));
       g.fillRect(0,0,width,height);
       //�趨����
       g.setFont(new Font("Times New Roman",Font.PLAIN,18));
       //���߿�
   
     //�������155�������ߣ���ͼ���е���֤�벻���ױ����������⵽
       g.setColor(getRandColor(160,200));
        for(int i=0;i<155;i++){
       int x=random.nextInt(width);
       int y=random.nextInt(height);
       int xi=random.nextInt(12);
       int yi=random.nextInt(12);
       g.drawLine(x,y,x+xi,y+yi);
       }
       //��ȡ�����������֤��
       String   sRand="";
       for(int i=0;i<4;i++){
       String  rand=String.valueOf(random.nextInt(10));
       sRand+=rand;
       //����֤����ʾ��ͼ����ȥ
       g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
       //���ú�����õ���ɫ��ͬ
       g.drawString(rand,13*i+6,16);
       }
       //����֤�����seeion��
       session.setAttribute("rand",sRand);
     
       //ͼ����Ч
       g.dispose();
       //���ͼ��ҳ��
       ImageIO.write(image,"JPEG",response.getOutputStream());
       out.clear();
       out=pageContext.pushBody();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkCode.JSP' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
