package org.app1;

import org.domain.BankTransaction;

import java.time.LocalDate;
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


    public double minimumWithinDates(LocalDate startDate, LocalDate endDate) {
        double minimumAmount = Double.MAX_VALUE;

        for(BankTransaction transaction : transactions){
            if( (transaction.getDate().isEqual(startDate) || transaction.getDate().isAfter(startDate)) &&
                (transaction.getDate().isEqual(endDate)   || transaction.getDate().isBefore(endDate))     )
            {
                if(minimumAmount > transaction.getAmount()) minimumAmount = transaction.getAmount();
            }
        }
        return minimumAmount;
    }

    public double maximumWithinDates(LocalDate startDate, LocalDate endDate) {
        double maximumAmount = Double.MIN_VALUE;

        for(BankTransaction transaction : transactions){
            if( (transaction.getDate().isEqual(startDate) || transaction.getDate().isAfter(startDate)) &&
                    (transaction.getDate().isEqual(endDate)   || transaction.getDate().isBefore(endDate))     )
            {
                if(maximumAmount < transaction.getAmount()) maximumAmount = transaction.getAmount();
            }
        }
        return maximumAmount;
    }
}
