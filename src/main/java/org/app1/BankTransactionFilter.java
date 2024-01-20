package org.app1;


/*
We have created this interface so that we could decouple the selection logic
from iteration logic in findTransactions
method in BankTransactionProcessor.java

So that the method findTransactions() can be extended for various selection criteria without modifying
existing code.
 */
@FunctionalInterface
public interface BankTransactionFilter {

    boolean test();
}
