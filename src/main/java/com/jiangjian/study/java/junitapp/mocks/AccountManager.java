package com.jiangjian.study.java.junitapp.mocks;

public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);

}
