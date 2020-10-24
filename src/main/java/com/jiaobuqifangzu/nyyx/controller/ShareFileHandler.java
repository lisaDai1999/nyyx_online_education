package com.jiaobuqifangzu.nyyx.controller;

import com.jiaobuqifangzu.nyyx.dao.repository.ShareFileRepository;
import com.jiaobuqifangzu.nyyx.domain.ShareFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChenXing
 * @date 2020/10/12 14:14
 */
@RestController
@RequestMapping("/share")
public class ShareFileHandler {
    @Autowired
    ShareFileRepository shareFileRepository;


    /**
     * 共享文件
     * @param shareFilesReq
     * @return
     */
    public ShareFiles addFiles(@RequestBody ShareFiles shareFilesReq){
        return null;
    }
}
