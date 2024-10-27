#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
    float m, mm=1000;
    char cn[100],lm[100],c=' ';
    while(c != '\n') {
        scanf("%[^@]@%f%c",&cn,&m,&c);
        printf("%s",cn);
        if(m<mm) {
            mm = m;
            strcpy(lm,cn);
        }
    }
    printf("%s",lm);
    return 0;
}
