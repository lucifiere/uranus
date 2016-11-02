package com.mvc.sqlgenerator.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Created by XD.Wang on 2016/11/2.
 */

@Service
public class Analyzer {

    private static boolean inTable = false;

    public HashMap<String, HashSet> getTable(InputStream inputStream) {
        HashSet<String> colSet = null;
        HashMap<String, HashSet> grouped = new HashMap<String, HashSet>();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader r = new BufferedReader(reader);
        String line;
        try {
            while ((line = r.readLine()) != null) {
                if(isTableEnd(line)){
                    colSet = new HashSet<String>();
                    inTable = false;
                }
                String tableName = getTableName(line);
                if(tableName != null){
                    colSet = new HashSet<String>();
                    grouped.put(tableName, colSet);
                    inTable = true;
                }
                String colName = getSingleColName(line);
                if (inTable && colName != null) {
                    assert colSet != null;
                    colSet.add(colName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grouped;
    }

    private String getSingleColName(String line) {
        return isMatch(Patterns.COL, line) ?
                line.substring(line.indexOf("`") + 1, line.indexOf("`", line.indexOf("`") + 1)) : null;
    }

    private String getTableName(String line) {
        return isMatch(Patterns.TABLE_BEGIN, line) ?
                line.substring(line.indexOf("`") + 1, line.indexOf("`", line.indexOf("`") + 1)) : null;
    }

    private boolean isTableEnd(String line){
        return isMatch(Patterns.TABLE_END, line);
    }

    private boolean isMatch(String pattern, String line){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(line);
        return matcher.find();
    }
}
