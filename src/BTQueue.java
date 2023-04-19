package Assignment;
// Hussein's Binary Tree

// 26 March 2017
// Hussein Suleman

public class BTQueue<dataType> {
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;

   /**
    * Constructor for BTQueue.
    */
   public BTQueue() {
      head = null;
      tail = null;
   }

   /**
    * Returns next node
    *
    * @return BinaryTreeNode<dataType> next Node
    */
   public BinaryTreeNode<dataType> getNext() {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if (head == null)
         tail = null;
      return qnode.node;
   }

   /**
    * @param node BST node
    */
   public void enQueue(BinaryTreeNode<dataType> node) {
      if (tail == null) {
         tail = new BTQueueNode<dataType>(node, null);
         head = tail;
      } else {
         tail.next = new BTQueueNode<dataType>(node, null);
         tail = tail.next;
      }
   }
}
