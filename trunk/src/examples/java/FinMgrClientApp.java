import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.finmgr.dataaccess.DataAccessor;
import com.finmgr.model.Expense;
import com.finmgr.model.ExpenseType;

/**
 * @author rkannappan
 */
public class FinMgrClientApp {

   public static void main(String[] args) {
      try {
         printExpTypes();
         System.out.println();
         
         ExpenseType expType = new ExpenseType();
         expType.setName("UTILITIES");
         expType.setDesc("Expenses on electric bill");
         
         DataAccessor.addExpenseType(expType);
         
         expType = DataAccessor.getExpenseType("UTILITIES");
         System.out.println("Added expense type: " + expType.getName() + ", " + expType.getDesc());
         
         System.out.println();
         printExpTypes();
         
         System.out.println();
         Expense exp = new Expense();
         exp.setTypeName("UTILITIES");
         exp.setDate(new Date());
         exp.setAmount(132.23);
         int key = DataAccessor.addExpense(exp);
         System.out.println("Key of added expense: " + key);
         System.out.println("Key of added expense from obj: " + exp.getId());
         
         System.out.println();
         System.out.println("All Expenses");
         printExpenses("ALL");
         
         System.out.println();
         System.out.println("All Gas Expenses");
         printExpenses("GAS");
         
         DataAccessor.deleteExpense(exp);
         
         DataAccessor.deleteExpenseType(expType);
      }
      catch (SQLException  ex) {
         ex.printStackTrace();
      }
   }
   
   private static void printExpenses(String typeName) throws SQLException {
      System.out.println();
      List<Expense> expenses = DataAccessor.getExpenses(typeName);
      for (Expense expense : expenses) {
         ExpenseType expType = DataAccessor.getExpenseType(expense.getTypeName());
         System.out.println(expType.getName() + " - " + expense.getId() + ", " + expense.getDate() + ", " + expense.getAmount());
      }
   }
   
   private static void printExpTypes() throws SQLException {
      System.out.println("All Expense Types: " + DataAccessor.getExpenseTypeCount());
      System.out.println();
      List<ExpenseType> expTypes = DataAccessor.getAllExpenseTypes();
      for (ExpenseType expType : expTypes) {
         System.out.println(expType.getName() + ", " + expType.getDesc());
      }
   }
}