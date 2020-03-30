package com.bhb.nioserver.msgInfo.dao;

import com.bhb.nioserver.msgInfo.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * User: 39601
 * Date: 2019/12/10
 * Time: 9:35
 * Description:
 */
@Mapper
public interface UserInfoDao {
    public void insertUserInfo(UserInfo userInfo);
}
