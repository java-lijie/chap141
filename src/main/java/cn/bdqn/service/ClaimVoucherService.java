package cn.bdqn.service;

import cn.bdqn.util.PageUtil;
import cn.bdqn.entity.*;
import java.util.List;

public interface ClaimVoucherService {

    public List<BizClaimVoucherEntity> claimVoucherList(PageUtil pageUtil, String status);

    public BizClaimVoucherEntity getVoucher(int id);


    public void addClaim(BizClaimVoucherEntity bizClaimVoucher);

    public void addresult(BizCheckResultEntity bizCheckResult);

    public void delBizClaimVoucher(int id);

    public void update(BizClaimVoucherEntity bizClaimVoucher);

    public void detailDel(int id);

    public SysEmployeeEntity selectEmp(int id);
}
