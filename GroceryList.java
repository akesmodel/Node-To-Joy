//imports data types we need later in the code
import java.io.*;
import java.util.*;

public class GroceryList extends Node{ //GroceryList is a subclass of Node, and inherits features of it
    private Node head; //This is a GroceryList's attribute that distinguishes it from a normal Node

    public GroceryList(){ //no arg constructor, by default sets a Grocery List null
        head=null;
    }
    public GroceryList(Node head){ //one arg constructor, sets the input to be the head with nothing afterwards
        this.head=head;
    }

    public void add(String item){ //adds an item to the end of the list
        Node temp=head; //setting a temporary variable with all the same data as the head
        //we do this for a lot of other methods, so I'll only mention it here,
        //but it has the same function each time: to manipulate the data without losing it.

        if(head==null){ //If there's nothing to add the item to, it becomes the head and calls on the constructor.
            head=new Node(item);
        }
        else{ //If there is something to add the item to, we set temp equal to the next element, 
        //until temp is pointing at the end of the grocery list. 
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node(item); //Because of aliasing, temp is pointing to the end of the head, 
            // so adding to temp will add to the end of the head.
        }
    }

    public void add(String item, int idx){ //Adds a value at a specific index
        Node temp=head;
        Node incoming=new Node(item);
        if (head==null){ //if head doesn't exist, set it to be the incoming
            head=incoming;
        } 
        else if(idx<size()&&idx>0){ //continue if the index given is valid
            //if the index is zero, places the item at the beginning
            if (idx==0){
                incoming.next=head;
                head=incoming;
            }
            //if index is the end, places the item at the end using our other method
            else if (idx==this.size()) {
                this.add(item);
            }
            //otherwise, places the item
            else {
                for(int i=0; i<idx-1; i++){
                    temp=temp.next;
                }
                incoming.next=temp.next;
                temp.next=incoming;
            }
        }
    }
    public void remove(int idx){
        //checks that the head exists and the index provided is valid
        if (head!=null&&idx<size()||idx>=0){
            if (idx==0){ //if the index is provided is the first node, 
            // we just make head point to its next node and cut off the first part
                head=head.next;
            } else{
                //otherwise, we set up a temporary variable, 
                // have it point to the node one before the one we want, 
                // and replace our index with the one after it.
                Node temp=head;
                for (int i = 0; i < idx-1; i++) {
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        } 
    }
    public int size(){ //calculates the size of the node by using a temporary variable 
    // and counting every time that variable isn't null, 
    // before moving it along in the list.
        int count=0;
        Node curr=head;
        while (curr!=null){
            curr=curr.next;
            count++;
        }
        return count;

    }

    public Map<String, Double> getGroceryMap() throws FileNotFoundException{ 
        //creates a Map of the csv file by scanning each line of the file, 
        // splitting it up into two parts (name and price), 
        // and adding those data points to the Map. 

        //There's some error going on when I try to parse the numbers into a double, 
        // but VSCode keeps alternating which line is red, so I really can't tell which one's the actual problem. 
        // Regardless, I hope this part of the code is conceptually clear at least? 
        // Thank you Miss Bono, and DEFINITELY no thank you to my computer
        Scanner s = new Scanner("grocery-items.txt");
        Map<String,Double> toRet = new HashMap<>();
        //itterate through
        while (s.hasNextLine()){
            //This part is supposed to split each row into an array of strings
            ArrayList<String> line= new ArrayList<>(Arrays.asList(s.nextLine().split(" ")));
            toRet.put(line.get(0),Double.parseDouble(line.get(1)));
        }
        s.close();
        return toRet;
    }
    public double getCost(Map<String,Double> items){ 
        //returns the cost of the items, by adding every value price stored in the Map of items given.
        //I fear this also doesn't really work if the getGroceryMap doesn't :(
        double totCost=0;
        for(double price: items.values()){
            totCost+=price;
        }
        return totCost;
    }

    public String toString(){
        //returns a list of every single item on the list in order, by using a temporary variable
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

    public int count(String item){ 
        //This was the method I chose to design myself.
        //It counts the number of instances of a specific item using a temporary variable.
        Node temp=head;
        int count=0;
        while(temp!=null){
            if (temp.data==item){
                count++;
                temp=temp.next;
            }
            else{
                temp=temp.next;
            }
        }
        return count;
    }

}