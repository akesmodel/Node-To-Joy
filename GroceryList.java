import java.io.*;
import java.util.*;

public class GroceryList extends Node{
    private Node head;

    public GroceryList(){
        head=null;
    }
    public GroceryList(Node head){
        this.head=head;
    }

    public void add(String item){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=new Node(item);
    }

    public void add(String item, int idx){
        Node curr=head;
        Node incoming=new Node(data);
        //if head doesn't exist, return incoming
        if (head==null){
            head=incoming;
        } 
        //if idx valid, continue return head
        else if(idx<size()&&idx>0){
            if (idx==0){
                incoming.next=head;
                head=incoming;
            }
            else {
                for(int i=0; i<idx-1; i++){
                    curr=curr.next;
                }
                incoming.next=curr.next;
                curr.next=incoming;
            }
        }
    }
    public void remove(int idx){
        //if head exists & valid index continue
        if (head!=null&&idx<size()||idx>=0){
            if (idx==0){
                head=head.next;
            } else{
                Node curr=head;
                for (int i = 0; i < idx-1; i++) {
                    curr=curr.next;
                }
                curr.next=curr.next.next;
            }
        } 
    }
    public int size(){
        int count=0;
        Node curr=head;
        while (curr!=null){
            curr=curr.next;
            count++;
        }
        return count;

    }

    public Map<String, Double> getGroceryMap() throws FileNotFoundException{
        Scanner s = new Scanner("grocery-items.txt");
        Map<String,Double> toRet = new HashMap<>();
        //itterate through
        while (s.hasNextLine()){
            //split each row into an array of strings
            String [] groceryData = s.nextLine().split(" ");
            toRet.put(groceryData[0],Double.parseDouble(groceryData[1]));
        }
        s.close();
        //return map of items
        return toRet;
    }
    public double getCost(Map<String,Double> items){
        double totCost=0;
        for(double price: items.values()){
            totCost+=price;
        }
        return totCost;
    }

    public String toString(){
        String toRet=head.data;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
            toRet+="\n"+temp.data;
        }
        try {
            Map<String, Double> hi=this.getGroceryMap();
            toRet+="\n Total Cost: "+this.getCost(hi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return toRet;

    }

    public void removeDuplicates(){
        Node comparison=head;
        Node comparedTo=head.next;
        int index=1;
        int counter=1;
        while(comparison!=null){
            while(comparedTo!=null){
                if (comparedTo==comparison){
                    this.remove(index);
                }
                index++;
            }
            comparison=comparison.next;
            comparedTo=comparison.next;
            counter++;
            index=counter;
        }

    }

}