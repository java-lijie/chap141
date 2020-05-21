package cn.bdqn.dao.impl;

import cn.bdqn.dao.EmployeeDao;
import cn.bdqn.entity.SysEmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao  {

    @Autowired
    private SessionFactory sessionFactory;
    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public SysEmployeeEntity manager(int id) {
        return (SysEmployeeEntity) getSession().createQuery("from SysEmployeeEntity where  sysPositionByPositionId.id=2 and sysDepartmentByDepartmentId.id= ?").setParameter(0,id).uniqueResult();
    }

    public SysEmployeeEntity login(String esn, String password) {
        return (SysEmployeeEntity) getSession().createQuery("from SysEmployeeEntity where sn=? and password=? ")
                .setParameter(0,esn).setParameter(1,password).uniqueResult();
    }



}
