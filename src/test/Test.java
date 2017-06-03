package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import cachableobject.Book;
import cache.*;


public class Test {

	public static void main(String[] args) throws InterruptedException, IOException, SQLException {
	//	speedCacheTest();
		//integrityCacheTest();
		mergeCacheTest();
		
	}
	/*
	 * Merge Cache Testim son olarak gelistirdigim implementasyondur
	 * Parametre olarak boyut ve implementasyon icin boolean aliyor
	 * true verdigimizde maximum hit ratio icin calisir
	 * false verdigimizda maximum speed icin calisir
	 * 
	 * */
	public static void mergeCacheTest(){

		Random r = new Random();
		Librarian li;		
		li = new Librarian(new MergeCache<String, Book>(100,true));
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
				
			}								
		},"Second reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();						
					}		
				}
				
			}									
		},"Fourth reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
				
			}									
		},"Third reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();				
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(20000);
					System.out.println(li.getHitRatio() + " => `HIT RATIO");
					System.out.println(li.getAvgGetOperationTime() + "=> AVERAGE GET OPERATION TIME");
					System.out.println(li.getAvgSetOperationTime() + "=> AVERAGE SET OPERATION TIME");
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			
			
		}).start();	
		
		
	}
	public static void integrityCacheTest(){

		Random r = new Random();
		Librarian li;	
		li = new Librarian(new IntegrityCache<String, Book>(100));
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();		
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
				
			}								
		},"Second reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();						
					}		
				}
				
			}									
		},"Fourth reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
				
			}									
		},"Third reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();	
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(20000);
					System.out.println(li.getHitRatio() + " => `HIT RATIO");
					System.out.println(li.getAvgGetOperationTime() + "=> AVERAGE GET OPERATION TIME");
					System.out.println(li.getAvgSetOperationTime() + "=> AVERAGE SET OPERATION TIME");
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			
			
		}).start();	
				
		
		
	}
	public static void speedCacheTest(){
		
		Random r = new Random();
		Librarian li;		
		li = new Librarian(new SpeedCache<String, Book>(100));
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(300-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}									
		},"First reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
				
			}								
		},"Second reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();						
					}		
				}
				
			}									
		},"Fourth reader").start();
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					try {
						System.out.println(li.getBookFromDatabase(Integer.toString(r.nextInt(500-1)+1)));
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
				
			}									
		},"Third reader").start();							
		new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(20000);
					System.out.println(li.getHitRatio() + " => `HIT RATIO");
					System.out.println(li.getAvgGetOperationTime() + "=> AVERAGE GET OPERATION TIME");
					System.out.println(li.getAvgSetOperationTime() + "=> AVERAGE SET OPERATION TIME");
					System.exit(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
			
			
		}).start();	
	}

}
