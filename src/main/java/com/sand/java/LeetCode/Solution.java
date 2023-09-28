package com.sand.java.LeetCode;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    //1
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, nums.length - 1};
    }

    //2
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        List<Integer> list2 = new ArrayList<>();
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        if (list1.size() > list2.size()) {
            a = list1;
            b = list2;
        } else {
            a = list2;
            b = list1;
        }
        List<Integer> n = new ArrayList<>();
        int c = 0;
        int rem = 0;
        for (Integer i : b) {
            if (i + a.get(c) + rem < 10) {
                n.add(i + a.get(c) + rem);
                rem = 0;
            } else {
                n.add((i + a.get(c) + rem) % 10);
                rem = 1;
            }
            c++;
        }
        for (int i = c; i < a.size(); i++) {
            if (a.get(i) + rem < 10) {
                n.add(a.get(i) + rem);
                rem = 0;
            } else {
                n.add((a.get(i) + rem) % 10);
                rem = 1;
            }

            //n.add(a.get(i));
        }
        if (rem == 1) {
            n.add(1);
        }
        //Collections.reverse(n);
        ListNode r = new ListNode();
        ListNode hea = r;
        for (Integer i : n) {
            if (r.next == null) {
                r.next = new ListNode(i);
                r = r.next;
            }
        }
        r = hea;
        return r.next;
    }

    //3
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.trim().length() == 0) return 1;
        Set<String> l = new HashSet<>();
        Predicate<String> hasNoDuplicates = x -> x.chars().distinct().count() == x.length();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (hasNoDuplicates.test(s.substring(i, j + 1))) l.add(s.substring(i, j + 1));
            }
        }


        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                System.out.println("char at right " + s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                System.out.println(maxLength + " " + left + " " + right + " " + set);
            } else {
                System.out.println("char at left " + s.charAt(left) + " char at right " + s.charAt(right));
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    System.out.println("char at left " + s.charAt(left));

                    left++;
                    System.out.println(maxLength + " " + left + " " + right + " " + set);
                }
                set.remove(s.charAt(left));
                left++;
                System.out.println("char at left " + s.charAt(left));
                set.add(s.charAt(right));
                System.out.println("char at right " + s.charAt(right));
                System.out.println(maxLength + " " + left + " " + right + " " + set);

            }

        }
        return maxLength;


//        return l.stream().filter(hasNoDuplicates).sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList()).get(0).length();
    }

    //4
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double m = 0;
        int arr[] = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
        Arrays.sort(arr);
        if (arr.length % 2 != 0) {
            m = arr[arr.length / 2];
        } else {
            int a = 0, b = 0;
            a = arr.length / 2;
            b = a - 1;
            m = (double) (arr[a] + arr[b]) / 2;
        }
        return m;
    }

    //5
    public static String longestPalindrome(String s) {
        Predicate<String> isPalindrome = x -> new StringBuilder(x).reverse().toString().equals(x);
        List<String> l = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String a = s.substring(i, j + 1);
                System.out.println(a);
                if (isPalindrome.test(a)) l.add(a);
            }
        }
        System.out.println(l);
        return l.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList()).get(0);

    }

    //7
    public static int reverse(int x) {
        String s = "";
        try {
            if (x < 0)
                return Integer.parseInt("-" + new StringBuilder(String.valueOf(x)).reverse().toString().replace("-", ""));
            else return Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
        } catch (Exception e) {
            return 0;
        }
    }

    //8
    public static int myAtoi(String s) {
        if (!Character.isDigit(s.trim().replace("-", "").toCharArray()[0])) return 0;
        s = s.trim().replaceAll("[^0-9+-.]", "");
        int x = 0;
        try {
            x = Integer.parseInt(s);
        } catch (Exception e) {
            return Integer.MIN_VALUE;
        }
        return x;
    }

    //10
    public static boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    //14
    public static String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for (String i : strs) {
            int c = 0;
            System.out.println(i);
            for (String j : common.split("")) {
                if (i.split("").length > c) {
                    if (!i.split("")[c].contains(j)) {
                        System.out.println("contains " + i + " j " + j);
                        common = common.replaceFirst(common.substring(c), "");
                        System.out.println(common);
                        break;
                    }
                } else if (common.equals("")) {
                    return "";
                }
                c++;
            }
        }
        return common;
    }

    //23
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode current = head;

        for (ListNode i: lists) {
            while (i !=null) {
                ListNode n = new ListNode(i.val);
                while (head!=null) {
                    if (n.val <=head.val) {

                    }
                    head.next = n;

                    head = head.next;
                }
                head.next = n;
                head = n;
                i=i.next;
            }
        }
        head = current;
        return head.next;
    }

    //26
    public static int removeDuplicates(int[] nums) {

        int[] newInt = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(newInt, 0, nums, 0, newInt.length);
        return newInt.length;
    }

    //27
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int removeElement(int[] nums, int val) {
        int c = 0;
        int s[] = Arrays.stream(nums).filter(i -> i != val).toArray();
        for (int i = 0; i < s.length; i++) {
            nums[i] = s[i];
        }

        System.arraycopy(Arrays.stream(nums).filter(i -> i != val).toArray(), 0, nums, 0, Arrays.stream(nums).filter(i -> i != val).toArray().length);

        return s.length;
    }

    //34
    public int[] searchRange(int[] nums, int target) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        if (list.isEmpty()) return new int[]{-1, -1};
        else return new int[]{list.get(0), list.get(list.size() - 1)};
    }

    //35
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            else if (nums[i] > target) {
                return i - 1;
            }
        }
        return -1;

    }

    //55
    public static boolean canJump(int[] nums) {
        if (nums.length < 2) return false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + i == nums.length - 1) {
                return true;
            } else if (nums[i] + i < nums.length - 1) {
                i += nums[i] - 1;
            }
        }
        return false;
    }

    //67
    public static int binToInt(String bin) {
        int a = Integer.parseInt(bin);
        int val = 0;
        while (a != 0) {
            val = 2 * val + a % 10;
            a /= 10;
        }
        return val;
    }

    public static String addBinary(String a, String b) {
        int x = binToInt(a) + binToInt(b);
        String val = "";
        while (x != 0) {
            val += x % 10;
            x /= 10;
        }
        return new StringBuilder(val).reverse().toString();


    }

    //80
    public int removeDuplicates11(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for (int i : nums) {
            int c = 0;
            if (map.containsKey(i)) c = map.get(i);
            c += 1;
            if (c < 3) {
                map.put(i, c);
                l.add(i);
            }
        }
        for (int i = 0; i < l.size(); i++) {
            nums[i] = l.get(i);
        }
        return l.size();
    }

    //83
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> l = new LinkedHashSet<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        ListNode n = new ListNode();
        ListNode m = n;
        for (Integer i : l) {
            ListNode x = new ListNode(i);
            n.next = x;
            n = n.next;
        }
        n = m;
        return n.next;
    }

    //88
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int newInt[] = new int[m + n];
        System.arraycopy(nums1, 0, newInt, 0, m);
        System.arraycopy(nums2, 0, newInt, m, n);
        newInt = Arrays.stream(newInt).sorted().toArray();
        for (int i = 0; i < m + n; i++) {
            nums1[i] = newInt[i];
        }
    }

    //94
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        if (root != null) {
            System.out.println(root.val);
            inorderTraversal(root.left);
            l.add(root.val);
            inorderTraversal(root.right);
        }
        return l;
    }

    //100
    static List<Integer> list = new ArrayList<>();
    static int c = 0;

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null) {
            isSameTree(p.left, q);
            list.add(p.val);
            isSameTree(p.right, q);
        }
        if (q != null) {
            if (list.get(c) != q.val) {
                return false;
            } else {
                isSameTree(p, q.left);
                isSameTree(p, q.right);
            }
            c++;
        }
        return false;
    }

    //121
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i : prices) {
            min = Math.min(min, i);
            if (i > min) {
                max = i;
            }
        }
        return Math.max(max - min, 0);
    }

    //125
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z]", "");
        return s.contentEquals(new StringBuilder(s).reverse());
    }

    //136
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = 0;
            if (map.containsKey(nums[i])) {
                c = map.get(nums[i]);
            }
            c += 1;
            map.put(nums[i], c);
        }
        return map.entrySet().stream().filter(i -> i.getValue() == 1).collect(Collectors.toList()).get(0).getKey();
    }

    //141
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, 1);
            head = head.next;
        }
        return false;
    }

    //144
    List<Integer> list1 = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            preorderTraversal(root.left);
            list1.add(root.val);
            preorderTraversal(root.right);
        }
        return list1;
    }

    //145
    List<Integer> list2 = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.right);
            list2.add(root.val);
            postorderTraversal(root.left);
        }
        return list2;
    }

    //148
    public ListNode sortList(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }
        ListNode n = null;
        ListNode h = n;
        for (Integer i : l) {
            if (n == null) {
                n = new ListNode(i);
            } else {
                n.next = new ListNode(i);
            }
        }
        n = h;
        return n;
    }

    //151
    public String reverseWords(String s) {
        return Arrays.stream(s.trim().replaceAll("\\s{2,}", " ").split(" "))
                .sorted(Collections.reverseOrder()).map(String::valueOf).collect(Collectors.joining(" "));
//        StringJoiner joiner = new StringJoiner(" ");
//        for (int i = str.length-1; i>=0; i--) {
//            joiner.add(str[i]);
//        }
//        return joiner.toString();
    }

    //160
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (headA !=null) {
            map.put(headA, 1);
            headA = headA.next;
        }
        while (headB !=null) {
            if (map.containsKey(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    //168
    public String convertToTitle(int columnNumber) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");
        map.put(9, "I");
        map.put(10, "J");
        map.put(11, "K");
        map.put(12, "L");
        map.put(13, "M");
        map.put(14, "N");
        map.put(15, "O");
        map.put(16, "P");
        map.put(17, "Q");
        map.put(18, "R");
        map.put(19, "S");
        map.put(20, "T");
        map.put(21, "U");
        map.put(22, "V");
        map.put(23, "W");
        map.put(24, "X");
        map.put(25, "Y");
        map.put(26, "Z");
        StringBuilder s = new StringBuilder();
        while (columnNumber != 0) {
            int rem = columnNumber %26;
            s.append(map.get(rem));
            columnNumber/=26;
        }
        return s.reverse().toString();
    }

    //169
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int c = 0;
            if (map.containsKey(nums[i])) {
                c = map.get(nums[i]);
            }
            c += 1;
            map.put(nums[i], c);
            if (c > len / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    //189
    public static void rotate(int[] nums, int k) {
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.rotate(l, k);
        int j = 0;
        for (Integer i : l) {
            nums[j] = i;
            j++;
        }
    }

    //191
    public int hammingWeight(int n) {
        int c =0;
        while(n!=0) {
            if (n%10 == 1) c++;
            n/=10;
        }
        return c;
    }

    //203
    public ListNode removeElements(ListNode head, int val) {
        while(head != null) {
            if (head.val == val) {
                head = head.next;
            }
        }
        return null;
    }

    //206
    public ListNode reverseList(ListNode head) {
        ListNode next = head.next;
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            next = head.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    //215
    public static int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums).sorted().toArray()[nums.length - k];
    }

    //217
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int c = 0;
            if (map.containsKey(i)) {
                c = map.get(i);
            }
            c += 1;
            map.put(i, c);
            if (c == 2) return true;
        }
        return false;
    }

    //231
    public boolean isPowerOfTwo(int n) {
        if (n==1) return true;
        if (n<1) return false;
        while (n!= 0) {
            if (n%2 !=0 && n!=1) return false;
            n/=2;
        }
        return true;
    }

    //234
    public boolean isPalindrome(ListNode head) {
        StringBuilder s = new StringBuilder();
        while(head != null) {
            s.append(head.val);
            head = head.next;
        }
        return s.toString().equals(s.reverse().toString());
    }

    //242
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
//        s = Arrays.stream(s.split("")).sorted().map(String::valueOf).collect(Collectors.joining());
//        t = Arrays.stream(t.split("")).sorted().map(String::valueOf).collect(Collectors.joining());
        Arrays.sort(s.toCharArray());
        Arrays.sort(t.toCharArray());
        return s.equals(t);
    }

    //258
    public int addDigits(int num) {
        while (num > 9) {
             num = Arrays.stream(String.valueOf(num).split("")).mapToInt(Integer::valueOf).sum();
        }
        return num;
    }

    //268
    public static int missingNumber(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return 0;
    }

    //283

    //    public static void swap(int nums[], int a, int b) {
//
//    }
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }

    //334
//    public boolean increasingTriplet(int[] nums) {
//        if (nums.length<3) return false;
//    }

    //287
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            if (map.containsKey(i)) {
                return i;
            }
            map.put(i, 1);
        }
        return 0;
    }

    //290
    public boolean wordPattern(String pattern, String s) {
        if (pattern.length() != s.split(" ").length) return false;
        Map<String, String> map = new HashMap<>(pattern.length());
        String[] str = s.split(" ");
        int j = 0;
        for (String i: pattern.split("")) {
            if (map.containsKey(i) && !map.get(i).equals(str[j])
            || (map.containsValue(str[j]) && map.get(i) == null)) {
                return false;
            }
            map.put(i, str[j]);
            j++;
        }
        return true;
    }

    //292
    public boolean canWinNim(int n) {
        if (n<4) return true;
        while (n!=0) {

        }
        return false;
    }

    //326
    public boolean isPowerOfThree(int n) {
        if (n<1 || n==2) return false;
        if (n==1) return true;
        while (n!=0) {
            if (n%3 !=0 && n!=1) return false;
            n/=3;
        }
        return true;
    }

    //342
    public boolean isPowerOfFour(int n) {
        if (n==1) return true;
        while (n!=0) {
            if (n%4 !=0 && n!=1) return false;
            n/=4;
        }
        return true;
    }

    //344
    public void reverseString(char[] s) {
        for (int i=0; i<s.length/2; i++) {
            char t = s[i];
            s[i] = s[s.length -1 -i];
            s[s.length -1 -i] = t;
        }
    }

    //345
    public static String reverseVowels(String s) {
        String[] rev = new StringBuilder(s.replaceAll("[^aeiou]", "")).reverse().toString().split("");
        StringBuilder str = new StringBuilder();
        int j=0;
        for (String i: s.split("")) {
            if (i.matches("[aeiou]")) {
                str.append(rev[j]);
            } else {
                str.append(i);
            }
            j++;
        }
        return str.toString();
    }

    //349
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> integers = new ArrayList<>();
        if (nums1.length < nums2.length) {
            for (int i : nums1) {
                if (Arrays.stream(nums2).boxed().collect(Collectors.toList()).contains(i)) {
                    integers.add(i);
                }
            }
        } else {
            for (int i : nums2) {
                if (Arrays.stream(nums1).boxed().collect(Collectors.toList()).contains(i)) {
                    integers.add(i);
                }
            }
        }
        return integers.stream().distinct().mapToInt(Integer::valueOf).toArray();

    }

    //383
    public boolean canConstruct(String ransomNote, String magazine) {
        int c = 0;
        for (String i: magazine.split("")) {
            ransomNote = ransomNote.replaceFirst(i, "");
        }
        return ransomNote.isEmpty();
    }

    //387
    public int firstUniqChar(String s) {
        for (String i: Arrays.stream(s.split("")).distinct().map(String::valueOf).collect(Collectors.toList())) {
            String str = s.replaceAll("[^"+ i + "]", "");
            if (str.length() == 1) return s.indexOf(str.toCharArray()[0]);
        }
        return -1;
    }

    //389
    public static char findTheDifference(String s, String t) {
        if (s.isEmpty()) return t.charAt(0);
        t = t.replaceAll("[" + s + "]", "");
        return t.toCharArray()[0];
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("", "y"));
    }

    //392
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.equals(t)) return true;
        int l = 0;
        char[] c = s.toCharArray();
        char[] d = t.toCharArray();
        for (int i = 0; i < d.length && l < c.length; i++) {
            if (d[i] == c[l]) {
                l += 1;
            }
        }
        return s.length() == l;
    }

    //394
    public static String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        while (s.contains("[")) {
            System.out.println("contains " + s);
            Pattern p = Pattern.compile("\\[.*?\\]");
            Matcher m = p.matcher(s);
            while (m.find()) {
                System.out.println("group " + m.group());
                System.out.println("int " + Integer.parseInt(String.valueOf(s.charAt(s.indexOf(m.group())-1))));
                System.out.println("string " + IntStream.range(0, Integer.parseInt(String.valueOf(s.charAt(s.indexOf(m.group())-1))))
                        .mapToObj(i-> m.group().replaceAll("(\\[)|(\\])", "")).collect(Collectors.joining()));
                s = s.replaceAll(".\\[.*" +m.group()+"]", IntStream.range(0, Integer.parseInt(String.valueOf(s.charAt(s.indexOf(m.group())-1))))
                        .mapToObj(i-> m.group().replaceAll("(\\[)|(\\])", "")).collect(Collectors.joining()));
                System.out.println("replace " + s);
            }
        }
        return s;

    }

    //412
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            StringBuilder s = new StringBuilder();
            if (i%3 ==0) s.append("Fizz");
            if (i%5 == 0) s.append("Buzz");
            if (s.toString().length() == 0) list.add(String.valueOf(i));
            else list.add(s.toString());
        }
        return list;
    }

    //414
    public static int thirdMax(int[] nums) {
        if (Arrays.stream(nums).distinct().count() < 3)
            return Arrays.stream(nums).distinct().sorted().toArray()[nums.length - 1];
        return Arrays.stream(nums).distinct().boxed().collect(Collectors.toList()).stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                .get(2);
    }

    //441
    public int arrangeCoins(int n) {
        int len =n, row =0;
        for (int i=1; i<=n; i++) {
            if (len >=0) len = len-i;

        }
        return -1;
    }

    //448
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> l2 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 1; i <= n; i++) {
            if (!l2.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    //485
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, c = 0;
        for (int i : nums) { // 110111
            if (i == 1) {
                c++;
                max = Math.max(max, c);
            } else {
                c = 0;
            }
        }
        return max;
    }

    //500
    public static String[] findWords(String[] words) {
        String regex = "([asdfghjkl])|(qwertyuiop)|(zxcvbnm)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("Hello");
        return null;
    }

    //504
    public String convertToBase7(int num) {
        StringBuilder s = new StringBuilder();
        if (num<0) s.append("-");
        num = Math.abs(num);
        while (num !=0) {
            s.append(num%7);
            num/=7;
        }
        return s.reverse().toString();
    }

    //520
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        } else {
            if (word.substring(0,1).equalsIgnoreCase(word.substring(0, 1).toUpperCase())) {
                for (String i: word.substring(1).split("")) {
                    if (i.equals(i.toLowerCase())) return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //541
    public String reverseStr(String s, int k) {
        if (k >= s.length()) {
            return new StringBuilder(s).reverse().toString();
        } else {
            return new StringBuilder(s.substring(0, k)).reverse() + s.substring(k);
        }
    }

    //557
    public String reverseWords2(String s) {
        return Arrays.stream(s.split(" ")).map(i -> new StringBuilder(i).reverse()).collect(Collectors.joining(" "));
    }

    //605
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n -= 1;
                i += 1;
            }
        }
        return n == 0;
    }

    //645
    public int[] findErrorNums(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i=1; i<=nums.length; i++) {
            if (i !=nums[i-1]) {
                return new int[]{nums[i-1], i};
            }
        }
        return null;
    }

    //704
    public int search(int[] nums, int target) {
        int start =0, r = nums.length-1;
        while (start < r) {
            int m = start + (r - start)/2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) {
                start = m+1;
            } else {
                r = m-1;
            }
        }
        return -1;
    }

    //1071
    public static String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {

        }
        return "";
    }

    //1432
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).mapToObj(i -> i + extraCandies >= max).collect(Collectors.toList());
    }

    //1456
    public int maxVowels(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            max = Math.max(max, s.substring(i, i + k).replaceAll("[^aeiou]", "").length());
        }
        return max;
    }

    //1658
    public int minOperations(int[] nums, int x) {
        int c = 0;
        if (x - nums[0] < 0 ||x - nums[nums.length -1]<0) return -1;
        for (int i=0; i<nums.length; i++) {
            if (x <0) {
                return c;
            }
            if (x - nums[i] >= 0){
                x = x-nums[i];
                c+=1;
            }
            if (x - nums[nums.length -1 -i]>=0) {
                x = x - nums[nums.length -1 -i];
                c+=1;
            }

        }
        return c;
    }

    //1732
    public int largestAltitude(int[] gain) {
        int[] newInt = new int[gain.length + 1];
        newInt[0] = 0;
        int j = 1, max = Integer.MIN_VALUE;
        for (int i : gain) {
            newInt[j] = newInt[j - 1] + gain[j - 1];
            max = Math.max(max, newInt[j]);
            System.out.print(newInt[j]);
            j++;
        }
        return Math.max(max, 0);
    }

    //1768
    public String mergeAlternately(String word1, String word2) {
        StringBuilder s = new StringBuilder();
        if (word1.length() < word2.length()) {
            char[] c = word1.toCharArray();
            char[] c2 = word2.toCharArray();
            int i = 0;
            for (i = 0; i < c.length; i++) {
                s.append(c[i]).append(c2[i]);
            }
            s.append(word2.substring(i));
            return s.toString();
        } else {
            char[] c = word1.toCharArray();
            char[] c2 = word2.toCharArray();
            int i = 0;
            for (i = 0; i < c2.length; i++) {
                s.append(c[i]).append(c2[i]);
            }
            s.append(word1.substring(i));
            return s.toString();
        }
    }

    //2215
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1.stream().filter(i -> !l2.contains(i)).distinct().collect(Collectors.toList()));
        list.add(l2.stream().filter(i -> !l1.contains(i)).distinct().collect(Collectors.toList()));
        return list;
    }

    //2390
    public static String removeStars(String s) {
        Pattern p = Pattern.compile("\\w\\*");
        while (s.contains("*")) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                s = s.replace(m.group(), "");
            }
        }
        return s;
    }


}

class MyHashMap {

    Map<Integer, Integer> map;

    public MyHashMap() {
        map = new HashMap<Integer, Integer>();
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        return map.get(key);
    }

    public void remove(int key) {
        map.remove(key);
    }
}
