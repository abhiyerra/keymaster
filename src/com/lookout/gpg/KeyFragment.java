package com.lookout.gpg;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ayerra
 * Date: 5/29/13
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class KeyFragment extends Fragment {
    SimpleAdapter adapter;

    public KeyFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_key, container, false);

        GPGFactory.buildData();

        ListView lv = (ListView) rootView.findViewById(R.id.keyView);
        String[] from = { "full_name", "pgp_fingerprint" };
        int[] to = { R.id.full_name, R.id.short_id };
        adapter = new SimpleAdapter(rootView.getContext(), GPGFactory.getKeys(), R.layout.key_list_item, from, to);
        lv.setAdapter(adapter);

        getActivity().setTitle("Public Keys");
        return rootView;
    }
}
