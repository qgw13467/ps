

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BaekJoon21610 {
//마법사 상어와 비바라기
	static int[] dx=new int[] {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy=new int[] {0,-1,-1,0,1,1,1,0,-1};
	static int n;
	static int m;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		arr=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		ArrayList<Cloud> clouds=new ArrayList<>();
		clouds.add(new Cloud(n-1,0));
		clouds.add(new Cloud(n-1,1));
		clouds.add(new Cloud(n-2,0));
		clouds.add(new Cloud(n-2,1));
		for(int t=0;t<m;t++) {
			int d=sc.nextInt();
			int s=sc.nextInt();
			for(Cloud c:clouds) { //모든 구름이 d방향으로 s칸 이동
				c.moveCloud(d, s);
				arr[c.x][c.y]++;   // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가
			}
			ArrayList<Cloud> removedClouds=new ArrayList<>(clouds);
			Collections.copy(removedClouds,clouds);
			for(Cloud c:removedClouds) {
				c.replicateWater(); //물복사버그 마법 시전
			}
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].length;j++) {
					Cloud cloud=new Cloud(i,j);
					if(!removedClouds.contains(cloud)&&arr[i][j]>=2){
						arr[i][j]-=2;
						clouds.add(cloud);
					}
				}
			}
			clouds.removeAll(removedClouds);
		}
		sc.close();
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sum+=arr[i][j];
			}
		}
		System.out.println(sum);
	}
	static class Cloud{
		int x;
		int y;
		Cloud(int x,int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Cloud) {
				Cloud c=(Cloud)obj;
				if(this.x==c.x && this.y == c.y)
					return true;
			}
			return false;
		}
		public void moveCloud(int d,int s) {
			this.x=(this.x+n+(dx[d]*s)%n)%n;
			this.y=(this.y+n+(dy[d]*s)%n)%n;
//			if(this.x+(dx[d]*s)>=0 && this.x+(dx[d]*s)<n) {
//				this.x+=dx[d]*s;
//			}else if(this.x+(dx[d]*s)<0) {
//				this.x-=Math.abs(dx[d]*s)%n;
//				if(this.x<0) {
//					this.x=n+this.x;
//				}
//			}else {
//				this.x=(this.x+(dx[d]*s))%n;
//			}
//			if(this.y+(dy[d]*s)>=0 && this.y+(dy[d]*s)<n) {
//				this.y+=dy[d]*s;
//			}else if(this.y+(dy[d]*s)<0) {
//				this.y-=Math.abs(dy[d]*s)%n;
//				if(this.y<0) {
//					this.y=n+this.y;
//				}
//			}else {
//				this.y=(this.y+(dy[d]*s))%n;
//			}
		}
		public void replicateWater() {
			for(int d=2;d<=8;d+=2) {
				if(isInBoundary(x+dx[d], y+dy[d])&&arr[x+dx[d]][y+dy[d]]>0) {
					arr[x][y]++;
				}
			}
		}
	}
	static boolean isInBoundary(int x,int y) {
		if(x>=0 && x<n && y>=0 && y<n)
			return true;
		return false;
	}

}