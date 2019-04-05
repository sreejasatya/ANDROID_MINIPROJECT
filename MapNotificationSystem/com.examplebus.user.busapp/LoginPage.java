package com.examplebus.user.busapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;


public class LoginPage extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,View.OnClickListener{

  SignInButton signInButton;
  Button signoutButton;
  TextView statusTextView;
  GoogleApiClient mGoogleApiClient;
  private static final String TAG="SIGN IN ACTIVITY";
  private static final int RC_SIGN_IN=9001;

  
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        statusTextView= findViewById(R.id.status_textview);
        signInButton= findViewById(R.id.gsignbutton);
        signInButton.setOnClickListener(this);
        signoutButton= findViewById(R.id.gsignoutbutton);
        signoutButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.gsignbutton:
                signIn();
                break;
            case R.id.gsignoutbutton:
                signOut();
                break;
        }

      //  Intent signinIntent=Auth.GOOGLE_SIGN_IN_API.getsigninIntent(mGoogleApiClient);

    }

    private void signIn()
    {
        Intent signinIntent=Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signinIntent,RC_SIGN_IN);

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN)
        {
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

        }

        @SuppressLint("SetTextI18n")
        private void handleSignInResult(GoogleSignInResult result)
        {
            Log.d(TAG,"handle sign in result:" +result.isSuccess());
            if(result.isSuccess())
            {

                GoogleSignInAccount acct=result.getSignInAccount();
                assert acct != null;
                statusTextView.setText("HELLO "+acct.getDisplayName());
                Intent clickact=new Intent(LoginPage.this,Details.class);
                startActivity(clickact);

            }

        }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Log.d(TAG,"ON CONNECTION FAILED"+connectionResult);

    }

    private void signOut()
    {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResult(@NonNull Status status) {
                statusTextView.setText("SIGNED OUT");
            }
        });
    }

}

