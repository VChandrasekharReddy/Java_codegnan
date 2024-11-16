package com.diary.service;

import java.util.List;

import com.diary.dao.DiaryDAOImpl;
import com.diary.model.Data;
import com.diary.model.User;

public class DiaryServiceImpl implements DiaryServiceInterface {

    private  DiaryDAOImpl diaryDao = new DiaryDAOImpl();

    @Override
    public boolean loginservice(String username, String password) {
        return diaryDao.loginaction(username, password);
    }

	@Override
	public User getuserdata(String userid, String password) {
		// TODO Auto-generated method stub
		return diaryDao.getuserdata(userid,password);
	}

	@Override
	public List<Data> getdata(String userid) {
		// TODO Auto-generated method stub
		return diaryDao.getdata(userid);
	}
}
