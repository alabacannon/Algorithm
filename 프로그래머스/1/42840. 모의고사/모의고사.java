import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] answers) {
    	int[] peek1 = {1,2,3,4,5};
    	int[] peek2 = {2,1,2,3,2,4,2,5};
    	int[] peek3 = {3,3,1,1,2,2,4,4,5,5};
    	
    	int count1 = 0;
    	int count2 = 0;
    	int count3 = 0;
    	
    	for (int i = 0; i < answers.length; i++) {
			if (answers[i] == peek1[i % peek1.length]) {
				count1++;
			}
			if (answers[i] == peek2[i % peek2.length]) {
				count2++;
			}
			if (answers[i] == peek3[i % peek3.length]) {
				count3++;
			}
		}
    	
    	int[][] countArr = {{count1,1},{count2,2},{count3,3}};
    	Arrays.sort(countArr, (o1,o2)-> {
    		if (o1[0] != o2[0]) {
    			return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o2[1], o1[1]);
			}
    	});
    	ArrayList<Integer> result = new ArrayList<>();
    	result.add(countArr[2][1]);
    	if (countArr[2][0] == countArr[1][0]) {
    		result.add(countArr[1][1]);
    	}
    	if (countArr[2][0] == countArr[0][0]) {
    		result.add(countArr[0][1]);
    	}
    	
    	return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}