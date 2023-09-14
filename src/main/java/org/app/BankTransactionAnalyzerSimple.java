package org.app;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
* in adhering to the KISS principle (KEEP IT SIMPLE STUPID)
* coding in single class the first requirement
* WHETHER THERE IS A PROFIT OR LOSS , AFTER ANALYZING ALL TRANSACTIONS
* */
public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";
    public static void main(String[] args) throws IOException {

        //the path of csv file downloaded from bank website
        Path path = Path.of(RESOURCES + args[0]);

        //reading all lines of transactions
        List<String> transactions = Files.readAllLines(path);

        //splitting transaction lines based on , delimiter and extracting the amount info from it
        double total = 0.0;
        for ( String line : transactions) {
           total += Double.parseDouble(line.split(",")[1]);
        }

        String result = (total > 0) ? "profit" : (total < 0 ? "loss" : "neither") ;
        System.out.println("So you incurred " + result + " of amount : "+ total);

    }
}
