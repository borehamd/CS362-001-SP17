
/**
 * Created by boreh on 4/17/2017.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class testassignment1 {
    @Test
    public void test01()   {
        program1 queue= new program1();
        for(int i=0;i<10;i++){
            queue.push(i);
        }
        int x=queue.push(11);
        assertEquals(x,-1);
    }
    @Test
    public void test02(){
        program1 queue= new program1();
        for(int i=0;i<8;i++){
            queue.push(i);

        }
        int x=queue.pop();
        assertEquals(0,x);
        for(int i=0;i<7;i++){
            assertEquals(i+1,queue.retval(i));
        }

    }

    @Test
    public void test03(){
        program1 queue= new program1();
        for(int i=0;i<8;i++){
            queue.push(i);

        }
        int x=queue.retSize();
        assertEquals(8,x);
    }

    @Test
    public void test04(){
        program1 queue= new program1();
        for(int i=0;i<8;i++){
            queue.push(i+2);

        }
        int x=queue.search(5);
        assertEquals(3,x);
    }

    @Test
    public void test05(){
        program1 queue= new program1();
        for(int i=0;i<8;i++){
            queue.push(i);

        }
        queue.movetofront(4);
        assertEquals(4,queue.retval(0));
    }

    @Test
    public void test06(){
        program1 queue= new program1();
        for(int i=0;i<8;i++){
            queue.push(i);

        }
        queue.movetofront(4);
        assertEquals(7,queue.retval(7));
    }
}


