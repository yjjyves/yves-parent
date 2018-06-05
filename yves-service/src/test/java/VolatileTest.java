
/**
 * Created by 76623 on 2018/5/31.
 */
public class VolatileTest {

    volatile long v1 = 0L;

    public void set(long l){
        v1 = l;
    }

    public void getAndInc(){
        v1++;
    }

    public long get(){
        return v1;
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                test.getAndInc();
                System.out.println(test.get());
            }).start();

        }
    }

}
