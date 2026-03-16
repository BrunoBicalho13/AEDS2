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


void Cifra(char* entrada, char* saida){ // ponteiro para a string de entrada e para a de saida
	if (*entrada  == '\0'){ // condição de parada - fim da string principal
		*saida = '\0'; // fim da string cifrada
		return;
	}
		
	*saida = *entrada + 3; // faz a cifragem e atribui na segunda string

	Cifra(entrada + 1, saida + 1); // chamada recursiva
}

int main(){
	char *string1 = (char*)malloc(2000 * sizeof(char));
	char *string2 = (char*)malloc(2000 * sizeof(char));
	
	scanf("%[^\n]",string1);getchar();

	while(comparaString(string1,"FIM") == 0){
		Cifra(string1, string2);
		printf("%s\n",string2);
		scanf("%[^\n]",string1);getchar();
	}
}
