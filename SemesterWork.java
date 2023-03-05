/*

Dataset: https://www.kaggle.com/datasets/syedasimalishah/auto-pedestrians-crashes
//obtained 

then, Save the data from csv to normal nodes or queue

Step 1: Make a queue for the car crashes based on their time line from January to December (Day 1 to
Day 31) and store day of week, crash type, light conditions, weather conditions and other necessary data.

Step 2: Make three sub queues from the original queue such as sub queues storing only clear weather
crashes, snow weather crashes and rain weather crashes.

Step 3: Make seven sub queues (one for each day of the week) for all crashes.

Step 4: Make two binary trees to store total number of crashes for each month(use crash number as key)
for both ‘hit and run’ and ‘not hit and run’ crash types.


Problem 1: How to find out which day (from Monday to Sunday) was the deadliest of all days as well as
which months’ Friday was the deadliest among all Fridays.

Problem 2: How to find the number of rainy day crashes in every month.

Problem 3: Which month had the lowest ‘hit and run’ and which month had the highest ‘hit and run’ crash
cases (use binary tree already developed). Which month has lowest ‘not hit and run’ and which month had
the highest ‘not hit and run’ crash cases

Postulate 1: Is it true that the weekends (Saturdays and Sundays) when the light conditions were dark,
caused more crashes than Mondays and Tuesdays.
*/
/**
 * SemesterWork
 */
import java.io.*;

public class SemesterWork {
    public static void main(String[] args) {
        Queue q = new Queue();
        DataEntry(q);
	System.out.println(q.first());
    }
    public static void DataEntry(Queue q) {
    // Queue q = new Queue();
    try {
        BufferedReader br = new BufferedReader(new FileReader("ped_crashes.csv"));
        String s;
        br.readLine();
        while((s=br.readLine())!=null){
            q.add(s);
        }
        br.close();
    } catch (Exception e) {
        // TODO: handle exception
    }
    }    
}

class Queue{
    Node head = new Node(null);
    private int size = 0;

    public void add(String dat){
        head.prev.next = new Node(dat,head.prev,head);
        head.prev = head.prev.next;
        size++;
    }
    
    public String first(){
        return head.next.data;
    }
    
    public String remove(){
        String temp = head.next.data;
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
}
class Node{
    Crash data;
    Node next = this;
    Node prev = this;
    Node(String data1){
        data = new Crash(data1);
    }
    Node(String data,Node p ,Node n){
        this.data = data;
        prev = p;
        next = n;
    }
}
class Crash{
    int year;
    String month;
    String dayOfWeek;
    Crash(String s){
        String [] values = s.split(',');
        year = Integer.valueOf(values[0]);
        
    }
}