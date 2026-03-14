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

int Anagrama(char string1[], char string2[]){
	
	int aux = 1;
	int tamanho1 = tamanhoString(string1);
	int tamanho2 = tamanhoString(string2);
	int soma1 = 0,soma2 = 0;
	
	if(tamanho1 == tamanho2){
		for(int i = 0; i < tamanho1; i++){
			soma1 += string1[i];
			soma2 += string2[i];
		}

		if(soma1 != soma2){
			aux = 0;
		}
	}else{
		aux = 0;
	} 
	
	return aux;
}



int main()
{
    char str1[2000];
    char str2[2000];
    char lixo;

    scanf("%s", str1);

    while (comparaString(str1, "FIM") == 0)
    {
        scanf(" %c ", &lixo);  // lê o '-'
        scanf("%s", str2);

        int anagrama = Anagrama(str1, str2);

        if (anagrama == 1)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }

        scanf("%s", str1);
    }
}
