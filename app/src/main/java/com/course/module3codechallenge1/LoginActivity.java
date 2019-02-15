package com.course.module3codechallenge1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText mEmailText;
    EditText mPhoneText;
    TextView mFailText;
    TextView mSuccessText;
    CheckBox termsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_1);
        initUi();

    }

    private void initUi() {
        mEmailText = findViewById(R.id.email_text);
        mPhoneText = findViewById(R.id.phone_text);
        mFailText = findViewById(R.id.fail_text);
        mSuccessText = findViewById(R.id.success_text);
        termsAndConditions = findViewById(R.id.terms_and_conditions);
    }

    private boolean validateEmail(String address) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    private String formatInputString() {

        String input = getString(R.string.input_message_format);
        input += " Email:" + mEmailText.getText();
        input += " Phone:" + mPhoneText.getText();
        return input;
    }

    private void setErrorText() {
        mSuccessText.setVisibility(View.GONE);
        mFailText.setVisibility(View.VISIBLE);
        mFailText.setText(getString(R.string.reintroduce_input));
    }

    private void setSuccessText() {
        String input = formatInputString();
        mFailText.setVisibility(View.GONE);
        mSuccessText.setVisibility(View.VISIBLE);
        mSuccessText.setText(input);
    }
    private void setTermsAndConditionsText()
    {
        mSuccessText.setVisibility(View.GONE);
        mFailText.setVisibility(View.VISIBLE);
        mFailText.setText(getString(R.string.accept_terms_and_conditions));
    }
    public void submit(View view) {
        String phone = mPhoneText.getText().toString();
        String address = mEmailText.getText().toString();
        if (
                validateEmail(address) &&
                (!phone.isEmpty()) &&
                (phone != null) &&
                (!address.isEmpty()) &&
                (address != null) &&
                termsAndConditions.isChecked()) {
            setSuccessText();
        } else {
            if(!termsAndConditions.isChecked()) {
                setTermsAndConditionsText();
            }
            else {
                mEmailText.setError(getString(R.string.email_error));
                mEmailText.requestFocus();
                setErrorText();
            }
        }
    }
}
