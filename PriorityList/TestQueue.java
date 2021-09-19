/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2s03.assignment2;

/**
 *
 * @author mehakkhan
 */
public class TestQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyQueue q = new MyQueue();
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                q.add(new Customer (i, j));

            }
        }
      //  System.out.println(q.back);
       System.out.println(q.print());
       
      //  System.out.println(q.print());
        for (int i = 0; i < 100; i ++) {
            q.remove();
        }
       System.out.println(q.print());
     //   System.out.println(q.front);
     //   System.out.println(q.back);

//        
//        
        for (int i = 0; i < 50; i++) {
            //System.out.println("B" + q.back);
            q.add(new Customer (i,i));
        }
////        
////       // System.out.println(q.front);
       //  System.out.println(q.peek().helper());
        System.out.println(q.print());
        
        for (int i = 0; i < 25; i++) {
            //System.out.println("B" + q.back);
            q.remove();
        }
       // System.out.println(q.peek().helper());
        System.out.println(q.print());
////
//}
}
}
    

