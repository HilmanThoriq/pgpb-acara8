package com.example.simpleapp7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DestinationFragment extends Fragment {

    private RecyclerView recyclerView;
    private BottomNavigationView bottomNavigationView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public DestinationFragment() {
        // Required empty public constructor
    }

    public static DestinationFragment newInstance(String param1, String param2) {
        DestinationFragment fragment = new DestinationFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination, container, false);

        // Find and store reference to BottomNavigationView
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Hide bottom navigation
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(View.GONE);
        }

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.ticket_disaster);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize data
        List<Disaster> disasterList = new ArrayList<>();
        disasterList.add(new Disaster("Yogyakarta", "First Class Ticket"));
        disasterList.add(new Disaster("Bali", "Business Class Ticket"));
        disasterList.add(new Disaster("Bandung", "Business Class Ticket"));
        disasterList.add(new Disaster("Yogyakarta", "First Class Ticket"));
        disasterList.add(new Disaster("Semarang", "Business Class Ticket"));
        disasterList.add(new Disaster("Denpasar", "Economy Class Ticket"));
        disasterList.add(new Disaster("Lombok", "Business Class Ticket"));
        disasterList.add(new Disaster("Semarang", "Economy Class Ticket"));
        disasterList.add(new Disaster("Denpasar", "Business Class Ticket"));
        disasterList.add(new Disaster("Lombok", "First Class Ticket"));

        // Set up adapter
        DisasterAdapter disasterAdapter = new DisasterAdapter(disasterList);
        recyclerView.setAdapter(disasterAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Show bottom navigation when this fragment is destroyed
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(View.VISIBLE);
        }
    }
}