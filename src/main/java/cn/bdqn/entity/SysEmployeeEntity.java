package cn.bdqn.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "SYS_EMPLOYEE", schema = "BDQN" )
public class SysEmployeeEntity {
    private String sn;
    private String name;
    private String password;
    private String status;
    private Collection<BizClaimVoucherEntity> bizClaimVouchersBySn;
    private Collection<BizClaimVoucherEntity> bizClaimVouchersBySn_0;
    private Collection<BizLeaveEntity> bizLeavesBySn;
    private SysPositionEntity sysPositionByPositionId;
    private SysDepartmentEntity sysDepartmentByDepartmentId;

    @Id
    @Column(name = "SN", nullable = false, length = 50)
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysEmployeeEntity that = (SysEmployeeEntity) o;
        return Objects.equals(sn, that.sn) &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sn, name, password, status);
    }

    @OneToMany(mappedBy = "sysEmployeeByNextDealSn")
    public Collection<BizClaimVoucherEntity> getBizClaimVouchersBySn() {
        return bizClaimVouchersBySn;
    }

    public void setBizClaimVouchersBySn(Collection<BizClaimVoucherEntity> bizClaimVouchersBySn) {
        this.bizClaimVouchersBySn = bizClaimVouchersBySn;
    }

    @OneToMany(mappedBy = "sysEmployeeByCreateSn")
    public Collection<BizClaimVoucherEntity> getBizClaimVouchersBySn_0() {
        return bizClaimVouchersBySn_0;
    }

    public void setBizClaimVouchersBySn_0(Collection<BizClaimVoucherEntity> bizClaimVouchersBySn_0) {
        this.bizClaimVouchersBySn_0 = bizClaimVouchersBySn_0;
    }

    @OneToMany(mappedBy = "sysEmployeeByEmployeeSn")
    public Collection<BizLeaveEntity> getBizLeavesBySn() {
        return bizLeavesBySn;
    }

    public void setBizLeavesBySn(Collection<BizLeaveEntity> bizLeavesBySn) {
        this.bizLeavesBySn = bizLeavesBySn;
    }

    @ManyToOne
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID", nullable = false)
    public SysPositionEntity getSysPositionByPositionId() {
        return sysPositionByPositionId;
    }

    public void setSysPositionByPositionId(SysPositionEntity sysPositionByPositionId) {
        this.sysPositionByPositionId = sysPositionByPositionId;
    }

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID", nullable = false)
    public SysDepartmentEntity getSysDepartmentByDepartmentId() {
        return sysDepartmentByDepartmentId;
    }

    public void setSysDepartmentByDepartmentId(SysDepartmentEntity sysDepartmentByDepartmentId) {
        this.sysDepartmentByDepartmentId = sysDepartmentByDepartmentId;
    }
}
