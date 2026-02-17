import java.io.FileNotFoundException;
public class GroceryTester{
    public static void main(String[] args) throws FileNotFoundException { //This is our main, and it tests cases for all of the methods in Grocery list
        GroceryList WholeFoods = new GroceryList();
        
        WholeFoods.add("put");
        System.out.println(WholeFoods); //Tests add (and toString, which is totally fine except for price)


       //Okay, so this next part tests out the getGroceryMap feature. 
       // I commented it out, because if getGroceryMap doesn't work it stops the rest of the code,
       //but if it did work, here's how I'd test it:
       
        // Map<String, Double> importedList=WholeFoods.getGroceryMap();
        // for(String item: importedList.keySet()){
        //     WholeFoods.add(item);
        // }
        // System.out.println(WholeFoods);

        

        //tests adding at different indexes, including an invalid one
        WholeFoods.add("fries");
        WholeFoods.add("fillerhaha",67);
        WholeFoods.add("in");
        WholeFoods.add("the",1);
        WholeFoods.add("bag");
        WholeFoods.add("the", 4); 
        System.out.println(WholeFoods);
        
       //tests the remove feature
        WholeFoods.remove(3);
        System.out.println(WholeFoods);

        //tests count and size features
        int howMany=WholeFoods.count("the");
        System.out.println("There are "+howMany+" instances of 'the' on your list.");
        System.out.println("The size of your list is: "+WholeFoods.size());

    }
}