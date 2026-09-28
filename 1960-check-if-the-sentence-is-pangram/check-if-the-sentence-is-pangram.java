class Solution {
    public boolean checkIfPangram(String sentence) {
        for(char ch='a';ch <='z';ch++){
            boolean found=false;
        

        for(char i=0;i<sentence.length();i++){
            if(ch == Character.toLowerCase(sentence.charAt(i))){
                found=true;
                break;
            }
        
        }
        if(!found){
            return false;
         }
        }
        return true;

    }  
        
    }
