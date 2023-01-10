package org.datastructure.linkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        // 저장하는 데이터
        private Object data;
        // 다음 노드
        private Node next;

        public Node(Object object) {
            this.data = object;
            this.next = null;
        }
    }
    Node node(int idx) {
        Node node = head;
        for(int i = 0; i < idx; i++) {
            node = node.next;
        }
        return node;
    }
    public void addFirst(Object object) {
        Node newNode = new Node(object);
        // 헤드를 자신의 다음노드로 지정하고
        newNode.next = head;
        // 자신이 헤드가 된다.
        head = newNode;
        size++;
        if(head.next == null) {
            tail = head;
        }
    }
    public void addLast(Object object) {
        Node newNode = new Node(object);

        if(size == 0) {
            addFirst(object);
        } else {
            // 테일 뒤에 새로운 노드가 오며
            tail.next = newNode;
            // 테일에 새로운 노드를 할당한다.
            tail = newNode;
            size++;
        }
    }
    public void add(int k, Object object) {
        if (k == 0) {
            addFirst(object);
        }
        Node curNode = node(k-1);
        Node nextNode = curNode.next;
        Node newNode = new Node(object);
        curNode.next = newNode;
        newNode.next = nextNode;
        size++;
        if(newNode.next == null) {
            tail = newNode;
        }
    }
    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node node = head;
        String str = "[";
        while(node.next != null) {
            str += node.data + ", ";
            node = node.next;
        }
        str += node.data + "]";
        return str;
    }
    public Object removeFirst() {
        Node node = head;
        head = node.next;
        Object object = node.data;
        node = null;
        size--;
        return object;
    }
    public Object remove(int k) {
        if(k == 0) {
            removeFirst();
        }
        Node node = node(k - 1);
        Node rmNode = node.next;
        node.next = node.next.next;
        Object object = rmNode.data;

        if(rmNode == tail) {
            tail = node;
        }
        rmNode = null;
        size--;
        return object;
    }
    public Object removeLast() {
       return remove(size()-1);
    }
    public int size() {
        return size;
    }
    public Object get(int k) {
        return node(k);
    }
    public int indexOf(Object object) {
        Node curNode = head;
        int cnt = 0;
        while(curNode.data != object) {
            cnt++;
            curNode = curNode.next;
            if (curNode == null) {
                return -1;
            }
        } return cnt;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(5);
        linkedList.addLast(15);
        linkedList.add(1,9);
        System.out.println(linkedList);
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.indexOf(5));
    }
}
