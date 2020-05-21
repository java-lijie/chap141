package cn.bdqn.service;
import cn.bdqn.entity.*;
public interface EmployeeService {

    public SysEmployeeEntity login(String esn, String password);

    public SysEmployeeEntity manager(int id);
}
