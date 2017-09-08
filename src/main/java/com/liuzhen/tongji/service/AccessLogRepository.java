package com.liuzhen.tongji.service;

import com.liuzhen.tongji.domain.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by liuzhen on 2017/9/6.
 */
public interface AccessLogRepository extends JpaRepository<AccessLog, String> {

    /**
     * 获取该网站总体pv
     *
     * @param host
     * @return
     */
    @Query("select count(id) from AccessLog where host = :host")
    long countByHost(@Param("host") String host);

    /**
     * 获取该网站总体pv
     *
     * @param host
     * @return
     */
    @Query(value = "select userId from AccessLog where host = :host group by userId")
    List countByHostGroupUser(@Param("host") String host);

    /**
     * 获取该网页总pv
     *
     * @param host
     * @return
     */
    @Query("select count(id) from AccessLog where url like %?1 ")
    long countByUrl(@Param("url") String url);

}
