package com.finmgr.model;

/**
 * @author rkannappan
 */
public class ExpenseType {
   private String name_;
   private String desc_;
   
   public String getName() {
      return name_;
   }
   
   public void setName(String name) {
      this.name_ = name;
   }
   
   public String getDesc() {
      return desc_;
   }
   
   public void setDesc(String desc) {
      this.desc_ = desc;
   }
}