package cn.bdqn.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BIZ_CLAIM_VOUYEAR__STATISTICS", schema = "BDQN")
public class BizClaimVouyearStatisticsEntity {
    private int id;
    private long totalCount;
    private long year;
    private Date modifyTime;
    private int departmentId;

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
    @Column(name = "MODIFY_TIME", nullable = false)
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "DEPARTMENT_ID", nullable = false, precision = 0)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizClaimVouyearStatisticsEntity that = (BizClaimVouyearStatisticsEntity) o;
        return id == that.id &&
                totalCount == that.totalCount &&
                year == that.year &&
                departmentId == that.departmentId &&
                Objects.equals(modifyTime, that.modifyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalCount, year, modifyTime, departmentId);
    }
}
