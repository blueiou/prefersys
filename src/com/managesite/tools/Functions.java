package com.managesite.tools;

public interface Functions {
	//**********************前端操作*********************************
public final int GOODS_OPERATION = 1500;   //商品操作
public final int GET_GOODS_OPERATION_LIST0=GOODS_OPERATION+ 10; //1510 获取商品列表      预备上映
public final int GET_GOODS_OPERATION_LIST1=GOODS_OPERATION+ 11; //1511 获取商品列表      正在上映


public final int GET_GOODS_OPERATION_INFO =GOODS_OPERATION+ 20;     //1520 取某商品详细信息	
public final int GET_GOODS_OPERATION_PlayTime_ById =GOODS_OPERATION+ 21;     //1521 获取某天放映的特定的电影时间列表	


public final int GET_GOODS_OPERATION_PlayTime=GOODS_OPERATION+25;  //1525 获取某天放映的电影列表

//*********************注册（手机？？）
//*********************参数操作*********************************
public final int SYS_OPERATION=9000;
public final int GET_SYS_OPERATION_BROKER_MSG=SYS_OPERATION+1;  //9001获取用户爆料信息


//**********************用户操作*********************************
public final int USERINFO_OPERATION = 100;   //用户基本信息
public final int USERINFO_OPERATION_LOGIN=USERINFO_OPERATION+50;    //150用户登录
public final int USERINFO_OPERATION_QUERY_ORDER=USERINFO_OPERATION+100; //200查询订单
public final int USERINFO_OPERATION_ISSUE=USERINFO_OPERATION+10086; //10186用户影片评价 
public final int USERINFO_OPERATION_INDEX=USERINFO_OPERATION-101;   //-1 返回首页
public final int USERINFO_OPERATION_DEL_ORDER=USERINFO_OPERATION+150; //250 删除订单


//*********************票务管理**********************************

public final int TICKET_OPERATION=1700;   //从选座位开始
public final int TICKET_OPERATION_SEARCH_SEAT=TICKET_OPERATION+10;// 1710查询可预订的位置
public final int TICKET_OPERATION_PRODUCED_ORDER=TICKET_OPERATION+25;//1725 生成订单
//*********************后台管理类******************************
public final int Admin_OPERATION = 5000;
public final int Admin_UserListInfo=Admin_OPERATION+1;     //5001 用户列表
public final int Admin_UserDisabled0=Admin_OPERATION+2;     //启用 用户	
public final int Admin_UserDisabled1=Admin_OPERATION+3;     //禁止用户	
public final int Admin_UserDisabled2_No=Admin_OPERATION+4;     //冻结用户
public final int Admin_UserDisabled2_Yes=Admin_OPERATION+5;     //解冻用户
public final int Admin_UserDel=Admin_OPERATION+6;    //删除用户
public final int Admin_UserInfo=Admin_OPERATION+10;          //用户详细信息
public final int Admin_NEWSVERIFYLISTINFO=Admin_OPERATION+15;      //审核列表
public final int Admin_NEWSVERIFYLISTINFO_0=Admin_OPERATION+16; //审核拒绝
public final int Admin_NEWSVERIFYLISTINFO_1=Admin_OPERATION+17;  //审核通过
public final int Admin_NEWSVERIFYLISTINFO_2=Admin_OPERATION+18;  //审核完成

//**新闻管理

public final int Admin_NEWSListInfo=Admin_OPERATION+41;          //5041 新闻列表
public final int Admin_ADDNEWSInfo_1=Admin_OPERATION+42;          //新闻增加  页面
public final int Admin_ADDNEWSInfo_2=Admin_OPERATION+43;          //新闻增加  提交数据
public final int Admin_EDITNEWSInfo_1=Admin_OPERATION+44;          //新闻修改 页面
public final int Admin_EDITNEWSInfo_2=Admin_OPERATION+45;          //新闻修改 提交数据
/*public final int Admin_STARTNEWSInfo=Admin_OPERATION+46;          //新闻上架
public final int Admin_STOPNEWSInfo=Admin_OPERATION+47;          //新闻下架
*/
public final int Admin_NEWSInfo=Admin_OPERATION+50;          //新闻详细信息


}
