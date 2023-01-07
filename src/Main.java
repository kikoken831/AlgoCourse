import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Main {

    private ArrayQueue<Integer> arrayQueue;
    private TreeNode<Integer> root;

    private BST<Integer> bst;

    private MinHeap<Integer> minHeap;

    private ExternalChainingHashMap<Integer, Integer> map;

    @Before
    public void setHashMap(){
        map = new ExternalChainingHashMap<>();


    }
    @Test
    public void testHashMap() {
        map.put(0,0);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);
        map.put(6,6);
        map.put(7,7);
        assertEquals(8, map.size());
        assertEquals(0, (int) map.get(0));
        assertEquals(1, (int) map.get(1));
        assertEquals(2, (int) map.get(2));
        assertEquals(3, (int) map.get(3));
        assertEquals(4, (int) map.get(4));
        assertEquals(5, (int) map.get(5));
        assertEquals(6, (int) map.get(6));
        assertEquals(7, (int) map.get(7));
        map.put(8,8);
        assertEquals(8, (int) map.get(8));
        assertEquals(9, map.size());
        map.put(9,9);
        assertEquals(9, (int) map.get(9));
        assertEquals(10, map.size());
        map.put(10,10);
        assertEquals(10, (int) map.get(10));
        assertEquals(11, map.size());
        map.put(11,11);
        assertEquals(11, (int) map.get(11));
        assertEquals(12, map.size());
        map.put(12,12);
        assertEquals(12, (int) map.get(12));
        assertEquals(13, map.size());
        map.put(13,13);
        assertEquals(13, (int) map.get(13));
        assertEquals(14, map.size());
        map.put(14,14);
        assertEquals(14, (int) map.get(14));
        assertEquals(15, map.size());
        map.put(15,15);
        assertEquals(15, (int) map.get(15));
        assertEquals(16, map.size());
        map.put(16,16);
        assertEquals(16, (int) map.get(16));
        assertEquals(17, map.size());
        map.put(17,17);
        assertEquals(17, (int) map.get(17));
        assertEquals(18, map.size());
        map.put(18,18);
        assertEquals(18, (int) map.get(18));
        assertEquals(19, map.size());
        System.out.println(Arrays.toString(map.getTable()));
        map.remove(0);
        map.remove(1);
        map.remove(2);
        map.remove(3);
        map.remove(4);
        map.remove(5);
        map.remove(6);
        map.remove(7);
        map.remove(8);
        map.remove(9);
        map.remove(10);
        assertEquals(8, map.size());
        System.out.println(Arrays.toString(map.getTable()));
        map.put(0,0);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);
        map.put(6,6);
        map.put(7,7);
        System.out.println(Arrays.toString(map.getTable()));

    }

    @Test
    public void testHashMap2(){
        map.put(13,13);
        map.put(53,53);
        map.put(15,15);
        map.put(3,3);
        map.put(17,17);
        map.put(5,5);
        map.put(19,19);
        map.put(218,218);
        map.put(1,1);
        System.out.println(Arrays.toString(map.getTable()));
    }
    @Before
    public void setMinHeap() {
        minHeap = new MinHeap<Integer>();
    }

    @Test
    public void testMinHeapAdd(){
        minHeap.add(5);
        minHeap.add(6);
        minHeap.add(7);
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(8);
        minHeap.add(9);
        minHeap.add(2);
        minHeap.add(3);
        System.out.println(Arrays.toString(minHeap.getBackingArray()));
        assertEquals(9, (int) minHeap.remove());
        assertEquals(8, (int) minHeap.remove());
        assertEquals(7, (int) minHeap.remove());
        assertEquals(6, (int) minHeap.remove());
        assertEquals(5, (int) minHeap.remove());
        assertEquals(4, (int) minHeap.remove());
        assertEquals(3, (int) minHeap.remove());
        assertEquals(2, (int) minHeap.remove());
        assertEquals(1, (int) minHeap.remove());



    }
    @Before
    public void setUpBST(){
        bst = new BST<>();
        bst.add(50);
        bst.add(15);
        bst.add(75);
        bst.add(100);
        bst.add(5);
        bst.add(10);
    }

    @Test
    public void testBSTGet(){
        assertEquals(50, (int) bst.get(50));
        assertEquals(15, (int) bst.get(15));
        assertEquals(75, (int) bst.get(75));
        assertEquals(100, (int) bst.get(100));
        assertEquals(5, (int) bst.get(5));
        assertEquals(10, (int) bst.get(10));
    }

    @Test
    public void testBSTAdd() {
        assertEquals(3, bst.size());
        bst.add(25);
        assertEquals(4, bst.size());
        bst.add(15);
        assertEquals(4, bst.size());
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] hash = new char[26];
            for (char c : str.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    @Test
    public void testGroupAnagrams(){
        String[] strs2 = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> list2 = groupAnagrams(strs2);
        System.out.println(list2);
    }

    @Test
    public void testPES(){
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }

    public static Sorting sorting;
    @Test
    public void testBubbleSort(){
        //declare an array of integers
        Integer[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11};
        //sort the array
        sorting.bubbleSort(array, (a,b) -> a.compareTo(b));
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
    public static void main(String[] args) {


        System.out.println("Hello world!");
    }
}