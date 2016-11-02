package com.mvc.sqlgenerator.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
public class DeleteTemplate {

    public String getBaseDeleteSql(HashMap<String, String> query, String table, String condition){
        StringBuilder sb = new StringBuilder();
        if(query == null){
            sb.append("delete from ").append(table);
        }else{
            sb.append(" where")
                    .append(Utils.getConditionCombSql(query, condition));
        }
        return sb.toString();
    }

    public String getBaseConjSelectSql(HashMap<String, String> query, String table){
        return getBaseDeleteSql(query, table, Patterns.AND);
    }

    public String getBaseDisjSelectSql(ArrayList<String> select, HashMap<String, String> query, String table){
        return getBaseDeleteSql(query, table, Patterns.OR);
    }

}
