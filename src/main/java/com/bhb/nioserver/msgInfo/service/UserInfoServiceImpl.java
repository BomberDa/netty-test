package com.bhb.nioserver.msgInfo.service;

import com.bhb.nioserver.msgInfo.bean.UserInfo;
import com.bhb.nioserver.msgInfo.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: 39601
 * Date: 2019/12/10
 * Time: 9:33
 * Description:
 */
@Service
public class UserInfoServiceImpl{
    @Autowired
    private UserInfoDao dao;
    @Transactional
    public void addUserInfo(UserInfo userInfo) {
        dao.insertUserInfo(userInfo);
    }
}
