package com.finmgr.dataaccess;

import java.sql.SQLException;
import java.util.List;

import com.finmgr.FinMgrSqlConfig;
import com.finmgr.model.Expense;
import com.finmgr.model.ExpenseType;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author rkannappan
 */
public class DataAccessor {
   
   private static final SqlMapClient SQL_MAPPER = FinMgrSqlConfig.getSqlMapper();
   
   public static List<ExpenseType> getAllExpenseTypes() throws SQLException {
      return SQL_MAPPER.queryForList("ExpenseType.selectAllExpTypes");
   }
   
   public static Integer getExpenseTypeCount() throws SQLException {
      return (Integer) SQL_MAPPER.queryForObject("ExpenseType.countExpTypes");
   }
   
   public static ExpenseType getExpenseType(String typeName) throws SQLException {
      return (ExpenseType) SQL_MAPPER.queryForObject("ExpenseType.selectExpTypeByName", typeName);
   }
   
   public static void addExpenseType(ExpenseType expType) throws SQLException {
      SQL_MAPPER.insert("ExpenseType.addExpType", expType);
   }
   
   public static void deleteExpenseType(ExpenseType expType) throws SQLException {
      SQL_MAPPER.delete("ExpenseType.deleteExpType", expType);
   }
   
   public static List<Expense> getExpenses(String expTypeName) throws SQLException {
      if (expTypeName.equalsIgnoreCase("ALL")) {
         return SQL_MAPPER.queryForList("Expense.selectAllExpenses");
      }
      
      return SQL_MAPPER.queryForList("Expense.selectExpensesByTypeName", expTypeName);
   }
   
   public static Integer addExpense(Expense expense) throws SQLException {
      return (Integer) SQL_MAPPER.insert("Expense.addExpense", expense);
   }
   
   public static void deleteExpense(Expense expense) throws SQLException {
      SQL_MAPPER.delete("Expense.deleteExpense", expense.getId());
   }   
}