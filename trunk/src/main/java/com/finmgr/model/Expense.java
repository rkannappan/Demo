package com.finmgr.model;

import java.util.Date;

/**
 * @author rkannappan
 */
public class Expense {
   private int id_;
   private String typeName_;
   private Date date_;
   private double amount_;
   
   public int getId() {
      return id_;
   }
   
   public void setId(int id) {
      this.id_ = id;
   }
   
   public String getTypeName() {
      return typeName_;
   }
   
   public void setTypeName(String typeName) {
      this.typeName_ = typeName;
   }
   
   public Date getDate() {
      return date_;
   }
   
   public void setDate(Date date) {
      this.date_ = date;
   }
   
   public double getAmount() {
      return amount_;
   }
   
   public void setAmount(double amount) {
      this.amount_ = amount;
   }
}