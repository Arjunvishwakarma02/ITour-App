package app.arjun.itour;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {
    TextView txtSignIn;

    TextInputLayout inpFullname, inpEmail, inpPhone, inpUser, inpPass, inpRePass;
    Button btnSignUp, btnReset;

    SharedPreferences preferences;
    private static final String KEY_NAME ="name";
    private static final String KEY_EMAIL ="email";
    private static final String KEY_PHONE ="phone";
    private static final String KEY_USER ="user";
    private static final String KEY_PASS ="pass";
    private static final String KEY_REPASS ="repass";

    private static final String KEY_TOTAL_PRICE ="total_price";
    private static final String KEY_NAME_TOUR ="name_tour";
    private static final String KEY_COUNT_ITEMS ="count_items";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inpFullname = findViewById(R.id.name);
        inpEmail = findViewById(R.id.email);
        inpPhone = findViewById(R.id.phone);
        inpUser = findViewById(R.id.username_regis);
        inpPass = findViewById(R.id.password_regis);
        inpRePass = findViewById(R.id.retype_password);
        btnSignUp = findViewById(R.id.btn_signUp);
        txtSignIn = findViewById(R.id.btn_signIn);
        btnReset = findViewById(R.id.btn_reset);

        preferences =getSharedPreferences("userInfo",0);

        inpRePass.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent keyEvent) {
                String nameVlaue = inpFullname.getEditText().getText().toString();
                String emailValue = inpEmail.getEditText().getText().toString();
                String phoneValue = inpPhone.getEditText().getText().toString();
                String userValue = inpUser.getEditText().getText().toString();
                String passValue = inpPass.getEditText().getText().toString();
                String repassValue = inpRePass.getEditText().getText().toString();

                if (passValue.equals(repassValue)){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(KEY_NAME,nameVlaue);
                    editor.putString(KEY_EMAIL,emailValue);
                    editor.putString(KEY_PHONE,passValue);
                    editor.putString(KEY_USER,userValue);
                    editor.putString(KEY_PASS,passValue);
                    editor.putString(KEY_REPASS,repassValue);
                    editor.apply();

                    try {
                        if (nameVlaue.equals("")||
                            emailValue.equals("")||
                            phoneValue.equals("")||
                            userValue.equals("")||
                            passValue.equals("") ||
                            repassValue.equals("")){
                            Toast.makeText(SignUp.this,"Data cannot be empty \n Data can be Exhaustedx`",Toast.LENGTH_SHORT).show();
                        }else{
                            String name = preferences.getString(KEY_NAME,null);
                            if(name!=null){
                                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER)){
                                    Toast.makeText(SignUp.this,"Successful Register",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(SignUp.this,LoginPage.class);
                                    startActivity(intent);
                                    resetDetailsTour();
                                    finish();
                                }
                            }

                        }
                    }catch(Exception e) {
                        Toast.makeText(SignUp.this,"Username as been used",Toast.LENGTH_SHORT).show();
                    }
                    }else {
                Toast.makeText(SignUp.this,"password doesn't match",Toast.LENGTH_SHORT).show();

                }
                return false;

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameVlaue = inpFullname.getEditText().getText().toString();
                String emailValue = inpEmail.getEditText().getText().toString();
                String phoneValue = inpPhone.getEditText().getText().toString();
                String userValue = inpUser.getEditText().getText().toString();
                String passValue = inpPass.getEditText().getText().toString();
                String repassValue = inpRePass.getEditText().getText().toString();

                if (passValue.equals(repassValue)){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(KEY_NAME,nameVlaue);
                    editor.putString(KEY_EMAIL,emailValue);
                    editor.putString(KEY_PHONE,passValue);
                    editor.putString(KEY_USER,userValue);
                    editor.putString(KEY_PASS,passValue);
                    editor.putString(KEY_REPASS,repassValue);
                    editor.apply();
                    try {
                        if (nameVlaue.equals("")||
                                emailValue.equals("")||
                                phoneValue.equals("")||
                                userValue.equals("")||
                                passValue.equals("") ||
                                repassValue.equals("")){
                            Toast.makeText(SignUp.this,"Data cannot be empty \n Data can be Exhausted",Toast.LENGTH_SHORT).show();
                        }else{
                            String name = preferences.getString(KEY_NAME,null);
                            if(name!=null){
                                    Toast.makeText(SignUp.this,"Successful Register",Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(SignUp.this,LoginPage.class);
                                    startActivity(intent);
                                    resetDetailsTour();
                                    finish();
                                }
                            }
                    }catch(Exception e) {
                        Toast.makeText(SignUp.this,"Username as been used",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(SignUp.this,"password doesn't match",Toast.LENGTH_SHORT).show();

                }

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, LoginPage.class);
                startActivity(intent);
            }

        });
    }
    private void reset() {
        inpFullname.getEditText().setText(null);
        inpEmail.getEditText().setText(null);
        inpPhone.getEditText().setText(null);
        inpUser.getEditText().setText(null);
        inpPass.getEditText().setText(null);
        inpRePass.getEditText().setText(null);
    }
    private void resetDetailsTour(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_NAME_TOUR,null);
        editor.putString(KEY_COUNT_ITEMS,null);
        editor.putString(KEY_TOTAL_PRICE,null);
        editor.apply();
    }
}
