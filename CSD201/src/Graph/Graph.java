package Graph;

import Queue.Queue;

public class Graph {

    int[][] array;
    int number; //total vertex
    char[] vertex;
    final int INF = Integer.MAX_VALUE;

    public Graph() {
        int[][] arr = {
            //A  B  C  D  E  F  G  H  I
            {0, 2, 3, 5, INF, 11, INF, INF, INF}, //A
            {2, 0, 4, 6, INF, INF, INF, INF, INF}, //B 
            {3, 4, 0, 7, INF, INF, INF, INF, INF}, //C
            {5, 6, 7, 0, INF, 1, INF, INF, INF}, //D
            {INF, INF, INF, INF, 0, 9, INF, INF, 13}, //E
            {11, INF, INF, 1, 9, 0, 12, INF, INF}, //F
            {INF, INF, INF, INF, INF, 12, 0, 8, 10}, //G
            {INF, INF, INF, INF, INF, INF, 8, 0, 14}, //H
            {INF, INF, INF, INF, 13, INF, 10, 14, 0} //I
        };
        array = arr;
        number = array.length;
        vertex = "ABCDEFGHIJKLMN".toCharArray();
    }

    //visit vertex i
    void visit(int i) {
        System.out.print(vertex[i] + "  ");
    }

    //breadth first traversal
    void breadth(int u, boolean[] enqueued) {
        Queue queue = new Queue();
        queue.enqueue(u);
        enqueued[u] = true;
        // loop until list empty
        while (!queue.isEmpty()) {
            int j = (int) queue.dequeue();
            visit(j);
            // loop for traverse all vertex
            for (int i = 0; i < number; i++) {
                // if not enqueue and i and j adjacent
                if (!enqueued[i] && array[j][i] > 0) {
                    queue.enqueue(i);
                    enqueued[i] = true;
                }
            }
        }
    }

    //breadth first traversal
    void breadth(int u) {
        boolean[] enqueued = new boolean[number];
        // loop for traverse all vertex
        for (int i = 0; i < number; i++) {
            // initialize all vertex not enqueue
            enqueued[i] = false;
        }
        breadth(u, enqueued);
        // loop for traverse all vertex
        for (int i = 0; i < number; i++) {
            // if not enqueue
            if (!enqueued[i]) {
                breadth(i, enqueued);
            }
        }
    }

    //depth first traversal
    void depth(int i, boolean[] visited) {
        visit(i);
        visited[i] = true;
        // loop for traverse all vertex
        for (int j = 0; j < number; j++) {
            // if not visit and i and j adjacent
            if (!visited[j] && array[i][j] > 0) {
                depth(j, visited);
            }
        }
    }

    //depth first traversal
    void depth(int i) {
        boolean[] visited = new boolean[number];
        // loop for traverse all vertex
        for (int j = 0; j < number; j++) {
            // initialize all vertex not visited
            visited[j] = false;
        }
        depth(i, visited);
        // loop for traverse all vertex
        for (int j = 0; j < number; j++) {
            // if not visit
            if (!visited[j]) {
                depth(j, visited);
            }
        }
    }

    // dijkstra algorithm
    void dijkstra(int i) {
        boolean[] set = new boolean[number]; // check set shortest path from i to j
        int[] distance = new int[number]; // distance[j] : shortest path from i to j
        // loop for traverse all vertex
        for (int j = 0; j < number; j++) {
            // initialize all vertex not set and distance INF
            set[j] = false;
            distance[j] = INF;
        }
        distance[i] = 0;
        // loop for traverse all vertex
        for (int j = 0; j < number; j++) {
            // get min distance vertex
            int min = FindMinDistance(distance, set);
            // set shortest path
            set[min] = true;
            // loop for traverse all vertex
            for (int k = 0; k < number; k++) {
                if (!set[k] && array[min][k] != INF && distance[min] + array[min][k] < distance[k]) {
                    distance[k] = distance[min] + array[min][k];
                }
            }
        }
        print(i, distance);
    }

    // print shortest path
    void print(int i, int[] distance) {
        // loop for traverse all vertex
        for (int j = 0; j < number; j++) {
            // if not same vertex
            if (j != i) {
                System.out.println("Shortest path from " + vertex[i] + " to " + vertex[j] + " : " + distance[j]);
            }
        }

    }
    // find min distance

    int FindMinDistance(int[] distance, boolean[] set) {
        int min = INF;
        int min_index = -1;
        // loop for traverse all vertex
        for (int i = 0; i < number; i++) {
            // if not set shortest path and distance smaller or equal to min
            if (!set[i] && distance[i] <= min) {
                min = distance[i];
                min_index = i;
            }
        }
        return min_index;
    }
}
