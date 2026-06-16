
class LinkedList {

    private static class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
        }
    }
    private Node head;
    private Node tail;
    private int size;


    public LinkedList() {
        head=null;
        tail=null;
        size=0;
       

    }


    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }

        Node curr = head;
        for(int i = 0; i < index; i++){
            curr=curr.next;
        }
        return curr.val;

        
    }

    public void insertHead(int val) {
        Node newNode= new Node(val);

        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
        
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if(tail == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    public boolean remove(int index) {
        if(index < 0 || index >= size){
            return false;
        }
        if(index == 0){
            head = head.next;
            
            if(head == null){
                tail=null;
            }
            size--;
            return true;
        }

        Node prev= head;

        for(int i=0;i<index-1;i++){
            prev =prev.next;
        }

        Node nodeToDelete=prev.next;
        prev.next=nodeToDelete.next;

        if(nodeToDelete== tail){
            tail=prev;
        }

        size--;
        return true;
        
    }


    public List<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = head;

        while( curr != null){
            values.add(curr.val);
            curr = curr.next;
        }
        return values;

    }
}
