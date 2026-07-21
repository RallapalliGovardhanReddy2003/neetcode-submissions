class MedianFinder {

    // Max Heap (stores smaller half)
    private PriorityQueue<Integer> small;

    // Min Heap (stores larger half)
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Step 1: Add to max heap
        small.offer(num);

        // Step 2: Ensure every element in small <= every element in large
        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }

        // Step 3: Balance heap sizes
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}