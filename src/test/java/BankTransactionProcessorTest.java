import org.app1.BankTransactionProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import  static org.junit.jupiter.api.Assertions.*;

public class BankTransactionProcessorTest {

    BankTransactionProcessor processor;
    @BeforeEach
    void init(){
        processor = new BankTransactionProcessor(null);
    }

    @Test
    void testsMinimumAmountWithinSpecifiedDateRange (){
       double amount =  processor.minimumWithinDates(null , null);
        assertEquals(45.44 , amount);
    }
}
