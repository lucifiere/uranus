package com.mvc.sqlgenerator.service;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Created by XD.Wang on 2016/11/2.
 */
public class UpdateTemplate {

    public String getBaseUpdateSql(HashMap<String, String> update, HashMap<String, String> query, String table, String condition){
        if(update == null) return null;
        StringBuilder sb = new StringBuilder();
        if(query == null){
            sb.append("update ")
                    .append(table)
                    .append(" set ")
                    .append(Utils.getGeneralCombSql(update));
        }else{
            sb.append(" where")
                    .append(Utils.getConditionCombSql(query, condition));
        }
        return sb.toString();
    }

    public String getBaseConjUpdateSql(HashMap<String, String> update, HashMap<String, String> query, String table){
        return getBaseUpdateSql(update, query, table, Patterns.AND);
    }

    public String getBaseDisjUpdateSql(HashMap<String, String> update, HashMap<String, String> query, String table){
        return getBaseUpdateSql(update, query, table, Patterns.OR);
    }

}
