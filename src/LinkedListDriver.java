import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {
    public static void main(String[] args) {
        
        if (args.length != 1) {
            System.out.println("Usage: java LinkedListDriver input.txt");
            return;
        }

        String fileName = args[0];
        SortedLinkedList list = new SortedLinkedList();

        
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextInt()) {
                int value = fileScanner.nextInt();
                ItemType item = new ItemType(value);
                list.insertItem(item); 
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not open file " + fileName);
            return;
        }

        System.out.println("Initial list from file:");
        list.printList(); 

        Scanner inputScanner = new Scanner(System.in);

        /**
         * Switch case for each command and their path to working.
         */
        while (true) {
            System.out.print("Enter a command: ");
            char command = inputScanner.next().charAt(0);

            switch (command) {
                case 'i':
                    System.out.print("Enter a number to insert: ");
                    int insertValue = inputScanner.nextInt();
                    ItemType insertItem = new ItemType(insertValue);
                    System.out.print("Original list: ");
                    list.printList();
                    list.insertItem(insertItem);
                    System.out.print("New list: ");
                    list.printList();
                    break;
                case 'd':
                    System.out.print("Enter a number to delete: ");
                    int deleteValue = inputScanner.nextInt();
                    ItemType deleteItem = new ItemType(deleteValue);
                    System.out.print("Original list: ");
                    list.printList();
                    list.deleteItem(deleteItem);
                    
                    System.out.print("New list: ");
                    list.printList();
                    break;
                case 's':
                    System.out.print("Enter a number to search: ");
                    int searchValue = inputScanner.nextInt();
                    ItemType searchItem = new ItemType(searchValue);
                    int index = list.searchItem(searchItem);
                    System.out.print("Original list: ");
                    list.printList();
                    if (index != -1) {
                        System.out.println("Item is present at index " + index);
                    }
                    break;
                case 'a':
                    System.out.print("Original list: ");
                    list.printList();
                    list.deleteAlternateNodes();
                    System.out.print("New list: ");
                    list.printList();
                    break;
                case 'm':
                    System.out.print("Enter the length of the new list: ");
                    int mergeLength = inputScanner.nextInt();
                    SortedLinkedList anotherList = new SortedLinkedList();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < mergeLength; i++) {
                        int mergeValue = inputScanner.nextInt();
                        ItemType mergeItem = new ItemType(mergeValue);
                        anotherList.insertItem(mergeItem); 
                    }
                    
                    System.out.print("List 1: ");
                    list.printList();
                    System.out.print("List 2: ");
                    anotherList.printList();
                    list.mergeList(anotherList);
                    System.out.print("Merged list: ");
                    list.printList();
                    break;

                case 't':
                    System.out.print("Enter the length of the new list: ");
                    int intersectLength = inputScanner.nextInt();
                    
                    SortedLinkedList intersectList = new SortedLinkedList();
                    System.out.print("Enter the numbers: ");
                    for (int i = 0; i < intersectLength; i++) {
                        int intersectValue = inputScanner.nextInt();
                        ItemType intersectItem = new ItemType(intersectValue);
                        intersectList.insertItem(intersectItem); 
                    }
                    
                    System.out.print("List 1: ");
                    list.printList();
                    
                    System.out.print("List 2: ");
                    intersectList.printList();
                    
                    System.out.print("Intersection of lists: ");
                    list.intersection(intersectList); 
                    break;

                case 'p':
                    list.printList();
                    break;
                case 'l':
                    System.out.println("The length of the list: " + list.getLength());
                    break;
                case 'q':
                    System.out.println("Quitting program.");
                    return;
                default:
                    System.out.println("Invalid command, try again!");
                    break;
            }
        }
    }
}
