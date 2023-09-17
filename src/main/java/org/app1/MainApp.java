package org.app1;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {

        BankTransactionAnlayzer bankTransactionAnlayzer = new BankTransactionAnlayzer();
        try {
            bankTransactionAnlayzer.analyze(args[0],new BankTransactionCsvParser());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
