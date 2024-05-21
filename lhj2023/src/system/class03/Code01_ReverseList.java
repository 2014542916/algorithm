package system.class03;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表的反转
 *
 * @author lihaojie
 * @date 2023/04/04 13:04
 **/
public class Code01_ReverseList {

    //单链表节点
    public static class Node {

        public int value;
        public Node next;

        public Node(int data) {
            value = data;
        }
    }

    /**
     * 单链表反转
     *
     * @param head 反转后链表的头指针
     * @return system.class03.Code01_ReverseList.Node
     * @author lihaojie
     * @date 2023/04/04 13:19
     */
    public static Node reverseList(Node head) {
        //TODO 将单链表反转
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * ForTest
     * 容器法反转单链表
     *
     * @param head 反转后链表的头指针
     * @return system.class03.Code01_ReverseList.Node
     * @author lihaojie
     * @date 2023/04/04 13:16
     */
    public static Node testReverseLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(N - 1);
    }

    /**
     * 生成随机单链表
     *
     * @param len   需要的链表长度
     * @param value 链表节点value
     * @return system.class03.Code01_ReverseList.Node
     * @author lihaojie
     * @date 2023/04/04 13:27
     */
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    /**
     * 验证是否正常
     *
     * @param origin 原链表内容
     * @param head   头节点
     * @return boolean
     * @author lihaojie
     * @date 2023/04/04 15:08
     */
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 获取原链表
     *
     * @param head 链表头
     * @return java.util.List<java.lang.Integer>
     * @author lihaojie
     * @date 2023/04/04 15:06
     */
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    public static Node DeleteGivenValueInLinkList(Node head, int value) {
        //找到头节点
        while (head != null) {
            if (head.value == value) {
                break;
            }
            //head 后移
            head = head.next;
        }
        //思路： 如果
        Node point = head;
        Node t = head.next;
        while (t != null) {
            if (t.value == value) {
                point.next = t.next;
            } else {
                point = t;
            }
        }

        return head;
    }

    //双向链表
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 双向链表逆序
     *
     * @param head 双向链表头节点
     * @return system.class03.Code01_ReverseList.DoubleNode
     * @author lihaojie
     * @date 2023/04/04 19:26
     */
    private static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {

            next = head.next;   //next 先下移 计入一下下一个节点
            head.last = head.next;
            head.next = pre;

            pre = head;
            head = next;

        }
        return pre;

    }

    /**
     * 检验双向链表逆序是否正确
     *
     * @param origin 原始数组
     * @param head   头节点
     * @return
     */
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.last;
        }
        return true;
    }

    /**
     * 生成随机双向链表
     *
     * @param len   双向链表的长度
     * @param value 节点的最大值
     * @return system.class03.Code01_ReverseList.DoubleNode
     * @author lihaojie
     * @date 2023/04/04 19:19
     */
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;

    }

    /**
     * 获取双向链表的原始值
     *
     * @param head 双向链表头节点
     * @return java.util.List<java.lang.Integer>
     * @author lihaojie
     * @date 2023/04/04 19:22
     */
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * main
     */
    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 10000;
        System.out.println("list begin");
        for (int i = 0; i < testTime; i++) {
            //链表
            Node head = generateRandomLinkedList(len, value);
            //获取元链表节点内容
            List<Integer> originList = getLinkedListOriginOrder(head);
            //反转链表
            Node reverseList = reverseList(head);
            //检验
            if (!checkLinkedListReverse(originList, reverseList)) {
                originList.forEach(System.out::println);
                break;
            }
        }
        System.out.println("list end");
        System.out.println("doubleList begin");
        for (int i = 0; i < testTime; i++) {
            //链表
            DoubleNode head = generateRandomDoubleList(len, value);
            //获取元链表节点内容
            List<Integer> originList = getDoubleListOriginOrder(head);
            //反转链表
            DoubleNode reverseList = reverseDoubleList(head);
            //检验
            if (!checkDoubleListReverse(originList, reverseList)) {
                originList.forEach(System.out::println);
                break;
            }
        }
        System.out.println("doubleList end");

        //删除元素
        
    }


}
