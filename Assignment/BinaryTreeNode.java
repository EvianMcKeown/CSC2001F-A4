package Assignment;
// Hussein's Binary Tree

// 26 March 2017
// Hussein Suleman

public class BinaryTreeNode<dataType> {
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;

   /**
    * Constructor
    *
    * @param d data
    * @param l left
    * @param r right
    */
   public BinaryTreeNode(dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r) {
      data = d;
      left = l;
      right = r;
      height = 0;
   }

   /**
    * Returns left node.
    * 
    * @return BinaryTreeNode<dataType>
    */
   BinaryTreeNode<dataType> getLeft() {
      return left;
   }

   /**
    * Returns right node.
    * 
    * @return BinaryTreeNode<dataType>
    */
   BinaryTreeNode<dataType> getRight() {
      return right;
   }

   /**
    * Returns Data stored in Node.
    *
    * @return dataType
    */
   public dataType getData() {
      return data;
   }

   /**
    * Sets Data stored in Node.
    * 
    * @param data
    */
   public void setData(dataType data) {
      this.data = data;
   }
}
