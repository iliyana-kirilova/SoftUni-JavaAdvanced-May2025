package Week7_Generics.Scale;

public class Scale <T extends  Comparable<T>>{
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        // this.left - елемент от ляво на везната
        // this.right - елемент от дясно на везната
        if (this.left.compareTo(this.right)>0){
            // this.left - e по-тежък
            return this.left;
        }

        if (this.left.compareTo(this.right)<0){
            // this.right - e по-тежък
            return this.right;
        }

        //this.left.compareTo(this.right)==0
        return null;
    }
}
