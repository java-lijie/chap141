package cn.bdqn.dao;
import cn.bdqn.entity.BizLeaveEntity;
import cn.bdqn.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public interface LeaveDao {

    //查询详情状态集合
    public List<BizLeaveEntity> leaveList(PageUtil pageUtil, String startDate, String endDate);

    //增加状态
    public void addLeave(BizLeaveEntity bizLeave);

    //根据ID查询状态详情
    public BizLeaveEntity leaveView(Serializable id);

}
