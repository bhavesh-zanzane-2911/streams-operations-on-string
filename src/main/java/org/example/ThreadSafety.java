package org.example;

public class ThreadSafety {


    public static void main(String[] args) throws InterruptedException {
        //String Buffer is thread safe and below is an example
        //Everytime we run a code sb length would always be same
        StringBuffer sb=new StringBuffer();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                sb.append(i+" ");
            }
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                sb.append(i+" ");
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("SB "+sb.length());

    }

}
