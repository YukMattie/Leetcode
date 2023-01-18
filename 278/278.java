/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
           
            int first = 1;
            int last = n;
    
            while(first < last ){

                // the sum may result to overflow if use (first + last) / 2
                int mid = first + (last - first) / 2;

                // the mid may be the first bad version, so don't use last = mid + 1
                if(isBadVersion(mid)){
                    last = mid;
                }
                else{
                    first = mid + 1;
                }
            }
    
            return first;   
            
        }
    }