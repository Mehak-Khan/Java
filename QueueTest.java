/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.khan.ics4u.u5;

/**
 *
 * @author 1khanmeh3
 */
public class QueueTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue q = new Queue();
        assert (q.tail() == null);
        assert (q.head() == null);
        assert (q.capacity() == 11);
        assert (q.size() == 0);
        assert (q.isFull() == false);
        assert (q.isEmpty() == true);
        //  q.toString();

        int letter = 96;
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

        for (int i = 0; i < q.capacity(); i++) {
            q.enqueue(Character.toString(++letter));
            assert (q.tail().equals(letters[i]));
        }

        //OVERFILL
        q.enqueue("l");
        assert (q.tail().equals("k"));
        assert (q.head().equals("a"));
        assert (q.isFull() == true);
        assert (q.size() == 11);
        assert (q.isEmpty() == false);

        for (int i = 0; i < q.capacity() - 1; i++) {
            q.dequeue();
            assert (q.head().equals(letters[i + 1]));
        }

        //OVERPOP
        q.dequeue();
        assert (q.head() == null);
        assert (q.tail() == null);
        assert (q.capacity() == 11);
        assert (q.size() == 0);
        assert (q.isFull() == false);
        assert (q.isEmpty() == true);

        //MAKE EMPTY
        for (int i = 0; i < q.capacity(); i++) {
            q.enqueue(Character.toString(++letter));
        }

        q.makeEmpty();
        assert (q.head() == null);
        assert (q.tail() == null);
        assert (q.capacity() == 11);
        assert (q.size() == 0);
        assert (q.isFull() == false);
        assert (q.isEmpty() == true);
        
        
        Queue q1 = new Queue();
        q1.enqueue("2");
        q1.enqueue("33");
        System.out.println(q1.size());
        q1.dequeue();
        q1.dequeue();
        System.out.println(q1.size());
        System.out.println(q1.isEmpty());

    }
}
