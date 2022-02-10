package com.example.demo.entity;

public class LoginResult extends Result<User> {
    boolean isLogin;

    protected LoginResult(Result.ResultEnum status, String msg, User data, boolean isLogin) {
        super(status, msg, data);
        this.isLogin = isLogin;
    }

    public static LoginResult success(String msg, boolean isLogin) {
        return new LoginResult(Result.ResultEnum.SUCCESSFUL, msg, null, isLogin);
    }

    public static LoginResult success(boolean isLogin) {
        return new LoginResult(Result.ResultEnum.SUCCESSFUL, null, null, isLogin);
    }

    public static LoginResult success(String msg) {
        return new LoginResult(Result.ResultEnum.SUCCESSFUL, msg, null, true);
    }

    public static LoginResult success(String msg, User user) {
        return new LoginResult(Result.ResultEnum.SUCCESSFUL, msg, user, true);
    }

    public static LoginResult failure(String msg) {
        return new LoginResult(ResultEnum.FAILURE, msg, null, false);
    }

    public boolean getIsLogin() {
        return isLogin;
    }
}
