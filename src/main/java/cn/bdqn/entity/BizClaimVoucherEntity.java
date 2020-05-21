package cn.bdqn.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BIZ_CLAIM_VOUCHER", schema = "BDQN")
public class BizClaimVoucherEntity {
    private int id;
    private Date createTime;
    private String event;
    private long totalAccount;
    private String status;
    private Date modifyTime;
    private List<BizCheckResultEntity> bizCheckResultsById;
    private SysEmployeeEntity sysEmployeeByNextDealSn;
    private SysEmployeeEntity sysEmployeeByCreateSn;
    private List<BizClaimVoucherDetailEntity> bizClaimVoucherDetailsById;

    @Id
    @Column(name = "ID",  precision = 0)
    @SequenceGenerator(name="gen",sequenceName="SEQ_VOUCHER" ,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "EVENT", length = 255)
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Basic
    @Column(name = "TOTAL_ACCOUNT",  precision = 2)
    public long getTotalAccount() {
        return totalAccount;
    }

    public void setTotalAccount(long totalAccount) {
        this.totalAccount = totalAccount;
    }

    @Basic
    @Column(name = "STATUS",  length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "MODIFY_TIME", nullable = true)
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizClaimVoucherEntity that = (BizClaimVoucherEntity) o;
        return id == that.id &&
                totalAccount == that.totalAccount &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(event, that.event) &&
                Objects.equals(status, that.status) &&
                Objects.equals(modifyTime, that.modifyTime);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, event, totalAccount, status, modifyTime);
    }

    @OneToMany(mappedBy = "bizClaimVoucherByClaimId")

    public List<BizCheckResultEntity> getBizCheckResultsById() {
        return bizCheckResultsById;
    }

    public void setBizCheckResultsById(List<BizCheckResultEntity> bizCheckResultsById) {
        this.bizCheckResultsById = bizCheckResultsById;
    }

    @ManyToOne
    @JoinColumn(name = "NEXT_DEAL_SN", referencedColumnName = "SN")
    public SysEmployeeEntity getSysEmployeeByNextDealSn() {
        return sysEmployeeByNextDealSn;
    }

    public void setSysEmployeeByNextDealSn(SysEmployeeEntity sysEmployeeByNextDealSn) {
        this.sysEmployeeByNextDealSn = sysEmployeeByNextDealSn;
    }

    @ManyToOne
    @JoinColumn(name = "CREATE_SN", referencedColumnName = "SN")
    public SysEmployeeEntity getSysEmployeeByCreateSn() {
        return sysEmployeeByCreateSn;
    }

    public void setSysEmployeeByCreateSn(SysEmployeeEntity sysEmployeeByCreateSn) {
        this.sysEmployeeByCreateSn = sysEmployeeByCreateSn;
    }

    @OneToMany(mappedBy = "bizClaimVoucherByMainId")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE})
    public List<BizClaimVoucherDetailEntity> getBizClaimVoucherDetailsById() {
        return bizClaimVoucherDetailsById;
    }

    public void setBizClaimVoucherDetailsById(List<BizClaimVoucherDetailEntity> bizClaimVoucherDetailsById) {
        this.bizClaimVoucherDetailsById = bizClaimVoucherDetailsById;
    }
}
