package com.mvc.admin.controller

import com.alibaba.fastjson.JSON
import com.mvc.admin.common.HttpCode
import com.mvc.admin.common.ResponseMsg
import com.mvc.admin.pojo.User
import com.mvc.admin.service.UserService
import com.mvc.admin.vo.LoginInfo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

import javax.annotation.Resource

/**
 *  Created by Created by XD.Wang on 2016/10/20.
 */

@Controller
class LoginController {

    @Resource(name = 'userService')
    UserService userService

    @RequestMapping(value = '/login', method = RequestMethod.GET)
    public ModelAndView login(){
        new ModelAndView('login.ftl')
    }

    @RequestMapping(value = '/check', method = RequestMethod.POST)
    @ResponseBody
    public String check(LoginInfo info){
        User user =  userService.getUserByAccount(info.getAccount())
        String url = "/admin/index"
        int code =  user.getCipher() == info.getCipher() ? HttpCode.SUCCESS.getCode() : HttpCode.AUTHORIZATION_FAILED.getCode()
        Map r = [code: code,
                 url: url, token: user.getToken()]
        JSON.toJSONString(r)
    }

}
