package com.diegopizzo.moviesbooks.ui.mainactivity.copyrightdialogfragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.diegopizzo.moviesbooks.R;

/**
 * Created by diegopizzo on 09/12/2017.
 */

public class CopyrightDialogFragment extends DialogFragment {

    public static final String TAG = "CopyrightDialogFragment";

    public static CopyrightDialogFragment newInstance() {
        return new CopyrightDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
        builder.setMessage(R.string.dialog_content).setTitle(R.string.dialog_title)
                .setIcon(R.drawable.ic_copyright_black_24dp).setCancelable(true);
        return builder.create();
    }
}
