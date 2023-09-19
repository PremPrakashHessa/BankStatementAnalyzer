import org.app1.BankTransactionCsvParser;
import org.app1.IBankTransactionParser;
import org.domain.BankTransaction;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class BankTransactionCsvParserTest {

    @Test
    public void shouldParseOneLine(){
        IBankTransactionParser csvParser = new BankTransactionCsvParser();
        String line = "05-02-2017,-30,Cinema";
        BankTransaction bankTransaction = csvParser.parseFromCSV(line);

        LocalDate date = LocalDate.of(2017,2,5);
        double amount = -30d;
        String description = "Cinema";

        assertAll(
                () -> assertEquals(date, bankTransaction.getDate()),
                () -> assertEquals(amount, bankTransaction.getAmount()),
                () -> assertEquals(description, bankTransaction.getDescription())
        );
    }
}
