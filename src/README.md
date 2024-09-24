Nilan Patel | nap02617@uga.edu

To compile and run, do in this order:
javac -cp bin -d bin src/NodeType.java
javac -d bin src/ItemType.java
javac -cp bin -d bin src/SortedLinkedList.java
javac -cp bin -d bin src/LinkedListDriver.java
java -cp bin LinkedListDriver src/input.txt


MergeList function breakdown:
Initialization - I created a temp node and set pointer (mergedCurrent) to it
Then after that I merge the lists by traversing both lists and comparing the nodes from each. I insert the smaller node of the two into the merged lists and then skip any duplications of numbers.
After that I append the remaining values from whichever list is longer either from thisList or otherList and they get added to mergedList
Finally, i update the head of the current list to point to start of merged list with the temphead.next command

Intersection Function Breakdown:
I create a current1 starting at head of list, and current 2 starting at head of the inputted list by user. Then I loop thru both while they arent null. After that i use compareTo between curr1 and curr2 to find matching values. If they  == 0 then that means they are matching according to the documentation of Java's compareTo method. 