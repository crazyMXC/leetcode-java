class LRUCache {
    private HashMap<Integer, Node>map;
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private class Node{
        int key,value;
        Node pre,next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.pre=null;
            this.next=null;
        }
    }
    
    public LRUCache(int capacity) {
        this.map=new HashMap<>();
        this.capacity=capacity;
    }
    // 将已有节点或新建节点移动到链表尾部
    private void moveToTail(Node target, boolean isNew) {
        // 尾部节点显然不需要移动
        if (target != tail.next) {
            if (!isNew) {
                // 修改旧节点的双向链表指针
                target.pre.next = target.next; 
                target.next.pre = target.pre;
            }
            // 添加节点到链表尾部
            tail.next.next = target;
            target.pre = tail.next;
            tail.next = target;
        }
    }
    // 命中节点添加到链表尾部，未命中返回-1
    public int get(int key) {
        if (map.containsKey(key)) {
            Node target = map.get(key);
            // 将已有节点移动到链表尾部
            moveToTail(target, false);
            // 此时链表尾部tail.next = target，更新next指向null，防止出现环
            tail.next.next = null;
            return target.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // cache中存在节点
        if (map.containsKey(key)) {
            Node target = map.get(key);
            target.value = value;
            map.put(key, target);
            // 将访问过的已有节点移动到链表尾部
            moveToTail(target, false);
        } else if(map.size() < capacity) {    // cache未满，添加节点
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (head.next == null) {
                head.next = newNode;
                newNode.pre = head;
                tail.next = newNode;
            } else {
                // 将新建节点移动到链表尾部
                moveToTail(newNode, true);
            }
        } else {    // cache已满，淘汰链表链表头部节点，新节点加入到链表尾部
            Node newNode = new Node(key, value);
            map.remove(head.next.key);
            map.put(key, newNode);
            // cache中只有一个元素
            if (head.next == tail.next) {
                head.next = newNode;
                tail.next = newNode;
            } else {    // cache中不止一个元素，删除头部
                head.next.next.pre = head; // 更新新头部.pre = head
                head.next = head.next.next;// 更新新头部
                // 将新建节点移动到链表尾部
                moveToTail(newNode, true);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */