package codetest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
		Stack<Light> stack = new Stack<>();
		int n = Integer.parseInt(stringTokenizer.nextToken());
		Light[] arr = new Light[n];
		ArrayList<Integer> result = new ArrayList<>();

		stringTokenizer = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			Light light = new Light();
			light.index = i + 1;
			light.height = Integer.parseInt(stringTokenizer.nextToken());
			arr[i] = light;
			stack.add(light);

		}

//		while (true) {
//			Queue<Light> lights = new LinkedList<>();
//			Light light = stack.pop();
//			if (stack.size() == 0) {
//				light.index = 0;
//				result.add(light);
//				break;
//			}
//			while (true) {
//				if (stack.size() == 0) {
//					light.index = 0;
//					result.add(light);
//					while (lights.size() != 0) {
//						stack.add(lights.poll());
//					}
//					break;
//				}
//				Light temp = stack.pop();
//
//				if (temp.height >= light.height) {
//					light.index = temp.index;
//					result.add(light);
//					while (lights.size() != 0) {
//						stack.add(lights.poll());
//					}
//					stack.add(temp);
//					break;
//				}
//				lights.add(temp);
//			}
//
//		}
//
//		for (int i = result.size() - 1; i >= 0; i--) {
//			System.out.print(result.get(i).index + " ");
//		}

	}
}

class Light {
	int index;
	int height;
}