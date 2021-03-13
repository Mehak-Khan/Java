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
public class StackTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack s = new Stack();
        assert (s.peek() == null);
        assert (s.capacity() == 11);
        assert (s.size() == 0);
        assert (s.isFull() == false);
        assert (s.isEmpty() == true);

        int letter = 96;
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

        for (int i = 0; i < s.capacity(); i++) {
            s.push(Character.toString(++letter));
            assert (s.peek().equals(letters[i]));
        }

        //OVERFILL
        s.push("l");
        assert (s.peek().equals("k"));
        assert (s.capacity() == 11);
        assert (s.size() == 11);
        assert (s.isFull() == true);
        assert (s.isEmpty() == false);
        

        for (int i = 0; i < s.capacity() - 1; i++) {
            s.pop();
            assert (s.peek().equals(letters[s.capacity() - i - 2]));
        }

        //OVERPOP
        s.pop();
        assert (s.peek() == null);
        assert (s.capacity() == 11);
        assert (s.size() == 0);
        assert (s.isFull() == false);
        assert (s.isEmpty() == true);

        //Make full to test make empty
        for (int i = 0; i < s.capacity(); i++) {
            s.push(Character.toString(++letter));
        }
        s.makeEmpty();
        assert (s.peek() == null);
        assert (s.capacity() == 11);
        assert (s.size() == 0);
        assert (s.isFull() == false);
        assert (s.isEmpty() == true);

        //size given
        Stack s1 = new Stack(13);
        assert (s1.capacity() == 13);

    }

}
