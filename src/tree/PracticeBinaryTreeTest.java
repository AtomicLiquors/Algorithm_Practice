public class PracticeBinaryTreeTest {
    public static void main(String[] args) {
        int size = 9;

        PracticeBinaryTree<Character> tree = new PracticeBinaryTree<>(size);

        for (int i = 0; i < size; i++) {
            tree.add((char)(65+i));
        }

        tree.bfs();
        tree.dfsByPreOrder();
    }
}
