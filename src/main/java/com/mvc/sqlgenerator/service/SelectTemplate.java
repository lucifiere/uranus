package com.mvc.sqlgenerator.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
public class SelectTemplate {

    public String getBaseSelectSql(ArrayList<String> select, HashMap<String, String> query, String table, String condition){
        if(select == null) return null;
        StringBuilder sb = new StringBuilder();
        if(query == null){
            sb.append("select ");
            for(String one : select){
                sb.append(one);
            }
            sb.append(table)
                    .append(" from ")
                    .append(table);
        }else{
            sb.append(" where")
                    .append(Utils.getConditionCombSql(query, condition));
        }
        return sb.toString();
    }

    public String getBaseConjSelectSql(ArrayList<String> select, HashMap<String, String> query, String table){
        return getBaseSelectSql(select, query, table, Patterns.AND);
    }

    public String getBaseDisjSelectSql(ArrayList<String> select, HashMap<String, String> query, String table){
        return getBaseSelectSql(select, query, table, Patterns.OR);
    }
}
