import java.util.*;

class book{
    String book_title;
    String book_author;
    String book_isbn;
    String branch_name;
    int copies;
    book(){

    }
    public book(String book_title,String book_author,String book_isbn,String branch_name,int copies){
        this.book_title=book_title;
        this.book_author=book_author;
        this.book_isbn=book_isbn;
        this.branch_name=branch_name;
        this.copies=copies;
    }
    public void display(){
        System.out.println("book_title:-"+book_title+"  book_author:-"+book_author+" book_isbn:-"+book_isbn+" branch_name:-"+branch_name+" no.of copies:-"+copies);
    }
        public void barrow(book[] bk,String title,int nb){
        int q=0;
        for(int i=0;i<nb;i++){
            if(title.equals(bk[i].book_title)){
                bk[i].copies-=1;
                q=1;
                break;
            }
        }
        if(q==0){
            System.out.println("Sorry!! Can't find book...");
        }
    }
    public void returning(book[] bk,String title,int nb){
        for(int i=0;i<nb;i++){
            if(title.equals(bk[i].book_title)){
                bk[i].copies+=1;
                break;
            }
        }
    }
}
class student{
    String username;
    String password;

    public student(String username,String password){
        this.username=username;
        this.password=password;
    }
}

class librarymanagement{
    public static void main(String[] args){
        int i;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no.of students:-");
        int ns=sc.nextInt();
        System.out.println("enter student details:-");
        student[] st=new student[ns];
        for(i=0;i<ns;i++){
            System.out.println("enter user"+i+1+" username and password");
            String name=sc.next();
            String pass=sc.next();
            st[i]=new student(name,pass);
        }
        System.out.println("enter no.of books:-");
        int nb=sc.nextInt();
        book[] bk=new book[nb];
        for(i=0;i<nb;i++){
            System.out.println("enter title,author,isbn,branchname and copies...");
            String title=sc.next();
            String author=sc.next();
            String isbn=sc.next();
            String branchname=sc.next();
            int copies=sc.nextInt();
            bk[i]=new book(title,author,isbn,branchname,copies);
        }
        //String b=sc.next();
        System.out.println("Enter ur credentials:- username,pin");
        String user=sc.next();
        String pin=sc.next();
        int j,f=0;
        boolean ch=false;
        for(j=0;j<ns;j++){
            if(st[j].username.equals(user) && st[j].password.equals(pin)){
                    f=1;
            }
        }
        if(f==1){
            ch=true;
        }
        int count=1;
        book bh=new book();
        do{
            for(i=0;i<nb;i++){
                if(bk[i].branch_name.equals("cse")){
                    System.out.println("BookName:-"+bk[i].book_title+" BookAuthor:-"+bk[i].book_author+" Book_isbn:-"+bk[i].book_isbn+" Copies:-"+bk[i].copies);
                }
            }
            for(i=0;i<nb;i++){
                if(bk[i].branch_name.equals("ece")){
                    System.out.println("BookName:-"+bk[i].book_title+" BookAuthor:-"+bk[i].book_author+" Book_isbn:-"+bk[i].book_isbn+" Copies:-"+bk[i].copies);
                }
            }
            for(i=0;i<nb;i++){
                if(bk[i].branch_name.equals("eee")){
                    System.out.println("BookName:-"+bk[i].book_title+" BookAuthor:-"+bk[i].book_author+" Book_isbn:-"+bk[i].book_isbn+" Copies:-"+bk[i].copies);
                }
            }
            System.out.println("Enter..\n 1.BORROW\n 2.RETURN");
            int sel=sc.nextInt();
            switch(sel){
                case 1:
                    System.out.println("Enter title of the book and copies to barrow:-");
                    String t=sc.next();
                    int cp=sc.nextInt();
                    if(cp>1){
                        System.out.println("You can't take more than 1");
                    }
                    else{
                        bh.barrow(bk,t,nb);
                    }
                    break;
                case 2:
                    System.out.println("Enter title of the book to return:-");
                    String rt=sc.next();
                    bh.returning(bk,rt,nb);
                    break;
            }
            System.out.println("Do you want to barrow again:- yes/no");
            String dec=sc.next();
            if(dec.equals("yes")){
                ch=true;
                count++;
                if(count>3){
                    System.out.println("You can't barrow more than 3");
                    ch=false;
                }
            }
            else{
                ch=false;
            }
        }while(ch);
    }
}