package com.mvc.sqlgenerator.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *  Created by XD.Wang on 2016/11/3.
 */
public class DataVo {

    private LinkedHashMap query;
    private LinkedHashMap update;
    private ArrayList select;
    private String table;
    private int condition;

    public LinkedHashMap getQuery() {
        return query;
    }

    public void setQuery(LinkedHashMap query) {
        this.query = query;
    }

    public LinkedHashMap getUpdate() {
        return update;
    }

    public void setUpdate(LinkedHashMap update) {
        this.update = update;
    }

    public ArrayList getSelect() {
        return select;
    }

    public void setSelect(ArrayList select) {
        this.select = select;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
