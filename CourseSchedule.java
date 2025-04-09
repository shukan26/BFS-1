//Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
// Space Complexity: O(V + E) for the adjacency list and in-degree array

/**
 * Determines if it's possible to finish all courses given their prerequisites using topological sorting.
 * Constructs an adjacency list and calculates in-degrees for each course, then processes courses with no prerequisites.
 * Uses a queue to iteratively remove courses from the graph, updating in-degrees and tracking the number of completed courses.
 */

import java.util.*;
import java.util.LinkedList;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preReqCourse = prerequisite[1];

            List<Integer> preReqList = adj.getOrDefault(preReqCourse, new ArrayList<Integer>());
            preReqList.add(course);
            adj.put(preReqCourse, preReqList);

            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0 ; i< inDegree.length ; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int numCoursesTaken = 0;

        while (!q.isEmpty()) {
            int currCourse = q.remove();
            result[numCoursesTaken] = currCourse;
            numCoursesTaken++;
            if (adj.containsKey(currCourse)) {
                List<Integer> preReqCourses = adj.get(currCourse);
                for (int preReqCourse : preReqCourses) {
                    inDegree[preReqCourse]--;
                    if (inDegree[preReqCourse] == 0) {
                        q.offer(preReqCourse);
                    }
                }
            }
        }

        return numCoursesTaken == numCourses;
    }
}
