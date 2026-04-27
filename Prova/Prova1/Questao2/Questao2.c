#include<stdio.h>
#include<stdlib.h>

void decodifica(char* string){
	if(*string == '@'){
		*string = 'a';
	}else if(*string == '&'){
		*string = 'e';
	}else if(*string == '!'){
		*string = 'i';
	}else if(*string == '*'){
		*string = 'o';
	}else if(*string == '#'){
		*string = 'u';
	}
}

int main(){
	char string [3000];
	char* str = string;
	/*while(fgets(string,3000,stdin) != NULL){
		decodifica(str);
		printf("%c",*str);
		str++;
	}*/

	fgets(string,3000,stdin);
	int i = 0;
	while(string[i] != 'E' && string[i +1] != 'O' && string[i +2] != 'F' && string[i + 3] != '\0'){
		decodifica(string[i]);
		i++;

	}
	
	printf("%s",string);

}
