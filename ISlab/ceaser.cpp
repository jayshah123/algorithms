#include<iostream>
#include<string>

char decrypt(char x,int shift)
{
     char d;
     if(x>='A'&&x<='Z')
     d='A';
     else 
     d='a';
    return d+(x-d-shift+26)%26;
}

using namespace std;
int main()
{
    char ciph[]="abcd";
    int shift;
    char pt[20];
    char cipher[30];
   int i;
   char d;
    cout<<"enter plaintext"<<endl;
    cin>>pt;
    cout<<"enter shift"<<endl;
    cin>>shift;
       
    for(i=0;pt[i]!='\0';i++){
            if(pt[i]>='A'&&pt[i]<='Z')
            d='A';
            else 
            d='a';
            ciph[i]=d+(pt[i]-d+shift)%26;
}    ciph[i]='\0';
    cout<<ciph<<endl;
    
    //decryption
    
    memset(pt,0,20);
    cout<<"enter cipher text"<<endl;
    fflush(stdin);
    //getline(cin,ciph2);
    scanf("%[^\n]s",cipher);           //to scan strings with spaces
    fflush(stdin);
    //strcpy(cipher,ciph2.c_str());
    for(i=1;i<26;i++){
    for(int j=0;j<strlen(cipher);j++){
                      if(cipher[j]==' ')
                       continue;                      
                      cout<<decrypt(cipher[j],i);
    }
    cout<<endl;
}
    system("pause");
    return 0;
}
