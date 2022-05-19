package com.example.swe311_final_assignment_swe1904867;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ResFragment extends Fragment {

    VideoView eightDaysBrother,sevenAttraction,xiamenGuide,xiamenCity;
    MediaPlayer player1,player2;
    Button play1,pause1,stop1,play2,pause2,stop2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_res,container,false);

        //set video view and media controller
        eightDaysBrother=view.findViewById(R.id.vvEightDaysBrother);
        String videoDirectory="android.resource://"+getActivity().getPackageName()+"/"+R.raw.eightdaysxiamentourwithchanbrotherstravel;
        Uri uri= Uri.parse(videoDirectory);
        eightDaysBrother.setVideoURI(uri);

        MediaController mediaController=new MediaController(getActivity());
        eightDaysBrother.setMediaController(mediaController);
        mediaController.setAnchorView(eightDaysBrother);

        //set video view and media controller
        sevenAttraction=view.findViewById(R.id.vvSevenAttraction);
        String videoDirectory1="android.resource://"+getActivity().getPackageName()+"/"+R.raw.sevenattractiveplaceofxiamenwhattodoinxiamen;
        Uri uri1= Uri.parse(videoDirectory1);
        sevenAttraction.setVideoURI(uri1);

        MediaController mediaController1=new MediaController(getActivity());
        sevenAttraction.setMediaController(mediaController1);
        mediaController1.setAnchorView(sevenAttraction);

        //set video view and media controller
        xiamenGuide=view.findViewById(R.id.vvXiamenChinaGuide);
        String videoDirectory2="android.resource://"+getActivity().getPackageName()+"/"+R.raw.xiamenchinatravelguidetopthingstodoinxiamenhappytrip;
        Uri uri2= Uri.parse(videoDirectory2);
        xiamenGuide.setVideoURI(uri2);

        MediaController mediaController2=new MediaController(getActivity());
        xiamenGuide.setMediaController(mediaController2);
        mediaController2.setAnchorView(xiamenGuide);

        //set video view and media controller
        xiamenCity=view.findViewById(R.id.vvXiamenCity);
        String videoDirectory3="android.resource://"+getActivity().getPackageName()+"/"+R.raw.xiamencitybeautificationfujianchina;
        Uri uri3= Uri.parse(videoDirectory3);
        xiamenCity.setVideoURI(uri3);

        MediaController mediaController3=new MediaController(getActivity());
        xiamenCity.setMediaController(mediaController3);
        mediaController3.setAnchorView(xiamenCity);

        play1=view.findViewById(R.id.btnExplorePlay);
        pause1=view.findViewById(R.id.btnExplroePause);
        stop1=view.findViewById(R.id.btnExploreStop);
        play2=view.findViewById(R.id.btnFiveThingsPlay);
        pause2=view.findViewById(R.id.btnFiveThingsPause);
        stop2=view.findViewById(R.id.btnFiveThingsStop);

        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1==null){
                    player1=MediaPlayer.create(getContext(),R.raw.exploretvxiamen);
                    player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            stopPlayer1();
                        }
                    });
                }
                player1.start();
            }
        });

        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player1!=null){
                    player1.pause();
                }
            }
        });

        stop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlayer1();
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player2==null){
                    player2=MediaPlayer.create(getContext(),R.raw.fivethingstodoinxiamen);
                    player2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            stopPlayer2();
                        }
                    });
                }
                player2.start();
            }
        });

        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player2!=null){
                    player2.pause();
                }
            }
        });

        stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlayer2();
            }
        });

        return view;
    }

    private void stopPlayer1(){
        if(player1!=null){
            player1.release();
            player1=null;
        }
    }

    private void stopPlayer2(){
        if(player2!=null){
            player2.release();
            player2=null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        stopPlayer1();
        stopPlayer2();
    }
}
