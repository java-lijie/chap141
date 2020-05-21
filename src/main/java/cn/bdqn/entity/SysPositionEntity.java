package cn.bdqn.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "SYS_POSITION", schema = "BDQN")
public class SysPositionEntity {
    private int id;
    private String nameCn;
    private String nameEn;
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
    @Column(name = "NAME_CN", nullable = false, length = 50)
    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    @Basic
    @Column(name = "NAME_EN", nullable = false, length = 50)
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysPositionEntity that = (SysPositionEntity) o;
        return id == that.id &&
                Objects.equals(nameCn, that.nameCn) &&
                Objects.equals(nameEn, that.nameEn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCn, nameEn);
    }

    @OneToMany(mappedBy = "sysPositionByPositionId")
    public Collection<SysEmployeeEntity> getSysEmployeesById() {
        return sysEmployeesById;
    }

    public void setSysEmployeesById(Collection<SysEmployeeEntity> sysEmployeesById) {
        this.sysEmployeesById = sysEmployeesById;
    }
}
