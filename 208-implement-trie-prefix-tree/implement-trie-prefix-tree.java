class Node {
    Node[] children;
    boolean EOW;

    Node() {
        children = new Node[26]; 
        EOW = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';

            if (curr.children[ind] == null) {
                curr.children[ind] = new Node();
            }
            curr = curr.children[ind];
        }

        curr.EOW = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';

            if (curr.children[ind] == null) {
                return false;
            }
            curr = curr.children[ind];
        }

        return curr.EOW;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int ind = prefix.charAt(i) - 'a';

            if (curr.children[ind] == null) {
                return false;
            }
            curr = curr.children[ind];
        }

        return true;
    }
}