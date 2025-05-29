package trie;

public class Mytrie {

    static class Node{
        Node[] children;
        boolean isEndOfWord;

        public Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            isEndOfWord = false;
        }

        public boolean childrenAreEmpty() {
            for (Node child : children) {
                if (child != null) {
                    return false; // At least one child is not empty
                }
            }
            return true; // All children are empty
        }
    }

    private Node root;

    public Mytrie() {
        root = new Node();
    }

    public void insert(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new Node();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return true;
    }

    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(Node currentNode, String word, int index) {
        if (index == word.length()) {
            if (!currentNode.isEndOfWord) {
                return false; // Word not found
            }
            currentNode.isEndOfWord = false;
            return currentNode.childrenAreEmpty();
        }

        int charIndex = word.charAt(index) - 'a';
        Node childNode = currentNode.children[charIndex];
        if (childNode == null) {
            return false; // Word not found
        }

        boolean shouldDeleteChild = deleteHelper(childNode, word, index + 1);

        if (shouldDeleteChild) {
            currentNode.children[charIndex] = null;
            return currentNode.childrenAreEmpty() && !currentNode.isEndOfWord;
        }
        return false;
    }

    //work break problem
    public boolean canBreak(String s, String[] wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
