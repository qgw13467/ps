

import java.util.ArrayList;
import java.util.Scanner;

public class ProductValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> arrayList= new ArrayList<>();
		ArrayList<Integer> numArrayList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			arrayList.add(sc.nextInt());
			numArrayList.add(1);
		}
		
		for(int i=0;i<arrayList.size();i++) {
			for(int j=0;j<arrayList.size();j++) {
				if(arrayList.get(i)<arrayList.get(j)) {
					numArrayList.set(i, numArrayList.get(i)+1);
				}
			}
		}
		System.out.println(numArrayList);
		
		
	}

}
