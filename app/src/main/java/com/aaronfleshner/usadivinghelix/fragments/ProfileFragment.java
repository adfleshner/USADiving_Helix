package com.aaronfleshner.usadivinghelix.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aaronfleshner.usadivinghelix.R;
import com.aaronfleshner.usadivinghelix.Utils;
import com.aaronfleshner.usadivinghelix.models.DtoDiver;
import com.aaronfleshner.usadivinghelix.web_calls.VolleyUtils;
import com.android.volley.cache.plus.SimpleImageLoader;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by aaronfleshner on 7/18/14.
 */
public class ProfileFragment extends Fragment {

    private static final String DIVER = "Diver profile";
    private CircleImageView ivProfileDiverPic;
    private TextView tvProfileDiverName, tvProfileDiverBiography, tvProfileDiverBirthday, tvProfileDiverBirthplace,
            tvProfileDiverHometown, tvProfileDiverCurrentRes, tvProfileDiverEducation, tvProfileDiverDegree, tvProfileDiverClub,
            tvProfileDiverCoach, tvProfileDiverNationTeam;
    private LinearLayout llProfileDiverBiography, llProfileDiverBirthday, llProfileDiverBirthplace,
            llProfileDiverHometown, llProfileDiverCurrentRes, llProfileDiverEducation, llProfileDiverDegree, llProfileDiverClub,
            llProfileDiverCoach;
    private ImageView mBackground;
    private SimpleImageLoader mImageLoader;
    private DtoDiver diver;

    public static Fragment fragmentInstance(DtoDiver diver) {
        Fragment frag = new ProfileFragment();
        Bundle args = new Bundle();
        args.putParcelable(DIVER, diver);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().getActionBar().hide();
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(DIVER)) {
            diver = getArguments().getParcelable(DIVER);
        }
        mImageLoader = VolleyUtils.createSimpleImageLoader(getActivity(), 0.50f, 200);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        tvProfileDiverName = (TextView) rootView.findViewById(R.id.tvProfileDiverName);
        tvProfileDiverBiography = (TextView) rootView.findViewById(R.id.tvBiography);
        tvProfileDiverBirthday = (TextView) rootView.findViewById(R.id.tvProfileDiverBirthday);
        tvProfileDiverBirthplace = (TextView) rootView.findViewById(R.id.tvProfileDiverBirthplace);
        tvProfileDiverHometown = (TextView) rootView.findViewById(R.id.tvProfileDiverHomeTown);
        tvProfileDiverCurrentRes = (TextView) rootView.findViewById(R.id.tvProfileDiverCurrentRes);
        tvProfileDiverEducation = (TextView) rootView.findViewById(R.id.tvProfileDiverEducation);
        tvProfileDiverDegree = (TextView) rootView.findViewById(R.id.tvProfileDiverDegree);
        tvProfileDiverClub = (TextView) rootView.findViewById(R.id.tvProfileDiverClub);
        tvProfileDiverCoach = (TextView) rootView.findViewById(R.id.tvProfileDiverCoach);
        tvProfileDiverNationTeam = (TextView) rootView.findViewById(R.id.tvProfileDiverNationTeam);
        ivProfileDiverPic = (CircleImageView) rootView.findViewById(R.id.ivProfileDiverPic);

        llProfileDiverBiography = (LinearLayout) rootView.findViewById(R.id.llBio);
        llProfileDiverBirthday = (LinearLayout) rootView.findViewById(R.id.llBirthday);
        llProfileDiverBirthplace = (LinearLayout) rootView.findViewById(R.id.llBirthplace);
        llProfileDiverHometown = (LinearLayout) rootView.findViewById(R.id.llHometown);
        llProfileDiverCurrentRes = (LinearLayout) rootView.findViewById(R.id.llResidence);
        llProfileDiverEducation = (LinearLayout) rootView.findViewById(R.id.llEducation);
        llProfileDiverDegree = (LinearLayout) rootView.findViewById(R.id.llDegree);
        llProfileDiverClub = (LinearLayout) rootView.findViewById(R.id.llClub);
        llProfileDiverCoach = (LinearLayout) rootView.findViewById(R.id.llCoach);
        mBackground = (ImageView) rootView.findViewById(R.id.background);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (diver != null) {
            mImageLoader.get(diver.getImgUrl(), ivProfileDiverPic);
            mImageLoader.get(diver.getImgSecondaryUrl(), VolleyUtils.createBlurImageListener(mBackground));
            tvProfileDiverName.setText(diver.getFullName());
            tvProfileDiverBiography.setText(diver.getBiography());
            tvProfileDiverBirthday.setText(diver.getBirthDate());
            tvProfileDiverBirthplace.setText(diver.getBirthPlace());
            tvProfileDiverHometown.setText(diver.getHomeTown());
            tvProfileDiverCurrentRes.setText(diver.getCurrentResidence());
            tvProfileDiverEducation.setText(diver.getEducation());
            tvProfileDiverDegree.setText(diver.getDegree());
            tvProfileDiverCoach.setText(diver.getCoach());
            tvProfileDiverClub.setText(diver.getClub());
            tvProfileDiverNationTeam.setText(Utils.ArrayListToString(diver.getNationalTeam()));

            if(diver.getBiography().isEmpty()){llProfileDiverBiography.setVisibility(View.GONE);}else{llProfileDiverBiography.setVisibility(View.VISIBLE);};
            if(diver.getBirthDate().isEmpty()){llProfileDiverBirthday.setVisibility(View.GONE);}else{llProfileDiverBirthday.setVisibility(View.VISIBLE);};
            if(diver.getBirthPlace().isEmpty()){llProfileDiverBirthplace.setVisibility(View.GONE);}else{llProfileDiverBirthplace.setVisibility(View.VISIBLE);};
            if(diver.getHomeTown().isEmpty()){llProfileDiverHometown.setVisibility(View.GONE);}else{llProfileDiverHometown.setVisibility(View.VISIBLE);};
            if(diver.getCurrentResidence().isEmpty()){llProfileDiverCurrentRes.setVisibility(View.GONE);}else{llProfileDiverCurrentRes.setVisibility(View.VISIBLE);};
            if(diver.getDegree().isEmpty()){llProfileDiverDegree.setVisibility(View.GONE);}else{llProfileDiverDegree.setVisibility(View.VISIBLE);};
            if(diver.getClub().isEmpty()){llProfileDiverClub.setVisibility(View.GONE);}else{llProfileDiverClub.setVisibility(View.VISIBLE);};
            if(diver.getCoach().isEmpty()){llProfileDiverCoach.setVisibility(View.GONE);}else{llProfileDiverCoach.setVisibility(View.VISIBLE);};
            if(diver.getEducation().isEmpty()){llProfileDiverEducation.setVisibility(View.GONE);}else{llProfileDiverEducation.setVisibility(View.VISIBLE);};
        }
    }


}
