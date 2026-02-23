#include <stdio.h>

int tamanhoString(char string[])
{
    int i = 0;
    while (string[i] != '\0')
    {
        i++;
    }
    return i;
}

void combinador(char *string1, char *string2, char string3[])
{
    int i = 0;

    while (*string1 != '\0' || *string2 != '\0')
    {
        if (*string1 != '\0')
        {
            string3[i++] = *string1++;
        }

        if (*string2 != '\0')
        {
            string3[i++] = *string2++;
        }
    }

    string3[i] = '\0';
}
int main()
{
    char String1[100];
    char String2[100];
    char String3[201];

    //int tamanho1, tamanho2;

    scanf("%[^\n]", String1);
    getchar();
    scanf("%[^\n]", String2);
    getchar();

    //tamanho1 = tamanhoString(String1);
    //tamanho2 = tamanhoString(String2);

    combinador(String1, String2, String3);

    // printf("%s",String1);
    // printf("%s",String2);
    printf("%s\n", String3);
}