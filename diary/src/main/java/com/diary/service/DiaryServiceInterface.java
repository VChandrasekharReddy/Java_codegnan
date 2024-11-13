package com.diary.service;

import com.diary.model.User;

public interface DiaryServiceInterface {
	public boolean loginservice(String username, String password);
	public User getuserdata(String userid,String password);
}
