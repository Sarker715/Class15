package com.map.class15;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog(View view) {
        View layout = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        final EditText editTextUsername = layout.findViewById(R.id.editText_username);
        final EditText editTextPassword = layout.findViewById(R.id.editText_password);
        CheckBox checkBox = layout.findViewById(R.id.check_box);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editTextPassword.setTransformationMethod(null);
                } else {
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Sign Up");
        alert.setView(layout);
        alert.setCancelable(false);

        alert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String name = editTextUsername.getText().toString();
                String pass = editTextPassword.getText().toString();

                Toast.makeText(MainActivity.this, "Name : " + name + " Passsword:" + pass, Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You've pressed negative button", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
