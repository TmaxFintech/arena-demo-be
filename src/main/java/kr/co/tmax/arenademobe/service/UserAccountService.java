package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.UserAccount;

public interface UserAccountService {

    public UserAccount getUserByEmail(String email) throws Exception;

    public UserAccount getUserByUsername(String username) throws Exception;

    public void saveUser(UserAccount userAccount);
}
