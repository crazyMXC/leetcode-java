public class RegularExpressionMatching {
	public static void main(String[] args){
		String s = "abc";
		String reg = "ab*c*";
		System.out.println(method( s, reg));
	}
 
	private static boolean method(String s, String reg) {
		// TODO Auto-generated method stub
		char[] chars = s.toCharArray();
		char[] charreg = reg.toCharArray();
		char charlast = 0;
		int regIndex = 0;//reg游标
		for(int i =0;i<s.length();i++){//超出游标范围
			if(regIndex>=charreg.length)
				return false;
			
			if(charreg[regIndex]=='.'){//得到。直接跳过
				charlast = charreg[regIndex];
				regIndex++;
				continue;
				
			}else if(charreg[regIndex]=='*'){
				if(regIndex!=0){
					if(charlast=='.')//点星匹配直接返回
						return true;
					else {//星号向下匹配
						int j = i;
						for(;j<s.length();j++){
							if(chars[j]!=charlast)
								break;
						}
						charlast = charreg[regIndex];
						regIndex++;
						i=--j;
						continue;
					}
				}
			}else {//得到字符
				if(chars[i]!=charreg[regIndex]){
					if(regIndex<(charreg.length-1)&&charreg[regIndex+1]=='*'){
						regIndex+=2;
						continue;
					}
					return false;
				}
				if(regIndex<(charreg.length-1)&&charreg[regIndex+1]=='*'){
					charlast = charreg[regIndex];
					i--;
					regIndex++;
					continue;
				}
				regIndex++;
			}
			charlast = charreg[regIndex];
		}
		if(regIndex!=charreg.length)//字长不匹配
		{	if(charreg.length>=regIndex){
				if((regIndex+1)==charreg.length){
					if(charreg[regIndex]!='*')
						return false;
					else
						return true;
				}
				if(charreg[charreg.length-1]!='*')
					return false;
				for(int i = regIndex+2;i<charreg.length;i++){//余下字符都是.*或者char＊才行
					if(charreg[i-1]!='.'&&charreg[i-1]!='*'&&charreg[i]!='.'&&charreg[i]!='*'){
						return false;
					}
				}
			}
			return false;
		}
		return true;
	}

