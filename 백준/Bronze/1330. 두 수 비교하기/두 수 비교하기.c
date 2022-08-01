#include <stdio.h>

int main(){
    int a, b;
    scanf("%d %d", &a, &b);
    
    if(a>b && -10000<=a && b<=10000){
        printf(">");
    }
    else if(a<b && -10000<=a && b<=10000){
        printf("<");
    }
    else if(a==b && -10000<=a && b<=10000){
        printf("==");
    }
    
    return 0;
}