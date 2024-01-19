package smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallchangeclass {
    private   double money;
    private double balance;
    public boolean loop=true;
    private String note;
    public Date date;
    private String exit;
    private String details;

    public smallchangeclass(double money, double balance, boolean loop, String note, Date date, String exit,String details) {
        this.money = money;
        this.balance = balance;
        this.loop = loop;
        this.note = note;
        this.date = date;
        this.exit = exit;
        this.details=details;
    }
    public smallchangeclass(){}

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }
    public void f1(){
        System.out.println(details);
    }
    public void f2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("收益入账金额：");
        money=scanner.nextDouble();
        //money的范围需要校验
        balance+=money;
        //拼接收益入账信息到details
        date=new Date();//获取当前日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化
        details+="\n收益入账\t+"+ money +"\t"+sdf.format(date)+"\t"+balance;
    }
    public void f3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("消费金额：");
        money=scanner.nextDouble();
        //会有一个范围校验
        if(money>balance){
            System.out.println("剩余金额不够，消费失败");
            return;
        }
        System.out.println("请输入消费说明：");
        note=scanner.next();
        balance-=money;
        //拼接消费信息
        date=new Date();//获取当前日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化
        details+="\n"+note+"\t-"+ money +"\t"+sdf.format(date)+"\t"+balance;
    }
    public void f4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("你确定要退出吗？y/n");
        while (true){
            exit=scanner.next();
            System.out.println("请输入正确的内容：");
            if (exit.equals("y") || exit.equals("n")){
                break;
            }
        }
        if(exit.equals("y")){
            loop=false;
            return;
        }
        else if(exit.equals("n")){
            return;
        }
    }
    public  void  menue(){
        do {
            System.out.println("\n======零钱通菜单======");
            System.out.println("\t1.零钱通明细");
            System.out.println("\t2.收益入账");
            System.out.println("\t3.消费情况");
            System.out.println("\t4.退    出");
            System.out.println("请选择1-4:");
            Scanner scanner = new Scanner(System.in);
            String key="";
            key=scanner.next();

            switch (key){
                case "1":
                    f1();
                    break;
                case "2":
                    f2();
                    break;
                case "3":
                   f3();
                    break;
                case "4":
                   f4();
                    break;
                default:
                    System.out.println("选择有误");
            }


        }while (loop);
        System.out.println("退出了零钱通系统");
    }

}
