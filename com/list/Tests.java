package com.list;

public class Tests<T> {

    public static void main(String[] args) {
        Tests tests = new Tests();

        MyList<Integer> arrayListOfIntegers = new MyArrayList<>();
        arrayListOfIntegers.add(0);
        arrayListOfIntegers.add(1);
        arrayListOfIntegers.add(2);
        arrayListOfIntegers.add(3);
        arrayListOfIntegers.add(4);
        arrayListOfIntegers.add(5);

        tests.printList(arrayListOfIntegers);

        MyList<String> arrayListOfStrings = new MyArrayList<>();
        arrayListOfStrings.add("Valentina");
        arrayListOfStrings.add("Anatoliy");
        arrayListOfStrings.add("Maxim");
        arrayListOfStrings.add("Dmitriy");
        arrayListOfStrings.add("Andrey");

        tests.printList(arrayListOfStrings);

        int removed = arrayListOfIntegers.remove(2);
        System.out.println("\nElement " + removed + " is removed from the MyArrayList of integers");

        int removed1 = arrayListOfIntegers.remove(arrayListOfIntegers.size() - 1);
        System.out.println("\nElement " + removed1 + " is removed from the MyArrayList of integers");

        tests.printList(arrayListOfIntegers);

        String removed2 = arrayListOfStrings.remove(0);
        System.out.println("\nElement " + removed2 + " is removed from the MyArrayList of Strings");

        String removed3 = arrayListOfStrings.remove(arrayListOfStrings.size() - 1);
        System.out.println("\nElement " + removed3 + " is removed from the MyArrayList of Strings");

        tests.printList(arrayListOfStrings);

        System.out.println("====================================================================");

        MyList<Integer> linkedListOfIntegers = new MyLinkedList<>();
        linkedListOfIntegers.add(5);
        linkedListOfIntegers.add(4);
        linkedListOfIntegers.add(3);
        linkedListOfIntegers.add(2);
        linkedListOfIntegers.add(1);
        linkedListOfIntegers.add(0);

        tests.printList(linkedListOfIntegers);

        MyList<String> linkedListOfStrings = new MyArrayList<>();
        linkedListOfStrings.add("Cat");
        linkedListOfStrings.add("Dog");
        linkedListOfStrings.add("Parrot");
        linkedListOfStrings.add("Bird");
        linkedListOfStrings.add("Mouse");

        tests.printList(linkedListOfStrings);

        int removed4 = linkedListOfIntegers.remove(4);
        System.out.println("\nElement " + removed4 + " is removed from the MyLinkedList of integers");

        int removed5 = linkedListOfIntegers.remove(3);
        System.out.println("\nElement " + removed5 + " is removed from the MyLinkedList of integers");

        tests.printList(linkedListOfIntegers);

        String removed6 = linkedListOfStrings.remove(0);
        System.out.println("\nElement " + removed6 + " is removed from the MyLinkedList of Strings");

        String removed7 = linkedListOfStrings.remove(linkedListOfStrings.size() - 2);
        System.out.println("\nElement " + removed7 + " is removed from the MyLinkedList of Strings");

        tests.printList(linkedListOfStrings);
    }

    private void printList(MyList<T> list) {
        System.out.print("\n[");
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print(list.get(list.size() - 1) + "]\n");
        System.out.println("size = " + list.size());
    }
}
