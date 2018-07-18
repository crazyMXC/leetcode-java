class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int len1=num1.length();
        int len2=num2.length();
        int len=len1+len2-1;
        int carry=0, temp=0,templ=0,tempr=0;
        int sum=0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i=1;i<=len;i++){
            for(int j=1;j<=i;j++){
                if(i+1-j>len2 || j>len1){
                    continue;
                }
                templ=Integer.parseInt(num1.substring(len1-j,len1-j+1));
                tempr = Integer.parseInt(num2.substring(len2-1-i+j, len2-i+j));
                temp = templ * tempr;
                sum = temp + sum;
            }
            sum +=carry;
            st.push(sum % 10);
            carry = sum/10;
            sum = 0;
        }
        while(carry != 0){
            st.push(carry % 10);
            carry /= 10;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
        }

}