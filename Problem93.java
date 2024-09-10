class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        if(intervals == null || len == 0){
            return 0;
        }

        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(intervals[0][1]);

        for(int i=1; i<len; i++){
            if(intervals[i][0]>=minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(intervals[i][1]);
        }
        return minHeap.size();
    }
}
