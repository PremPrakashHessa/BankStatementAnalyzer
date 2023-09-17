package org.app1;

import org.domain.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionProcessor {

   private List<BankTransaction> transactions;

    public BankTransactionProcessor(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

   public double calculateTotalAmount(){
        double amount = 0d;
        for( BankTransaction tx : transactions) amount+= tx.getAmount();
        return amount ;
    }

     public double calculateTotalForMonth(Month month){
        double amount = 0d;
        for(BankTransaction tx : transactions)
            if(tx.getDate().getMonth().equals(month)) amount+= tx.getAmount();
        return amount;
    }

    public double calculateTotalForCategory(String category){
        double total = 0d;
        for(BankTransaction tx: transactions)
            if(tx.getDescription().equals(category)) total+= tx.getAmount();
        return total;
    }

}
