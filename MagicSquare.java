import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.*;

public class Solution {

    static int sool(int[]a,int []b)
    {
        int h=0;
       
        for(int i=0;i<9;i++)
        {
           
            if(a[i]!=b[i])
            {
             
                int aa=a[i];
                int bb=b[i];
                int yy=aa-bb;
                int u;
                if(yy<0)
                {
                    yy=(-1)*yy;
                    
                }
               
                h=h+yy;

            }
        }

        return h;
    }
    
    static int formingMagicSquare(int[][] s) {
        int [] a=new int[]{8, 1, 6, 3, 5, 7, 4, 9, 2};
        int [] b=new int[]{6, 1, 8, 7, 5, 3, 2, 9, 4};
        int [] c=new int[]{4, 9, 2, 3, 5, 7, 8, 1, 6};
        int [] d=new int[]{2, 9, 4, 7, 5, 3, 6, 1, 8};
        int [] e=new int[]{8, 3, 4, 1, 5, 9, 6, 7, 2};
        int [] f=new int[]{4, 3, 8, 9, 5, 1, 2, 7, 6};
        int [] g=new int[]{6, 7, 2, 1, 5, 9, 8, 3, 4};
        int [] h=new int[]{2, 7, 6, 9, 5, 1, 4, 3, 8};
        int [] aa=new int[9];
        int i=0;
        for(int t=0;t<3;t++)
        {
            for(int j=0;j<3;j++)
            {
                aa[i]=s[t][j];
                i++;
            }
        }
        int a1=0,b1=0,c1=0,d1=0,e1=0,f1=0,g1=0,h1=0;
        for(i=0;i<9;i++)
        {
            if(aa[i]==a[i])
            {
                a1++;
            }
            if(aa[i]==b[i])
            {
                b1++;
            }
            if(aa[i]==c[i])
            {
                c1++;
            }
            if(aa[i]==d[i])
            {
                d1++;
            }
            if(aa[i]==e[i])
            {
                e1++;
            }
            if(aa[i]==f[i])
            {
                f1++;
            }
            if(aa[i]==g[i])
            {
                g1++;
            }
            if(aa[i]==h[i])
            {
                h1++;
            }
           
            
        }
        
      
            {
                int w=0;
                int []q=new int[8];
                q[0]=a1;
                q[1]=b1;
                q[2]=c1;
                q[3]=d1;
                q[4]=e1;
                q[5]=f1;
                q[6]=g1;
                q[7]=h1;
                int []ee=new int[8];
                for(i=0;i<8;i++)
                {
                    ee[i]=q[i];
                }
                Arrays.sort(q);
                int qq=0,qy=q[7];
              List<Integer>l1=new ArrayList<>();
                int hello=0;
                for(int j=0;j<8;j++)
                {
                    if(qy==q[j])
                    {
                        hello++;
                    }
                }
             
                {
                   
                {
                  
                     w=sool(a,aa);
                   l1.add(w);
                     w=sool(b,aa);
                   l1.add(w);
                     w=sool(c,aa);
                    l1.add(w);
                     w=sool(d,aa);
                    l1.add(w);
                    w=sool(e,aa);
                   l1.add(w);
                    w=sool(f,aa);
                    l1.add(w);
                    w=sool(g,aa);
                   l1.add(w);
                    w=sool(h,aa);
                    
                    l1.add(w);

                }
                
                            
                    
                }
                int []asss=new int[l1.size()];
                for( i=0;i<l1.size();i++)
                {
                    asss[i]=l1.get(i);
                }
                
                Arrays.sort(asss);
    
                return asss[0];
            }
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
