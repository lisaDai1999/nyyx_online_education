package com.jiaobuqifangzu.nyyx.dao.repository;

import com.jiaobuqifangzu.nyyx.domain.ShareFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/12 14:13
 */
public interface ShareFileRepository extends JpaRepository<ShareFiles, Integer>, JpaSpecificationExecutor<ShareFiles> {

//    public List<ShareFiles> findShareFilesByShareFileId(Integer id);
}
