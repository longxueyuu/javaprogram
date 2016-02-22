package javaclass.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class TestCopyOnWriteArrayList {
    /**
     * ���߳�
     * @author wangjie
     *
     */
    private static class ReadTask implements Runnable {
        List<String> list;
        int index;
 
        public ReadTask(List<String> list, int index) {
            this.list = list;
            this.index = index;
        }
 
        public void run() {
        	// ����ǰ����
          for (String str : list) {
          System.out.println(str);
     		}
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(list.get(0));// ����ʱ��Ҫ���ñ����ķ�ʽ��ֱ��get���ܻ��������Խ�����
            
//            for (String str : list) {
//                System.out.println(str);
//            }
        }
    }
    /**
     * д�߳�
     * @author wangjie
     *
     */
    private static class WriteTask implements Runnable {
        List<String> list;
        int index;
 
        public WriteTask(List<String> list, int index) {
            this.list = list;
            this.index = index;
        }
 
        public void run() {
        	System.out.println("romoving...");
            list.remove(index);
            System.out.println("romoved...");
        }
    }
 
    public void run() {
        final int NUM = 10;
        List<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < NUM; i++) {
            list.add("main_" + i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUM);
        for (int i = 0; i < 1; i++) {
            executorService.execute(new ReadTask(list, 0));// 
            executorService.execute(new WriteTask(list, 0));
        }
        executorService.shutdown();
    }
 
    public static void main(String[] args) {
        new TestCopyOnWriteArrayList().run();
    }
}