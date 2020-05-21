package cn.bdqn.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BIZ_LEAVE", schema = "BDQN")
public class BizLeaveEntity {
    private int id;
    private Date starttime;
    private Date endtime;
    private long leaveday;
    private String reason;
    private String status;
    private String leavetype;
    private String nextDealSn;
    private String approveOpinion;
    private Date createtime;
    private Date modifytime;
    private SysEmployeeEntity sysEmployeeByEmployeeSn;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name="gen",sequenceName="SEQ_LEAVE" ,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "STARTTIME", nullable = false)
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "ENDTIME", nullable = false)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "LEAVEDAY", nullable = false, precision = 1)
    public long getLeaveday() {
        return leaveday;
    }

    public void setLeaveday(long leaveday) {
        this.leaveday = leaveday;
    }

    @Basic
    @Column(name = "REASON", nullable = false, length = 500)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "LEAVETYPE", nullable = true, length = 50)
    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    @Basic
    @Column(name = "NEXT_DEAL_SN", nullable = true, length = 50)
    public String getNextDealSn() {
        return nextDealSn;
    }

    public void setNextDealSn(String nextDealSn) {
        this.nextDealSn = nextDealSn;
    }

    @Basic
    @Column(name = "APPROVE_OPINION", nullable = true, length = 100)
    public String getApproveOpinion() {
        return approveOpinion;
    }

    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

    @Basic
    @Column(name = "CREATETIME", nullable = true)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "MODIFYTIME", nullable = true)
    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizLeaveEntity leave = (BizLeaveEntity) o;
        return id == leave.id &&
                leaveday == leave.leaveday &&
                Objects.equals(starttime, leave.starttime) &&
                Objects.equals(endtime, leave.endtime) &&
                Objects.equals(reason, leave.reason) &&
                Objects.equals(status, leave.status) &&
                Objects.equals(leavetype, leave.leavetype) &&
                Objects.equals(nextDealSn, leave.nextDealSn) &&
                Objects.equals(approveOpinion, leave.approveOpinion) &&
                Objects.equals(createtime, leave.createtime) &&
                Objects.equals(modifytime, leave.modifytime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, starttime, endtime, leaveday, reason, status, leavetype, nextDealSn, approveOpinion, createtime, modifytime);
    }

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_SN", referencedColumnName = "SN", nullable = false)
    public SysEmployeeEntity getSysEmployeeByEmployeeSn() {
        return sysEmployeeByEmployeeSn;
    }

    public void setSysEmployeeByEmployeeSn(SysEmployeeEntity sysEmployeeByEmployeeSn) {
        this.sysEmployeeByEmployeeSn = sysEmployeeByEmployeeSn;
    }
}
