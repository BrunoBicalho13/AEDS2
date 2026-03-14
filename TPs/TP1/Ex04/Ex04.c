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

void inverteString(char str[])
{
	int tamanho = tamanhoString(str);
	for(int i = tamanho; i >= 0; i--){
		printf("%c",str[i]);
	}

	printf("\n");
	

}


int main(){
	char *string = (char*)malloc(2000 * sizeof(char));
	scanf("%[^\n]",string);getchar();

	while(comparaString(string,"FIM") == 0){
		inverteString(string);
		scanf("%[^\n]",string);getchar();
	}
}	
	

