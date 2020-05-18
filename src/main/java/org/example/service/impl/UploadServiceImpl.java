package org.example.service.impl;

import org.example.dao.UploadDao;
import org.example.entity.Upload;
import org.example.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author TMK
 * date 2020/5/2 - 18:20
 */
@Service
@Transactional
public class UploadServiceImpl implements UploadService{

    @Resource
    private  UploadDao uploadDao;

    @Override
    public void saveUpload(Upload u) {
        uploadDao.saveUpload(u);
    }

    @Override
    public Integer checkOneUpload(Upload u) {
        return uploadDao.checkOneUpload(u);
    }

    @Override
    public void deleteUpload(Upload u) {

    }
}
