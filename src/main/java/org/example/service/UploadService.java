package org.example.service;

import org.example.entity.Upload;

/**
 * @author TMK
 * date 2020/5/2 - 17:58
 */
public interface UploadService {
    //储存用户上传文件记录
    void saveUpload(Upload u);

    //检测记录是否存在
    Integer checkOneUpload(Upload u);

    //删除该条记录方法
    void deleteUpload(Upload u);
}
