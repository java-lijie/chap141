package cn.bdqn.dao.impl;


import cn.bdqn.dao.ClaimVoucherDao;
import cn.bdqn.entity.BizCheckResultEntity;
import cn.bdqn.entity.BizClaimVoucherDetailEntity;
import cn.bdqn.entity.BizClaimVoucherEntity;
import cn.bdqn.entity.SysEmployeeEntity;
import cn.bdqn.util.PageUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
@Repository
public class ClaimVoucherDaoImpl implements ClaimVoucherDao {
    @Autowired
    SessionFactory sessionFactory;
    public Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }




    public BizClaimVoucherEntity getVoucher(Serializable id) {
        return (BizClaimVoucherEntity) getSession().load(BizClaimVoucherEntity.class,id);
    }




    public void detailDel(Serializable id) {
       BizClaimVoucherDetailEntity bizClaimVoucherDetail=  (BizClaimVoucherDetailEntity) getSession().get(BizClaimVoucherDetailEntity.class,id);
       if(bizClaimVoucherDetail!=null) {
          getSession().delete(bizClaimVoucherDetail);
       }
    }
    public void addresult(BizCheckResultEntity bizCheckResult) {
        getSession().save(bizCheckResult);
    }

    public void addClaim(BizClaimVoucherEntity bizClaimVoucher) {
        getSession().save(bizClaimVoucher);
    }

    public List<BizClaimVoucherEntity> claimVoucherList(PageUtil pageUtil, String status) {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("from BizClaimVoucherEntity where 1=1  ");
        if(status!=null&&!("".equals(status))){
            stringBuffer.append(" and STATUS ='"+status+"'");
        }
        stringBuffer.append(" order by createTime DESC");

        Query query=  getSession().createQuery(stringBuffer.toString());
        if(pageUtil!=null){
            query.setFirstResult((pageUtil.getCurrentPageNo()-1)*pageUtil.getPageSize()).setMaxResults(pageUtil.getPageSize());
        }

        return query.list();
    }

    public void delBizClaimVoucher(Serializable id) {
        getSession().delete((BizClaimVoucherEntity) getSession().load(BizClaimVoucherEntity.class,id));
    }

    public SysEmployeeEntity selectEmp(int id) {
        Query query=getSession().createQuery("from SysEmployeeEntity where sysDepartmentByDepartmentId.id=? and sysPositionByPositionId.id=2");
        query.setParameter(0,id);
        return (SysEmployeeEntity) query.uniqueResult();
    }

    public void update(BizClaimVoucherEntity bizClaimVoucher) {
        getSession().update(bizClaimVoucher);
    }

}
