package com.diary.dao;

import java.time.LocalDate;
import java.util.List;

import com.diary.model.Data;
import com.diary.model.User;

public interface DiaryDAOInterface {
	public boolean loginaction(String username,String password);
	public User getuserdata(String userid, String password);
	public List<Data> getdata(String userid);
	public boolean adddiary(String userid , LocalDate date,String mater);
}
