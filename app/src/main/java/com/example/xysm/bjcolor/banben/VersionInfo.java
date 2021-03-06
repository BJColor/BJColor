package com.example.xysm.bjcolor.banben;

/**
 * <p>function: 版本管理</p>
 * <p>description:  </p>
 * <p>history:  1. 2016/11/22</p>
 * <p>Author: geek</p>
 * <p>modification:</p>
 */
public enum VersionInfo {

    /** 全部版*/
    NATION(0),

    /** 餐厅版*/
    RESTAURANT(1);

    private int version;

    VersionInfo(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }
}
