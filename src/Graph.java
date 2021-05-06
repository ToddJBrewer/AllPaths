import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    //class data members
    List<List<Integer>> pathResult;
    int target;
    /**
     * function that calculates all possible paths from position 0 to position N-1
     * uses linked list to check possible paths
     * @param graph 2 dimensional data structure in DAG format
     * @return result 2 dimensional int array containing all possible paths to target
     */
    public int[][] allPaths(int[][] graph) {
        target = graph.length-1;
        pathResult = new ArrayList<List<Integer>>();
        LinkedList<Integer> tempPath = new LinkedList<Integer>();
        tempPath.addLast(0);
        checkPath(0, tempPath, graph);
        int[][] result = listToArr(pathResult);
        return result;
    }
    /**
     * helper function that main function calls to recusively check paths
     * @param cur current position in graph
     * @param tempPath partially constructed path
     * @param graph 2 dimensional data structure in DAG format
     */
    public void checkPath(int cur, LinkedList<Integer> tempPath, int[][]graph) {
        if (cur == target) {
            pathResult.add(new ArrayList<Integer>(tempPath));
            return;
        }
        for (int next : graph[cur]) {
            tempPath.addLast(next);
            checkPath(next, tempPath, graph);
            tempPath.removeLast();
        }
    }
    /**
     * function that takes a 2 dimensional list and returns it as an int array
     * @param list 2 dimensional list containing all possible paths to target
     * @return arr 2 dimensional int array containing all possible paths to target
     */
    public int[][] listToArr(List<List<Integer>> list) {
        int[][] arr;
        arr = list.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        return arr;
    }

    @Override
    public String toString() {
        return
                "pathResult=" + pathResult +
                '}';
    }

    public static void main(String[] args) {
        //test cases
        int[][] graph1 = {{1,2}, {3}, {3}, {}};
        int[][] graph2 = {{1}, {}};
        int[][] graph3 = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        Graph result = new Graph();
        result.allPaths(graph1);
        System.out.println(result);
        result.allPaths(graph2);
        System.out.println(result);
        result.allPaths(graph3);
        System.out.println(result);


    }

}
