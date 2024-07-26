//making a function called add to insert element to free spaces i.e. inside the array 0s. if there is no free spaces inside the array then add to last position.
class ArrayADT {
    private int size, array[];
    private static int point;

    // constructor
    ArrayADT() {
        array = new int[0];
        size = 0;
    }

    ArrayADT(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // insertion
    public void insertElement(int index, int element) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException("Index is out of range");
        } else if (isFull()) {
            System.out.println("Array is full!");
        } else if (size <= index) {
            array[index] = element;
            size = index + 1;
        } else {// size<=index==>size=index+1; 0 2 0 1 5
            for (int i = size - 1; index <= i; i--) {
                array[i + 1] = array[i];
                array[i] = 0;
            }
            array[index] = element;
            size++;
        }
    }

    // add make it work bro
    public void add(int element) {
        for(int i=0;i<array.length;i++){
            if(array[i]==0){point=i;break;}
        }
        array[point]=element;
        if(point>size-1){size++;}
    }

    // update
    public void update(int index, int element) {
        if (index < 0 || index > array.length - 1) {
            throw new IndexOutOfBoundsException("Index is out of range");
        } else {
            array[index] = element;
        }
    }

    // array full or not
    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // deletion
    public void deleteByindex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index is out of range");
        } else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0;
            size--;
        }
    }

    // deletion by element
    public void deleteByElement(int element) {
        int index = searchByElement(element);
        if (index == -1) {
            System.out.println("Given element is not in the array!");
        } else {
            deleteByindex(index);
        }
    }

    // search element in unsorted array
    public int searchByElement(int element) {
        int index = -1;
        for (int i = 0; i < size - 1; i++) {
            if (element == array[i]) {
                return i;
            }
        }
        return index;
    }

    // traverse
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += array[i] + ",";
        }
        return str;
    }

}

class test {
    public static void main(String args[]) {
        ArrayADT arr = new ArrayADT(5);
        // inserting in row
        arr.insertElement(0, 10);
        arr.insertElement(1, 20);
        arr.insertElement(2, 30);
        arr.insertElement(3, 40);
        arr.insertElement(4, 50);
        System.out.println("Array: " + arr.toString());
        // searching index by element
        System.out.println("index of 40: " + arr.searchByElement(40));// 3
        System.out.println("index of 400: " + arr.searchByElement(400));// -1 theres no
        // deleting the element by the element
        arr.deleteByElement(400);
        System.out.println("Array: " + arr.toString());

        ArrayADT arr1 = new ArrayADT(5);
        // inserting in middle
        arr1.insertElement(0, 10);
        arr1.insertElement(1, 20);
        arr1.insertElement(2, 30);
        arr1.insertElement(4, 40);// 10 20 30 0 40
        arr1.insertElement(1, 50);// 10 50 20 30 0
        System.out.println("Array1: " + arr1.toString());
        // inserting after array is full

        ArrayADT arr2 = new ArrayADT(30);
        System.out.println("****************************************************************************");
        // inserting in row
        arr2.insertElement(0, 10);
        arr2.insertElement(1, 20);
        //arr2.insertElement(2, 30);
        //arr2.insertElement(3, 40);
        arr2.insertElement(4, 50);
        arr2.insertElement(1, 25);
        System.out.println("Array2: " + arr2.toString());
        arr2.add(15);System.out.println("****************\nArray2: " + arr2.toString());
        arr2.add(25);System.out.println("****************\nArray2: " + arr2.toString());
        arr2.add(35);
        System.out.println("****************\nArray2: " + arr2.toString());

        arr2.insertElement(20, 20);
        System.out.println("****************\nArray2: " + arr2.toString());
        arr2.insertElement(17, 17);
        System.out.println("****************\nArray2: " + arr2.toString());
        arr2.add(18);
        System.out.println("****************\nArray2: " + arr2.toString());
        arr2.insertElement(20, 2400);
        System.out.println("****************\nArray2: " + arr2.toString());
        System.out.println("****************************************************************************");
        // deleting arr2
        arr2.deleteByindex(0);// 20 30 40 50
        arr2.deleteByindex(3);// 20 30 40
        arr2.deleteByindex(1);// 20 40
        arr2.deleteByindex(0);// 40
        arr2.deleteByindex(0);//
        // arr2.deleteByindex(0);//error
        System.out.println("Array2: " + arr2.toString());

    }
}