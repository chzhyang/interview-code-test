import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<1){
            return;
        }
        for(int i=0; i<n; i++){//n组test
            int num = in.nextInt();
            int k = in.nextInt();
            if(num<1 || k<1){
                continue;
            }
            // 依次对k个属性的满足区间进行交集计算
            int[] p = new int[num+1];//num头牛的数组[1,num] ，代表交集的累计结果
            for(int j=0; j<k;i++){//验证k个属性
                int jNum = in.nextInt();//满足属性j的区间数
                if(jNum<1){
                    continue;
                }
                for(int h=0; h<jNum; h++){//每个区间
                    int left = in.nextInt();
                    int right = in.nextInt();
                    if(left<=0 || right<=0){
                        continue;
                    }
                    for(int t=left; t<=right; t++){//区间内连续
                        //跟前面属性的验证结果，求交集，只有前后都在区间才能标记为1
                        if(i==0){//严格讲要加flag
                            p[t]=1;
                        }else if(p[t]!=1){
                            p[t]=0;
                        }else if(p[t]==1){
                            p[t]=1;
                        }
                    }
                }//该属性所有区间验证完
            }//验证完本组k个属性
            //计算本组测试数据的结果
            int cnt = 0;//满足条件的数量
            for(int ii=1; ii<=num; ii++){
                if(p[ii]==1){
                    cnt++;
                }
            }
            System.out.println(cnt);
            for(int ii=1; ii<=num; ii++){
                if(p[ii]==1){
                    if(cnt>0) {
                        System.out.print(p[ii] + " ");
                    }else{
                        System.out.println(p[ii]);
                    }
                }
            }
        }
    }
}
