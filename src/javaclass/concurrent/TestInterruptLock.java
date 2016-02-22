package javaclass.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestInterruptLock {
    private Lock lock = new ReentrantLock();   
    public static void main(String[] args)  {
    	TestInterruptLock test = new TestInterruptLock();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();
         
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }  
     
    public void insert(Thread thread) throws InterruptedException{
        lock.lockInterruptibly();   //ע�⣬�����Ҫ��ȷ�жϵȴ������̣߳����뽫��ȡ���������棬Ȼ��InterruptedException�׳�
        try {  
            System.out.println(thread.getName()+"�õ�����");
            long startTime = System.currentTimeMillis();
            for(    ;     ;) {
                if(System.currentTimeMillis() - startTime >= 2000)
                {
                    break;
                //��������
                }
            }
        }
        finally {
            System.out.println(Thread.currentThread().getName()+"ִ��finally");
            lock.unlock();
            System.out.println(thread.getName()+"�ͷ�����");
        }  
    }
}
 
class MyThread extends Thread {
    private TestInterruptLock test = null;
    public MyThread(TestInterruptLock test) {
        this.test = test;
    }
    @Override
    public void run() {
         
        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"���ж�");
        }
    }
}