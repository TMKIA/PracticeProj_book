package org.example.dao;

import org.example.entity.Upload;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadDao {

	//储存用户上传文件记录
	void saveUpload(Upload u);

	//检测记录是否存在
	Integer checkOneUpload(Upload u);

	//删除该条记录方法
	void deleteUpload(Upload u);
}
