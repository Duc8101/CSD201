package BSTree;

import Queue.Queue;

public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    // add to tree
    Node add(Node node, int value) {
        // if tree empty or node not added yet
        if (node == null) {
            node = new Node(value);
        } else {
            // if value smaller than node's value
            if (value < node.data) {
                // traverse left
                node.left = add(node.left, value);
                // if value bigger than node's value 
            } else if (value > node.data) {
                // traverse right
                node.right = add(node.right, value);
            }
        }
        return node;
    }

    // add to tree
    void add(int value) {
        root = add(root, value);
    }

    // display tree by preorder
    void PreOrder(Node node) {
        // if tree not empty
        if (node != null) {
            System.out.print(node.data + " ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    // display tree by preorder
    void PreOrder() {
        PreOrder(root);
    }

    // display tree by inorder
    void InOrder(Node node) {
        // if tree not empty
        if (node != null) {
            InOrder(node.left);
            System.out.print(node.data + " ");
            InOrder(node.right);
        }
    }

    // display tree by inorder
    void InOrder() {
        InOrder(root);
    }

    // display tree by postorder
    void PostOrder(Node node) {
        // if tree not empty
        if (node != null) {
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // display tree by postorder
    void PostOrder() {
        PostOrder(root);
    }

    // search node
    Node search(Node node, int value) {
        // if tree empty
        if (node == null) {
            return null;
        } else {
            // if value smaller than node's value
            if (value < node.data) {
                return search(node.left, value);
                // if value bigger than node's value 
            } else if (value > node.data) {
                return search(node.right, value);
            } else {
                return node;
            }

        }
    }

    // search node
    Node search(int value) {
        return search(root, value);
    }

    // display node with two children
    void NodeTwoChildren(Node node) {
        // if tree not empty
        if (node != null) {
            // if node have two children
            if (node.left != null && node.right != null) {
                System.out.print(node.data + " ");

            }
            NodeTwoChildren(node.left); // traverse left
            NodeTwoChildren(node.right);// traverse right
        }

    }
    // display node with one child

    void NodeOneChild(Node node) {
        // if tree not empty
        if (node != null) {
            // if node have one child
            if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
                System.out.print(node.data + " ");
            }
            NodeOneChild(node.left); // traverse left
            NodeOneChild(node.right);// traverse right
        }

    }
    // display node leaf

    void NodeLeaf(Node node) {
        // if tree not empty
        if (node != null) {
            // if node is leaf
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
            NodeLeaf(node.left); // traverse left
            NodeLeaf(node.right);// traverse right
        }

    }

    // get height of tree
    int height(Node node) {
        // if tree empty
        if (node == null) {
            return 0;
        } else {
            //compute the depth of each subtree
            int LeftDepth = height(node.left);
            int RightDepth = height(node.right);
            // return larger depth
            return LeftDepth > RightDepth ? LeftDepth + 1 : RightDepth + 1;
        }
    }

    // get height of tree
    int height() {
        return height(root);
    }

    // breadth first traversal
    void breadth(Node node) {
        // if tree not empty
        if (node != null) {
            Queue queue = new Queue();
            queue.enqueue(node);
            // loop until list empty
            while (!queue.isEmpty()) {
                // get node at first position which be deleted
                Node p = (Node) queue.dequeue();
                System.out.print(p.data + " ");
                // if p have node left
                if (p.left != null) {
                    queue.enqueue(p.left);
                }
                // if p have node right
                if (p.right != null) {
                    queue.enqueue(p.right);
                }
            }
        }
    }

    // breadth first traversal
    void breadth() {
        breadth(root);
    }

    // delete node by copying
    Node DeleteByCopying(Node node, int value) {
        // if tree empty or not found node
        if (node == null) {
            return null;
        } else {
            // if value smaller than node's value
            if (value < node.data) {
                // traverse left
                node.left = DeleteByCopying(node.left, value);
                // if value bigger than node's value 
            } else if (value > node.data) {
                // traverse right
                node.right = DeleteByCopying(node.right, value);
            } else {
                // delete node with 1 child and node leaf
                if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                } else {// node with 2 children
                    // update node's data which is right most node's data
                    node.data = RightMostValue(node.left);
                    // delete right most node 
                    node.left = DeleteByCopying(node.left, node.data);
                }
            }
        }
        return node;
    }

    // delete node by copying
    void DeleteByCopying(int value) {
        root = DeleteByCopying(root, value);
    }

    // get right most node value or left subtree
    int RightMostValue(Node node) {
        // loop until find right node most 
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    // get right most node value or left subtree
    Node RightMostNode(Node node) {
        // loop until find right node most 
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // delete by merging
    Node DeleteByMerging(Node node, int value) {
        // if tree empty or not found node
        if (node == null) {
            return null;
        } else {
            // if value smaller than node's value
            if (value < node.data) {
                // traverse left
                node.left = DeleteByMerging(node.left, value);
                // if value bigger than node's value 
            } else if (value > node.data) {
                // traverse right
                node.right = DeleteByMerging(node.right, value);
            } else {
                // delete node with 1 child and node leaf
                if (node.left == null) {
                    node = node.right;
                } else if (node.right == null) {
                    node = node.left;
                } else {// node with 2 children
                    // find right most node
                    Node p = RightMostNode(node.left);
                    Node right = node.right;
                    p.right = right;
                    node = node.left;
                }
            }
        }
        return node;
    }

    // delete by merging
    void DeleteByMerging(int value) {
        root = DeleteByMerging(root, value);
    }

    // rotate left
    Node RotateLeft(Node node) {
        // if node not have right child
        if (node.right == null) {
            return node;
        }
        Node p = node.right;
        node.right = p.left;
        p.left = node;
        return p;
    }

    // rotate right
    Node RotateRight(Node node) {
        // if node not have left child
        if (node.left == null) {
            return node;
        }
        Node p = node.left;
        node.left = p.right;
        p.right = node;
        return p;
    }

}
