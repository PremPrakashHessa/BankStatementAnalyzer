package org.app1;

import org.domain.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionProcessor {
    double calculateTotalAmount(List<BankTransaction> transactions){
        double amount = 0d;
        for( BankTransaction tx : transactions) amount+= tx.getAmount();
        return amount ;
    }

    static List<BankTransaction> selectInMonth(List<BankTransaction> allTransactions , Month month){
        List<BankTransaction> transactions = new ArrayList<>();
        for(BankTransaction tx : allTransactions)
            if(tx.getDate().getMonth().equals(month)) transactions.add(tx);

        return transactions;
    }
}
