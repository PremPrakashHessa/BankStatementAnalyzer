import org.app1.BankTransactionProcessor;
import org.junit.jupiter.api.*;

import  static org.junit.jupiter.api.Assertions.*;

public class BankTransactionProcessorTest {

    BankTransactionProcessor processor;
    @BeforeEach
    void init(){
        processor = new BankTransactionProcessor(null);
    }

    @Test
    @Disabled
    void testsMinimumAmountWithinSpecifiedDateRange (){
       double amount =  processor.minimumWithinDates(null , null);
        assertEquals(45.44 , amount);
    }
}
