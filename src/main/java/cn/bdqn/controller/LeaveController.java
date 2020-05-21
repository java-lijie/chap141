package cn.bdqn.controller;

import cn.bdqn.entity.BizLeaveEntity;
import cn.bdqn.service.LeaveService;
import cn.bdqn.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController  {
    @Autowired
   private LeaveService leaveService;

    public LeaveService getLeaveService() {
        return leaveService;
    }

    public void setLeaveService(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @RequestMapping("/leave_list")
    public String leaveList(Model model, @RequestParam(required = false) String startDate,@RequestParam(required = false) String pageNo, @RequestParam(required = false) String endDate ) throws ParseException {
        PageUtil pu=new PageUtil();
        pu.setTotalRecordCount(leaveService.leaveList(null,startDate,endDate).size());
        //判断是否为空
        if(pageNo!=null) {
            pu.setCurrentPageNo(Integer.parseInt(pageNo));
        }else{
            pu.setCurrentPageNo(1);
        }
        pu.setTotalPageCount();
        List<BizLeaveEntity> leaveList=leaveService.leaveList(pu,startDate,endDate);
        model.addAttribute("endDate",endDate);
        model.addAttribute("pageSupport",pu);
        model.addAttribute("leaveList",leaveList);
        model.addAttribute("startDate",startDate);
        model.addAttribute("url","jsp/leave/leave_list.jsp");
        return "leave/leave_list";
    }
    /**
     * 进去新增请假页面
     * @param model
     * @return
     */
    @RequestMapping("/leave_edit")
    public String add(Model model){
        return "leave/leave_edit";

    }

    /**
     * 新增请假
     * @param bizLeave
     * @return
     */
    @RequestMapping("/leave_add")
    public String leaveAdd(BizLeaveEntity bizLeave){
        bizLeave.setCreatetime(new Date());
        bizLeave.setStatus("待审批");//将状态改为待审批
        leaveService.addLeave(bizLeave);
        return "redirect:/leave/leave_list";
    }

    /**
     * 根据id进行查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/leave_view/{id}")
    public String leaveId(@PathVariable int id,Model model){
        model.addAttribute("leave",leaveService.leaveView(id));
        return "leave/leave_view";
    }

    /**
     * 进入审核页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/leave_check/{id}")
    public String leaveCheck(@PathVariable int id,Model model){
        model.addAttribute("leave",leaveService.leaveView(id));
        return "leave/leave_check";
    }

    /**
     * 修改操作
     * @param leave
     * @param model
     * @return
     */
    @RequestMapping("/leave_update")
    public String leaveUpd(BizLeaveEntity leave,Model model){
        BizLeaveEntity bl=leaveService.leaveView(leave.getId());
        bl.setApproveOpinion(leave.getApproveOpinion());
        bl.setStatus(leave.getStatus());
        bl.setModifytime(new Date());
        leaveService.addLeave(bl);
        return "redirect:/leave/leave_list";
    }
}
