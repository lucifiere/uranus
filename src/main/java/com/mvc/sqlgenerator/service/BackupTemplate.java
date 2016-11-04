package com.mvc.sqlgenerator.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Created by XD.Wang on 2016/11/3.
 */
public class BackupTemplate {

    static String getBackupSql(String table, String query){
        if(query == null) return "";
        StringBuilder sb = new StringBuilder();
        String day = new SimpleDateFormat("yyMMdd").format(new Date());
        String backupTable = "backup_tables." + table + "_" + day;
        sb.append("\nCreate table backup_tables.").append(backupTable).append(" like ").append(table).append(";\n");
        sb.append("insert into ").append(backupTable).append("\n").append("select * from ").append(table).append(" ").append(query).append("\n");
        return sb.toString();
    }

}
