package G_CMS_Dao_Service_Impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import F_CMS_Dao_Service.A_UserDaoService;

@Repository
public class A_UserDaoServiceImpl implements A_UserDaoService {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

}
