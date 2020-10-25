package com.jiaobuqifangzu.nyyx.dao.repository;

import com.jiaobuqifangzu.nyyx.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    public User findByUsernameAndPassword(String username, String password);

    public User findByUsername(String username);

    //public User (String phonenum , String password);

    public User findByPhoneNumAndPassword(String phonenum , String password);
    public User findByPhoneNum(String phonenum);

    public User findUserById(Integer id);
    
    /**
     * 根据username模糊查询
     * 
     * 编写人：戴礼霞
     */
    @Query(value = "SELECT * FROM user WHERE username LIKE %?1% ORDER BY create_time DESC", nativeQuery = true)
    public List<User> findAllByNameLike(@Param("username") String username);
}
