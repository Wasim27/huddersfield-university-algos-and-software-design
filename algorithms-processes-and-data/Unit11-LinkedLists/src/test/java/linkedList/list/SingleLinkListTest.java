package linkedList.list;

import arrayGenerator.generator.ArrayGenerator;
import arrayGenerator.generator.IntegerArrayGenerator;
import arrayGenerator.scope.IntegerScope;
import arrayGenerator.scope.Scope;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkListTest {
    Scope<Integer> scope = new IntegerScope(1000);
    ArrayGenerator<Integer> generator = new IntegerArrayGenerator(scope);
    Random random = new Random();
    Class<? extends Integer> integerClass = new Integer(0).getClass();

    public void testSize(int size) throws ListAccessError {
        Integer[] array = generator.getArray(size);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        list = list.fromArray(array);
        assertEquals(array.length,list.size(),"List does not have the required size");
    }

    public void testRemove(int size,int index) throws ListAccessError {
        Integer[] array = generator.getArray(size);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        list = list.fromArray(array);
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        Collections.addAll(javaList,array);
        int toAdd = scope.getValue();
        Integer fromList = list.remove(index);
        Integer fromJavaList = javaList.remove(index);
        javaList.removeAll(Collections.singleton(null));
        assertEquals(fromJavaList,fromList,"Remove behaviour does not match that of Java's lists\n" +
                "Java list removed : " + fromJavaList + "\n" +
                "List list removed : " + fromList);
        assertArrayEquals(javaList.toArray(new Integer[javaList.size()]),list.toArray(integerClass),"Remove behaviour does not match that of Java's lists\n" +
                "Java list after remove: " + Arrays.toString(javaList.toArray(array)) + "\n" +
                "List list after remove: " + Arrays.toString(list.toArray(integerClass)));

    }

    public void testRemove(int size) throws ListAccessError {
        testRemove(size,random.nextInt(size));
    }

    public void testAdd(int size,int index) throws ListAccessError {
        Integer[] array = generator.getArray(size);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        list = list.fromArray(array);
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        Collections.addAll(javaList,array);
        int toAdd = scope.getValue();
        list.add(index,toAdd);
        javaList.add(index,toAdd);
        assertArrayEquals(javaList.toArray(array),list.toArray(integerClass),"Add behaviour does not match that of Java's lists\n" +
                "Java list after add: " + Arrays.toString(javaList.toArray(array)) + "\n" +
                "List list after add: " + Arrays.toString(list.toArray(integerClass)));

    }

    public void testAdd(int size) throws ListAccessError {
        testAdd(size,random.nextInt(size));
    }

    public void testGet(int size,int index) throws ListAccessError {
        Integer[] array = generator.getArray(size);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        list = list.fromArray(array);
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        Collections.addAll(javaList,array);
        int toAdd = scope.getValue();
        list.add(index,toAdd);
        javaList.add(index,toAdd);
        assertEquals(javaList.get(index),list.get(index),"Get behaviour does not match that of Java's lists\n" +
                "Java list got : " + javaList.get(index) + "\n" +
                "List list got : " + list.get(index));

    }

    public void testGet(int size) throws ListAccessError {
        testGet(size,random.nextInt(size));
    }

    @Test
    public void testSmallSize() throws ListAccessError {
        testSize(5);
    }

    @Test
    public void testLargeSize() throws ListAccessError {
        testSize(500);
    }

    @Test
    public void testEmptySize() throws ListAccessError {
        testSize(0);
    }

    @Test
    public void testSmallAdd() throws ListAccessError {
        testAdd(5);
    }

    @Test
    public void testLargeAdd() throws ListAccessError {
        testAdd(500);
    }

    @Test
    public void testEmptyAdd() throws ListAccessError {
        Integer toAdd = scope.getValue();
        Integer[] array = {toAdd};
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        list.add(0,toAdd);
        assertArrayEquals(array,list.toArray(integerClass),"Add behaviour does not match that of Java's lists\n" +
                "Java array: " + array + "\n" +
                "List array: " + list.toString(10));
    }

    @Test
    public void testAddZeroIndex() throws ListAccessError {
        testAdd(random.nextInt(100)+1,0);
    }

    @Test
    public void testAddLimitIndex() throws ListAccessError {
        int size = random.nextInt(100)+1;
        testAdd(size,size);
    }

    @Test
    public void testAddNegativeIndex() throws ListAccessError {
        Integer[] array = generator.getArray(10);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        SingleLinkList<Integer> finalList = list.fromArray(array);
        assertThrows(ListAccessError.class,()-> finalList.add(-1,0));
    }

    @Test
    public void testAddOutOfBoundsIndex() throws ListAccessError {
        Integer[] array = generator.getArray(10);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        SingleLinkList<Integer> finalList = list.fromArray(array);
        assertThrows(ListAccessError.class,()-> finalList.add(11,0));
    }

    @Test
    public void testSmallGet() throws ListAccessError {
        testGet(5);
    }

    @Test
    public void testLargeGet() throws ListAccessError {
        testGet(500);
    }

    @Test
    public void testEmptyGet() throws ListAccessError {
        Integer toAdd = scope.getValue();
        Integer[] array = {toAdd};
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        assertThrows(ListAccessError.class,()->list.get(0));
    }

    @Test
    public void testGetZeroIndex() throws ListAccessError {
        testGet(random.nextInt(100)+1,0);
    }

    @Test
    public void testGetLimitIndex() throws ListAccessError {
        int size = random.nextInt(100)+1;
        testGet(size,size-1);
    }

    @Test
    public void testGetNegativeIndex() throws ListAccessError {
        Integer[] array = generator.getArray(10);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        SingleLinkList<Integer> finalList = list.fromArray(array);
        assertThrows(ListAccessError.class,()-> finalList.get(-1));
    }

    @Test
    public void testGetOutOfBoundsIndex() throws ListAccessError {
        Integer[] array = generator.getArray(10);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        SingleLinkList<Integer> finalList = list.fromArray(array);
        assertThrows(ListAccessError.class,()-> finalList.get(10));
    }

    @Test
    public void testSmallRemove() throws ListAccessError {
        testRemove(5);
    }

    @Test
    public void testLargeRemove() throws ListAccessError {
        testRemove(500);
    }

    @Test
    public void testEmptyRemove() throws ListAccessError {
        Integer toAdd = scope.getValue();
        Integer[] array = {toAdd};
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        assertThrows(ListAccessError.class,()->list.remove(0));
    }

    @Test
    public void testRemoveZeroIndex() throws ListAccessError {
        testRemove(random.nextInt(100)+1,0);
    }

    @Test
    public void testRemoveLimitIndex() throws ListAccessError {
        int size = random.nextInt(100)+1;
        testRemove(size,size-1);
    }

    @Test
    public void testRemoveNegativeIndex() throws ListAccessError {
        Integer[] array = generator.getArray(10);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        SingleLinkList<Integer> finalList = list.fromArray(array);
        assertThrows(ListAccessError.class,()-> finalList.remove(-1));
    }

    @Test
    public void testRemoveOutOfBoundsIndex() throws ListAccessError {
        Integer[] array = generator.getArray(10);
        SingleLinkList<Integer> list = new SingleLinkList<Integer>();
        SingleLinkList<Integer> finalList = list.fromArray(array);
        assertThrows(ListAccessError.class,()-> finalList.remove(10));
    }
}