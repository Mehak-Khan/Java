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
public class TEMP {

    public void addCustomer(Customer customer) {
        if (isEmpty()) {
            PriorityNode n = new PriorityNode();
            n.getQeueue().add(customer);
            head = n;
        } else {

            //CHECK FOR PRIORITY LEVEL 
            PriorityNode current = head;
            //  System.out.println("XX");
            while (current.next != null) {
                //  System.out.println("XX");
                if (current.getQeueue().peek().priority == customer.priority) {
                    break;

                } else if (customer.priority < current.next.getQeueue().peek().priority) {
                    System.out.println("HELLO");
                    head = new PriorityNode();
                    break;
                    //ADD TO THE CURRENT NODE because customer priority is less than the next node
                }
                current = current.next;
                //else addd it to the end which will eventually happen at the end of the loop
            }
            //  System.out.println("XX");

            //now we add to whatever the current node is basically 
            //we have to check the queue of the current node
            //add it appropriately according to ID first come first serve basis
            MyQueue tempCheckID = new MyQueue(); //temp queue to store 

            //  Customer c0 = current.getQeueue().remove(); //get last element to check
            //  tempCheckID.add(c0);
            if (current.getQeueue().peek().id > customer.id) { //if last element had higher priority
                //       System.out.println("LL");
                boolean condition = true;
                while (condition) { //while true
                    if (current.getQeueue().isEmpty()) {
                        break;
                    }

                    Customer c = current.getQeueue().remove(); //get another element and add it to temp
                    tempCheckID.add(c);

                    if (c.id < customer.id) {
                        current.getQeueue().add(c);
                        break;
                    }

                }
            } else {

            }
            current.getQeueue().add(customer);
            // System.out.println("ZZZz");
            while (!tempCheckID.isEmpty()) {
                System.out.println("ZZZZ");
                current.getQeueue().add(tempCheckID.remove());

            }
        }
    }

}


public PriorityList mergeLists(PriorityList listToMerge) {
        //PriorityNode current = listToMerge.head;
        MyQueue temp = new MyQueue();
        MyQueue temp2 = new MyQueue();
        PriorityList merged = new PriorityList();

        //get number of cust for both!!
        int og = this.getNumberOfNodes();
        int in = listToMerge.getNumberOfNodes();
        int min;
        int maxN;
        if (og <= in) {
            min = og;

        } else {
            min = in;

        }

        for (int i = 0; i < min; i++) {
            if (listToMerge.head.getQeueue().peek().priority == this.head.getQeueue().peek().priority) {
              //  System.out.println("HELLOPP");
                // INTERLEAVE :D 

                //get max length
                int lm = listToMerge.head.getQeueue().getLength();
                int th = this.head.getQeueue().getLength();
                int max;
                if (lm > th) {
                    max = lm;

                } else {
                    max = th;
                }

                //INTERLEAVE 
                for (int j = 0; j < max; j++) {
                    if (j < th) {
                        //add the og to merged
                       // System.out.println("HELLO");
                        merged.addCustomer(this.head.getQeueue().peek());
                        temp.add(this.head.getQeueue().remove());
                        if (this.head.getQeueue().isEmpty()) {
        
                            this.head = head.next;
                        }

                    }
                    if (j < lm) {
                        //add the in to merged
                        merged.addCustomer(listToMerge.head.getQeueue().peek());
                        temp2.add(listToMerge.head.getQeueue().remove());
                        if (listToMerge.head.getQeueue().isEmpty()) {
                            listToMerge.head = listToMerge.head.next;
                        }

                    }
                }

            }
            
           
        }

        while (!listToMerge.isEmpty()) {

            while (!listToMerge.head.getQeueue().isEmpty()) {
                //  System.out.println("XX");
                //      System.out.println(listToMerge.head.getQeueue());
                merged.addCustomer(listToMerge.head.getQeueue().peek());
                temp2.add(listToMerge.head.getQeueue().remove());

                //  listToMerge.head.getQeueue().remove();
            }

            listToMerge.head = listToMerge.head.next;
        }

        while (!this.isEmpty()) {

            while (!this.head.getQeueue().isEmpty()) {
                //  System.out.println("XX");
                //      System.out.println(listToMerge.head.getQeueue());
                merged.addCustomer(this.head.getQeueue().peek());
                temp.add(this.head.getQeueue().remove());

                //  listToMerge.head.getQeueue().remove();
            }

            this.head = this.head.next;
        }

        while (!temp.isEmpty()) {
            Customer c = temp.remove();
            this.addCustomer(c);

        }

        while (!temp2.isEmpty()) {

            listToMerge.addCustomer(temp2.remove());

        }

        return merged;

    }



////////RESIZE DOWN



//        if (front == customers.length) {
//            System.out.println("CIRCLE BACK???");
//            front = 0;
//        }
        //  System.out.println("SS");
        //(customers.length * 3) / 4;
        // System.out.println(customers.length);
        //   System.out.println("ELEMENT" + this.length);
        int newLength = (4 * this.length);
        if (front - (customers.length - newLength) - 1 >= 0) {
            front = front - (customers.length - newLength) - 1;
            back = back - (customers.length - newLength);
        }

        // System.out.println("DEC" + front);
        //    front = front - (newLength - customers.length);
//        while (front >= newLength) {
//            //System.out.println(newLength);
//            newLength = newLength + 1;
//       
        Customer[] temp = new Customer[newLength];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = customers[i];
            //  System.out.println(customers[i].helper());
        }
//        if (front != 0) {
//         front = front - 1;
//      }
        customers = temp;
        System.out.println("RESIZED DOWN TO:" + customers.length);




    public void resizeUp() {
//        if (front == back) {
//            front = 0;
//            back = 0;
//        }
        int newLength = (this.length * (3)) / 2 + 1;
        back = customers.length;
        if (newLength < 10) {

        } else {

            //  System.out.println(newLength);
            Customer[] temp = new Customer[newLength];
            for (int i = 0; i < customers.length; i++) {
                temp[i] = customers[i];
            }
            customers = temp;
           // System.out.println("RESIZED UP TO:" + customers.length);

        }
  
    }




    public void resizeDown() {
        if (front == back) {
            front = 0;
            back = 0;
        }

        int newLength = this.length * 4; //NEW LENGTH

        back = back - front;

        //only copy from front onwards!!!!!
        Customer[] temp = new Customer[newLength];
        for (int i = 0; i < newLength; i++) {
            if (front + i == customers.length) {
                break;
            }
            temp[i] = customers[front + i];
        }

        customers = temp;
        front = 0;

       // System.out.println("RESIZED DOWN TO:" + customers.length);
    }









    public PriorityList mergeLists(PriorityList listToMerge) {

        MyQueue temp = new MyQueue();
        MyQueue temp2 = new MyQueue();
        PriorityList merged = new PriorityList();
        if (listToMerge == this) {
            while (!this.isEmpty()) {
                //  System.out.println("YY");
                while (!this.head.getQeueue().isEmpty()) {
                    //     System.out.println("XX");
                    merged.addCustomer(this.head.getQeueue().peek());
                    merged.addCustomer(this.head.getQeueue().peek());
                    temp.add(this.head.getQeueue().remove());
                }
                head = head.next;
            }
            this.numberOfCustomers = 0;
            while (!temp.isEmpty()) {

                Customer c = temp.remove();

                this.addCustomer(c);

            }
            return merged;

        }

        int nodesLM = listToMerge.getNumberOfNodes();
        int nodesTH = this.getNumberOfNodes();
        int minNODES;

        if (nodesLM == 0 && nodesTH == 0) {

            return merged;

        } else if (nodesLM == 0) {

            while (!this.isEmpty()) {

                while (!this.head.getQeueue().isEmpty()) {

                    merged.addCustomer(this.head.getQeueue().peek());
                    temp.add(this.head.getQeueue().remove());

                }

                this.head = this.head.next;
            }

            this.numberOfCustomers = 0;

            while (!temp.isEmpty()) {

                Customer c = temp.remove();

                this.addCustomer(c);

            }
            return merged;

        } else if (nodesTH == 0) {
            while (!listToMerge.isEmpty()) {

                while (!listToMerge.head.getQeueue().isEmpty()) {

                    merged.addCustomer(listToMerge.head.getQeueue().peek());
                    temp2.add(listToMerge.head.getQeueue().remove());
                }

                listToMerge.head = listToMerge.head.next;
            }

            listToMerge.numberOfCustomers = 0;

            while (!temp2.isEmpty()) {

                Customer c = temp2.remove();

                listToMerge.addCustomer(c);

            }
            return merged;

        }

        if (nodesLM < nodesTH) { //GET MIN NODE NUMB
            minNODES = nodesLM;
        } else {
            minNODES = nodesTH;
        }

        for (int i = 0; i < minNODES; i++) {
    
            int priorTH = this.head.getQeueue().peek().priority;
            int priorLM = listToMerge.head.getQeueue().peek().priority;

            if (priorTH == priorLM) {
                System.out.println("EXCUSE MOI??");
                //INTERLEAVE

                int custLM = listToMerge.head.getQeueue().getLength();
                int custTH = this.head.getQeueue().getLength();
              //  System.out.println(custTH);
                int maxCUST;
                if (custLM > custTH) {
                    maxCUST = custLM;
                } else {
                    maxCUST = custTH;
                }

                for (int j = 0; j < maxCUST; j++) {
                    if (j < custTH) {
                        //System.out.println("FIRS THING???????");
                        merged.addCustomer(this.head.getQeueue().peek());
                        temp.add(this.head.getQeueue().remove());
                        if (this.head.getQeueue().isEmpty()) {
                            this.head = head.next;
                        }
                    }
                    if (j < custLM) {
                        merged.addCustomer(listToMerge.head.getQeueue().peek());
                        temp2.add(listToMerge.head.getQeueue().remove());
                        if (listToMerge.head.getQeueue().isEmpty()) {
                            listToMerge.head = listToMerge.head.next;
                        }
                    }
                }

            } else {

                if (priorTH < priorLM) {
                    while (!this.head.getQeueue().isEmpty()) {
                        merged.addCustomer(this.head.getQeueue().peek());
                        temp.add(this.head.getQeueue().remove());
                    }
                    this.head = head.next;
                } else {
                    while (!listToMerge.head.getQeueue().isEmpty()) {
                        merged.addCustomer(listToMerge.head.getQeueue().peek());
                        temp2.add(listToMerge.head.getQeueue().remove());
                    }
                    listToMerge.head = listToMerge.head.next;
                }

            }

        }

        //LOGIC HERE
        while (!listToMerge.isEmpty()) {

            while (!listToMerge.head.getQeueue().isEmpty()) {

                merged.addCustomer(listToMerge.head.getQeueue().peek());
                temp2.add(listToMerge.head.getQeueue().remove());
            }

            listToMerge.head = listToMerge.head.next;
        }

        while (!this.isEmpty()) {

            while (!this.head.getQeueue().isEmpty()) {

                merged.addCustomer(this.head.getQeueue().peek());
                temp.add(this.head.getQeueue().remove());

            }

            this.head = this.head.next;
        }

        listToMerge.numberOfCustomers = 0;
        this.numberOfCustomers = 0;

        while (!temp.isEmpty()) {

            Customer c = temp.remove();

            this.addCustomer(c);

        }

        while (!temp2.isEmpty()) {

            Customer c = temp2.remove();

            listToMerge.addCustomer(c);

        }

        return merged;
    }


    public String helper() {
        if (this.isEmpty()) {
            return "( )";
        }
        PriorityNode current = head;
        String s = "[";

        s += head.getQeueue().print();

        while (current.next != null) {

            current = current.next;
            s += current.getQeueue().print();

        }
        s += "]";
        return s;
    }

    public String print() {
        String s = "";
        int c = customers.length;

        for (int i = front; i < c; i++) {
            if (customers[i] == null) {
                s += "[null]";
            } else {
                s += "[" + customers[i].id + ", " + customers[i].priority + "]";
            }
        }
        return s;
    }
