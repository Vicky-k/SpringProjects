package com.sdk.app.dao;

import java.util.List;
import com.sdk.app.model.*;

public interface ClassDao {

	List<Object> getData(@SuppressWarnings("rawtypes") Class className);
	
	boolean register(UserInfo userinfo);
	
}
