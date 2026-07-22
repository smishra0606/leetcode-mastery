class Solution {
    public void helper(int node, boolean[] visited, int[][]isConnected){
        visited[node]=true;
        for(int n=0;n<isConnected.length;n++){
            if(isConnected[node][n]==1 && !visited[n]){
                helper(n,visited,isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                helper(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }
}