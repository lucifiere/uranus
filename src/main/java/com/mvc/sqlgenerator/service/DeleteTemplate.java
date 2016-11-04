package com.mvc.sqlgenerator.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
public class DeleteTemplate {

    public String getBaseDeleteSql(LinkedHashMap<String, String> query, String table, String condition){
        StringBuilder sb = new StringBuilder();
        if(query == null){
            sb.append("delete from ").append(table);
        }else{
            sb.append(" where")
                    .append(Utils.getConditionCombSql(query, condition));
        }
        return sb.toString();
    }

    public String getBaseConjSelectSql(LinkedHashMap<String, String> query, String table){
        return getBaseDeleteSql(query, table, Patterns.AND);
    }

    public String getBaseDisjSelectSql(ArrayList<String> select, LinkedHashMap<String, String> query, String table){
        return getBaseDeleteSql(query, table, Patterns.OR);
    }

}
