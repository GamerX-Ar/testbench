package com.hubble;

import com.hubble.data.Transaction;
import org.junit.jupiter.api.Assertions;
import java.util.*;

class TestbenchUtilTest {

    @org.junit.jupiter.api.Test
    void deleteDuplicates() {
        double[] array = {2,1,4,2,3};
        double[] expected = {1,4,2,3};
        Assertions.assertArrayEquals(expected, TestbenchUtil.deleteDuplicates(array));
    }

    @org.junit.jupiter.api.Test
    void getAverageRefundMapByCurrency() {
        List<Transaction> transactionList = Arrays.asList(
                new Transaction(Transaction.Type.REFUND, "EUR", 2000L),
                new Transaction(Transaction.Type.REFUND, "USD", 15L),
                new Transaction(Transaction.Type.REFUND, "RUB", 200L),
                new Transaction(Transaction.Type.PAYMENT, "RUB", 1250L),
                new Transaction(Transaction.Type.REFUND, "USD", 35L),
                new Transaction(Transaction.Type.PAYMENT, "USD", 55L),
                new Transaction(Transaction.Type.REFUND, "RUB", 100L)
        );

        Map<String, Double> expected = new LinkedHashMap<>();
        expected.put("EUR", 2000.0);
        expected.put("RUB", 150.0);
        expected.put("USD", 25.0);

        Map<String, Double> actual = TestbenchUtil.getAverageRefundMapByCurrency(transactionList);

        Assertions.assertEquals(expected.entrySet(), actual.entrySet());
    }
}