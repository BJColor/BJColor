package com.haier.jiuzhidao.myapplication.selector;

import java.io.Serializable;

public class IconBean implements Serializable {
    private String iconName;
    private String drawbleDown;
    private String drawbleUp;
    private int type;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getDrawbleDown() {
        return drawbleDown;
    }

    public void setDrawbleDown(String drawbleDown) {
        this.drawbleDown = drawbleDown;
    }

    public String getDrawbleUp() {
        return drawbleUp;
    }

    public void setDrawbleUp(String drawbleUp) {
        this.drawbleUp = drawbleUp;
    }
}
