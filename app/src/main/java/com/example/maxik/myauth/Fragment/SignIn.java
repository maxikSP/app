package com.example.maxik.myauth.Fragment;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.maxik.myauth.Activity.MainActivity;
import com.example.maxik.myauth.Command.UserService;
import com.example.maxik.myauth.Entity.Repo;
import com.example.maxik.myauth.Entity.User;
import com.example.maxik.myauth.R;
import com.example.maxik.myauth.Services.DaggerRestClientComponent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignIn extends Fragment implements Validator.ValidationListener {

    @NotEmpty
    @Email
    private EditText email;

    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC)
    private EditText password;
    private FrameLayout progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button buttonSignIn = (Button) view.findViewById(R.id.sign_in);
        Button buttonSignUp = (Button) view.findViewById(R.id.sign_up);

        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        progress = (FrameLayout) getActivity().findViewById(R.id.progress_bar);

        final Validator validator = new Validator(this);
        validator.setValidationListener(this);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onValidationSucceeded() {
        final RestAdapter adapter = DaggerRestClientComponent.create().provideRestAdapter();

        EditText email = (EditText) getView().findViewById(R.id.email);
        EditText password = (EditText) getView().findViewById(R.id.password);

        byte[] bytes = String.format("%s:%s", email.getText(), password.getText()).getBytes();
        String encodedCredentials = String.format("Basic %s", Base64.encodeToString(bytes, Base64.URL_SAFE));

        progress.setVisibility(getView().VISIBLE);

        adapter.create(UserService.class).authenticate(encodedCredentials, new Callback<User>() {

            @Override
            public void success(User user, Response response) {

                SharedPreferences.Editor preferences = SignIn.this.getActivity()
                        .getSharedPreferences(User.USER_PREFERENCES, Context.MODE_PRIVATE)
                        .edit();

                preferences.putString(User.USER_PREFERENCES, new GsonBuilder().create().toJson(user));
                preferences.commit();

                startActivity(MainActivity.newIntent(getActivity()));
            }

            @Override
            public void failure(RetrofitError error) {

                progress.setVisibility(View.GONE);
                DialogFragment dialog = GithubDialog.newInstance(
                        getResources().getString(R.string.validation_fail_title),
                        getResources().getString(R.string.validation_fail_message)
                );

                dialog.show(getFragmentManager(), "sign_in_validation_error");
            }
        });
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        progress.setVisibility(View.GONE);

        DialogFragment dialog = GithubDialog.newInstance(
                "Validation falure",
                errors.get(0).getCollatedErrorMessage(getActivity())
        );

        dialog.show(getFragmentManager(), "sign_in_validation_error");

    }



}
