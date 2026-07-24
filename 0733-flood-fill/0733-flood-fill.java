class Solution {
    public void dfs(int r, int c, int[][] image, int orgColor, int newColor){
        int n=image.length;
        int m=image[0].length;
        if(r<0 || r>=n || c<0 || c>=m) return;
        if(image[r][c]!=orgColor) return;

        image[r][c]=newColor;

        //For going top
        dfs(r-1,c,image, orgColor, newColor);
        //For going bottom
        dfs(r+1,c,image, orgColor, newColor);
        //For going left
        dfs(r,c-1,image, orgColor, newColor);
        //For going right
        dfs(r,c+1,image, orgColor, newColor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor=image[sr][sc];
        if(orgColor==color) return image;
        dfs(sr,sc,image,orgColor,color);
        return image;
    }
}