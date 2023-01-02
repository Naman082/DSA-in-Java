/*
SAMPLE INPUT 1:
6 // size of the array
1 3 5 7 11 14
14 // elem
SAMPLE OUTPUT 1:
5 //index
SAMPLE INPUT 2:
6 // size of the array
1 3 5 7 11 14
2 // elem
SAMPLE OUTPUT 2:
-1 //element not present
*/

import java.util.Scanner;
public class BinarySearch {
	
	private static int binarySearch(int[] arr, int startIndex, int endIndex, int elem) {
		if(startIndex > endIndex) 
			return -1;
		int midIndex = (startIndex + endIndex) / 2;
		if(arr[midIndex] > elem) // element is at left of midIndex
			return binarySearch(arr, startIndex, midIndex-1, elem);
        else if(arr[midIndex] < elem)  // element is at right of midIndex       
            return binarySearch(arr, midIndex+1, endIndex, elem);
		else // element is at midIndex  
			return midIndex;
	}
	
	private static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i]= s.nextInt();
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = takeInput();
		int elem = s.nextInt();
		System.out.println(binarySearch(arr, 0, arr.length-1, elem));
	}
}
