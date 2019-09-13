/**
* Let's call an array A a mountain if the following properties hold:
*    - A.length >= 3
*    - There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
*
* Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
*
* Note:
*    - 3 <= A.length <= 10000
*    - 0 <= A[i] <= 10^6
*    - A is a mountain, as defined above.
*
* This is a binary search solution.
*/
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int peak = 0;
        int first = 0;
        int last = A.length - 1;
        
        while(first < last){
            int midpoint = first + (last - first) / 2;
            if(A[midpoint] < A[midpoint + 1]){
                first = midpoint + 1;
            } else { 
              last = midpoint;
            }
        }
        return first;
    }
}
