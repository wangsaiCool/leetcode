package concurrencyInPractice;

import org.openjdk.jol.info.ClassLayout;

/**
 * Created by WangSai on 2021/2/17
 */
public class LockUpgrade {


    public static void main(String[] args) throws Exception {
        LockUpgrade lp = new LockUpgrade();
        LocalUser localUser1 = new LocalUser();
        System.out.println("无锁状态-001: " + ClassLayout.parseInstance(localUser1).toPrintable());

        synchronized (localUser1) {
            System.out.println("偏向锁锁状态-001: " + ClassLayout.parseInstance(localUser1).toPrintable());

        }
        // jvm 默认4sec开启偏向锁
        Thread.sleep(5000L);
        LocalUser localUser2 = new LocalUser();
        System.out.println("偏向锁状态-101: " + ClassLayout.parseInstance(localUser2).toPrintable());

        // 加锁之后，会将线程id写入对象头
        for (int i = 0; i < 2; i++) {
            synchronized (localUser2) {
                System.out.println("偏向锁状态-101(带线程id-"+i+"): " + ClassLayout.parseInstance(localUser2).toPrintable());
            }
            // 实际上，并不会释放偏向锁
            System.out.println("偏向锁释放-101(带线程id-"+i+"): " + ClassLayout.parseInstance(localUser2).toPrintable());
        }

        new Thread(() -> {
            synchronized (localUser2) {
                System.out.println("轻量级锁-00(带线程id: " + ClassLayout.parseInstance(localUser2).toPrintable());
                lp.sleep(3000L);
                System.out.println("轻量级锁升级为重量级锁-10，" + ClassLayout.parseInstance(localUser2).toPrintable());
            }
        }).start();
        lp.sleep(1000L);

        new Thread(() -> {
            synchronized (localUser2) {
                System.out.println("重量级锁-10，" + ClassLayout.parseInstance(localUser2).toPrintable());
            }

        }).start();
    }

    private void sleep(long ms)  {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
