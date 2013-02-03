package com.wave.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

public class Title {
    private Integer titleid;

    private String title;

    private Integer teacherid;

    private Byte studentNum;

    private Integer deptid;

    private Byte state=0;

    private Date createAt;

    private String availableMajors;

    private String description;

    private String requireInfo;
    
    private List<String>available_major;
    
    
    public List<String> getAvailable_major() {
		return available_major;
	}

	public void setAvailable_major(List<String> available_major) {
		this.available_major = available_major;
	}

	public Integer getTitleid() {
        return titleid;
    }

    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Byte getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Byte studentNum) {
        this.studentNum = studentNum;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    @JSON(serialize = false)
    public String getAvailableMajors() {
        return availableMajors;
    }

    public void setAvailableMajors(String availableMajors) {
        this.availableMajors = availableMajors == null ? null : availableMajors.trim();
        String[] strs = availableMajors.split(",");
        available_major = new ArrayList<String>();
		for (String str : strs) {
			available_major.add(str);
		}
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRequireInfo() {
        return requireInfo;
    }

    public void setRequireInfo(String requireInfo) {
        this.requireInfo = requireInfo == null ? null : requireInfo.trim();
    }
}