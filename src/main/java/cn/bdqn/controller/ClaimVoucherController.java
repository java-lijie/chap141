package cn.bdqn.controller;

import cn.bdqn.entity.BizCheckResultEntity;
import cn.bdqn.entity.BizClaimVoucherEntity;
import cn.bdqn.service.ClaimVoucherService;
import cn.bdqn.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/claimVoucher")
public class ClaimVoucherController {
    @Autowired
    private ClaimVoucherService claimVoucherService;

    public ClaimVoucherService getClaimVoucherService() {
        return claimVoucherService;
    }

    public void setClaimVoucherService(ClaimVoucherService claimVoucherService) {
        this.claimVoucherService = claimVoucherService;
    }

    /**
     * 查询集合
     * @param model
     * @param pageNo
     * @param status
     * @return
     */
    @RequestMapping("/claimVoucher_list")
    public String claimVoucherLists(Model model, @RequestParam(required = false) String pageNo, @RequestParam(required = false) String status){
        PageUtil pu=new PageUtil();
        pu.setTotalRecordCount(claimVoucherService.claimVoucherList(null,status).size());
        if(pageNo!=null) {
            pu.setCurrentPageNo(Integer.parseInt(pageNo));
        }else{
            pu.setCurrentPageNo(1);
        }
        pu.setTotalPageCount();
        model.addAttribute("pageSupport",pu);
        model.addAttribute("status",status);
        model.addAttribute("claimVoucherList",claimVoucherService.claimVoucherList(pu,status));
        return "claim/claim_voucher_list";
    }

    /**
     * 根据id进行查询
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/claimVoucher_getClaimVoucherById/{id}")
    public String getClaimVoucherId(Model model, @PathVariable int id){
        model.addAttribute("claimVoucher",claimVoucherService.getVoucher(id));
        return "claim/claim_voucher_view";
    }

    /**
     * 删除之后重定向到查询操作
     * @param id
     * @return
     */
    @RequestMapping("/claimVoucher_todel/{id}")
    public String getClaimVouchertoDel( @PathVariable int id){
        claimVoucherService.delBizClaimVoucher(id);
        return "redirect:/claimVoucher/claimVoucher_list";
    }



    /**
     * 根据id查询并跳转修改页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/claimVoucher_toUpdate/{id}")
    public String getClaimVouchertoUPdate(Model model, @PathVariable int id){
        model.addAttribute("claimVoucher",claimVoucherService.getVoucher(id));
        return "claim/claim_voucher_update";
    }



    /**
     * 修改操作
     * @param model
     * @param bizClaimVoucher
     * @return
     */
    @RequestMapping("/claimVoucher_Update")
    public String setClaimVouchertoUpd(Model model, BizClaimVoucherEntity bizClaimVoucher){
        BizClaimVoucherEntity bcv=claimVoucherService.getVoucher(bizClaimVoucher.getId());
        bcv.setTotalAccount(bizClaimVoucher.getTotalAccount());
        bcv.setBizClaimVoucherDetailsById(bizClaimVoucher.getBizClaimVoucherDetailsById());
        bcv.setEvent(bizClaimVoucher.getEvent());
        bcv.setStatus(bizClaimVoucher.getStatus());
        bcv.setModifyTime(new Date());
        claimVoucherService.update(bcv);
        return "redirect:/claimVoucher/claimVoucher_list";
    }


    /**
     * 转到添加报销单页面
     * @param model
     * @return
     */
    @RequestMapping("/claimVoucher_edit")
    public String editList(Model model){
        Date date = new Date(System.currentTimeMillis());
        String ft = new SimpleDateFormat("yyyy-MM-dd").format(date);
        model.addAttribute("time",ft);
        return "claim/claim_voucher_edit";
    }


    /**
     * 添加报销单
     * @param bizClaimVoucher
     * @return
     */
    @RequestMapping(value="/claimVoucher_editadd",method= RequestMethod.GET)
    public String editadd(BizClaimVoucherEntity bizClaimVoucher){
        /**
         * 循环读取集合里的参数
         */
        for(int i=0;i<bizClaimVoucher.getBizClaimVoucherDetailsById().size();i++){
            bizClaimVoucher.getBizClaimVoucherDetailsById().get(i).setBizClaimVoucherByMainId(bizClaimVoucher);
        }
        bizClaimVoucher.setSysEmployeeByNextDealSn(claimVoucherService.selectEmp(bizClaimVoucher.getSysEmployeeByCreateSn().getSysDepartmentByDepartmentId().getId()));
        bizClaimVoucher.setCreateTime(new Date());
        claimVoucherService.addClaim(bizClaimVoucher);
        return "redirect:/claimVoucher/claimVoucher_list";
    }

    /**
     * 查询报销单然后跳转报销单页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/claim_check/{id}")
    public String claimcheck(Model model,@PathVariable int id){
        model.addAttribute("claimVoucher",claimVoucherService.getVoucher(id));
        return "claim/claim_voucher_check";
    }

    /**
     * 报销单操作
     * @param bizCheckResult
     * @return
     */
    @RequestMapping("/checkResult_checkClaimVoucher")
    public String checkClaimVoucher(BizCheckResultEntity bizCheckResult){
        bizCheckResult.setCheckTime(new Date());
        claimVoucherService.addresult(bizCheckResult);
        return "redirect:/claimVoucher/claimVoucher_list";
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping("/claimVoucher_del")
    @ResponseBody
    public  void del(@RequestParam int id){
        claimVoucherService.detailDel(id);
    }
}
