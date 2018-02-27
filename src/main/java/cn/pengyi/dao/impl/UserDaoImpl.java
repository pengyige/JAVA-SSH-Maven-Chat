package cn.pengyi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.pengyi.dao.UserDao;
import cn.pengyi.domain.User;


public class UserDaoImpl extends BaseDaoImpl<User>  implements UserDao {

/*	@Override
	public void save(User user) {
		
		Session session =  this.getSessionFactory().getCurrentSession();
		session.save(user);
		
		
	}
*/
	
	@Override
	public User find(User user) {
		Session session =this.getSessionFactory().getCurrentSession();
		String hql = "from User where username = ? and password = ?";
		List list = session.createQuery(hql)
				.setParameter(0, user.getUsername())
				.setParameter(1, user.getPassword())
				.list();
		
		if(!list.isEmpty()){
			return (User) list.get(0);
		}
		return null;
	}

	@Override
	public boolean findUserIsExist(String username) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from User where username = ?";
		List list = session.createQuery(hql)
				.setParameter(0, username)
				.list();
		
		if(list.isEmpty()){
			return false;
		}
		return true;
	}

}
