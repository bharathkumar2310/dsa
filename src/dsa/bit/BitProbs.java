package dsa.bit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BitProbs {

	public List<String> oddOrEven(List<Integer>number){
		List<String> ans = new ArrayList<>();
		
		for(Integer it : number) {
			if((it & 1) == 1) {
				ans.add("odd");
			} else {
				ans.add("even");
			}
		}
		return ans;
		
//		 return number.stream()
//                 .map(it -> (it & 1) == 1 ? "odd" : "even")
//                 .collect(Collectors.toList());
	}
	
	
	public List<String> powerOf2(List<Integer>number) {
		List<String> ans = new ArrayList<>();
        for(Integer it : number) {
        	if((it & it-1) == 0 && it > 0) {
        		ans.add("power of 2");
        	}
        	else {
				ans.add("not a power of 2");
			}
        }     
        return ans;
//       return  number.stream().map((num) -> (num >0 && (num & num-1)) == 0 ? "power Of 2" : "not a power of 2")
//                                        .collect(Collectors.toList());
	}
	
	public List<Integer> noOfbitsHaving1(List<Integer>number){
		List<Integer> ans = new ArrayList<>();
		
		for(Integer it : number) {
			int count =0;
			while(it != 0) {
				it = it & it-1;
				count++;
			}
			ans.add(count);
		}
		return ans;
		
			
//			 return number.stream()
//            .map(this::countBits)   // inbuilt
//            .collect(Collectors.toList());	     }
     }
	
}
