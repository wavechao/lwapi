package com.wave.model;

import java.io.Serializable;

public class Time implements Serializable{
	private long teacher_chosen;// 开始给教师添加资格的日期
	private long title_assign;// 开始出题的日期
	private long title_chosen;// 开始选题的日期
	private long compose;// 选题结束的日期 （开始撰写）
	private long deadline;// 论文结束的时间
	private long oral_examination;// 答辩时间
	public long getTeacher_chosen() {
		return teacher_chosen;
	}
	public void setTeacher_chosen(long teacher_chosen) {
		this.teacher_chosen = teacher_chosen;
	}
	public long getTitle_assign() {
		return title_assign;
	}
	public void setTitle_assign(long title_assign) {
		this.title_assign = title_assign;
	}
	public long getTitle_chosen() {
		return title_chosen;
	}
	public void setTitle_chosen(long title_chosen) {
		this.title_chosen = title_chosen;
	}
	public long getCompose() {
		return compose;
	}
	public void setCompose(long compose) {
		this.compose = compose;
	}
	public long getDeadline() {
		return deadline;
	}
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
	public long getOral_examination() {
		return oral_examination;
	}
	public void setOral_examination(long oral_examination) {
		this.oral_examination = oral_examination;
	}
	
}
