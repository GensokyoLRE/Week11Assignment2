import java.util.ArrayList;

public class GenericQueue2<O>{
    private final ArrayList<O> elements;

    private GenericQueue2(){
        this(10);
    }

    private GenericQueue2(int capacity){
        int initCap = capacity > 0 ? capacity : 10;
        elements = new ArrayList<>(initCap);
        String[] list2 ={"Bob","Ross","Dan","Avi","Arin",null};
        for (String s : list2) {
            elements.add((O)s);
        }
    }

    public void printQueue(O[] inputArray) throws EmptyStackException{
        if (elements.isEmpty()){
            throw new EmptyStackException();
        }
        System.out.println("\nArrayList elements contains: ");
        for (O element : inputArray){
            System.out.print(element);
            System.out.print(" ");
        }
    }

    public O dequeue(O removeItem) throws EmptyStackException{
        if (elements.isEmpty()){
            throw new EmptyStackException();
        }
        int removed = 0;
        for (int x = 0; x < elements.size(); x++) {
            if (elements.get(x) == removeItem) {
                elements.remove(x);
                removed = x;
                break;
            }
        }
        System.out.println("The following was dequeued: " + removeItem);
        return elements.get(removed);
    }

    public O enqueue(O element) throws EmptyStackException{
        if (elements.isEmpty()){
            throw new EmptyStackException();
        }
        final int sized = elements.size();
        if (elements.get(elements.size()-1)== null){
            elements.set(sized-1,element);
        } else {
            elements.add(element);
        }
        System.out.println("The following was queued: " + element);

        return elements.get(elements.size()-1);
    }

    public static void main(String[] args) {
        try{
            GenericQueue2 genQueue2 = new GenericQueue2<>(6);
            String[] list1 ={"George","Steve","Ana","Carl","Sheen","Jimmy","Teal"};

            for (String s2 : list1){
                if (genQueue2.elements.get(genQueue2.elements.size()-1)== null){
                    genQueue2.enqueue(s2);
                } else {
                    genQueue2.dequeue(genQueue2.elements.get(0));
                    genQueue2.enqueue(s2);
                }
            }
            
            genQueue2.printQueue(genQueue2.elements.toArray());
            System.out.println();

        } catch (EmptyStackException eSE){
            System.err.println();
            eSE.printStackTrace();
        }
    }

}
