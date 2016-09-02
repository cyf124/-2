package com.factory;

import com.dao.SchoolDao;
import com.impl.SchoolDaoimpl;


public class DAOFactory {

	
	public static SchoolDao getSchoolDaoInstance(){
		return new SchoolDaoimpl();
	}
}
