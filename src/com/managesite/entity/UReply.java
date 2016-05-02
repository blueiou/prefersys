package com.managesite.entity;
import com.managesite.entity.UserComment;

import com.managesite.entity.User;
public class UReply{

private int r_id;//回复ip
private String content;//回帖的内容
private String r_ip;//回帖的ip
//与评论多对一
private UserComment ucomm;//回复的评论
//与用户多对一
private  User User;   //回复的人






}