package com.diary.service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	@Override
	public boolean adddiary(String userid, LocalDate today, String mater) {
		// TODO Auto-generated method stub
		return diaryDao.adddiary(userid,today,mater);
	}

	@Override
	public boolean unique(String userid) {
		// TODO Auto-generated method stub
		return diaryDao.unique(userid);
	}

	@Override
	public boolean registeruser(User user) {
		// TODO Auto-generated method stub
		return diaryDao.registeruser(user);
	}

	@Override
	public boolean useridstatus(String userid) {
		// TODO Auto-generated method stub
		return diaryDao.useridstatus(userid);
	}

	@Override   
	public boolean isvaliedusername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override    																						//validating the username
	public boolean isvalieduserid(String userid) {
		  // Trim spaces before checking
	    userid = userid.trim();
	    
	    // Check if userid contains spaces or does not meet length requirements
	    if (userid.contains(" ") || userid.length() < 8 || userid.length() > 20) {
	        return false; // Invalid userid
	    }
	    
	    return true; // Valid userid
	}

	@Override																								// validating the password 
	public boolean isvaliedpassword(String password) {
	    String pass = password.trim();
	    boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

	    // Check if password length is between 8 and 25 and does not contain spaces
	    if (pass.length() >= 8 && pass.length() <= 25 && !pass.contains(" ")) {
	        // Loop through each character in the password
	        for (char c : pass.toCharArray()) {
	            if (Character.isUpperCase(c)) {
	                hasUpperCase = true;
	            } else if (Character.isLowerCase(c)) {
	                hasLowerCase = true;
	            } else if (Character.isDigit(c)) {
	                hasDigit = true;
	            } else if (!Character.isLetterOrDigit(c)) {
	                hasSpecialChar = true;
	            }

	            // Early exit if all conditions are met
	            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
	                return true;
	            }
	        }
	    }

	    // Return false if any condition is not met
	    return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
	}

	@Override																		//validating the email
	public boolean isvaliedemail(String email) {
		 // Define the regex pattern for a valid email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Match the email against the pattern
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
	}

	@Override																				//validating mobie number
	public boolean isvaliedmobilenumber(String mobilenumber) {
		 // Define the regex pattern for a valid mobile number with country code
        String mobileRegex = "^\\+\\d{1,3}[6-9]\\d{9}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(mobileRegex);

        // Match the mobile number against the pattern
        if (mobilenumber == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(mobilenumber);
        return matcher.matches();
	}
}
