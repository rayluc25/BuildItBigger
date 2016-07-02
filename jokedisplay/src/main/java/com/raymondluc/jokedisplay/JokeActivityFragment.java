package com.raymondluc.jokedisplay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rtluc on 6/30/2016.
 */
public class JokeActivityFragment extends Fragment {
    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokeActivity.EXTRA_JOKE);
        if(TextUtils.isEmpty(joke)){
            displayError();
        }
        else {
            TextView jokeTextView = (TextView) root.findViewById(R.id.joke_textview);
            if (joke != null && joke.length() != 0) {
                jokeTextView.setText(joke);
            }
        }
        return root;
    }

    private void displayError(){
        new AlertDialog.Builder(getContext())
                .setTitle("Error")
                .setMessage("No Joke Provided")
                .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                })
                .show();
    }
}
