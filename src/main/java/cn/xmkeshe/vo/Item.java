package cn.xmkeshe.vo;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
    private Integer iid;
    private String title,note;
    private List<Drug> allDrug;

    public List<Drug> getAllDrug() {
        return allDrug;
    }

    public void setAllDrug(List<Drug> allDrug) {
        this.allDrug = allDrug;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
