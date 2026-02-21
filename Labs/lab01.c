#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int NumeroMaiusculas(char* string){
	int cont = 0;
	if(*string >= 65 && *string <= 95){
		cont++;
	}
}

int main(){
	char *string = (*char)malloc(2000*sizeof(char));
	fgets(string,2000,stdin);

	int Maiusculas = 0;

	Maiusculas = NumeroMaiusculas(&string);	printf("O numero de letras maiusculas eh: %d\n",Maiusculas);
}
