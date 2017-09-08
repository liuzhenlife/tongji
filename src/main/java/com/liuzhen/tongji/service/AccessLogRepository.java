package com.liuzhen.tongji.service;

import com.liuzhen.tongji.domain.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * Created by liuzhen on 2017/9/6.
 */
public interface AccessLogRepository extends JpaRepository<AccessLog, String> {

}
