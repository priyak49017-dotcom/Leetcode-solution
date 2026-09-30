class WordDictionary {
    private static class Node {
        Node[] children = new Node[26];
        boolean isWord;
    }

    private final Node root = new Node();

    public WordDictionary() {
    }

    public void addWord(String word) {
        Node curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchFrom(root, word, 0);
    }

    private boolean searchFrom(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            for (Node child : node.children) {
                if (child != null && searchFrom(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        }

        int childIndex = ch - 'a';
        Node child = node.children[childIndex];

        return child != null && searchFrom(child, word, index + 1);
    }
}