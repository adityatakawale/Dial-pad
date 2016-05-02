package com.aditya.phone;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
    }

    private void initializeView() {
        screen=(EditText)findViewById(R.id.screen);
        int idlist[] = {R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,
                        R.id.btn8,R.id.btn9,R.id.btndail,R.id.btndel,R.id.btnhash,R.id.btnnull,R.id.btnzero,
                        R.id.btnstar};

        for (int d: idlist){
            View v = (View)findViewById(d);
            if (v != null) {
                v.setOnClickListener(this);
            }
        }

    }
    public void display(String val){
        screen.append(val);
    }

    private boolean checkCallPermission(){
            String permission ="android.permission.CALL_PHONE";
            int res = getApplicationContext().checkCallingOrSelfPermission(permission);
            return (res == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                display("1");
                break;
            case R.id.btn2:
                display("2");
                break;
            case R.id.btn3:
                display("3");
                break;
            case R.id.btn4:
                display("4");
                break;
            case R.id.btn5:
                display("5");
                break;
            case R.id.btn6:
                display("6");
                break;
            case R.id.btn7:
                display("7");
                break;
            case R.id.btn8:
                display("8");
                break;
            case R.id.btn9:
                display("9");
                break;
            case R.id.btnzero:
                display("0");
                break;
            case R.id.btnstar:
                display("*");
                break;
            case R.id.btnhash:
                display("#");
                break;
            case R.id.btndail:
                if(screen.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Enter the number",Toast.LENGTH_SHORT).show();
                else if (checkCallPermission())
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+screen.getText())));
                break;
            case R.id.btndel:
                if(screen.getText().toString().length()>=1){
                    String newScreen = screen.getText().toString().substring(0,screen.getText().toString().length() -1);
                    screen.setText(newScreen);
                }
                break;
            default:
                break;
        }

    }
}
