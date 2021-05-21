package lesson3;

public class Something<T extends Object> {
    private T objArr[] ;

    public Something(T ... objArr) {
        this.objArr = objArr;
    }

    public T[] getObjArr() {
        return objArr;
    }

    public void setObjArr(T[] objArr) {
        this.objArr = objArr;
    }
    public static void reversArray(Something arrS, int elem1, int elem2) {
        try {
            Object[] arr = arrS.getObjArr();
            Object[] temp = new Object[2];
             temp[0] = arr[elem1];
            arr[elem1] = arr[elem2];
            arr[elem2] = temp[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива!");
        }


    }


}
