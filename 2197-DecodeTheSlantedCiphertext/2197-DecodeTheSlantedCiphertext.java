// Last updated: 8/14/2026, 10:02:29 AM
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;

        int n = encodedText.length();
        int cols = n / rows;

        char[][] matrix = new char[rows][cols];

        // Fill matrix row-wise
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = encodedText.charAt(idx++);
            }
        }

        // Traverse diagonally
        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            int i = 0, j = col;

            while (i < rows && j < cols) {
                result.append(matrix[i][j]);
                i++;
                j++;
            }
        }

        // Remove trailing spaces
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}