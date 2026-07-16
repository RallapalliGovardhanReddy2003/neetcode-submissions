class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash the two heaviest stones
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Heaviest
            int x = maxHeap.poll(); // Second heaviest

            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
