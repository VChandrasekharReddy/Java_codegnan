package com.diary.dao;

import com.diary.model.User;

public interface DiaryDAOInterface {
	public boolean loginaction(String username,String password);
	public User getuserdata(String userid, String password);
}
