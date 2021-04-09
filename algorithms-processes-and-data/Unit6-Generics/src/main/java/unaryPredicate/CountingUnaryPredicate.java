package unaryPredicate;

/**
 *  @author Wasim Ramzan
 *  @version October 2020
 */

public abstract class CountingUnaryPredicate <T extends Comparable<? super T>> implements UnaryPredicateCount<T>{

    @Override
    public int numberSatisfying(T[] array) {
        int count = 0;
        for(Comparable elem : array){
            if(test((T) elem)) {
                count++;
            }
        }
        return count;
    }
}
