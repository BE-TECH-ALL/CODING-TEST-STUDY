/*
 * 문제 : 14503 - 로봇 청소기 / 난이도 : Gold5
 * 구현 문제
 *
 * 메모리 : 14752KB / 시간 : 136ms
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		// (북, 동, 남, 서) 순서로 이동 배열 생성
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(true){
			// 현재 칸이 청소 되어있지 않으면 청소 진행
			if(map[r][c] == 0) {
				map[r][c] = 2; // 2는 청소된 상태를 의미
				answer++;
			}
			// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			if(map[r-1][c] != 0 && map[r][c-1] != 0 && map[r+1][c] != 0 && map[r][c+1] != 0){
				// 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진
				if(map[r-dr[d]][c-dc[d]] != 1){
					r = r - dr[d];
					c = c - dc[d];
				} else {
					// 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춤
					break;
				}
				// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			} else if (map[r-1][c] == 0 || map[r][c-1] == 0 || map[r+1][c] == 0 || map[r][c+1] == 0){
				d = (d + 3) % 4; // 반시계 방향으로 90도 회전
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				if(map[r+dr[d]][c+dc[d]] == 0) {
					r = r + dr[d];
					c = c + dc[d];
				}
			}
		}

		System.out.println(answer);
	}
}