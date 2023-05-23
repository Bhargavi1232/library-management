import java.util.*;

class account{
    String userid;
    String userpin;
    String bank;
    int balance=1000;

    account(String id,String pin){
        userid=id;
        userpin=pin;
    }

    void withdraw(int amount){
       if(amount>balance)
            System.out.println("Insuffient Balance");
        else
            balance=balance-amount;
    }
    void deposit(int amount){
        balance=balance+amount;
    }
    void tranfer(int amount){
        balance=balance-amount;
    }
    void  checkBalance(){
        System.out.println("Your present Balance:"+balance);
    }

}

class ATMinterface
{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
		System.out.println("first initializedetails:");
		System.out.println("how many users:");
		int n=sc.nextInt();
		account ac[]=new account[n];
        for(int i=0;i<n;i++){
            System.out.println("enter userid,userpin"+(i+1));
            String a=sc.next();
            String b=sc.next();
            ac[i]=new account(a,b);
        }
        System.out.println("do u want to perform any action:true/false");
		boolean hm=sc.nextBoolean();
        if(hm){
            System.out.println("do you want to perform credit or debit or tranfer or check balance or exit():");
            System.out.println("=====ENTER CREDENTIALS TO PERFORM ANY ACTIONS=====");
            String id=sc.next();
            String pin=sc.next();
            int c=0;
            int i;
            for(i=0;i<n;i++){
                if((ac[i].userid.compareTo(id)==0) && (ac[i].userpin.compareTo(pin)==0)){
                    c++;
                    break;
                }
            }
			while(c<0){
                System.out.println("===Enter correct credentials===");
            }
            boolean h=true;
            while(h){
            System.out.println("select 1.credit 2.debit 3.tranfer 4.getBalance 5.exit:");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("enter the amount to be credit:");
                    int amount=sc.nextInt();
                    ac[i].deposit(amount);
                    break;
                case 2:
                    System.out.println("enter the amount to withdraw:");
                    amount=sc.nextInt();
                    ac[i].withdraw(amount);
                    break;
                case 3:
                    System.out.println("enter the amount to tranfer:");
                    amount=sc.nextInt();
                    ac[i].tranfer(amount);
                    break;
                case 4:
                    ac[i].checkBalance();
                    break;
                case 5:
                    h=false;
                    break;
            }
            System.out.println("do u want to perform another trasaction:yes/no");
					String prompt=sc.next();
					if(prompt.compareTo("yes")==0){
						h=true;}
					else{
						h=false;
					}
            }

        }
    }
}