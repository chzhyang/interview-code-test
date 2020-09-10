一个有序的数组(事先不确定升降序)中混入了一个不符合次序的错误数字，请一个java函数将它找出来。
例如 89,75,56,34,54,16，10 ，9，-5输出54
```java
public int find(int [] a,int len){
	if(a==null||len<=2){
    	return -1;
    int flag;
    int res;
   
    for(int i=1; i<len;i++){
    	if(i==1){
        	flag = (a[i]-a[i-1]>=0) ? 1 ; -1;
        }else{
        	if(!(flag==1 && a[i]>=1[i-1]) || (flag==-1 && a[i]<a[i-1])){
            	if(flag==1){res = a[i-1];}
                else{res = a[i];}
                break;
            }
        }
    }
    return res;
}
```