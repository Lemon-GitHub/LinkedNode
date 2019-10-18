
public class test {
    public static void main(String[] args) {
        LinkedList linklist = new LinkedList();

//        linklist.addFirst(1);
//        linklist.addFirst(2);
//        linklist.addFirst(3);
//        linklist.addFirst(4);
//        linklist.display();

        linklist.addLast(1);
        linklist.addLast(2);
        linklist.addLast(3);
        linklist.addLast(1);
        linklist.addLast(4);
        linklist.addLast(1);
        linklist.display();

//        linklist.addIndex(0,0);
//        linklist.display();
//        linklist.addIndex(1,8);
//        linklist.display();
//        linklist.addIndex(6,9);
//        linklist.display();
//        linklist.addIndex(10,0);
//        linklist.display();

//        System.out.println(linklist.contains(9));
//        System.out.println(linklist.contains(3));

//        linklist.remove(1);
//        linklist.display();
//        linklist.remove(3);
//        linklist.display();


        linklist.removeAllKey(1);
        linklist.display();

        linklist.clear();
        linklist.display();
    }
}