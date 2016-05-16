package com.jiangjian.study.java.platformenv.commandline;

/**
 * Created by Administrator on 2016/5/15.
 */
public class CommandArguments {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("should supply arguments from command");
            System.exit(1);
        }
    }
}
