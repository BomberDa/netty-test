package com.bhb.nioserver.msgInfo.dao;

import com.bhb.nioserver.msgInfo.bean.MsgInfo;

public interface MsgInfoMapper {
    int deleteByPrimaryKey(Integer infoNo);

    int insert(MsgInfo record);

    int insertSelective(MsgInfo record);

    MsgInfo selectByPrimaryKey(Integer infoNo);

    int updateByPrimaryKeySelective(MsgInfo record);

    int updateByPrimaryKey(MsgInfo record);
}