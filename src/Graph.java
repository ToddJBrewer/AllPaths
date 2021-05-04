import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    int target;
    List<List<Integer>> pathResult;

    public int[][] listToArr(List<List<Integer>> list) {
        int[][] arr;
        arr = list.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        return arr;

    }



    public int[][] allPaths(int[][] graph) {
        target = graph.length-1;
        this.pathResult = new ArrayList<List<Integer>>();
        LinkedList<Integer> tempPath = new LinkedList<Integer>();
        tempPath.addLast(0);
        this.goBack(0, tempPath, graph);
        int[][] result = listToArr(pathResult);
        return result;
    }

    public void goBack(int cur, LinkedList<Integer> tempPath, int[][]graph) {
        if (cur == target) {
            pathResult.add(new ArrayList<Integer>(tempPath));
            return;
        }
        for (int next : graph[cur]) {
            tempPath.addLast(next);
            goBack(next, tempPath, graph);
            tempPath.removeLast();
        }
    }

    @Override
    public String toString() {
        return
                "pathResult=" + pathResult +
                '}';
    }

    public static void main(String[] args) {
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
