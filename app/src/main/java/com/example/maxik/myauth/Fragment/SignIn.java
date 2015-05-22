package com.example.maxik.myauth.Fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.maxik.myauth.Activity.MainActivity;
import com.example.maxik.myauth.Command.UserService;
import com.example.maxik.myauth.Entity.User;
import com.example.maxik.myauth.R;
import com.example.maxik.myauth.Services.DaggerRestClientComponent;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignIn.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignIn extends Fragment implements Validator.ValidationListener {

    /**
     * todo move all constraints to separate class that implement  ValidationListener interface
     */
    @NotEmpty
    @Email
    private EditText email;

    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC)
    private EditText password;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SignIn.
     */
    // TODO: Rename and change types and number of parameters
    public static SignIn newInstance() {
        SignIn fragment = new SignIn();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SignIn() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button buttonSignIn = (Button) view.findViewById(R.id.sign_in);
        Button buttonSignUp = (Button) view.findViewById(R.id.sign_up);

        this.email = (EditText) view.findViewById(R.id.email);
        this.password = (EditText) view.findViewById(R.id.password);

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onValidationSucceeded() {
        RestAdapter adapter = DaggerRestClientComponent.create().provideRestAdapter();

        byte[] bytes = String.format("%s:%s", email, password).getBytes();
        String encodedCredentials = String.format("Basic %s", Base64.encodeToString(bytes, Base64.URL_SAFE));

        adapter.create(UserService.class).authenticate(encodedCredentials, new Callback<User>() {

            @Override
            public void success(User user, Response response) {
                startActivity(MainActivity.newIntent(getActivity()));
            }

            @Override
            public void failure(RetrofitError error) {
                int a = 2;
            }
        });
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error: errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this.getActivity());

            ((EditText) view).setError(message);
        }
    }
}
