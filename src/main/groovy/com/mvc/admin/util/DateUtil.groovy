package com.mvc.admin.util

import java.text.SimpleDateFormat

/**
 *  Created by Created by XD.Wang on 2016/10/21.
 */
class DateUtil {

    public static final CHINESE_FULL_PAT = 'yyyy年MM月dd日 HH时mm分ss秒'
    public static final SYMBOL_FULL_PAT = 'yyyy-MM-dd HH:mm:ss秒'
    public static final SYMBOL_SIMPLE_PAT = 'yyyy-MM-dd'
    public static final CHINESE_SIMPLE_PAT = 'yyyy年MM月dd日'

    public static String f(Date date, String pat){
        if(!date)
            return ''
        def sdf = new SimpleDateFormat(pat)
        sdf.format(date)
    }

}
