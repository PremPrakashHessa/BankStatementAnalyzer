package org.app1;

import org.domain.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionCsvParser {

    final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public  BankTransaction parseFromCSV(String line){

        String[] cols = line.split(",");
        LocalDate date = LocalDate.parse(cols[0], DATE_PATTERN);
        double amount = Double.parseDouble(cols[1]);
        String description = cols[2];
        return new BankTransaction(date, amount, description);
    }

    public  List<BankTransaction> parseLinesFromCSV(List<String> transactions){
        ArrayList<BankTransaction> bankTransactions = new ArrayList<>();
        for(String transaction : transactions)
            bankTransactions.add(parseFromCSV(transaction));
        return bankTransactions;
    }
}
