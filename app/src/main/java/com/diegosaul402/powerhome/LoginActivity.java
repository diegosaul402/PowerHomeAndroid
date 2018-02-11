package com.diegosaul402.powerhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.diegosaul402.powerhome.apiCalls.LoginCaller;
import com.diegosaul402.powerhome.models.Data;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginCaller.LoginResponse{

    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);//bind the view with ButterKnife
    }

    @OnClick(R.id.btn_login)
    public void loginClick(){
        LoginCaller caller = new LoginCaller(this);
        editEmail.setText("gerardolodu@gmail.com");
        editPassword.setText("12345678");
        caller.callLogin(editEmail.getText().toString(), editPassword.getText().toString());
    }

    @Override
    public void successLogin(Data response, String accessToken, String client) {
        Toast.makeText(this, "Success Login: " + response.getUid() + response.getEmail(), Toast.LENGTH_LONG).show();
        Log.v("RESPONSE: ", accessToken + ": " + client);

    }

    @Override
    public void errorLogin(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void inProgress(boolean isInProgress) {

    }
}
