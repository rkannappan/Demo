package com.finmgr;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * @author rkannappan
 */
public class FinMgrSqlConfig {
   
   private static final SqlMapClient SQL_MAPPER;
   
   static {
      try {
         Reader reader = Resources.getResourceAsReader("sqlmaps/SqlMapConfig.xml");
         SQL_MAPPER = SqlMapClientBuilder.buildSqlMapClient(reader);
         reader.close();
       } 
      catch (IOException e) {
         throw new RuntimeException("Unable to create SqlMapClient instance: " + e.getMessage(), e);
       }
   }
   
   public static SqlMapClient getSqlMapper() {
      return SQL_MAPPER;
   }

}