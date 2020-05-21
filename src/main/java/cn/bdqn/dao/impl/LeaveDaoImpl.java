package cn.bdqn.dao.impl;

import cn.bdqn.dao.LeaveDao;
import cn.bdqn.entity.BizLeaveEntity;
import cn.bdqn.util.PageUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.io.Serializable;
import java.util.List;

@Repository
public class LeaveDaoImpl implements LeaveDao {

    @Autowired
    SessionFactory sessionFactory;
    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public BizLeaveEntity leaveView(Serializable id) {
        return (BizLeaveEntity) getSession().load(BizLeaveEntity.class,id);
    }

    public void addLeave(BizLeaveEntity bizLeave) {
        getSession().saveOrUpdate(bizLeave);
    }



    public List<BizLeaveEntity> leaveList(PageUtil pageUtil, String startDate, String endDate ) {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("from BizLeaveEntity where 1=1  ");
        if(startDate!=null&&!("".equals(startDate))){
            stringBuffer.append("and STARTTIME >=TO_DATE('"+startDate+"', 'yyyy-MM-dd')");
        } if(endDate!=null&&!("".equals(endDate))){
            stringBuffer.append(" and ENDTIME <=TO_DATE('"+endDate+"', 'yyyy-MM-dd')");
        }
        stringBuffer.append(" order by createtime DESC");
        Query query=  getSession().createQuery(stringBuffer.toString());

        if(pageUtil!=null){
            query.setFirstResult((pageUtil.getCurrentPageNo()-1)*pageUtil.getPageSize()).setMaxResults(pageUtil.getPageSize());
        }
        return query.list();
    }

}
