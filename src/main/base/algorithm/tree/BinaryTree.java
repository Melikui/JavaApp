package algorithm.tree;

class BinaryTree<T> {
    private final Node<T> root;

    // 创建一棵空二叉树
    public BinaryTree() {
        // 创建根结点，该结点的数据域为空
        this.root = new Node<T>();
    }

    // 创建一棵以数据元素x为根结点的二叉树
    public BinaryTree(T x) {
        this.root = new Node<T>(x);
    }

    /**
     * 在当前二叉树的parent结点中插入一个新的左子结点
     * 若已存在左子树，则将该左子树变成新左子结点的左孩子树
     */
    public boolean insertLeft(T x, Node<T> parent) {
        if (parent == null) return false;
        // 创建一个新结点
        Node<T> p = new Node<T>(x);
        if (parent.left != null) {
            // 先将父结点原来的左子树设置为新结点的左子树
            p.left = parent.left;
            // 再将新结点设置到父结点的左孩子结点
        }
        // 将新结点直接设置到父结点的左孩子结点
        parent.left = p;
        return true;
    }

    /**
     * 在当前二叉树的parent结点中插入一个新的右孩子结点
     * 若已存在右子树，则将该右子树变成新右孩子结点的左子树
     */
    public boolean insertRight(T x, Node<T> parent) {
        if (parent == null) return false;
        // 创建一个新结点
        Node<T> p = new Node<T>(x);
        if (parent.right != null) {
            // 先将父结点原来的左子树设置为新结点的左子树
            p.right = parent.right;
            // 再将新结点设置到父结点的左孩子结点
        }
        // 将新结点直接设置到父结点的左孩子结点
        parent.right = p;
        return true;
    }

    // 删除在当前二叉树的parent结点中的左子树
    public boolean deleteLeft(Node<T> parent) {
        if (parent == null) {
            return false;
        } else {
            parent.left = null;
            return true;
        }
    }

    // 删除在当前二叉树的parent结点中的右子树
    public boolean deleteRight(Node<T> parent) {
        if (parent == null) {
            return false;
        } else {
            parent.right = null;
            return true;
        }
    }

    // 在当前二叉树中查找数据x
    public boolean search(T x) {
        return false;
    }

    // 按某种方式遍历当前二叉树的全部结点
    public void traversal(int i) {
    }

    // 求当前二叉树的高度
    // 使用后序遍历法计算二叉树的高度
    // 当parent为root时，即可计算当前二叉树的高度
    public int getHeight(Node<T> parent) {
        int lh, rh, max;
        if (parent != null) {
            lh = getHeight(parent.left);  //求左子树的高度
            rh = getHeight(parent.right);  //求右子树的高度
            max = Math.max(lh, rh);
            return max + 1;
        } else return 0;
    }
}
