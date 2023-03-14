class Queu{
    Node head = new Node(null);
    private int size = 0;

    public void add(Crash dat){
        head.prev.next = new Node(dat,head.prev,head);
        head.prev = head.prev.next;
        size++;
    }
    
    public Crash first(){
        return head.next.data;
    }
    
    public Crash remove(){
        Crash temp = head.next.data;
        head.next= head.next.next;
        head.next.prev = head;
        --size;
        return temp;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return (size==0);

    }
    public void Print(){
        Node temp = head;
        int count=0;
        while(count!=size){
            System.out.println(temp.data);
            temp = temp.next;
            count++;
        }
    }
    public void SearchWeather(String W,Queu q){
        Node temp = head;
        int count=0;
        temp = temp.next;
        while(count!=size){
            if(temp.data.Weather.equals(W))
            q.add(temp.data);
            temp = temp.next;
            count++;
        }

    }
    public void SearchDays(String D,Queu q){
        Node temp = head;
        int count=0;
        temp = temp.next;
        while(count!=size){
            if(temp.data.DayofWeek.equals(D))
            q.add(temp.data);
            temp = temp.next;
            count++;
        }
    }
    public int MonthSearch(String M){
        Node temp = head;
        int count=0;
        
        while(temp==null){
            temp = temp.next;
            if(!(temp==null))
            break;
        }
        while(temp!=null){
            if(temp.data.Month.equals(M))
            count++;
            temp = temp.next;
        }
        return count;
    }
        public int MonthSearch(String M,String Ctype){
        Node temp = head;
        int count=0;
        temp = temp.next;
        while(count!=size){
            if(temp.data.Month.equals(M)&&temp.data.crashTypeHit.equals(Ctype))
            count++;
            temp = temp.next;
        }
        return count;
    }
}
class Node{
    Crash data;
    Node next = this;
    Node prev = this;
    Node(Crash data){
        this.data = data;
    }
    Node(Crash data,Node p ,Node n){
        this.data = data;
        prev = p;
        next = n;
    }
}