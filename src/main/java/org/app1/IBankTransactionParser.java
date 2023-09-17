package org.app1;

import org.domain.BankTransaction;

import java.time.format.DateTimeFormatter;
import java.util.List;

public interface IBankTransactionParser {

   // final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
     BankTransaction parseFromCSV(String line);
     List<BankTransaction> parseLinesFromCSV(List<String> transactions);
}
