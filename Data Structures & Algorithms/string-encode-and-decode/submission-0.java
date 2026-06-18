class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str : strs){
            encoded.append(str.length())
                    .append('#')
                    .append(str);
        }
         return encoded.toString();

    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();
        int i=0;

        while(i<str.length()){
            int j=i;

            while(str.charAt(j)!='#'){
                j++;
            }
            
            int length= Integer.parseInt(str.substring(i,j));

            String word= str.substring(j+1,j+1+length);
            
            result.add(word);
            
            i=j+1+length;

        }
        return result;

    }
}
