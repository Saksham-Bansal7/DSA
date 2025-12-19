class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> res = new HashSet<>();
        res.add(0);
        res.add(firstPerson);
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        for (int i = 0; i < meetings.length; i++) {
            int time = meetings[i][2];

            Set<Integer> InitialSecret = new HashSet<>();

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            while (i < meetings.length && time == meetings[i][2]) {

                if (res.contains(meetings[i][0])) {
                    InitialSecret.add(meetings[i][0]);
                }
                if (res.contains(meetings[i][1])) {
                    InitialSecret.add(meetings[i][1]);
                }

                map.putIfAbsent(meetings[i][0], new ArrayList<>());
                map.putIfAbsent(meetings[i][1], new ArrayList<>());
                map.get(meetings[i][0]).add(meetings[i][1]);
                map.get(meetings[i][1]).add(meetings[i][0]);
                i++;
            }
            i--;

            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            for (int key : InitialSecret) {
                queue.offer(key);
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (visited.contains(cur))
                    continue;
                visited.add(cur);

                for (int key : map.get(cur)) {
                    if (!visited.contains(key)) {
                        res.add(key);
                        queue.offer(key);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}