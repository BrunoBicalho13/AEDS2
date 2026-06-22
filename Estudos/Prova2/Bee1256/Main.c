#include <stdio.h>
#include <stdlib.h>

// Estrutura para o nó da lista encadeada
typedef struct Node {
    int val;
    struct Node* next;
} Node;

int main() {
    int n;
    if (scanf("%d", &n) != 1) return 0;
    
    for (int t = 0; t < n; t++) {
        int m, c;
        scanf("%d %d", &m, &c);
        
        // Array de ponteiros para os cabeçalhos das listas e para as caudas
        // 'tails' ajuda a inserir no final da lista em complexidade O(1)
        Node** table = (Node**)calloc(m, sizeof(Node*));
        Node** tails = (Node**)calloc(m, sizeof(Node*));
        
        for (int i = 0; i < c; i++) {
            int val;
            scanf("%d", &val);
            int idx = val % m;
            
            // Cria um novo nó
            Node* newNode = (Node*)malloc(sizeof(Node));
            newNode->val = val;
            newNode->next = NULL;
            
            // Insere na tabela
            if (table[idx] == NULL) {
                table[idx] = newNode;
                tails[idx] = newNode;
            } else {
                tails[idx]->next = newNode;
                tails[idx] = newNode;
            }
        }
        
        // Impressão do resultado
        for (int i = 0; i < m; i++) {
            printf("%d -> ", i);
            Node* curr = table[i];
            while (curr != NULL) {
                printf("%d -> ", curr->val);
                Node* temp = curr;
                curr = curr->next;
                free(temp); // Libera a memória para evitar vazamentos
            }
            printf("\\\n");
        }
        
        free(table);
        free(tails);
        
        // Regra de ouro do Beecrowd: linha em branco apenas ENTRE os casos
        if (t < n - 1) {
            printf("\n");
        }
    }
    return 0;
}
