
/**
 * Created by 76623 on 2018/5/31.
 */
public class VolatileTest2 {

    long v1 = 0L;

    public synchronized void set(long l){
        v1 = l;
    }

    public synchronized void getAndInc(){
       long temp = get();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp += 1L;
        set(temp);
    }

    public synchronized long get(){
        return v1;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest2 test = new VolatileTest2();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                test.getAndInc();
            }).start();

        }

        Thread.sleep(6000);
        System.out.println("__________________" + test.get());
    }


}
