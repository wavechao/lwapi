package com.wave.action.users;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;

import com.sina.sae.storage.SaeStorage;
import com.sina.sae.util.SaeUserInfo;
import com.wave.action.BasicAciton;
import com.wave.model.User;
import com.wave.service.UserService;
import com.wave.util.ImageUtils;
import com.wave.util.KvdbUtil;

public class Update_avatarAction extends BasicAciton {
	private File upload;// 实际上传文件

	private String uploadFileName; // 上传文件名

	private ServletContext context;

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String execute() {
		// 获得文件的绝对路径
		String targetDirectory = SaeUserInfo.getSaeTmpPath();
		// 判断图片的格式
		String str = "";
		if (uploadFileName.endsWith("jpg")) {
			str = "jpg";
		} else if (uploadFileName.endsWith("img")) {
			str = "img";
		} else if (uploadFileName.endsWith("png")) {
			str = "png";
		} else {
			setErrorCode(400, "格式不对");
			return super.execute();
		}
		// 获得文件名
		int user_id = 0;
		try {
			user_id = getUserId();
		} catch (Exception e) {
			System.out.println("获取userid出现异常：" + e.getMessage());
			setErrorCode(500);
			return super.execute();
		}
		// System.out.println("文件的存放目录为:" + targetDirectory);
		int ramdon = (int) (Math.random() * 100);
		String filename = "user_" + user_id + "_" + ramdon + "." + str;
		String file = "temp." + str;
		// 上传源文件到SaeStorage上去
		File target = new File(targetDirectory, file);
		try {
			FileUtils.copyFile(upload, target);
		} catch (IOException e) {
			setErrorCode(500);
			response.setMessage(e.getMessage());
			e.printStackTrace();
			return super.execute();

		}
		System.out.println("临时文件：" + target.getPath());
		setUploadFileName(target.getPath());// targetDirectory保存文件的存放路径

		SaeStorage ss = new SaeStorage();

		com.wave.util.ImageUtil.abscut(target.getPath());
		ImageUtils.scale2(target.getPath(), targetDirectory + "user_" + user_id
				+ "." + str, 180, 180, true);
		ss.upload("pic", targetDirectory + "user_" + user_id + "." + str,
				filename);
		ImageUtils.scale2(target.getPath(), targetDirectory + "user_min_"
				+ user_id + "." + str, 51, 51, true);

		// 使用upload方法上传到域为image下
		ss.upload("picmin",
				targetDirectory + "user_min_" + user_id + "." + str, filename);

		String url = ss.getUrl("pic", filename);
		String minUrl = ss.getUrl("picmin", filename);

		User user = new User();

		// 删除文件
		user = userService.findUser(user_id);
		delete(user.getAvatar());

		user.setAvatar(url);
		user.setAvatar_thumb(minUrl);
		User userFromDb = userService.updateUserPicUrl(user);
		if (userFromDb == null) {
			response.setCode(404);
			return super.execute();
		}
		// 删除缓存内容
		KvdbUtil.delete(userFromDb.getUsername());
		response.setCode(200);
		response.setObject(userFromDb);
		return super.execute();

	}

	public int getUserId() throws ClassNotFoundException, IOException {
		String username = (String) request.getAttribute("username");
		User user = KvdbUtil.getUserFromKv(username);
		return user.getUserid();
	}

	public void delete(String url) {

		String filename = url.replace("http://lwapi-pic.stor.sinaapp.com/", "");
		System.out.println("删除文件：" + filename);
		SaeStorage storage = new SaeStorage();
		storage.delete("pic", filename);
		storage.delete("picmin", filename);
	}

}
