package com.roysters.connectyou;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 'Nagarjuna' on 21/10/16.
 */

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mNameEditText;
    private EditText mChatNameEditText;
    private Button mSaveButton;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_details);

        initViews();
        initListeners();
    }

    private void initViews() {
        mNameEditText = (EditText) findViewById(R.id.full_name_editText);
        mChatNameEditText = (EditText) findViewById(R.id.chat_name_editText);
        mSaveButton = (Button) findViewById(R.id.save_button);
    }

    private void initListeners() {
        mSaveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
