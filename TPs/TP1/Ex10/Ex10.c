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


int vogais(char str[], int i) {
    if (str[i] == '\0') return 1; //caso base de fim da string
                      
    char c = str[i];

    if (!(c=='A'||c=='E'||c=='I'||c=='O'||c=='U'||
          c=='a'||c=='e'||c=='i'||c=='o'||c=='u')) {
        return 0; //verifica se é vogal
    }

    return vogais(str, i + 1); //chama a função para o proximo indice
}


int consoantes(char str[], int i) {
    if (str[i] == '\0') return 1; //caso base de fim de string

    char c = str[i];

    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {

        if (c=='A'||c=='E'||c=='I'||c=='O'||c=='U'||
            c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
            return 0; // verifica se é consoante
        }

    } else {
        return 0;
    }

    return consoantes(str, i + 1); // chama a função para o proximo indice
}

int inteiro(char str[], int i) {
    if (str[i] == '\0') return 1; // fim da string

    if (!(str[i] >= '0' && str[i] <= '9')) {
        return 0; // verifica se é um numero de 0 a 9
    }

    return inteiro(str, i + 1); // chama pra o prox indice
}


int real(char str[], int i, int separador) {
    if (str[i] == '\0') return 1;

    char c = str[i];

    if (c >= '0' && c <= '9') {
    } // verifica se são numeros de 1 a 9 antes de verificar os separadores
    else if (c == '.' || c == ',') {
        separador++;
        if (separador > 1) return 0; // conta se existem separadores
    }
    else {
        return 0;
    }

    return real(str, i + 1, separador);// chama para o prox indice
}

int main(){
	char *string = (char*)malloc(2000 * sizeof(char));

	
	scanf("%[^\n]",string);getchar();

	while(comparaString(string,"FIM") == 0){
		if(vogais(string,0) == 1){ // se for 1 conta apenas o caso base, somente vogais. Mesma coisa para as outras funções
			printf("SIM ");
		}else{
			printf("NAO ");
		}

		if (consoantes(string, 0) == 1){
           		 printf("SIM ");
		}else{
           		 printf("NAO ");
		}
       
	       	if (inteiro(string, 0) == 1){
           		 printf("SIM ");
       		} else{
           		 printf("NAO ");

		}
        
		if (real(string, 0, 0) == 1){
            		printf("SIM\n");
        	}else{
            		printf("NAO\n");
		}	

		
		scanf("%[^\n]",string);getchar();
	}

}
