#include<stdio.h>
#include<stdlib.h>
#include<locale.h>

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
	for(int i = tamanho - 1; i >= 0; i--){
		if(str[i] == '~' || str[i] == 'ç' || str[i] == '`' || str[i] == '^'){
			printf("%c %c",str[i + 1],str[i]);
		}
		
		printf("%c",str[i]);
	}

	printf("\n");
	
	
}


int main(){
	setlocale(LC_ALL,"");
	char *string1 = (char*)malloc(2000 * sizeof(char));


	scanf("%[^\n]",string1);getchar();

	while(comparaString(string1,"FIM") == 0){
		inverteString(string1);
		scanf("%[^\n]",string1);getchar();
	}
}	
	

