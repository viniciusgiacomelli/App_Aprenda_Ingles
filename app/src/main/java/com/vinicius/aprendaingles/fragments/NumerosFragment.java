package com.vinicius.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.vinicius.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    private ImageButton buttonOne,buttonTwo, buttonThree
            , buttonFour, buttonFive, buttonSix;

    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        if(mediaPlayer != null){
            mediaPlayer = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_numeros, container, false);

        buttonOne = view.findViewById(R.id.buttonUm);
        buttonTwo = view.findViewById(R.id.buttonDois);
        buttonThree = view.findViewById(R.id.buttonTres);
        buttonFour = view.findViewById(R.id.buttonQuatro);
        buttonFive = view.findViewById(R.id.buttonCinco);
        buttonSix = view.findViewById(R.id.buttonSeis);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.buttonUm:
                tocarSom(R.raw.one);
                mostrarNome("ONE");
            break;

            case R.id.buttonDois:
                tocarSom(R.raw.two);
                mostrarNome("TWO");
            break;

            case R.id.buttonTres:
                tocarSom(R.raw.three);
                mostrarNome("THREE");
            break;

            case R.id.buttonQuatro:
                tocarSom(R.raw.four);
                mostrarNome("FOUR");
            break;

            case R.id.buttonCinco:
                tocarSom(R.raw.five);
                mostrarNome("FIVE");
            break;

            case R.id.buttonSeis:
                tocarSom(R.raw.six);
                mostrarNome("SIX");
            break;
        }
    }

    public void tocarSom(int file){
        mediaPlayer = MediaPlayer.create(getContext(),file);
        if(mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    public void mostrarNome(String nome){
        Toast.makeText(getContext(), nome, Toast.LENGTH_SHORT).show();
    }
}