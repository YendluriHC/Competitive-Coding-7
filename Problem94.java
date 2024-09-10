class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        // Min-heap to store elements along with their row and column positions
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Add the first element of each row to the heap
        for (int r = 0; r < n; r++) {
            minHeap.offer(new int[]{matrix[r][0], r, 0}); // {element, row, column}
        }
        
        // Remove elements from the heap k-1 times
        for (int i = 0; i < k - 1; i++) {
            int[] current = minHeap.poll();
            int row = current[1], col = current[2];
            
            // If there's an element in the next column of the same row, add it to the heap
            if (col + 1 < n) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        
        // The top element of the heap is the k-th smallest element
        return minHeap.poll()[0];
    }
}
