package com.bhb.nioserver.controller;


import com.bhb.nioserver.msgInfo.bean.UserInfo;
import com.bhb.nioserver.msgInfo.service.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: 39601
 * Date: 2019/12/10
 * Time: 9:28
 * Description:
 */
@Controller
@RequestMapping("/test")
public class SomeController {
    @Autowired
    private UserInfoServiceImpl userInfoService;
    @PostMapping("/register")
    public String someHandler(UserInfo userInfo ){
        userInfoService.addUserInfo(userInfo);
        return "page/welcome";
    }
}
