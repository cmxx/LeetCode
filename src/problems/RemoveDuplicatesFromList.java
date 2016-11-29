package problems;

import supporting.ListNode;

public class RemoveDuplicatesFromList {
	// # 83 Remove duplicates From Sorted Linked List
	// Status: Passed. 1ms  15.31%

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null)
			return head;
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;

	}
}