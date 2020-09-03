import java.util.*;
class Node {
    int cnt;
    int id;
    Node(int x, int y){
        id = x;
        cnt =y;
    }
}
public class Main {
    public static void mysort(ArrayList<Node> list){
        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                int flag;
                //cnt down sort
                flag = n1.cnt-n2.cnt;
                if(flag==0){
                    //id up sort
                    flag = n1.id-n2.id;
                }
                return flag;
            }
        });
    }
    public static void myprint(int color, int max, ArrayList<Node> l){
        int a,b,c;
        a = l.get(0).id;
        b = l.get(1).id;
        c = l.get(0).id;
        System.out.print(a+" "+b+" "+c);
        System.out.println();
        System.out.println(color);
        System.out.println(max);
    }
    public static void find(ArrayList<Node> l1, ArrayList<Node> l2){
        if((l1==null && l2==null )|| (l1.size()<3 &&l2.size()<3)) return;
        int max1=0;
        int max2=0;
        //sort 
        if(l1!=null&&l1.size()>=3){
            mysort(l1);
            max1 = l1.get(0).cnt+l1.get(1).cnt+l1.get(2).cnt;
        }
        if(l2!=null&&l2.size()>=3){
            mysort(l2);
            max2 = l2.get(0).cnt+l2.get(1).cnt+l2.get(2).cnt;
        }
        //compare
        
        if(max1>max2){
            myprint(1,max1,l1);
            
        }else if(max1<max2){
            myprint(2,max2,l2);
        }else{//==
            for(int i=0; i<3; i++){
                if(l1.get(i).id<l2.get(i).id){
                    myprint(1,max1,l1);
                    return;
                }
            }
            myprint(2,max2,l2);
            return;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n<=2) return;
        ArrayList<Node> l1 = new ArrayList<>();//color=1
        ArrayList<Node> l2 = new ArrayList<>();//color=2
        for(int i=0; i<n;i++){//i is id of child
            int cnt = in.nextInt();
            int color = in.nextInt();
            Node node = new Node(i+1, cnt);///id+1
            if(color==1){
                l1.add(node);
            }else{
                l1.add(node);
            }
        }
        find(l1,l2);
    }
}