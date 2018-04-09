package com.jiangjian.study.java.test.junitapp.mocks;

public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);

}
