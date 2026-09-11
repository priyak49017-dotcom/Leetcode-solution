class FrontMiddleBackQueue {
    LinkedList<Integer>q=new LinkedList<>();

    public FrontMiddleBackQueue() {
        
    }
    
    public void pushFront(int val) {
        q.addFirst(val);
        
    }
    
    public void pushMiddle(int val) {
        
        q.add(q.size()/2,val);
    }
    
    public void pushBack(int val) {
        q.addLast(val);
        
    }
    
    public int popFront() {
        if(q.isEmpty()) return -1;
        return q.removeFirst();
        
    }
    
    public int popMiddle() {
        if(q.isEmpty()) return -1;
        return q.remove((q.size()-1)/2);
        
    }
    
    public int popBack() {
        if(q.isEmpty()) return -1;
        return q.removeLast();
        
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */