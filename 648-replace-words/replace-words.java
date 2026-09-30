import java.util.List;

class Solution {
    private static class Node {
        Node[] children = new Node[26];
        boolean isRoot;
    }

    public String replaceWords(List<String> dic, String sent) {
        Node root = new Node();
        for (String word : dic) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }

                curr = curr.children[index];
            }

            curr.isRoot = true;
        }

        String[] words = sent.split(" ");
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                res.append(" ");
            }
            res.append(subroot(root, words[i]));
        }

        return res.toString();
    }

    private String subroot(Node root, String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';

            if (curr.children[ind] == null) {
                return word;
            }

            curr = curr.children[ind];

            if (curr.isRoot) {
                return word.substring(0, i + 1);
            }
        }

        return word;
    }
}