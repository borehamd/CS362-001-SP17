/**  positive integer queue list implementation w/ sort
 * Created by boreh on 4/14/2017.
 */


public class program1 {
    public static void main(String[] args){}
    private static int MAX=10;
    private int[] array=new int[MAX];
    private int size=0;

    public int push(int x){
        if(size>MAX||x<0) return -1; /* won't reject a MAX+1th term*/
        array[size]=x;
        size++;
        return 0;
    }

    public int pop(){   /*corrupts entire array with last value, for loop reversed*/
        if (size==0)return -1;
        int temp=array[0];
        for(int i=size-1;i>0;i--) array[i-1]=array[i];
        size--;
        return temp;
    }
    public int retSize(){
        return array.length;
    }

    public int retval(int n){
        if (n<0||n>=size)return -1;
        return array[n];
    }

    public int search(int n){
        for(int i=0;i<size;i++) if(array[i]==n)return i;
        return -1;
    }
    // x is the position that is moved to the front of the queue
    // mismanaged for loop (values to the right of target should not be changed)
    public void movetofront(int n){
        if(n<=0||n>=size) return;
        int temp=array[n];
        for(int i=MAX-1;i>0;i--) array[i]=array[i-1];
        array[0]=temp;
    }
}