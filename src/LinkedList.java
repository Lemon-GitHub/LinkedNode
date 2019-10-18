class LinkedNode{
    public int data = 0;
    public LinkedNode next = null;

    public LinkedNode(int data){
        this.data = data;
    }
}

public class LinkedList {
    private LinkedNode head = null;

    //头插法
    public void addFirst(int elem){
        //创建节点
        LinkedNode node = new LinkedNode(elem);

        //链表为空
        if(this.head == null){
            this.head = node;
            return;
        }

        //链表不为空
        node.next = head;
        head = node;
    }

    //打印链表
    public void display(){
        System.out.print("[");
        for(LinkedNode cur = this.head; cur != null; cur = cur.next){
            System.out.print(cur.data);
            if(cur.next != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    //尾插法
    public void addLast(int elem){
        //创建节点
        LinkedNode node = new LinkedNode(elem);

        //链表为空
        if(this.head == null){
            this.head = node;
            return;
        }

        //链表不为空
        LinkedNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    public int size(){
        int size = 0;
        for(LinkedNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }

    //获取指定位置的节点
    public LinkedNode getIndexPos(int index){
        LinkedNode cur = this.head;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }
    //指定位置插入
    public void addIndex(int index,int elem){
        //创建一个节点
        LinkedNode node = new LinkedNode(elem);

        //判断位置是否合法
        if(index < 0 || index > size()){
            System.out.println("位置非法");
            return;
        }

        //index == 0时 头插法
        if(index == 0){
            addFirst(elem);
            return;
        }

        //其他位置 （重点是找到要插入元素的前一个元素的位置
        LinkedNode prev = getIndexPos(index - 1);

        node.next = prev.next;
        prev.next = node;
    }

    public boolean contains(int toFind){
        for(LinkedNode cur = this.head; cur != null; cur = cur.next){
            if(cur.data == toFind){
                return true;
            }
        }
        return false;
    }

    //找前一个节点
    private LinkedNode searchPrev(int toRemove){
        LinkedNode prev = this.head;
        while(prev.next != null){
            if(prev.next.data == toRemove){
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    //删除第一次出现的key
    public void remove(int toRemove){
        //判断是否为空链表
        if(this.head == null){
            return;
        }

        //key为头节点元素
        if(head.data == toRemove){
            head = head.next;
            return;
        }

        //其他节点 (找到删除节点的前一个节点
        LinkedNode prev = searchPrev(toRemove);

        LinkedNode nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
    }

    public void removeAllKey(int key){
        //是否为空链表
        if(head == null){
            return;
        }

        //处理后续节点
        LinkedNode prev = head;
        LinkedNode cur = head.next;

        while(cur != null){
            //delete
            if(cur.data == key){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }

        //处理头节点
        if(head.data == key){
            this.head = this.head.next;
        }
    }





    public void clear(){
        this.head = null;
    }
}
