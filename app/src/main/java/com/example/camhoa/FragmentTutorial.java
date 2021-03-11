package com.example.camhoa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.camhoa.widget.ViewPagerAdapter;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FragmentTutorial extends Fragment {
    PlayerView playerView;
    ProgressBar progressBar;
    ImageView btnFullScreen;
    SimpleExoPlayer simpleExoPlayer;
    boolean flag = false;
    ImageView imgBack;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!isTablet(getContext())) {
            View view = inflater.inflate(R.layout.fragment_tutorial, container, false);
            viewPager = view.findViewById(R.id.viewPager);
            imgBack = view.findViewById(R.id.imgBack);
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    requireActivity().onBackPressed();
                }
            });

            ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
            List<Fragment> listFragment = new ArrayList<>();
            listFragment.add(new FragmentTutorialIntroduce());
            listFragment.add(new FragmentTutorialFeedback());
            List<String> listTitle = new ArrayList<>();
            listTitle.add("Giới thiệu");
            listTitle.add("Cộng đồng");
            pagerAdapter.setFragments(listFragment);
            pagerAdapter.setTitles(listTitle);
            viewPager.setAdapter(pagerAdapter);
            ((TabLayout) view.findViewById(R.id.tabLayout)).setupWithViewPager(viewPager);
            playerView = view.findViewById(R.id.player_view);
            progressBar = view.findViewById(R.id.progress_bar);
            btnFullScreen = view.findViewById(R.id.exo_fullscreen);
            VideoCustom();
            return view;
        }else {
            View view = inflater.inflate(R.layout.fragment_tutorial_ipad, container, false);
            viewPager = view.findViewById(R.id.viewPager);
            imgBack = view.findViewById(R.id.imgBack);
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    requireActivity().onBackPressed();
                }
            });

            ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
            List<Fragment> listFragment = new ArrayList<>();
            listFragment.add(new FragmentTutorialIntroduce());
            listFragment.add(new FragmentTutorialFeedback());
            List<String> listTitle = new ArrayList<>();
            listTitle.add("Giới thiệu");
            listTitle.add("Cộng đồng");
            pagerAdapter.setFragments(listFragment);
            pagerAdapter.setTitles(listTitle);
            viewPager.setAdapter(pagerAdapter);
            ((TabLayout) view.findViewById(R.id.tabLayout)).setupWithViewPager(viewPager);
            playerView = view.findViewById(R.id.player_view);
            progressBar = view.findViewById(R.id.progress_bar);
            btnFullScreen = view.findViewById(R.id.exo_fullscreen);
            VideoCustom();
            return view;
        }
    }

    private void VideoCustom() {

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Uri url = Uri.parse("https://i.imgur.com/7bMqysJ.mp4");
        LoadControl loadControl = new DefaultLoadControl();
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelector trackSelector = new DefaultTrackSelector(
                new AdaptiveTrackSelection.Factory(bandwidthMeter)
        );
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(getActivity(), trackSelector, loadControl);
        DefaultHttpDataSourceFactory factory = new DefaultHttpDataSourceFactory("exoplayer_video");
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource mediaSource = new ExtractorMediaSource(url, factory, extractorsFactory, null, null);
        playerView.setPlayer(simpleExoPlayer);
        playerView.setKeepScreenOn(true);
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
        simpleExoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == Player.STATE_BUFFERING) {
                    progressBar.setVisibility(View.VISIBLE);
                } else if (playbackState == Player.STATE_READY) {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }
        });
        btnFullScreen.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SourceLockedOrientationActivity")
            @Override
            public void onClick(View v) {
                if (flag) {
                    btnFullScreen.setImageDrawable(getResources().getDrawable(R.drawable.ic_fullscreen));
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    flag = false;
                } else {
                    btnFullScreen.setImageDrawable(getResources().getDrawable(R.drawable.ic_fullscreen));
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    flag = true;
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        simpleExoPlayer.setPlayWhenReady(false);
        simpleExoPlayer.getPlaybackState();
    }

    public Boolean isTablet(Context context) {
        return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }

}
