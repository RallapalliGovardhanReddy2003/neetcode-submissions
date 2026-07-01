class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charset=new HashSet<>();
        int maxLength=0;
        int left=0;

        for(int right=0;right<s.length();right++){
            while(charset.contains(s.charAt(right))){
                charset.remove(s.charAt(left));
                left++;
            }
            charset.add(s.charAt(right));
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;

        
    }
}
