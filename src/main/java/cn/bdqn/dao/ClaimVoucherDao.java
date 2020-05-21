package cn.bdqn.dao;

import cn.bdqn.entity.BizCheckResultEntity;
import cn.bdqn.entity.BizClaimVoucherEntity;
import cn.bdqn.entity.SysEmployeeEntity;
import cn.bdqn.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public interface ClaimVoucherDao {

    //查询报销单
    public List<BizClaimVoucherEntity> claimVoucherList(PageUtil pageUtil, String status);

    //根据ID查询报销单
    public BizClaimVoucherEntity getVoucher(Serializable id);

    //修改报销单
    public void update(BizClaimVoucherEntity bizClaimVoucher);

    //根据ID删除报销单
    public void detailDel(Serializable id);

    //增加报销单
    public void addClaim(BizClaimVoucherEntity bizClaimVoucher);

    //删除发票
    public void delBizClaimVoucher(Serializable id);

    //增加结果
    public void addresult(BizCheckResultEntity bizCheckResult);

    //根据id查询员工
    public SysEmployeeEntity selectEmp(int id);
}
