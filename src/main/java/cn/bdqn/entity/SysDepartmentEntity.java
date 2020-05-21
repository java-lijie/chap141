package cn.bdqn.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "SYS_DEPARTMENT", schema = "BDQN")
public class SysDepartmentEntity {
    private int id;
    private String name;
    private Collection<BizClaimVoucherStatisticsEntity> bizClaimVoucherStatisticsById;
    private Collection<SysEmployeeEntity> sysEmployeesById;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysDepartmentEntity that = (SysDepartmentEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "sysDepartmentByDepartmentId")
    public Collection<BizClaimVoucherStatisticsEntity> getBizClaimVoucherStatisticsById() {
        return bizClaimVoucherStatisticsById;
    }

    public void setBizClaimVoucherStatisticsById(Collection<BizClaimVoucherStatisticsEntity> bizClaimVoucherStatisticsById) {
        this.bizClaimVoucherStatisticsById = bizClaimVoucherStatisticsById;
    }

    @OneToMany(mappedBy = "sysDepartmentByDepartmentId")
    public Collection<SysEmployeeEntity> getSysEmployeesById() {
        return sysEmployeesById;
    }

    public void setSysEmployeesById(Collection<SysEmployeeEntity> sysEmployeesById) {
        this.sysEmployeesById = sysEmployeesById;
    }
}
