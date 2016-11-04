package com.mvc.sqlgenerator.service;

import java.util.LinkedHashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
public class UpdateTemplate {

    public String getBaseUpdateSql(LinkedHashMap<String, String> update, LinkedHashMap<String, String> query, String table, String condition){
        if(update == null) return null;
        StringBuilder sb = new StringBuilder();
        String queryStr;
        if(query == null){
            sb.append("update ")
                    .append(table)
                    .append(" set ")
                    .append(Utils.getGeneralCombSql(update));
        }else{
            queryStr = "where" + Utils.getConditionCombSql(query, condition);
            sb.append(queryStr);
        }
        return sb.toString();
    }

    public String getBaseConjUpdateSql(LinkedHashMap<String, String> update, LinkedHashMap<String, String> query, String table){
        return getBaseUpdateSql(update, query, table, Patterns.AND);
    }

    public String getBaseDisjUpdateSql(LinkedHashMap<String, String> update, LinkedHashMap<String, String> query, String table){
        return getBaseUpdateSql(update, query, table, Patterns.OR);
    }

}
