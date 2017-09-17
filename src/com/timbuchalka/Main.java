package com.timbuchalka;

public class Main {
    static boolean[][] visited;

    public static boolean search (char[][] a, String word) {
        int m = a.length, n = a[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i<m;i++) {
            for (int j=0;j<n;j++) {
                if (word.charAt(0) == a[i][j] && search(a, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] a, int i, int j, String word, int index) {
        if(index == word.length())
            return true;
        if (i<0 || i>=a.length || j<0 || j>=a[0].length|| a[i][j] != word.charAt(index) || visited[i][j] == true)
            return false;
        visited[i][j] = true;
        if (search(a, i-1, j, word, index+1) ||
                search(a,i+1, j, word, index+1)||
                search(a, i, j-1, word, index+1) ||
                search(a, i, j+1, word, index+1))
            return true;
        visited[i][j] = false;
        return false;
    }


    public static void main(String[] a) {
	// write your code here
        char[][] s = {{'A','B','C','E'},
                      {'S','F','C','S'},
                      {'A','D','E','E'}};
        String word = "EEDASFCSECBA";
        System.out.println(search(s, word));



    }
}
