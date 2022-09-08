import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_12865 {

	static StringTokenizer stringTokenizer;
	static int n, k;
	static int[][] arr;
	static Product[] products;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		n = Integer.parseInt(stringTokenizer.nextToken());
		k = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[n + 1][k + 1];
		products = new Product[n + 1];
		for (int j = 1; j <= n; j++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			Product product = new Product();
			product.weight = Integer.parseInt(stringTokenizer.nextToken());
			product.value = Integer.parseInt(stringTokenizer.nextToken());
			products[j] = product;
		}
		
		System.out.println(Arrays.toString(products));
		System.out.println();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (products[i].weight > j) {
					arr[i][j] = arr[i - 1][j];
				} else {
					arr[i][j] = Math.max(products[i].value + arr[i - 1][j - products[i].weight], arr[i - 1][j]);
				}
			}
		}
		
		for(int i=0;i<=n;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		System.out.println(arr[n][k ]);

	}

}

class Product {

	int weight, value;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return weight + " " + value;
	}
}