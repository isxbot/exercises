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
*/

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int peak = 0;
        for(int i = 0; i < A.length -1 ; i ++){
            if(A[i] > A[i + 1]){
                peak = i;
                break;
            }
        }
        return peak;
    }
}
