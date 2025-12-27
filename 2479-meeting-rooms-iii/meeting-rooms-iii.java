class Solution {
        public int mostBooked(int n, int[][] meetings) {

            int[] rooms = new int[n];
            Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
            );
            PriorityQueue<Integer> free = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                free.offer(i);
            }

            for (int i = 0; i < meetings.length; i++) {

                int start = meetings[i][0];
                int end = meetings[i][1];

                while (!pq.isEmpty() && pq.peek()[0] <= start) {
                    free.offer(pq.poll()[1]);
                }

                int room;
                int finishTime;

                if (!free.isEmpty()) {
                    room = free.poll();
                    finishTime = end;
                } else {
                    int[] curr = pq.poll();
                    room = curr[1];
                    finishTime = curr[0] + (end - start);
                }

                rooms[room]++;
                pq.offer(new int[]{finishTime, room});
            }

            int max = 0;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (rooms[i] > max) {
                    max = rooms[i];
                    ans = i;
                }
            }
            return ans;
        }
    }