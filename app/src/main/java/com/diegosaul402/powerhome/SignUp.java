package com.diegosaul402.powerhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp extends AppCompatActivity {
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.edit_confirm_password)
    EditText editConfirmPassword;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);//bind the view with ButterKnife
    }

    @OnClick(R.id.btn_sign_up)
    public void signUpClick(){
        if(verifyFields()){
            //continue with signUp
        }
    }

    private boolean verifyFields() {
        if(editEmail.getText().toString().trim().length() <= 4) {
            editEmail.setError("Check your email");
            return false;
        }
        if(editName.getText().toString().trim().isEmpty()){
            editEmail.setError("Please add yor name");
            return false;
        }
        if(editPassword.getText().toString().trim().length() <= 5){
            editPassword.setError("Your password should have 6 or more characters");
            return false;
        }
        if(editConfirmPassword.getText().toString().trim().length() <= 5){
            editConfirmPassword.setError("Your password should have 6 or more characters");
            return false;
        }
        if (!editPassword.getText().toString().trim().equals(editConfirmPassword.getText().toString().trim())){
            editConfirmPassword.setError("Your password do not match");
            return false;
        }
        return true;
    }


}
