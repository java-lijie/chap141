package cn.bdqn.service.impl;

import cn.bdqn.dao.EmployeeDao;
import cn.bdqn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.bdqn.entity.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    public SysEmployeeEntity login(String esn, String password) {
        return employeeDao.login(esn,password);
    }


    public SysEmployeeEntity manager(int id) {
        return employeeDao.manager(id);
    }


}
