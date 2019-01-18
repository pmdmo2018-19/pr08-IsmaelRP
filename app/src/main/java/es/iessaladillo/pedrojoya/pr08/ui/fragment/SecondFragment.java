package es.iessaladillo.pedrojoya.pr08.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.databinding.FragmentSecondBinding;
import es.iessaladillo.pedrojoya.pr08.utils.ToastUtils;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding b;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        return b.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        b.fab2.setOnClickListener(v -> showMessage());
        ((AppCompatActivity) requireActivity()).setSupportActionBar(b.toolbar2);

        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowHomeEnabled(true);

    }

    private void showMessage() {
        ToastUtils.toast(requireContext(), getString(R.string.fab2_event_text));
        requireActivity().getSupportFragmentManager().popBackStack();
    }


}
