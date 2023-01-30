/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    // hashmap key is old node, value is copy node 
    public Node dfs(Node cur, HashMap<Node, Node> visited){
        if(cur == null){
            return null;
        }
        // the node is already be visited
        if(visited.containsKey(cur)){
            return visited.get(cur);
        }

        // a copy from current node
        Node copy = new Node(cur.val);

        // mark current node as visited
        visited.put(cur, copy);

        // loop each neighbor of current node, add each neighbor to copy
        for(Node n: cur.neighbors){
            // in recursive call, if the neighbor is visited, just return
            // if not visited, create a copy node, mark visited, and return copy
            copy.neighbors.add(dfs(n, visited));

        }
        return copy;
    }
}