package com.example.obserandservice;

import android.widget.EditText;

public class EditTextUtils {

    public void isEdit(EditText... editTexts) {

        for (EditText et : editTexts) {
            String trim = et.getEditableText().toString().trim();
            if (trim.equals("")) {
                et.setText("0");
            }
        }
    }
}
