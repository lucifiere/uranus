package com.mvc.sqlgenerator.service;

import java.util.LinkedHashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
class Utils {

    static String getGeneralCombSql(LinkedHashMap<String, String> info){
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String key : info.keySet()){
            if(isFirst){
                sb.append(key).append("=").append(info.get(key));
                isFirst = false;
            }else{
                sb.append(",").append(key).append("=").append("\'").append(info.get(key)).append("\'");
            }
        }
        return sb.toString();
    }

    static String getConditionCombSql(LinkedHashMap<String, String> info, String condition){
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String key : info.keySet()){
            if(isFirst){
                sb.append(key).append("=").append(info.get(key));
                isFirst = false;
            }else{
                sb.append(condition).append(" ").append(key).append("=").append("\'").append(info.get(key)).append("\'");
            }
        }
        return sb.toString();
    }



}
