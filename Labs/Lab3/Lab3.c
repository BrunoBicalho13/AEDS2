#include<stdio.h>
#include<stdlib.h>
#include<time.h>

void crescente(int *array, int n) {
   for (int i = 0; i < n; i++) {
      array[i] = i;
   }
}

void swap(int *i, int *j) {
   int temp = *i;
   *i = *j;
   *j = temp;
}

void aleatorio(int *array, int n) {
   crescente(array, n);
   srand(time(NULL));
   for (int i = 0; i < n; i++) {
      swap(&array[i], &array[rand() % n]);
   }
}

void selecao(int *array, int n,int M){
    for (int i = 0; i < (n - 1); i++) {
      int menor = i;
      for (int j = (i + 1); j < n; j++){
         if (array[menor] % M  > array[j] % M){
	   menor = j;
	 }
	    else if(array[menor] % M  ==  array[j] % M){
		    if(array[menor] % 2 != 0 && array[j] % 2 != 0){
		    	if(array[menor]  <  array[j]){
				 menor = j;
			}
		    }else if(array[menor] % 2 == 0 && array[j] % 2 == 0){
		    	if(array[menor]  >  array[j]){
                                 menor = j;
		         }
         	   }
		    else if(array[menor] % 2 == 0 && array[j] % 2 != 0){
		    	menor = j;
		    }
           }
      swap(&array[menor], &array[i]);
   }
 }
}

int main(){
	
	int N, M;
	scanf("%d %d",&N,&M);
	printf("%d %d\n",N,M);

	while(N != 0 && M != 0){
		int * arr = (int*) malloc ( N * sizeof(int));
	
		for(int i = 0; i < N; i++){
			scanf("%d",(arr + i));
		}
	
		selecao(arr,N,M);

		for(int i = 0; i < N; i++){
			printf("%d\n",*(arr + i));
		}
		scanf("%d %d",&N,&M);
		printf("%d %d\n",N,M);


	}
}
