
//大佬写的 https://paste.ubuntu.com/p/svJtV5FrYg/
//实际上就是求树的子节点中，子节点数最多的那个加一

import java.util.ArrayList;
import java.util.Scanner;

public class LeastTime {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 1; i < n; i++) {
			int from = input.nextInt(), to = input.nextInt();
			from--;
			to--;
			graph[from].add(to);
			graph[to].add(from);
		}

//		for(int i = 0;i < n;i++)
//			System.out.println(graph[i]);
		System.out.println(leastTime(graph));
	}

	private static int leastTime(ArrayList<Integer>[] graph) {
		int result = 0;
		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		for (int i = 0; i < graph[0].size(); i++) {
			visited[graph[0].get(i)] = true;
			int count = countOfChild(graph, graph[0].get(i), visited);
			result = Math.max(result, count);
		}

		return result;
	}

	private static int countOfChild(ArrayList<Integer>[] graph, Integer x, boolean[] visited) {
		int sum = 1;
		for (int i = 0; i < graph[x].size(); i++) {
			int next = graph[x].get(i);
			if (!visited[next]) {
				visited[next] = true;
				sum += countOfChild(graph, next, visited);
			}
		}
		return sum;
	}
}

public class Main {

    static int sum(int[][] arr) {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 2; j < arr.length; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    static void move(int[][] arr, int i, int j) {
            for (int x = 1; x < arr.length; x++){
                if (arr[x][i] > 0){
                    arr[x][i] -= 1;
                    arr[i][j] += 1;
                    move(arr,x,i);
                    break;
                }
            }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 1;
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (b > a){
                int temp = b;
                b = a;
                a = temp;
            }
            arr[a][b] = 1;
        }

        while (sum(arr) > 0){
            System.out.println(sum(arr));
            result += 1;
            for (int i = 1; i <= n; i++) {
                if (arr[i][1] > 0){
                    arr[i][1] -= 1;
                    move(arr,i,1);
                }
            }
        }

        System.out.println(result);

    }
}