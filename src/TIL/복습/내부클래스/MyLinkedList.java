package TIL.복습.내부클래스;

public class MyLinkedList {
    private Node head = null;

    private class Node{
        private String data;
        private Node link;

        public Node(String data){

            this.data = data;
        }
    }

    public void add(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else {
            Node next = head;
            while(next.link != null){
                next = next.link;
            }

            next.link = newNode;
        }
    }

}