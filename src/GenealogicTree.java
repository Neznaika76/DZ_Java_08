public class GenealogicTree {

    public static class Node {
        String name;
        Node sibling, child;

        public Node(String name) {
            this.name = name;
            sibling = child;
            child = null;
        }
    }

    static public Node addSibling(Node node, String name) {
        if (node == null)
            return null;

        while (node.sibling != null)
            node = node.sibling;
        return (node.sibling = new Node(name));
    }

    static public Node addChild(Node node, String name) {
        if (node == null)
            return null;

        if (node.child != null)
            return (addSibling(node.child, name));
        else
            return (node.child = new Node(name));
    }

    static public void preorderTraversal(Node root) {
        if (root == null) {
            System.out.println("Дерево пустое! Нет корня!");
        }
        while (root != null) {
            System.out.print(root.name + " ");
            if (root.child != null)
                preorderTraversal(root.child);
            root = root.sibling;
        }
    }

    public static void main(String args[]) {
        System.out.println("Генеалогическое дерево с обходом: \n");

        Node root = new Node("Паша");
        Node node1 = addChild(root, "Назар");
        Node node2 = addChild(root, "Полина");
        Node node3 = addSibling(root, "Захар");
        Node node4 = addChild(node1, "Андрей");
        Node node5 = addSibling(root, "Вика");
        Node node6 = addChild(node2, "Олег");
        Node node7 = addChild(node3, "Катя");
        Node node8 = addSibling(node4, "Вова");


        preorderTraversal(root);
    }
}