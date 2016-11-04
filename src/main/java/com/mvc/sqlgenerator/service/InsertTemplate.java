package com.mvc.sqlgenerator.service;

import java.util.LinkedHashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
public class InsertTemplate {

    public String getBaseInsertSql(LinkedHashMap<String, String> query, String table){
        if(query == null || table == null) return null;
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ").append(table).append(" (");
        for(String one : query.keySet()){
            if(isFirst){
                sb.append(one);
                isFirst = false;
            }else{
                sb.append(",").append(one);
            }
        }
        sb.append(")");
        sb.append(" values ");
        sb.append("(");
        for(String one : query.keySet()){
            if(isFirst){
                sb.append("\'").append(query.get(one)).append("\'");
                isFirst = false;
            }else{
                sb.append(",").append("\'").append(query.get(one)).append("\'");
            }
        }
        sb.append(")");

        return sb.toString();
    }

}
