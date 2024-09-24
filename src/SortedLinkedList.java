public class SortedLinkedList {
    private NodeType head;

    public SortedLinkedList(){
        this.head = null;
    }

    /**
     * Prints elements of the list.
     */
    public void printList() {
    if (head == null) {
        System.out.println("The list is empty.");
        return;
    }
    NodeType current = head;
    System.out.print("The list is: "); 
    while (current != null) {
        System.out.print(current.info + " ");
        current = current.next;
    } 
    System.out.println(); 
}


    /**
     * Loops through the nodes in the method to 
     * return the length of the LinkedList.
     * @return the length of the LinkedList.
     */
    public int getLength(){
        int count = 0;
        NodeType current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Inserts the itemtype into the LL in the 
     * order it is supposed to go.
     * @param item the item inserted.
     */
    public void insertItem(ItemType item) {
    NodeType newNode = new NodeType(item);     

    if (head == null) {
        head = newNode;
        return;
    }

    if (head.info.compareTo(item) == 0) {
        System.out.println("Item already exists");
        return;
    }

    if (head.info.compareTo(item) > 0) {
        newNode.next = head;
        head = newNode;
        return;
    }
    NodeType current = head;
    NodeType previous = null;

    while (current != null && current.info.compareTo(item) < 0) {
        previous = current;
        current = current.next;
    }
    if (current != null && current.info.compareTo(item) == 0) {
        System.out.println("Item already exists");
        return;
    }
    previous.next = newNode;
    newNode.next = current;
}



    /**
     * Deletes node based on input by user.
     * @param item the item that you want deleted.
     */
    public void deleteItem(ItemType item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        }

        if (head.info.compareTo(item) == 0) {
            head = head.next;  
            return;
        }

        NodeType current = head;
        NodeType previous = null;

        while (current != null && current.info.compareTo(item) != 0) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("The item is not present in the list");
            return;
        }

        previous.next = current.next;
    }

    /**
     * searches for item in the list and returns its index.
     * @param item item inputted that this method searches for.
     * @return the index of the item in LL.
     */
    public int searchItem(ItemType item){
        NodeType current = head;
        int count = 0;
        while (current != null) {
            if (current.info.compareTo(item) == 0) {
                return count;
            }
            current = current.next;
            count++;
        }
        if (count == 0){
            System.out.println("The list is empty");
        }

        // item cant be found ec
        System.out.println("Item is not present in the list.");
        return -1; 

    }


    /**
     * Deletes alternating nodes, so if the list was 1 3 5 6, 
     * it would delete 3 and 6.
     */
    public void deleteAlternateNodes() {
        if (head == null) {
            return;
        }
        NodeType current = head;
        while (current != null && current.next != null) {
            current.next = current.next.next; 
            current = current.next; 
        }
    }

    /**
     * Merges 2 lists together in ascending order.
     */
    public void mergeList(SortedLinkedList otherList) {
        NodeType thisCurrent = head;
        NodeType otherCurrent = otherList.head;
        NodeType tempHead = new NodeType(null); 
        NodeType mergedCurrent = tempHead;

        while (thisCurrent != null && otherCurrent != null) {
            if (thisCurrent.info.compareTo(otherCurrent.info) == 0) {
                mergedCurrent.next = thisCurrent;
                mergedCurrent = mergedCurrent.next;
                
                thisCurrent = thisCurrent.next;
                otherCurrent = otherCurrent.next;
            } else if (thisCurrent.info.compareTo(otherCurrent.info) < 0) {
                mergedCurrent.next = thisCurrent;
                mergedCurrent = mergedCurrent.next;
                thisCurrent = thisCurrent.next;
            } else {
                mergedCurrent.next = otherCurrent;
                mergedCurrent = mergedCurrent.next;
                otherCurrent = otherCurrent.next;
            }
        }

        while (thisCurrent != null) {
            mergedCurrent.next = thisCurrent;
            mergedCurrent = mergedCurrent.next;
            thisCurrent = thisCurrent.next;
        }

        while (otherCurrent != null) {
            mergedCurrent.next = otherCurrent;
            mergedCurrent = mergedCurrent.next;
            otherCurrent = otherCurrent.next;
        }

        mergedCurrent.next = null;  
        head = tempHead.next;       
    }



    
    /**
     * Compares the values between the two lists and
     * if they are the same then it will print the value.
     */
    public void intersection(SortedLinkedList otherList) {
        NodeType current1 = this.head; 
        NodeType current2 = otherList.head;         
        while (current1 != null && current2 != null) {
            if (current1.info.compareTo(current2.info) == 0) {
                System.out.print(current1.info + " ");
                current1 = current1.next;
                current2 = current2.next;
            } else if (current1.info.compareTo(current2.info) < 0) {
                current1 = current1.next;
            } else {
                current2 = current2.next;
            }
        }

        System.out.println(); 
    }










}





