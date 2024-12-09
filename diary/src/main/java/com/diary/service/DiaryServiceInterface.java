package com.diary.service;

import java.time.LocalDate;
import java.util.List;

import com.diary.model.Data;
import com.diary.model.User;

public interface DiaryServiceInterface {
	public boolean loginservice(String username, String password);
	public User getuserdata(String userid,String password);
	public List<Data> getdata(String userid);
	public boolean adddiary(String userid , LocalDate today,String mater);
	public boolean unique(String userid);
	public boolean registeruser(User user);
	public boolean useridstatus(String userid);
	public boolean isvaliedusername(String username);//username
	public boolean isvalieduserid(String userid);//userid
	public boolean isvaliedpassword(String password);//password
	public boolean isvaliedemail(String email);//email
	public boolean isvaliedmobilenumber(String mobilenumber);//mobilenumber
}
