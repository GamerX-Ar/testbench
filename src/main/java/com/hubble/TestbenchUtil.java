package com.hubble;

import com.hubble.data.Transaction;
import java.util.*;
import java.util.stream.Collectors;

public final class TestbenchUtil {

    /**
     *
     * @param array
     * @return
     */
    public static double[] deleteDuplicates(double[] array) {
        Set<Double> set = new LinkedHashSet<>();

        for (int i = array.length - 1; i >= 0; i--) {
            if ( array[i] < 0 ) {
                throw new RuntimeException("Array item is less than zero: item index = " + i);
            }
            set.add(array[i]);
        }

        List<Double> list = new ArrayList<>(set);
        Collections.reverse(list);

        return list.stream().mapToDouble(Double::doubleValue).toArray();
    }

    /**
     *
      * @param transactionList
     * @return
     */
    static Map<String, Double> getAverageRefundMapByCurrency(List<Transaction> transactionList) {
        return transactionList.stream()
                .filter(t -> t.getType() == Transaction.Type.REFUND)
                .sorted(Comparator.comparing(Transaction::getCurrency))
                .collect(Collectors.groupingBy(Transaction::getCurrency, LinkedHashMap::new, Collectors.averagingDouble(Transaction::getAmount)));
    }

    /**
     *
     * @param list
     * @return
     */
    static Optional<Integer> getMax(List<Integer> list) {
        return list.stream().filter(Objects::nonNull).max(Integer::compareTo);
    }

}
