package Assignment;
// Hussein's AVL Tree

// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<dataType extends Comparable<dataType>> extends BinaryTree<dataType> {

   /**
    * Gets height of node
    * 
    * @param node node of datatype
    * @return int height
    */
   public int height(BinaryTreeNode<dataType> node) {
      if (node != null)
         return node.height;
      return -1;
   }

   /**
    * Gets balance factor from node
    * 
    * @param node Node from where is measured
    * @return int balance factor
    */
   public int balanceFactor(BinaryTreeNode<dataType> node) {
      return height(node.right) - height(node.left);
   }

   /**
    * Fixes Height
    * 
    * @param node Node of datatype
    */
   public void fixHeight(BinaryTreeNode<dataType> node) {
      node.height = Math.max(height(node.left), height(node.right)) + 1;
   }

   /**
    * Rotates node right
    * 
    * @param p Node of data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> rotateRight(BinaryTreeNode<dataType> p) {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight(p);
      fixHeight(q);
      return q;
   }

   /**
    * Rotates node left
    * 
    * @param q node of data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> rotateLeft(BinaryTreeNode<dataType> q) {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight(q);
      fixHeight(p);
      return p;
   }

   /**
    * Balances Binary tree node
    * 
    * @param p Node of data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> balance(BinaryTreeNode<dataType> p) {
      fixHeight(p);
      if (balanceFactor(p) == 2) {
         if (balanceFactor(p.right) < 0)
            p.right = rotateRight(p.right);
         return rotateLeft(p);
      }
      if (balanceFactor(p) == -2) {
         if (balanceFactor(p.left) > 0)
            p.left = rotateLeft(p.left);
         return rotateRight(p);
      }
      return p;
   }

   /**
    * Inserts node into AVLTree
    * 
    * @param d raw datatype implementing Comparable
    */
   public void insert(dataType d) {
      root = insert(d, root);
   }

   /**
    * Internal method that recursively finds where to insert node
    * 
    * @param d    data of comparable
    * @param node node of data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> insert(dataType d, BinaryTreeNode<dataType> node) {
      if (node == null)
         return new BinaryTreeNode<dataType>(d, null, null);
      if (d.compareTo(node.data) <= 0)
         node.left = insert(d, node.left);
      else
         node.right = insert(d, node.right);
      return balance(node);
   }

   /**
    * Deletes node
    * 
    * @param d data type
    */
   public void delete(dataType d) {
      root = delete(d, root);
   }

   /**
    * Internal method that is called to delete node
    * 
    * @param d    data
    * @param node node of data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> delete(dataType d, BinaryTreeNode<dataType> node) {
      if (node == null)
         return null;
      if (d.compareTo(node.data) < 0)
         node.left = delete(d, node.left);
      else if (d.compareTo(node.data) > 0)
         node.right = delete(d, node.right);
      else {
         BinaryTreeNode<dataType> q = node.left;
         BinaryTreeNode<dataType> r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode<dataType> min = findMin(r);
         min.right = removeMin(r);
         min.left = q;
         return balance(min);
      }
      return balance(node);
   }

   /**
    * Finds left most node
    * 
    * @param node Binary tree node of data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node) {
      if (node.left != null)
         return findMin(node.left);
      else
         return node;
   }

   /**
    * Removes left most node
    * 
    * @param node Binary tree node of data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node) {
      if (node.left == null)
         return node.right;
      node.left = removeMin(node.left);
      return balance(node);
   }

   /**
    * Finds and returns node if it exists in BST
    * 
    * @param d data type
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> find(dataType d) {
      if (root == null)
         return null;
      else
         return find(d, root);
   }

   /**
    * Internal method that is called to find node if it exists
    * 
    * @param d    data type
    * @param node BST node
    * @return BinaryTreeNode<dataType>
    */
   public BinaryTreeNode<dataType> find(dataType d, BinaryTreeNode<dataType> node) {
      if (d.compareTo(node.data) == 0)
         return node;
      else if (d.compareTo(node.data) < 0)
         return (node.left == null) ? null : find(d, node.left);
      else
         return (node.right == null) ? null : find(d, node.right);
   }

   public void treeOrder() {
      treeOrder(root, 0);
   }

   /**
    * @param node
    * @param level
    */
   public void treeOrder(BinaryTreeNode<dataType> node, int level) {
      if (node != null) {
         for (int i = 0; i < level; i++)
            System.out.print(" ");
         System.out.println(node.data);
         treeOrder(node.left, level + 1);
         treeOrder(node.right, level + 1);
      }
   }
}
