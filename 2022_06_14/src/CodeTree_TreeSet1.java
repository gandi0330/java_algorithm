import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class CodeTree_TreeSet1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		for(int i=0;i<n;i++) {
			String[] command = br.readLine().split(" ");
			
			if(command[0].equals("add")) {
				treeSet.add(Integer.parseInt(command[1]));
			}
			
			else if(command[0].equals("find")) {
				if(treeSet.contains(Integer.parseInt(command[1]))){
					System.out.println("true");
				}
				else {
					System.out.println("false");
				}
			}
			
			else if(command[0].equals("remove")) {
				if(treeSet.isEmpty()) {
					System.out.println("None");
				}
				else treeSet.remove(Integer.parseInt(command[1]));
			}
			
			else if(command[0].equals("largest")) {
				if(treeSet.isEmpty()) {
					System.out.println("None");
				}
				else System.out.println(treeSet.last());
			}
			
			else if(command[0].equals("smallest")) {
				if(treeSet.isEmpty()) {
					System.out.println("None");
				}
				else System.out.println(treeSet.first());
			}
			else if(command[0].equals("lower_bound")) {
				if(treeSet.isEmpty()) {
					System.out.println("None");
				}
				else System.out.println(treeSet.lower(Integer.parseInt(command[1])));
			}
			else if(command[0].equals("upper_bound")) {
				if(treeSet.isEmpty()) {
					System.out.println("None");
				}
				else System.out.println(treeSet.higher(Integer.parseInt(command[1])));
			}
		}
	}

}
