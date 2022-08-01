#include <stdio.h>

int main(){
    int a, b;
    scanf("%d", &a);
    scanf("%d", &b);
    if(a>0 && b<10){
        printf("%d", a-b);
        
        return 0;
    }
}