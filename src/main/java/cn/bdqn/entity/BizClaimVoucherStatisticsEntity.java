package cn.bdqn.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "BIZ_CLAIM_VOUCHER_STATISTICS", schema = "BDQN")
public class BizClaimVoucherStatisticsEntity {
    private int id;
    private long totalCount;
    private long year;
    private long month;
    private Time modifyTime;
    private SysDepartmentEntity sysDepartmentByDepartmentId;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TOTAL_COUNT", nullable = false, precision = 2)
    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    @Basic
    @Column(name = "YEAR", nullable = false, precision = 0)
    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    @Basic
    @Column(name = "MONTH", nullable = false, precision = 0)
    public long getMonth() {
        return month;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    @Basic
    @Column(name = "MODIFY_TIME", nullable = false)
    public Time getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Time modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizClaimVoucherStatisticsEntity that = (BizClaimVoucherStatisticsEntity) o;
        return id == that.id &&
                totalCount == that.totalCount &&
                year == that.year &&
                month == that.month &&
                Objects.equals(modifyTime, that.modifyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalCount, year, month, modifyTime);
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
