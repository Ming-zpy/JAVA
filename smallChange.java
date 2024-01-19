package smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class smallChange {
    //1.完成显示菜单，并可以选择菜单，给出对应提示信息
    //2.完成零钱通明细
    //3.完成收益入账
    //4.完成消费
    //5.退出
    public static void main(String[] args) {
        //定义相关变量
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        String key="";
        //2.完成零钱通明细
        //（1）使用数组 （2）使用对象 （3）使用string拼接
        String details="-------零钱通明细-------";
        //3.完成收益入账
        //定义新的变量
        double money=0;
        double balance=0;
        Date date=null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化
        //4.完成消费
        String note="";
        //5.退出
        String exit="";
        do {
            System.out.println("\n======零钱通菜单======");
            System.out.println("\t1.零钱通明细");
            System.out.println("\t2.收益入账");
            System.out.println("\t3.消费情况");
            System.out.println("\tt4.退    出");
            System.out.println("请选择1-4:");
            key=scanner.next();

            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额：");
                    money=scanner.nextDouble();
                    //money的范围需要校验
                    balance+=money;
                    //拼接收益入账信息到details
                    date=new Date();//获取当前日期
                    details+="\n收益入账\t+"+ money +"\t"+sdf.format(date)+"\t"+balance;
                    break;
                case "3":
                    System.out.println("消费金额：");
                    money=scanner.nextDouble();
                    //会有一个范围校验
                    if(money>balance){
                        System.out.println("剩余金额不够，消费失败");
                        break;
                    }
                    System.out.println("请输入消费说明：");
                    note=scanner.next();
                    balance-=money;
                    //拼接消费信息
                    date=new Date();//获取当前日期
                    details+="\n"+note+"\t-"+ money +"\t"+sdf.format(date)+"\t"+balance;
                    break;
                case "4":
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
                        break;
                    }
                   else if(exit.equals("n")){
                       break;
                   }
                default:
                    System.out.println("选择有误");
            }


        }while (loop);
        System.out.println("退出了零钱通系统");
    }
}
