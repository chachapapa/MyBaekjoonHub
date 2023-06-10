import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static class spot{
        int i;
        int j;
        int cnt;
        boolean destroyed;

        public spot(int i, int j, int cnt, boolean d) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String ezin = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = ezin.charAt(j);
            }
        }


        Queue<spot> q = new LinkedList<>();
        q.add(new spot(0, 0, 1, false));

        int[] di = {0, 0, -1, 1};
        int[] dj = {-1, 1, 0, 0};

        boolean[][][] visited = new boolean[n][m][2];

        while (!q.isEmpty()) {
            spot now = q.poll();

            if (now.i == n - 1 && now.j == m - 1) {
                System.out.println(now.cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if(ni<0 || ni>=n || nj<0 || nj>=m) continue;

                int next_cnt = now.cnt+1;

                if(map[ni][nj]=='0'){
                    if(!now.destroyed && !visited[ni][nj][0]) {
                        q.add(new spot(ni, nj, next_cnt, false));
                        visited[ni][nj][0] = true;
                    }else if(now.destroyed && !visited[ni][nj][1]){
                        q.add(new spot(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }

                }else { 
                    if(!now.destroyed){ 
                        q.add(new spot(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }
                }
            }

        }

        System.out.println(-1);
    }
}