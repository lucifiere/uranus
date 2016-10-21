package com.mvc.admin.controller

import com.mvc.admin.pojo.OperateLog
import com.mvc.admin.pojo.Statics
import com.mvc.admin.pojo.Word
import com.mvc.admin.service.OperateLogService
import com.mvc.admin.service.StaticsService
import com.mvc.admin.service.UserService
import com.mvc.admin.service.WordService
import com.mvc.admin.util.DateUtil
import com.mvc.admin.vo.OperateLogVo
import com.mvc.admin.vo.UserVo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

import javax.annotation.Resource

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */

@Controller
@RequestMapping('/admin')
class AdminController {

    @Resource
    UserService userService
    @Resource
    StaticsService staticsService
    @Resource
    WordService wordService
    @Resource
    OperateLogService operateLogService

    @RequestMapping(value = '/index', method = RequestMethod.POST)
    public ModelAndView login(String token){

        UserVo userInfo = userService.getUserByToken(token)
        Statics statics = staticsService.getStaticsByDate(new Date().format(DateUtil.SYMBOL_SIMPLE_PAT))
        Word word = wordService.getLeaveWord()
        List<OperateLogVo> logList = operateLogService.getOperateLog4Admin()
        List<UserVo> userList = userService.getUser4Admin()

        def mv = new ModelAndView('admin-index.ftl')
        mv.addObject("statics", statics)
        mv.addObject("logList", logList)
        mv.addObject("word", word)
        mv.addObject("userInfo", userInfo)
        mv.addObject("userList", userList)
        mv
    }

}
