package primary;

/**
 * 链表倒置
 *
 * @author lihaojie
 * @date 2022/12/20 20:58
 **/
public class Class04_0101_lianBiaoDaoZhi {
    public static void main(String[] args){
        Node node1=new Node().setValue("我是节点1");
        Node node2=new Node().setValue("我是节点2");
        node1.setNext(node2);
        Node node3=new Node().setValue("我是节点3");
        node2.setNext(node3);

    }
    public static class Node {
        private String value;
        private Node next;


        public String getValue() {
            return value;
        }

        public Node setValue(String value) {
            this.value = value;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
