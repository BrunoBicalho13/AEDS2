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

int VerificaSubstring ( char string[]){
    int tamMax = 0;
    int n = tamanhoString(string);

    for (int i = 0; i < n; i++) {
        int ascii[256] = {0}; 
        int cont = 0;

        for (int j = i; j < n; j++) {
            int valor = (int)string[j];

            if (ascii[valor] == 0) {
                ascii[valor] = 1;
                cont++;
                if (cont > tamMax) {
                    tamMax = cont;
                }
            } else {
                // Se o caractere já foi visto, essa substring acabou
                break;
            }
        }
    }
    return tamMax;
}
 int main(){
	char string[2000];
	scanf(" %[^\n]", string);
	while(comparaString(string,"FIM") == 0){
		int resultado = VerificaSubstring(string);
		printf("%d\n", resultado);
		scanf(" %[^\n]", string);
	}
	return 0;
 }	
