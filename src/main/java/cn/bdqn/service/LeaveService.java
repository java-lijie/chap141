package cn.bdqn.service;

import cn.bdqn.util.PageUtil;
import cn.bdqn.entity.*;

import java.util.List;

public interface LeaveService {
    public List<BizLeaveEntity> leaveList(PageUtil pageUtil, String startDate, String endDate);

    public BizLeaveEntity leaveView(int id);

    public void addLeave(BizLeaveEntity bizLeave);
}
