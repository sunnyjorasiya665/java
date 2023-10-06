class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class reorderLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(25);
        head.next = new ListNode(5);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(0);

        reorderLL reorderLinkedList = new reorderLL();
        reorderLinkedList.reorderList(head);

        // Print the reordered list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void reorderList(ListNode head) {
        // Your code here
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = getMid(head);
        ListNode hs = reverse(mid.next);
        mid.next = null;

        ListNode hf = head;

        // Rearrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
