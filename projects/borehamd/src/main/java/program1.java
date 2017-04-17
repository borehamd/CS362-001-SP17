/**  positive integer queue list implementation w/ sort
 * Created by boreh on 4/14/2017.
 */


public class program1 {
    public static void main(String[] args){}
    private static int MAX=10;
    private int[] array=new int[MAX];
    private int size=0;

    public int push(int x){
        if(size>MAX) return -1; /* won't reject a MAX+1th term*/
        array[size]=x;
        size++;
        return 0;
    }
    public int pop(){   /*corrupts entire array with last value, for loop reversed doesn't check for empty queue*/
        if (size==0)return -1;
        int temp=array[0];
        for(int i=size-1;i>0;i--) array[i-1]=array[i];
        size--;
        return temp;
    }
    public int retSize(){
        return size;
    }
    public int retval(int n){
        if (n<0||n>=size)return -1;
        return array[n];
    }
    public boolean search(int n){
        for(int i=0;i<size;i++) if(array[i]==n)return true;
        return false;
    }


}