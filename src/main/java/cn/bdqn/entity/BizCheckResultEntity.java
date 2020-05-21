package cn.bdqn.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BIZ_CHECK_RESULT", schema = "BDQN")
public class BizCheckResultEntity {
    private int id;
    private Date checkTime;
    private String checkerSn;
    private String result;
    private String comm;
    private BizClaimVoucherEntity bizClaimVoucherByClaimId;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name="gen",sequenceName="SEQ_CHECK_RESULT" ,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CHECK_TIME", nullable = false)
    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }


    @Basic
    @Column(name = "RESULT", nullable = false, length = 50)
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    @Basic
    @Column(name = "CHECKER_SN", nullable = false, length = 50)
    public String getCheckerSn() {
        return checkerSn;
    }

    public void setCheckerSn(String checkerSn) {
        this.checkerSn = checkerSn;
    }
    @Basic
    @Column(name = "COMM", nullable = false, length = 500)
    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizCheckResultEntity that = (BizCheckResultEntity) o;
        return id == that.id &&
                Objects.equals(checkTime, that.checkTime) &&
                Objects.equals(result, that.result) &&
                Objects.equals(comm, that.comm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkTime, result, comm);
    }

    @ManyToOne
    @JoinColumn(name = "CLAIM_ID", referencedColumnName = "ID", nullable = false)
    public BizClaimVoucherEntity getBizClaimVoucherByClaimId() {
        return bizClaimVoucherByClaimId;
    }

    public void setBizClaimVoucherByClaimId(BizClaimVoucherEntity bizClaimVoucherByClaimId) {
        this.bizClaimVoucherByClaimId = bizClaimVoucherByClaimId;
    }
}
