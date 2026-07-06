class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Store {position, timeToReachTarget}
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort by position in ascending order
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        double lastTime = 0;

        // Traverse from the car closest to the target
        for (int i = n - 1; i >= 0; i--) {
            double currentTime = cars[i][1];

            // Cannot catch up -> forms a new fleet
            if (currentTime > lastTime) {
                fleets++;
                lastTime = currentTime;
            }
            // Otherwise, joins the fleet ahead
        }

        return fleets;
        
    }
}
