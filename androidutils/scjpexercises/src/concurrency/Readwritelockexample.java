package concurrency;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Readwritelockexample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Readwritelockexample rw = new Readwritelockexample();
		
		ArrayList<Integer> arr = new ArrayList<Integer>();

    final ReentrantReadWriteLock readWriteLock = 
     new ReentrantReadWriteLock();
 
   final Lock read  = readWriteLock.readLock();
   
    final Lock write = readWriteLock.writeLock();
   
		
		arr.add(2);
		arr.add(2);
		arr.add(2);
		arr.add(2);
		arr.add(2);
		System.out.println("arr is "+arr.hashCode());
		ReaderThread reader = rw.new ReaderThread("reader thread",arr,read);
		WriterThread writer = rw.new WriterThread("writer thread",arr,write);
		ReaderThread reader1 = rw.new ReaderThread("reader 1 thread",arr,read);
		ReaderThread reader2 = rw.new ReaderThread("reader 2 thread",arr,read);
		ReaderThread reader3 = rw.new ReaderThread("reader 3 thread",arr,read);
		WriterThread writer2 = rw.new WriterThread("writer2 thread",arr,write);
		
		
		reader.start();
		reader1.start();
		reader2.start();
		reader3.start();
		writer.start();
		writer2.start();
	}
	
	private class ReaderThread extends Thread{

		ArrayList<Integer> arr;
		Lock lock;
		public ReaderThread(String name,ArrayList<Integer> arr,Lock read) {
			// TODO Auto-generated constructor stub
			this.setName(name);
			this.arr = arr;
			System.out.println("reader gets array = "+arr.hashCode());
			lock = read;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				//try commenting these locks to see interleaving in console
				lock.lock();
				System.out.println("Reader "+this.getName()+"reading");
				for(Integer i :arr){
					System.out.print(" "+i);
					
				}
				System.out.println();
				lock.unlock();
				/*try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			}
		}
		
	}

	private class WriterThread extends Thread{

		ArrayList<Integer> arr;
		Lock lock ;
		
		public WriterThread(String name,ArrayList<Integer> arr,Lock write) {
			// TODO Auto-generated constructor stub
			this.setName(name);
			this.arr = arr;
			System.out.println("writer gets array = "+arr.hashCode());
			lock = write;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				System.out.println("Writer"+this.getName()+" writing");
				//try commenting these locks to see interleaving in consoleoutput
				lock.lock();
				for(int index = 0 ;index < arr.size(); index++){
					Integer element = arr.get(index);
					element -=1 ;
					arr.set(index, element);
				}
				lock.unlock();
			/*	try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
			}
		}
		
	}
	
}
