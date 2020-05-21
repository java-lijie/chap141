package cn.bdqn.controller;

import cn.bdqn.entity.SysEmployeeEntity;
import cn.bdqn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/emp")
@SessionAttributes(value = {"EMP","manager"})
public class EmployeeController {
    @Autowired
    private EmployeeService userService;

    public EmployeeService getUserService() {
        return userService;
    }

    public void setUserService(EmployeeService userService) {
        this.userService = userService;
    }

    /**
     * 登录
     * @param sn
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam String sn, @RequestParam String password, Model model){
        SysEmployeeEntity employee=userService.login(sn,password);
        //判断参数是否为空
        if(employee!=null){
            //再判断该员工是否已经离职
            if("离职".equals(employee.getStatus())){
                model.addAttribute("msg","员工已离职不可登录");
                return "../login";
            }
            model.addAttribute("EMP",employee);
            SysEmployeeEntity sysEmployee=userService.manager(employee.getSysDepartmentByDepartmentId().getId());
            if(sysEmployee!=null) {
                model.addAttribute("manager", sysEmployee);
            }
            return "../index";
        }
        else{
            model.addAttribute("msg","账号或密码错误");
            return "../login";
        }

    }
}
