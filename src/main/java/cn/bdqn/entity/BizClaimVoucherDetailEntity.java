package cn.bdqn.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BIZ_CLAIM_VOUCHER_DETAIL", schema = "BDQN")
public class BizClaimVoucherDetailEntity {
    private int id;
    private String item;
    private long account;
    private String des;
    private BizClaimVoucherEntity bizClaimVoucherByMainId;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name="gen",sequenceName="SEQ_VOUCHER_DETAIL" ,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ITEM", nullable = false, length = 20)
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "ACCOUNT", nullable = false, precision = 2)
    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    @Basic
    @Column(name = "DES", nullable = false, length = 200)
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BizClaimVoucherDetailEntity that = (BizClaimVoucherDetailEntity) o;
        return id == that.id &&
                account == that.account &&
                Objects.equals(item, that.item) &&
                Objects.equals(des, that.des);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, item, account, des);
    }

    @ManyToOne()
    @JoinColumn(name = "MAIN_ID", referencedColumnName = "ID", nullable = false)
    public BizClaimVoucherEntity getBizClaimVoucherByMainId() {
        return bizClaimVoucherByMainId;
    }

    public void setBizClaimVoucherByMainId(BizClaimVoucherEntity bizClaimVoucherByMainId) {
        this.bizClaimVoucherByMainId = bizClaimVoucherByMainId;
    }
}
