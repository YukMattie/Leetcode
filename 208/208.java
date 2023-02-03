class TrieNode{

    public boolean isWord;
    // each node at most could have 26 child
    public TrieNode[] children;

    public TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}


class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode tree = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(tree.children[ch - 'a'] == null){
                tree.children[ch - 'a'] = new TrieNode();               
            }
            // go down util it come to the end of a word
            tree = tree.children[ch - 'a'];
        }
        tree.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode tree = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(tree.children[ch - 'a'] == null){
                return false;
            }
            tree = tree.children[ch - 'a'];
        }
        return tree.isWord;

    }
    
    public boolean startsWith(String prefix) {
        TrieNode tree = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(tree.children[ch - 'a'] == null){
                return false;
            }
            tree = tree.children[ch - 'a'];
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */