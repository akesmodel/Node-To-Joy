#Reflections

##Additional method reflection:
The method I added to Grocery List was called *count*, and it does the following:

1. Take in an input item
2. Create a temporary Node object that points to the same Node as the head of the grocery list
3. Also creates a tally
4. Traverse the grocery list by pointing to the next node on the list
5. Every time a Node's head is the same as the input, it increases the tally.
6. Return the tally.
7. That's it, I just wanted a 6-7 haha

This program enhances the code because it can give the user an idea of the quantity of an object they have put on their list. For example, there is a very large difference between 1 and 100 rolls of toilet paper. Especially during:
- COVID
- TP'ing someone's house (which I do not in any way endorse)
- Dressing up as a mummy for Halloween

But anyways, not knowing this quantity gives you know idea how much of something you have, nor how much of it you've spent. Leading me to my next point...

**Major Limitations

A major limitation is the disjointedness of prices and items. We can import these into a map together, but because prices are not an attribute of the GroceryList or Node class, if I were to add a new item to the grocery list, I couldn't set a price for it. 

If I could improve this, I would add a double price as an attribute to the Node class, that could be accessed in a similar way as the data of the Node is. This would make the total cost reflect the actual cost and not just the list I imported from a file.

**Diagram
I didn't do a diagram of every single test case, but I drew out adding and removing nodes, which (in my very professional and humble opinion) is the most important thing to visualise.

Thank you for reading through all this yap Miss Bono! And I'm so sorry about the tardiness!!