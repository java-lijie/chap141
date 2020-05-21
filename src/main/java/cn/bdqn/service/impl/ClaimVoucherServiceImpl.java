package cn.bdqn.service.impl;

import cn.bdqn.dao.ClaimVoucherDao;
import cn.bdqn.service.ClaimVoucherService;
import cn.bdqn.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.bdqn.entity.*;
import java.util.List;
@Service
public class ClaimVoucherServiceImpl implements ClaimVoucherService {
    @Autowired
     private ClaimVoucherDao claimVoucherDao;

    public ClaimVoucherDao getClaimVoucherDao() {
        return claimVoucherDao;
    }

    public void setClaimVoucherDao(ClaimVoucherDao claimVoucherDao) {
        this.claimVoucherDao = claimVoucherDao;
    }


    @Override
    public BizClaimVoucherEntity getVoucher(int id) {
        return claimVoucherDao.getVoucher(id);
    }

    @Override
    public void detailDel(int id) {
        claimVoucherDao.detailDel(id);
    }

    @Override
    public List<BizClaimVoucherEntity> claimVoucherList(PageUtil pageUtil,String status) {
        return claimVoucherDao.claimVoucherList( pageUtil, status);
    }
    @Override
    public void addClaim(BizClaimVoucherEntity bizClaimVoucher) {
        claimVoucherDao.addClaim(bizClaimVoucher);
    }

    @Override
    public void delBizClaimVoucher(int id) {
        claimVoucherDao.delBizClaimVoucher(id);
    }

    @Override
    public void update(BizClaimVoucherEntity bizClaimVoucher) {
        claimVoucherDao.update(bizClaimVoucher);
    }


    @Override
    public SysEmployeeEntity selectEmp(int id) {
        return claimVoucherDao.selectEmp(id);
    }

    @Override
    public void addresult(BizCheckResultEntity bizCheckResult) {
        claimVoucherDao.addresult(bizCheckResult);
    }
}
