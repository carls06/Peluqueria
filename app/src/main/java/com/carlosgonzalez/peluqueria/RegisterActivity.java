package com.carlosgonzalez.peluqueria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public  EditText email, password, confirmpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        email=findViewById(R.id.emailText);
        password=findViewById(R.id.passText);
        confirmpass=findViewById(R.id.passText2);



    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }

    public void registeUser(View view) {

        if (password.getText().toString().equals(confirmpass.getText().toString())){

            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                                Toast.makeText(RegisterActivity.this, "Usuario Creado",Toast.LENGTH_SHORT).show();

                                limpiar();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });


        }else{
            Toast.makeText(RegisterActivity.this, "Contraseñas no coinciden ",
                    Toast.LENGTH_SHORT).show();


        }

    }
    public void limpiar(){
        email.setText("");
        password.setText("");
        confirmpass.setText("");
    }
}