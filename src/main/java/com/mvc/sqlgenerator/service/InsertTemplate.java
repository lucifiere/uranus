package com.mvc.sqlgenerator.service;

import java.util.HashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
public class InsertTemplate {

    public String getBaseSelectSql(HashMap<String, String> query, String table){
        if(query == null || table == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ").append(table).append(" (");

        
        return sb.toString();
    }

}
