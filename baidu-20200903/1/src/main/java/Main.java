import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int num_zero=0,num_five=0;
        for(int i=0; i<n; i++){
            if(in.nextInt()==0){
                num_zero++;
            }else{
                num_five++;
            }
        }
        in.close();

       if(num_five/9 > 0 && num_zero > 0){
            String basic = "555555555";
            StringBuilder result = new StringBuilder();
            for(int i=0; i<num_five/9; i++){
                result.append(basic);
            }
            for(int i =0;i <num_zero;i++){
                result.append("0");
            }
            System.out.println(result);
        }else if(num_zero>0) {
           System.out.println(0);
       }else {
            System.out.println(-1);
       }


    }
}
