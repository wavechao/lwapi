package com.wave.service;

import java.util.List;

import com.wave.model.Title;

public interface TitleService {
	/**获取所有的论文题目，用于测试
	 * @return
	 */
	public List<Title> getTitles();

	/**获取单条论题
	 * @param id 论题id
	 * @return 论题实例
	 */
	public Title query(int id);

	/** 添加论题
	 * @param title 论题实例
	 * @return 论题实例
	 */
	public Title add(Title title);

	/** 审核论题(有老师审核学生申请论题和管理员审核老师申请的论题)
	 * @param id	论题id
	 * @param pass	0 通过老师审核，1 通过审核，2学生申请的论题
	 * @return
	 */
	public Title verify(int id, int pass);

	/**获取某个学生可选的论题
	 * @param page 页面 
	 * @param count 单页所包含的数量
	 * @param id	专业id
	 * @return
	 */
	public List<Title> getMyTitle(int page, int count, int id);

	/**获取某个老师该审核的论题
	 * @param page 页码
	 * @param count 数量
	 * @param teacherid 老师的id
	 * @return
	 */
	public List<Title> getTitleByState(int page, int count, int teacherid);

	/**获取某个高级管理员该审核的论题
	 * @param page
	 * @param count
	 * @param deptid
	 * @return
	 */
	public List<Title> getTitleByStateDept(int page, int count, int deptid);
	
	/**对论题可选人数进行减1操作
	 * @param id 论题id
	 * @return
	 */
	public Title plus(int id);
}
