class Solution {

    void printTriangle(int n) {
        for (int i = 0; i < n; i++) {
            
            //space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            } 
            
            //stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
        
    }
}