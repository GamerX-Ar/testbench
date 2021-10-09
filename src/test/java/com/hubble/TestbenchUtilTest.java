package com.hubble;

import com.hubble.data.Person;
import com.hubble.data.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

class TestbenchUtilTest {

    @Test
    void deleteDuplicates() {
        double[] array = {2,1,4,2,3};
        double[] expected = {1,4,2,3};
        Assertions.assertArrayEquals(expected, TestbenchUtil.deleteDuplicates(array));
    }

    @Test
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

    @Test
    void getMax() {
        List<Integer> list = Arrays.asList(5, 8, 9, 0, -5, 20, 10);
        Assertions.assertEquals(20, TestbenchUtil.getMax(list).orElse(null)); // Collections.max(list)
    }

    @Test
    void getOlderMan() {
        List<Person> persons = Arrays.asList(
                new Person("Alex", (byte) 27),
                new Person("Julia", (byte) 25),
                null,
                new Person("Jhon", (byte) 32)
        );

        Assertions.assertEquals("Jhon", TestbenchUtil.getOlderMan(persons).orElseThrow(RuntimeException::new).getName());
    }
}