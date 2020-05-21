package cn.bdqn.service.impl;

import cn.bdqn.dao.LeaveDao;
import cn.bdqn.service.LeaveService;
import cn.bdqn.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import cn.bdqn.entity.*;
@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
   private LeaveDao leaveDao;


    public List<BizLeaveEntity> leaveList(PageUtil pageUtil, String startDate, String endDate) {
        return leaveDao.leaveList(pageUtil,startDate,endDate);
    }

    public void addLeave(BizLeaveEntity bizLeave) {
        leaveDao.addLeave(bizLeave);
    }

    public BizLeaveEntity leaveView(int id) {
        return leaveDao.leaveView(id);
    }
}
