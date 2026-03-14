#include<stdio.h>
#include<stdlib.h>

int tamanhoString(char string[])
{
	int i = 0;
	while (string[i] != '\0')
	{
		i++;
	}
	return i;
}


int somaDigitos(int n){
	if(n == 0){
		return 0; // Caso Base
	}
	return (n % 10) + somaDigitos( n / 10); // Modulo pega o ultimo digito e a divisão remove o ultimo digito ( pois divide por 10)
}

int comparaString(char string1[], char string2[])
{
	int tamanho1 = tamanhoString(string1);
	int tamanho2 = tamanhoString(string2);
	int flag = 1;

	if (tamanho1 != tamanho2)
	{
		return 0;
	}
	else
	{
		for (int i = 0; i < tamanho1; i++)
		{
			if (string1[i] != string2[i])
			{
				flag = 0;
			}
		}
	}

	if (flag == 0)
	{
		return 0;
	}
	else
	{
		return 1;
	}
}

int main(){
	char str[2000];// declarar como string pois é necessario comparar com FIM
	scanf("%s",str); 

	while(comparaString(str,"FIM") == 0){
		int num = atoi(str); //Aprendi a função atoi em programação competitiva, por ser stdlib assumi que posso usar
		printf("%d\n",somaDigitos(num));
		scanf("%s",str);
	}
}
