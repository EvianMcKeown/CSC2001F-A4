package src;
// Hussein's Binary Tree

// 26 March 2017
// Hussein Suleman

public class BinaryTree<dataType> {
   /**
    * root of BST
    */
   BinaryTreeNode<dataType> root;

   /**
    * Constructor
    */
   public BinaryTree() {
      root = null;
   }

   /**
    * Returns height of BST
    * 
    * @return int height
    */
   public int getHeight() {
      return getHeight(root);
   }

   /**
    * Internal method to determine height of BST
    * 
    * @param node Binary tree node of data type
    * @return int height
    */
   public int getHeight(BinaryTreeNode<dataType> node) {
      if (node == null)
         return -1;
      else
         return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
   }

   /**
    * Returns size of BST
    * 
    * @return int size
    */
   public int getSize() {
      return getSize(root);
   }

   /**
    * internal method that is called to determine size of BST
    * 
    * @param node node of Binary Tree datatype
    * @return int size
    */
   public int getSize(BinaryTreeNode<dataType> node) {
      if (node == null)
         return 0;
      else
         return 1 + getSize(node.getLeft()) + getSize(node.getRight());
   }

   /**
    * prints data type to string of node
    * 
    * @param node
    */
   public void visit(BinaryTreeNode<dataType> node) {
      System.out.println(node.data.toString());
   }

   public void preOrder() {
      preOrder(root);
   }

   /**
    * Internal method to sort preOrder
    * 
    * @param node Binary Tree Node of data type
    */
   public void preOrder(BinaryTreeNode<dataType> node) {
      if (node != null) {
         visit(node);
         preOrder(node.getLeft());
         preOrder(node.getRight());
      }
   }

   /**
    * method to sort postOrder
    */
   public void postOrder() {
      postOrder(root);
   }

   /**
    * Internal method to sort postOrder
    * 
    * @param node
    */
   public void postOrder(BinaryTreeNode<dataType> node) {
      if (node != null) {
         postOrder(node.getLeft());
         postOrder(node.getRight());
         visit(node);
      }
   }

   /**
    * Method to sort inOrder
    */
   public void inOrder() {
      inOrder(root);

   }

   /**
    * Internal method to sort InOrder
    * 
    * @param node Binary Tree Node of data type
    */
   public void inOrder(BinaryTreeNode<dataType> node) {
      if (node != null) {
         inOrder(node.getLeft());
         visit(node);
         inOrder(node.getRight());
      }
   }

   /**
    * method to sort levelOrder
    */
   public void levelOrder() {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType>();
      q.enQueue(root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext()) != null) {
         visit(node);
         if (node.getLeft() != null)
            q.enQueue(node.getLeft());
         if (node.getRight() != null)
            q.enQueue(node.getRight());
      }
   }
}
