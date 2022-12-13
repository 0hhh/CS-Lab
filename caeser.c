#include<stdio.h>
#include<stdlib.h>
#include<string.h>
char* encrypt(char*,char*);
char* decrypt(char*,char*);
char* toUpperCase(char*);
int main(){
    char* key = (char*)malloc(200*sizeof(char));
    char* input = (char*)malloc(200*sizeof(char));
    printf("Enter key: ");
    scanf("%s",key);
    printf("Enter plaintext: ");
    scanf("%s",input);
    char* encryptS = encrypt(key,input);
    printf("The encrypted text is: %s\n",encryptS);
    char* decryptS = decrypt(key,encryptS);
    printf("The decrypted text is: %s\n",decryptS);
    return 0;
}
char* encrypt(char* key,char* input) {
    int i;
    int inputLength = strlen(input);
    int keyLength = strlen(key);
    char* output = (char*)malloc((inputLength+1)*sizeof(key));
    for(i=0;i<inputLength;i++) {
        output[i]=(input[i]-2*'a'+key[i%keyLength])%26+'a';
    }
    output[i]='\0';
    output = toUpperCase(output);
    return output;
}
char* decrypt(char* key,char* input) {
    int i;
    int inputLength = strlen(input);
    int keyLength = strlen(key);
    char* output = (char*)malloc((inputLength+1)*sizeof(key));
    for(i=0;i<inputLength;i++) {
        output[i]=(input[i]-'A'+'a'-key[i%keyLength]+26)%26+'a';
    }
    output[i]='\0';
    //output = toUpperCase(output);
    return output;
}
char* toUpperCase(char* input){
    int len = strlen(input);
    char* output = (char*)malloc((len+1)*sizeof(char));
    int i;
    for(i=0;i<len;i++){
        char temp = input[i];
        if(temp >= 'a' && temp <= 'z'){
            temp-=32;
        }
        output[i] = temp;
    }
    output[i] = '\0';
    return output;
}