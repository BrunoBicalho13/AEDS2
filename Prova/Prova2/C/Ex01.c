#include<stdio.h>
#include<string.h>
#include<stdlib.h>
void swap(char* a, char* b){
	char* c = NULL;
	*c = *a;
	*a = *b;
	*b = *c;
}

typedef struct string{
	char* str;		
}string;

int main(){
	int n;
	string str;
	scanf("%d",&n);
	for(int i = 0; i < n; i++){
		fgets(str.str,50,stdin); getchar();
		string aux;
		char* pt = strtok(str.str," ");
		int j = 0;
		while(pt != "\0"){
			aux.str[j] = *pt; 
			//aux.str[j + 1]  = " ";
			pt = strtok(str.str, " ");
			j++;
		}
//		printf("aaaa");		
		for(int k = 0; k < strlen(aux.str); k++){
			for(int u = 0; u < strlen(aux.str) - 1; u++){
				if(aux.str[u] > aux.str[u + 1]);
					swap(&aux.str[u], &aux.str[u + 1]);
//					printf("bbbb");
			}
		}

		printf("%s",aux.str);
	}

	
}
