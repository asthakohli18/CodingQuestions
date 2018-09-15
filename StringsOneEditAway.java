/**
 * Created by kohas02 on 6/30/18.
 */
/**
 * EXAMPLE
 pale, ple -) true
 pales, pale -) true
 pale, bale -) true
 pale, bae -) false
 * */
public class StringsOneEditAway {

    private boolean isOneEditAway(String s1, String s2){

        if(s1.length() == s2.length())
            return oneEditReplace(s1,s2);
        else if(s1.length() == s2.length()+1)
            return oneEditInsert(s2,s1);
        else if(s2.length() == s1.length()+1)
            return oneEditInsert(s1,s2);
        return false;
    }

    // if only single difference, then 1 character replace will make two strings equal
    private boolean oneEditReplace(String s1, String s2) {
        boolean foundDiff = false;
        for(int i=0; i< s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDiff) {
                    return false;
                }
                foundDiff=true;
            }
        }
        return foundDiff;
    }


    private boolean oneEditInsert(String smaller, String longer) {
        int index1 =0;
        int index2 =0;
        while(index1 < smaller.length() && index2 < longer.length()){
            if(smaller.charAt(index1) != longer.charAt(index2)){
                if(index1 != index2) // this condition will happen if 1 is replace and 1 is insert
                    return false;
                index2++;
            }
            else{
                index1++;
                index2++;
            }
        }
        return true;
    }


    public static void main(String args[] ){
        StringsOneEditAway obj = new StringsOneEditAway();
        System.out.println("pale, ple EXPECTED true ACTUAL " +obj.isOneEditAway("pale", "ple"));
        System.out.println(" pales, pale EXPECTED true ACTUAL "+obj.isOneEditAway("pales", "pale"));
        System.out.println("pale, bale EXPECTED true ACTUAL "+obj.isOneEditAway("pale", "bale"));
        System.out.println("pale, bae EXPECTED false ACTUAL "+obj.isOneEditAway("pale", "bae")); // this should return false


    }
}
