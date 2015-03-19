package chapter53;


public class KMP {

	private final int R;      
    private int[][] dfa;       

    private char[] pattern;    
    private String pat;        

    
    public KMP(String pat) {
        this.R = 256;
        this.pat = pat;

        
        int M = pat.length();
        dfa = new int[R][M]; 
        dfa[pat.charAt(0)][0] = 1; 
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) 
                dfa[c][j] = dfa[c][X];    
            dfa[pat.charAt(j)][j] = j+1;    
            X = dfa[pat.charAt(j)][X];     
        } 
    } 

    
    public KMP(char[] pattern, int R) {
        this.R = R;
        this.pattern = new char[pattern.length];
        for (int j = 0; j < pattern.length; j++)
            this.pattern[j] = pattern[j];


        int M = pattern.length;
        dfa = new int[R][M]; 
        dfa[pattern[0]][0] = 1; 
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) 
                dfa[c][j] = dfa[c][X];     
            dfa[pattern[j]][j] = j+1;      
            X = dfa[pattern[j]][X];        
        } 
    } 

    // return offset of first match; N if no match
    public int search(String txt) {

        // simulate operation of DFA on text
        int M = pat.length();
        int N = txt.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i - M;    // found
        return N;                    // not found
    }


    // return offset of first match; N if no match
    public int search(char[] text) {

        // simulate operation of DFA on text
        int M = pattern.length;
        int N = text.length;
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text[i]][j];
        }
        if (j == M) return i - M;    // found
        return N;                    // not found
    }


    public int query(String query, String txt) {
		
        int len = query.length();
        int longest = len+1;
        
        for(int i=len; i>0; i--){
        	for(int j=0; j+i<len; j++){
        		String pat = query.substring(j, j+i);
        		KMP kmp1 = new KMP(query);
        		longest = kmp1.search(txt)-1;
        		if(longest<=len)
        			break;
        	}
        }
        return longest;
	}

    // test client
    public static void main(String[] args) {
        String pat = "acbac";
        String txt = "acaccbabbacbac";
        
        KMP kmp = new KMP(pat);
        
        
        /*char[] pattern = pat.toCharArray();
        char[] text    = txt.toCharArray();*/

        int location = txt.length();
        int locat = 0;
        int len = pat.length();
        for(int i=len; i>0; i--){
        	for(int j=0; j+i<len; j++){
        		String query = pat.substring(j, j+i+1);
        		KMP kmp1 = new KMP(query);
        		location = kmp1.search(txt);
        		if(location<=txt.length())
        			break;
        	}
        	if(location<=txt.length()){
        		locat = i;
        		break;
        	}
        }
//        System.out.println(len);
        System.out.println("offset1:"+locat);
        
        /*KMP kmp = new KMP(pat);
        int offset1 = kmp.search(txt);
        System.out.println(len);
        System.out.println("offset1:"+offset1);*/

        /*KMP kmp2 = new KMP(pattern, 256);
        int offset2 = kmp2.search(text);
*/
        // print results
        /*System.out.println("text:    " + txt);

        System.out.print("pattern: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);*/

        /*System.out.print("pattern: ");
        for (int i = 0; i < offset2; i++)
            System.out.print(" ");
        System.out.println(pat);*/
    }
	
}
