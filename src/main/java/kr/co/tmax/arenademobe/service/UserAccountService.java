package kr.co.tmax.arenademobe.service;

import kr.co.tmax.arenademobe.domain.UserAccount;

public interface UserAccountService {

    public UserAccount getUserByEmail(String email);

    public UserAccount getUserByUsername(String username);

    public void saveUser(UserAccount userAccount);
}
