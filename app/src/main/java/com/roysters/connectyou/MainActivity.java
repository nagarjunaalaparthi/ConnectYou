package com.roysters.connectyou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthConfig;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPhoneNumberEditText;
    private ImageView mSelectImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mPhoneNumberEditText = (EditText) findViewById(R.id.phone_number_editText);
        mSelectImageView = (ImageView) findViewById(R.id.select_imageView);
        mSelectImageView.setOnClickListener(this);
     }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_imageView:
                if (mPhoneNumberEditText.getText().toString().length() > 0) {
                    String mUserId = mPhoneNumberEditText.getText().toString();
                    if (mUserId.length() != 10) {
                        mPhoneNumberEditText.setError("enter a valid phone number");
                    } else {
                        DigitsAuthConfig config = new DigitsAuthConfig.Builder().withAuthCallBack(authCallback).withPhoneNumber("+91" + mPhoneNumberEditText.getText().toString()).build();
                        Digits.getSessionManager().clearActiveSession();
                        Digits.authenticate(config);
                    }

                } else {
                    mPhoneNumberEditText.setError("Phone is required");
                }
                break;
        }
    }

    AuthCallback authCallback = new AuthCallback() {
        @Override
        public void success(DigitsSession session, String phoneNumber) {

        }

        @Override
        public void failure(DigitsException error) {

        }
    };
}
