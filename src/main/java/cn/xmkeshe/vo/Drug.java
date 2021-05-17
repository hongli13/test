package cn.xmkeshe.vo;

import java.io.Serializable;
import java.util.Date;

public class Drug implements Serializable {
    private Integer count, status;
    private Item iid; //iid
    private String title,drid, address, phone;
    private Date prodate;

    public String getDrid() {
        return drid;
    }

    public void setDrid(String drid) {
        this.drid = drid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Item getIid() {
        return iid;
    }

    public void setIid(Item iid) {
        this.iid = iid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getProdate() {
        return prodate;
    }

    public void setProdate(Date prodate) {
        this.prodate = prodate;
    }
}
