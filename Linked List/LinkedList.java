public class LinkedList {
    public static class Node {
        int data;
        Node next;
        int flag; // for detectLoop in linked list(only use)

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static int getSize() {
        return size;
    }

    public static Node insert(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        return head;
    }

    public static void addFirst(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return;
        }
        temp.next = head;
        head = temp;
    }

    public static void addLast(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            return;
        }
        Node val = head;
        while (val.next != null) {
            val = val.next;
        }
        val.next = temp;
    }

    public static Node insertAtGivenPosition(Node head, int k, int pos) {
        pos = pos - 1;
        Node temp = head;

        Node insert = new Node(k);
        if (pos == 0) {
            insert.next = head;
            return insert;
        }
        int currentPos = 0;
        while (currentPos < pos - 1 && head.next != null) {
            head = head.next;
            currentPos++;
        }
        Node temp2 = head.next;
        head.next = insert;
        head = head.next;
        head.next = temp2;

        return temp;
    }

    public static void deleteNode(Node head) {
        Node next = head.next;
        head.data = next.data;

        if (next.next == null)
            head.next = null;
        else
            deleteNode(next);
    }

    // public static void deleteEvenNode(Node head){
    // Node current = head;
    // while(current != null)
    // {
    // if(current.data % 2 == 0)
    // {
    // deleteNode(current.data);
    // }
    // current = current.next;
    // }
    // }

    // public static void deleteOddNode(Node head){
    // Node current = head;
    // while(current != null)
    // {
    // if(current.data % 2 == 1)
    // {
    // deleteNode(current.data);
    // }
    // current = current.next;
    // }
    // }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    // Using recursion to reverse linked list...
    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null)
            return head;

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static Node reverseKNodes(Node head, int k) {
        if (head == null)
            return null;

        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKNodes(next, k);
        }
        return prev;
    }

    public static Node reverseSpecificPosition(Node head, int m, int n) {
        if (m > n) {
            return head;
        }
        Node prev = null;
        Node curr = head;

        for (int i = 1; curr != null && i < m; i++) {
            prev = curr;
            curr = curr.next;
        }

        Node start = curr; // `prev` now points to (m-1)'th node // `curr` now points to m'th node
        Node end = null;

        for (int i = 1; curr != null && i <= n - m + 1; i++) // 2. Traverse and reverse the sublist from position `m` to
                                                             // `n`
        {
            Node next = curr.next;
            curr.next = end;
            end = curr;
            curr = next;
        }
        // `start` points to the m'th node // `end` now points to the n'th node //
        // `curr` now points to the (n+1)'th node

        if (start != null) // 3. Fix the pointers and return the head node
        {
            start.next = curr;
            if (prev != null) {
                prev.next = end;
            } else {
                head = end; // when m = 1, `prev` is null
            }
        }
        return head;
    }

    public static Node deleteMiddleElement(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow, fast, prev;
        slow = fast = prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static Node deleteKthNode(Node head, int k) {
        if (head == null)
            return null;
        int count = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int target = count - k;
        if (target == 0) {
            return head.next;
        }
        temp = head;
        for (int i = 0; i < target - 1; i++)
            temp = temp.next;

        temp.next = temp.next.next;

        return head;
    }

    public Node findMid(Node head) { // int find mid then return value is slow.data
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow is my midNode // return slow.data
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step1 - find mid
        Node midNode = findMid(head);

        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;// right half head
        Node left = head;

        // step3 - check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;   
            right = right.next;
        }

        return true;
    }

    public static Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    // 1st method //isCycle
    public static boolean detectLoop(Node head) {
        while (head != null) {
            if (head.flag == 1)
                return true;

            head.flag = 1;

            head = head.next;
        }
        return false;
    }

    // 2nd Method //iscycle
    public static void detectLoopItr(Node head) {
        Node slow = head;
        Node fast = head;
        int flag = 0;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            System.out.println("Loop Found");

        else
            System.out.println("Loop not found");
    }

    // gfg Question without using Flag..
    public static boolean detectLoopGFG(Node head) {
        if (head == null || head.next == null)
            return false;

        Node slow = head;
        Node fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }

    // remove the loop without losing any nodes // remove cycle in loop
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                if (slow != fast) {
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    fast.next = null;
                    return;
                } else {
                    while (fast.next != slow) {
                        fast = fast.next;
                    }
                    fast.next = null;
                    return;
                }
            }
        }
    }

    public static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) // If Duplicate traverse in the LL
                temp.next = temp.next.next;
            else // If NOT Duplicate then Update the temp
                temp = temp.next;
        }
        return head;
    }
}
// class Main{
// // public static void main(String[] args) {
// // LinkedList list = new LinkedList();
// }
// }
