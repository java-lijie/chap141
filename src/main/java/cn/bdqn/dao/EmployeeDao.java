package cn.bdqn.dao;
import cn.bdqn.entity.SysEmployeeEntity;
public interface EmployeeDao {

    //员工登录
    public SysEmployeeEntity login(String esn, String password);

    //员工管理
    public SysEmployeeEntity manager(int id);
}
