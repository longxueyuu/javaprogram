package javaclass.concurrent.LatchBarrierSemaphore;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

	 public static void main(String[] args) throws InterruptedException {
	        int N = 8;
	        CountDownLatch latch = new CountDownLatch(8);
	        CyclicBarrier barrier  = new CyclicBarrier(N, new Runnable() {
				public void run() {
					System.out.println("�����е�д��������֮�󣬴����е��߳���ѡ��һ���߳���ִ��runnable�еĶ�����ѡ����" + Thread.currentThread().getName());
				}
			});
	        
	        for(int i = 0;i < (N / 2);i++)
	        {
	            new WriterA(barrier, latch).start();
	        	new WriterB(barrier, latch).start();
	        }
	        System.out.println("�ȴ������߳���ɣ�");
	        latch.await();
	        System.out.println("�����߳�ִ�����");
	    }
	 
	 
	 	// �ڲ��߳���
	    static class WriterA extends Thread{
	        private CyclicBarrier cyclicBarrier;
	        private CountDownLatch latch;
	        public WriterA(CyclicBarrier cyclicBarrier, CountDownLatch latch) {
	            this.cyclicBarrier = cyclicBarrier;
	            this.latch = latch;
	        }
	 
	        @Override
	        public void run() {
	            System.out.println("�߳�A"+Thread.currentThread().getName()+"����д������...");
	            try {
	                Thread.sleep((long)Math.random() * 5000);      //��˯����ģ��д�����ݲ���
	                System.out.println("�߳�A"+Thread.currentThread().getName()+"д��������ϣ��ȴ������߳�д�����");
	                cyclicBarrier.await();
	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }catch(BrokenBarrierException e){
	                e.printStackTrace();
	            }
	            System.out.println("����WriterA�߳�ִ�����");
	            latch.countDown();
	        }
	    }
	    
	    // �ڲ��߳���
	    static class WriterB extends Thread{
	        private CyclicBarrier cyclicBarrier;
	        private CountDownLatch latch;
	        public WriterB(CyclicBarrier cyclicBarrier, CountDownLatch latch) {
	            this.cyclicBarrier = cyclicBarrier;
	            this.latch = latch;
	        }
	 
	        @Override
	        public void run() {
	            System.out.println("�߳�B"+Thread.currentThread().getName()+"����д������...");
	            try {
	                Thread.sleep((long)Math.random() * 5000);      //��˯����ģ��д�����ݲ���
	                System.out.println("�߳�B"+Thread.currentThread().getName()+"д��������ϣ��ȴ������߳�д�����");
	                cyclicBarrier.await();
	                
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }catch(BrokenBarrierException e){
	                e.printStackTrace();
	            }
	            System.out.println("����WriterB�߳�ִ�����");
	            latch.countDown();
	        }
	    }
}
