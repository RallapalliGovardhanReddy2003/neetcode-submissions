class Twitter {

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private final Map<Integer, Set<Integer>> follows;
    private final Map<Integer, List<Tweet>> tweets;
    private int timestamp;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }

        // Add followees' tweets
        if (follows.containsKey(userId)) {
            for (int followee : follows.get(userId)) {
                if (tweets.containsKey(followee)) {
                    maxHeap.addAll(tweets.get(followee));
                }
            }
        }

        List<Integer> newsFeed = new ArrayList<>();

        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(maxHeap.poll().tweetId);
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        follows.computeIfAbsent(followerId, k -> new HashSet<>())
               .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}