import java.util.ArrayList;

public class GenericQueue<Object>{
    private ArrayList<Object> elements = new ArrayList<>();
    private String[] list1 ={"George","Steve","Ana","Carl","Sheen","Jimmy","Teal"};
    private String[] list2 ={"Bob","Ross","Dan","Avi","Arin"};

//    ArrayList<String> list1 = new ArrayList<>(Arrays.asList("George","Steve","Ana","Carl","Sheen","Jimmy","Teal"));
//    ArrayList<String> list2 = new ArrayList<>(Arrays.asList("Bob","Ross","Dan","Avi","Arin"));

    private GenericQueue(int capacity){
        int initCapacity = capacity > 0 ? capacity : 10;
        elements = new ArrayList<>(initCapacity);
        for (int x = 0; x < list2.length; x++){
            elements.add((Object)list2[x]);
        }
    }

    public void dequeue(){
        try{
            System.out.println("Dequeueing element: " + elements.get(0));
            elements.remove(0);
        } catch (EmptyStackException emptyStackExcept){
            System.err.println();
            emptyStackExcept.printStackTrace();
        }
    }

    public void enqueue(Object element){
        try{
            System.out.println("Enqueueing element: " + element);
            elements.add(elements.size(),element);
        } catch (EmptyStackException emptyStackExcept){
            System.err.println();
            emptyStackExcept.printStackTrace();
        }
    }

    public int length(){
        final int arrayLength = elements.size();
        System.out.println("Calculating length.... length is: " + arrayLength);
        return arrayLength;
    }

    public void GenQueueRun(){
        try{
            final int lengthOfElements = length();
            System.out.println("Size of queue now is: " + lengthOfElements);

            for (String input : list1){
                if (elements.get(elements.size()-1) == null){
                    enqueue((Object)input);
                } else {
                    dequeue();
                    enqueue((Object)input);
                }
            }
            for (Object o: elements){
                System.out.println("Inside of elements is: " + o);
            }
        } catch (EmptyStackException ese){
            System.err.println();
            ese.printStackTrace();
        }
    }


    public static void main(String[] args) {
        GenericQueue trialQueue = new GenericQueue(6);
        trialQueue.GenQueueRun();
    }

}
