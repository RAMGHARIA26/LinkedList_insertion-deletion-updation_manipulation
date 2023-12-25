import java.math.BigInteger;
import java.util.Scanner;

public class main {

    public static void printRev(Node<Integer> head){
        if(head == null){
            return;
        }else {
            printRev(head.next);

            System.out.println(head.data);
        }
    }

    public static void duplicateRemove(Node head){
        Node temp = head.next;
        Node prev = head;

        while(prev!=null && temp!=null){
            if(prev.data != temp.data){
                prev.next = temp;
                prev = prev.next;
                temp = temp.next;
            }else{
                temp = temp.next;
            }
        }

        print(head);
    }


    public static void appendLastNode(Node<Integer> head,int n){
        Node<Integer> t = head;
        Node<Integer> temp = head;
        int length = 0;
        while(t!= null ){
            length++;
            temp = t;
            t = t.next;
        }
        int cnt=1;
        int loc = length - n;

        temp.next = head;
        Node<Integer> prev = head;
        while(cnt < loc){

            prev = prev.next;
            cnt++;
        }
        head = prev.next;
        prev.next = null;
        print(head);

    }


    public static void deleteNode(Node<Integer> head ,int loc){
        Node<Integer> temp = head;

        int cnt = 0;
        if(loc == 0){
            head  = temp.next;
        }else {

            while (cnt < loc) {
                temp = temp.next;
                cnt++;
            }

            temp.next = temp.next.next;
        }
        print(head);
    }


    public static void locInsert(Node<Integer> head,int data,int loc){

        Node<Integer> temp = head;
        Node<Integer> newNode = new Node<>(data);
        int cnt = 0;

        if(loc == 0){
            newNode.next = head;
            head = newNode;
        }else {

            while (cnt < loc - 1&& temp!=null) {
                cnt++;
                temp = temp.next;

            }
            if(temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        print(head);

    }



    public static Node<Integer> insertNode(){
        Scanner sc  = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        Node<Integer> tail = head;
        while(data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }

            data = sc.nextInt();
        }


        return head;
    }

    public static void print(Node head){
        Node temp = head;

        while(temp!= null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

    }

    public static Node<Integer> mergeSort(Node head1,Node head2){
        Node temp1 = head1;
        Node temp2 = head2;
        Node newHead = null;
        Node neWTail = null;
        if(temp1.data<temp2.data){
            newHead = temp1;
            neWTail = temp1;
            temp1 = temp1.next;
        }else{
            newHead = temp2;
            neWTail = temp2;
            temp2 = temp2.next;
        }

        while(temp1 != null && temp2 != null){
            if(temp1.data > temp2.data){
                neWTail.next = temp2;
                neWTail = temp2;
                temp2 = temp2.next;
            }
            if(temp1.data < temp2.data){
                neWTail.next = temp1;
                neWTail = temp1;
                temp1 =temp1.next;
            }
        }

        if(temp1 !=null){
            neWTail.next = temp1;
        }else{
            neWTail.next = temp2;
        }

        return newHead;
    }


    public static String[] revString(String str1,String str2){
        String revString1 = "";
        String revString2 = "";

        for(int i = str1.length()-1; i>=0;i--){
            revString1+= str1.charAt(i);
        }
        for(int i = str2.length()-1; i>=0;i--){
            revString2+= str2.charAt(i);
        }
        return new String[]{revString1, revString2};
    }

    public static Node<Integer> addTwoList(Node<Integer> l1, Node<Integer> l2){
        Node<Integer> head = null;
        Node<Integer> tail = null;
       int remainder = 0;
        while(l1 != null || l2 != null){
            int val = (l1 != null ? l1.data:0) + (l2 != null? l2.data:0) +remainder;
            if(val > 9){
                remainder = val/10;
                val = val%10;
            }
            Node<Integer> newNode = new Node<>(val);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(remainder > 0){
            Node<Integer> newNode = new Node<>(remainder);
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }

    public static void evenOddList(Node<Integer> head){
        Node<Integer> temp = head;
        Node<Integer> oddHead = new Node<>(-1);
        Node<Integer> oddTail = oddHead;
        Node<Integer> evenHead = new Node<>(-1);
        Node<Integer> evenTail = evenHead;



        while(temp != null){
            if(temp.data%2 != 0){
                if(oddHead == null){
                    oddHead = temp;
                    oddTail = temp;
                }else{
                    oddTail.next = temp;
                    oddTail = temp;
                }
            }
            if(temp.data%2== 0){
               if(evenHead == null){
                   evenTail = temp;
                   evenHead = temp;
               }else{
                   evenTail.next = temp;
                   evenTail = temp;
               }
           }

            temp = temp.next;
        }
        if(oddTail != null){
            oddTail.next = null;
        }
        if(evenTail != null){
            evenTail.next = null;
        }
        evenTail.next = oddHead.next;
        print(evenHead.next);
    }

    public static void sort012(Node<Integer> head){
        Node<Integer> zeroHead = new Node<>(-1);
        Node<Integer> zeroTail = zeroHead;
        Node<Integer> temp = head;
        int flag = 0;
        while(temp != null){
            if(temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = temp;
            }
                temp = temp.next;

        }
        if(zeroTail != null){
            zeroTail.next = null;
        }
        temp = head;
        while(temp != null){
            if(temp.data == 1) {
                zeroTail.next = temp;
                zeroTail = temp;
            }
            temp = temp.next;
        }
        if(zeroTail != null){
            zeroTail.next = null;
        }
        temp = head;
        while(temp != null){
            if(temp.data == 2) {
                zeroTail.next = temp;
                zeroTail = temp;
            }
            temp = temp.next;
        }
        if(zeroTail != null){
            zeroTail.next = null;
        }

        print(zeroHead.next);

    }

    public static void sortList012(Node<Integer> head){

        Node<Integer> temp = head;
        Node<Integer> nodeZero = new Node<>(-1);
        Node<Integer> zero = nodeZero;
        Node<Integer> nodeOne = new Node<>(-1);
        Node<Integer> one = nodeOne;
        Node<Integer> nodeTwo = new Node<>(-1);
        Node<Integer> two = nodeTwo;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        if(zero != null || one != null || two != null){
            zero.next = null;
            one.next = null;
            two.next = null;
        }

        zero.next = nodeOne.next;
        one.next = nodeTwo.next;
        print(nodeZero.next);



        Node<Integer> temp = head;
        int cnt0 = 0,cnt1 = 0,cnt2 = 0;

        while(temp != null){
            if(temp.data == 0){
                cnt0++;
            }else if(temp.data == 1){
                cnt1++;
            }else{
                cnt2++;
            }
            temp = temp.next;
        }

        Node<Integer> curr = head;
        int length = 0;
        while(curr != null){
            if(cnt0 != 0){
                curr.data = 0;
                cnt0--;
                curr = curr.next;
                continue;
            }else if(cnt1 != 0){
                curr.data = 1;
                cnt1--;
                curr = curr.next;
                continue;
            }else{
                curr.data = 2;
                cnt2--;
                curr = curr.next;
                continue;
            }
        }
        print(head);

    }




    public static void main(String[] args) {
        System.out.println(153/100+" "+153%10);
//        Node <Integer> n1 = new Node<>(10);
//        Node <Integer> n2 = new Node<>(10);
//
//
//        Node <Integer> head = insertNode();
//        sortList012(head);



//        duplicateRemove(head);

//        appendLastNode(head,3);

//        deleteNode(head,0);

//        System.out.println();
//        locInsert(head,20,10);

    }
}
