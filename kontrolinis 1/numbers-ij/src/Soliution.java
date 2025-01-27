import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;

public class Soliution implements Exercises {
    @Override
    public Integer findSmallest(List<Integer> list) {
        int smallest = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > smallest) {
                smallest = i;
            }
        }
        return smallest;
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        int maxValue = Collections.max(list);
        return maxValue;
    }

    @Override
    public boolean isEqual(Object o, Object o1) {

        return (o == o1) || (o != null && o.equals(o1));
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return (o == o1) || (o != null && o.equals(o1));
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    @Override
    public int computeSumOfNumbers(int i) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int i, NumberFilter numberFilter) {
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            if (numberFilter.accept(j)) {
                sum += j;
            }
        }
        return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int i) {
        List<Integer> result = new ArrayList<>();
        for (int j = 1; j < i; j++) {
            result.add(j);
        }
        return result;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (Integer number : list)
            occurrence.put(number, occurrence.getOrDefault(number, 0) + 1);
        return occurrence;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {

        return new IntegerGenerator() {
            private int next = i;
            @Override
            public Integer getNext() {
                   if ( next <= i1){
                       return next++;
                   }
                return null;
            }
        };
    }


    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return new IntegerGenerator() {
            @Override
            public Integer getNext() {
                Integer another = integerGenerator.getNext();
                if (another != null && !numberFilter.accept(another)){
                    return integerGenerator.getNext();
                }
                return another;
            }
        };
    }
}
