import java.util.HashMap;

public class AnnaSocDrawer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//example
		int noOfWashes = 10;
		int[] cleanPile = {1, 2, 1, 1 };
		int[] dirtyPile = {1, 4, 3, 2, 4 };
		
		System.out.println(getMaximuNumberOfSocks(noOfWashes, cleanPile, dirtyPile));
	}
	
	public static int getMaximuNumberOfSocks(int noOfWashes, int[] cleanPile, int[] dirtyPile) {
		
		//constraint 1: clean socks do not need to be re-wash
		//constraint 2:  noOfWashes variable is within the range of 0..50
		if(noOfWashes < 0 || noOfWashes > 50) {
			return -1; //invalid input. error
		}
		
		//constraint: cleanPile & dirty cannot be empty and cannot be greater than 50
		if(cleanPile.length <= 0 || dirtyPile.length <= 0 || cleanPile.length > 50 || dirtyPile.length >50)
		{
			return -1; // invalid input. //error
		}
		
	
		int maxSocks = 0;
		
		//Clean pile does not need to be clean again.
		//that is even noOfWashes = 0. lets return the pair of socks.
		
		//hash to hold the visited cleanPile
		HashMap<Integer, Integer> visitedCleanPile = new HashMap<>();
		for(int i = 0; i < cleanPile.length; i++) {
			
			//check if the visited is empty for the first time
			if(visitedCleanPile.isEmpty()) {
				visitedCleanPile.put(cleanPile[i], i);
			}else {
				//now the visited has item, compare the current item to onces in the house
				// if return true, increase the count and remove it from the house
				if(visitedCleanPile.containsKey(cleanPile[i])) {
					//increase count
					maxSocks++;
					//remove the item in the house
					visitedCleanPile.remove(cleanPile[i]);
				}else {
					//if not found, add the item
					visitedCleanPile.put(cleanPile[i], i);
				}
			}
			
			
			
		}
		
		//get the number of socks from dirtyPile, 
		//at first we will assume that the machine can wash all 
		//then we will now pick base on the number of washes.
		
		//assumed nnumber of washes
		int assumeWashedSocks = 0;
		
	
		
		//hash to hold visitedCleanPile
		HashMap<Integer, Integer> visitedDirtyPile = new HashMap<Integer, Integer>();
		for(int i = 0; i < dirtyPile.length; i++) {
	
			if(visitedDirtyPile.isEmpty()) {
				visitedDirtyPile.put(dirtyPile[i], i);
				//check the first...too...in just case :)
				if(visitedCleanPile.containsKey(dirtyPile[i])){
				assumeWashedSocks++;
				
				//remove to avoid double checking
				visitedCleanPile.remove(dirtyPile[i]);
			   }
			
			}else {
				//first compare within the dirty socks
				if(visitedDirtyPile.containsKey(dirtyPile[i])) {
					assumeWashedSocks++;
					visitedDirtyPile.remove(dirtyPile[i]);
				}else if(visitedCleanPile.containsKey(dirtyPile[i])) {
					  assumeWashedSocks++;
					  visitedCleanPile.remove(dirtyPile[i]);
				}
				else {
					visitedDirtyPile.put(dirtyPile[i], i);
					
				}
				//second compare within left over clean pile		
			}
			
		}
		
		int NoOfAvailablePairsOfSocks = 0;
		
		//if no of wahes is zero
		if(noOfWashes == 0) {
			NoOfAvailablePairsOfSocks =  maxSocks;
		}else {
			if(noOfWashes >=  assumeWashedSocks) {
				NoOfAvailablePairsOfSocks =  assumeWashedSocks + maxSocks;
			}else {
				NoOfAvailablePairsOfSocks =  noOfWashes + maxSocks;
			}
		}
		
		return NoOfAvailablePairsOfSocks;
		
	}

}
