package com.example.chenjh.mycontacts;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FindDialog extends Dialog {

    public FindDialog(Context context) {
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find);
        setTitle("联系人查询");
        Button find= (Button) findViewById(R.id.find);
        Button cancel= (Button) findViewById(R.id.cancel);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText value= (EditText) findViewById(R.id.value);
                ContactsTable ct=new ContactsTable(v.getContext());
                User[] users=ct.findUserByKey(value.getText().toString());
                for(int i=0;i<users.length;i++){
                    System.out.println("姓名是"+users[i].getName()+",电话是"+users[i].getMobile());
                }
                dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
