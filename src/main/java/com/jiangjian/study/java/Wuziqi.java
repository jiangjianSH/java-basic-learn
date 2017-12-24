package com.jiangjian.study.java;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Wuziqi extends JFrame implements Runnable,MouseListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //游戏界面大小
    int width=Toolkit.getDefaultToolkit().getScreenSize().width;
    int height=Toolkit.getDefaultToolkit().getScreenSize().height;

    int x,y;  //鼠标坐标
    int[][]allChess=new int[15][15];  //保存棋盘,0表示无子,1表示黑子,2表示白字
    Boolean isblack=true; //当前下子是黑子还是白字，true代表黑子，false代表白子
    Boolean canPlay=true;  //标始当前游戏是否结束
    String message="黑方先行";
    String blackMessage="无限制";
    String whiteMessage="无限制";

    //保存棋谱,记录双方每一步落子的位置
    int[]chessX=new int[255];
    int[]chessY=new int[255];
    int countX,countY;

    //默认设置无时间限制
    int maxTime=0; //保存最大时间
    int blackTime=0;
    int whiteTime=0; //保存黑白方所剩余的时间

    Thread timer=new Thread(this);

    public Wuziqi(){
        this.setTitle("五子棋游戏");
        this.setSize(500, 500);
        this.setLocation((width - 500) / 2, (height - 500) / 2);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.repaint();
        this.addMouseListener(this);

        timer.start();  //开启计时线程
        timer.suspend();
    }

    //画棋盘界面
    public void paint(Graphics g){
        //双缓冲技术
        BufferedImage buf=new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
        Graphics g1=buf.createGraphics();  //创建画笔
        g1.setColor(new Color(0,169,158));  //设置画笔颜色
        g1.fill3DRect(43,60,375,375,true);

        for(int i=0;i<=15;i++){
            g1.setColor(Color.WHITE);
            g1.drawLine(43,60+i*25,375+43,60+i*25);//画棋盘横线
            g1.drawLine(43+i*25,60,43+i*25,375+60); //画棋盘竖线
        }

        g1.setFont(new Font("黑体",Font.BOLD,20));
        g1.drawString("游戏信息: "+message,50,50);

        g1.drawRect(30,440,180,40);
        g1.drawRect(250,440,180,40);  //画黑方时间与白方时间字符串的边框
        g1.setFont(new Font("宋体",0,12));

        g1.drawString("黑方时间: "+blackMessage,40,465);
        g1.drawString("白方时间: "+whiteMessage,260,465);

        g1.drawRect(428,66,54,20);
        g1.drawString("重新开始",432,80); //重新开始按钮

        g1.drawRect(428,106,54,20);
        g1.drawString("游戏设置",432,120); //游戏设置按钮

        g1.drawRect(428, 146, 54, 20);
        g1.drawString("游戏说明", 432, 160); // 游戏说明按钮

        g1.drawRect(428, 186, 54, 20);
        g1.drawString("退出游戏", 432, 200);  // 退出游戏按钮

        g1.drawRect(428, 246, 54, 20);
        g1.drawString("悔棋", 442, 260);  // 悔棋

        g1.drawRect(428, 286, 54, 20);
        g1.drawString("认输", 442, 300);  // 认输

        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                //画实心黑子
                if(allChess[i][j]==1){
                    int tempX=i*25+47;
                    int tempY=j*25+64;
                    g1.setColor(Color.BLACK);
                    g1.fillOval(tempX,tempY,16,16);
                    g1.setColor(Color.BLACK);
                    g1.drawOval(tempX,tempY,16,16);
                }

                //画实心白子
                if(allChess[i][j]==2){
                    int tempX=i*25+47;
                    int tempY=j*25+64;
                    g1.setColor(Color.WHITE);
                    g1.fillOval(tempX, tempY, 16, 16);
                    g1.setColor(Color.BLACK);
                    g1.drawOval(tempX, tempY, 16, 16);
                }
            }
        }
        g.drawImage(buf, 0, 0,this);
    }


    @Override
    public void mousePressed(MouseEvent e){
        if(canPlay){
            x=e.getX();
            y=e.getY(); //获得鼠标坐标

            if(x>=55 && x<=405 && y>=72 && y<=420){
                //使x,y在0-15的范围
                if((x-55)%25>12){
                    x=(x-55)/25+1;
                }
                else{
                    x=(x-55)/25;
                }
                if((y-72)%25>12){
                    y=(y-72)/25+1;
                }
                else{
                    y=(y-72)/25;
                }

                //落子
                if(allChess[x][y]==0){
                    chessX[countX++]=x;
                    chessY[countY++]=y;

                    if(isblack){
                        allChess[x][y]=1;
                        isblack=false;
                        message="白方下子";
                    }
                    else{
                        allChess[x][y]=2;
                        isblack=true;
                        message="黑方下子";
                    }
                    this.repaint();

                    if(this.isWin()){
                        if(allChess[x][y]==1){
                            JOptionPane.showMessageDialog(this, "游戏结束，黑方胜利");
                        }else{
                            JOptionPane.showMessageDialog(this, "游戏结束，白方胜利");
                        }
                        this.canPlay=false; //标识游戏结束
                    }
                }
            }
        }

        //重新开始游戏
        if(e.getX()>=428 && e.getY()<=(428+54) && e.getY()>=66 && e.getY()<=(66+20)){
            int result=JOptionPane.showConfirmDialog(this,"是否重新开始游戏？"); //0表示重新开始
            if(result==0){
                restartGame();
            }
        }

        //游戏倒计时设置
        if (e.getX()>=428 && e.getX()<=(428+54) && e.getY()>= 106 && e.getY()<=(106+20)) {
            String time=JOptionPane.showInputDialog("请输入游戏的最大时间(单位:分钟),如果输入0,表示没有时间限制:");
            maxTime=Integer.parseInt(time)*60;  //将分钟转换为秒，以便后面计算
            if(maxTime<0){
                JOptionPane.showMessageDialog(this,"输入的游戏时间有误,请重新设置!");
            }
            else if(maxTime==0){
                int result=JOptionPane.showConfirmDialog(this,"游戏时间设置成功,是否重新开始游戏?");
                //重新开始
                if(result==0){
                    restartGame();
                    timer.suspend(); //挂起线程,以便之后重新启动
                }
            }
            else if(maxTime>0){
                int result = JOptionPane.showConfirmDialog(this,"游戏时间设置成功,是否重新开始游戏?");
                if(result==0){
                    for(int i=0;i<15;i++){
                        for(int j=0;j<15;j++){
                            allChess[i][j]=0;
                        }
                    }
                    for(int i=0;i<15;i++){
                        chessX[i]=-1;
                        chessY[i]=-1;
                    }
                    countX=0;
                    countY=0;
                    message="黑方先行";
                    isblack=true;

                    blackMessage=maxTime/3600+":"+(maxTime/60-maxTime/3600*60)+":"+(maxTime-maxTime/60*60);
                    whiteMessage = maxTime/3600 + ":" + (maxTime/60-maxTime/3600*60) + ":"+ (maxTime-maxTime/60*60);

                    blackTime=maxTime;
                    whiteTime=maxTime;
                    timer.resume();
                    this.canPlay=true;
                    this.repaint();
                }
            }

        }


        //游戏说明
        if(e.getX()>=428 && e.getY()<=(428+54) && e.getY()>=146 && e.getY()<=(146+20)){
            JOptionPane.showMessageDialog(this,"规则:横竖斜先连成五子者获胜!");
        }

        //退出游戏
        if(e.getX()>=428 && e.getX()<=(428+54) && e.getY()>=186 && e.getY()<=(186+20)) {
            int result=JOptionPane.showConfirmDialog(this,"是否退出游戏?");
            if(result==0){
                System.exit(0);
            }
        }

        //悔棋
        if(e.getX()>=428 && e.getX()<=(428+54) && e.getY()>=246 && e.getY()<=(246+20)){
            int result=JOptionPane.showConfirmDialog(this,(isblack==true?"白方悔棋，黑方是否同意？" : "黑方悔棋，白方是否同意？"));
            //result=0为悔棋
            if(result==0){
                allChess[chessX[--countX]][chessY[--countY]]=0;
                if(isblack==true){
                    isblack=false;
                }
                else{
                    isblack=true;
                }

                this.repaint(); //重绘棋盘
            }
        }

        //认输
        if(e.getX()>=428 && e.getX()<=(428+54) && e.getY()>=286 && e.getY()<=(286+20)){
            int result=JOptionPane.showConfirmDialog(this, "是否认输?");
            if(result==0){
                JOptionPane.showMessageDialog(this,"游戏结束,"+(isblack==true ? "黑方认输，白方获胜!" : "白方认输，黑方获胜!"));
            }
        }

    }

    //计时
    @Override
    public void run() {
        if(this.maxTime>0){
            while(true){
                if(isblack){
                    blackTime--;
                    if(blackTime==0){
                        JOptionPane.showMessageDialog(this,"黑方超时,游戏结束");
                        restartGame();
                        timer.suspend();
                    }
                }
                else{
                    whiteTime--;
                    if(whiteTime==0){
                        JOptionPane.showMessageDialog(this,"白方超时,游戏结束");
                        restartGame();
                        timer.suspend();
                    }
                }
                blackMessage=blackTime/3600+":"+(blackTime/60-blackTime/3600*60)+":"+(blackTime-blackTime/60*60);
                whiteMessage=whiteTime/3600+":"+(whiteTime/60-whiteTime/3600*60)+":"+(whiteTime-whiteTime/60*60);
                this.repaint();
                try {
                    Thread.sleep(1000);  //设置与时钟同步,1秒钟记一次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void restartGame(){
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                allChess[i][j]=0;  //清空棋盘的棋子
            }
        }
        //清空下棋棋子坐标(x,y)的记录
        for(int i=0;i<15;i++){
            chessX[i]=0;
            chessY[i]=0;
        }

        countX=0;
        countY=0;
        message="黑方先行";
        blackMessage="无限制";
        whiteMessage="无限制";
        blackTime=maxTime;
        whiteTime=maxTime;
        isblack=true;
        canPlay=true;
        this.repaint();
    }

    public boolean isWin(){
        boolean flag=false;  //定义一标志位
        int count=1;  //保存共有相同颜色多少棋子相连,初始值为1
        int color=allChess[x][y]; //color=1(黑子).color=2(白子)

        //判断横向是否有5个棋子相连，特点:纵坐标是相同,即allChess[x][y]中y值是相同
        count=this.checkCount(1,0,color);
        if(count>=5){
            flag=true;
        }
        else{
            //判断纵向
            count=this.checkCount(0, 1, color);
            if(count>=5){
                flag=true;
            }
            else{
                //判断右上,左下
                count=this.checkCount(1,-1, color);
                if(count>=5){
                    flag=true;
                }
                else{
                    //判断右下,左上
                    count=this.checkCount(1,1,color);
                    if(count>=5){
                        flag=true;
                    }
                }
            }
        }
        return flag;

    }

    public int checkCount(int xChange,int yChange,int color){
        int count=1;
        int tempX=xChange;
        int tempY=yChange; //保存初始值

        //全局变量x,y最初为鼠标点击的坐标，经下棋方法已经将x,y的范围变成0-15(遍历整个棋盘,寻找相同颜色的棋子)
        while(x+xChange>=0 && x+xChange<15 && y+yChange>=0 && y+yChange<15 && color==allChess[x+xChange][y+yChange]){
            count++;
            if(xChange!=0) xChange++;
            if(yChange!=0){
                if(yChange!=0){
                    if(yChange>0) yChange++;
                    else {
                        yChange--;
                    }
                }
            }
        }
        xChange=tempX;
        yChange=tempY;
        while(x-xChange>=0 && x-xChange<15 && y-yChange>=0 && y-yChange<15 && color==allChess[x-xChange][y-yChange]){
            count++;
            if(xChange!=0){
                xChange++;
            }
            if(yChange!=0){
                if(yChange>0) yChange++;
                else{
                    yChange--;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        new Wuziqi();
    }

}