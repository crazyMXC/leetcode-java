public String removeDuplicateLetters(String s) {
    	int len=s.length();
    	if(len<1) return "";
    	/**存储字符及个数*/
    	Map<Character,Integer> map=new HashMap<Character,Integer>();
    	for(int i=0;i<len;i++)
    	{
    		char c=s.charAt(i);
    		if(map.containsKey(c))
    		{
    			map.put(c, map.get(c)+1);
    		}
    		else
    		{
    			map.put(c, 1);
    		}
    		
    	}
    	/**记录最小字符及位置*/
    	MinChar minc=new MinChar();
    	
    	
    	minc.ch=s.charAt(0);
    	minc.pos=0;
    	for(int i=0;i<len;i++)
    	{
    		char c=s.charAt(i);
    		/**更新最小字符*/
    		if(c<minc.ch)
    		{
    			minc.ch=c;
    			minc.pos=i;
    		}
            /**只有一个字符，不能再减了。更新字符串，递归查找*/
    		if(map.get(c)==1)
    		{
    			 String news=s.substring(minc.pos+1).replaceAll(minc.ch+"", "");
    			 return minc.ch+removeDuplicateLetters(news);
    		}
    		else
    		{
    			map.put(c, map.get(c)-1);
    		}
    		
    	}
        return "";
    }

