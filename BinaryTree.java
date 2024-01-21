public class BinaryTree
{
  private Node root = null;

  public void add(int value) {
    if (root == null)
      root = new Node(value);

    else {
      Node toAdd = new Node(value);
      Node searched = searchForValue(value);

      if (value >= searched.getValue())
        searched.setRight(toAdd);

      else
        searched.setLeft(toAdd);

      toAdd.setParent(searched);
    }
  }

  public boolean remove(int value) {
    Node searched = searchForValue(value);
    if (searched.getValue() != value) {
      System.out.println("The number you are trying to remove is not in the tree");
      return false;
    }

    else {
      if (searched.getLeft() == null && searched.getRight() == null) {
        if (searched.getValue() < searched.getParent().getValue())
          searched.getParent().setLeft(null);

        else
          searched.getParent().setRight(null);

        return true;
      }

      else {
        Node toAdd = searched.getRight();

        while (toAdd.getLeft() != null) {
          toAdd = toAdd.getLeft();
        }

        if (searched.getValue() < searched.getParent().getValue())
          searched.getParent().setLeft(toAdd);

        else
          searched.getParent().setRight(toAdd);

        toAdd.getParent().setLeft(null);

        searched.getLeft().setParent(toAdd);
        searched.getRight().setParent(toAdd);

        toAdd.setLeft(searched.getLeft());
        toAdd.setRight(searched.getRight());

        return true;
      }
    }
  }
  
  //Returns the node with the given value, if not found returns parent node, if root == null returns null
  public Node searchForValue(int value) {
    Node searched = root;

    if (searched == null)
      return null;

    while (true) {
      if (value == searched.getValue())
        return searched;

      else if (value < searched.getValue()) {
        if (searched.getLeft() == null)
          return searched;

        searched = searched.getLeft();
      }

      else {
        if (searched.getRight() == null)
          return searched;

        searched = searched.getRight();
      }
    }
  }

  public void printTree() 
  {
    System.out.print("[ ");
    print(root);
    System.out.println(" ]");
  }

  private void print(Node node) 
  {
    if (node == null)
      return;

    print(node.getLeft());
    System.out.print(node.getValue() + " ");
    print(node.getRight());
  }
}

class Node {
  private int value;
  private Node left;
  private Node right;
  private Node parent;

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }
}