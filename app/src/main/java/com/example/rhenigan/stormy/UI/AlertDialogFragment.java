package com.example.rhenigan.stormy.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.example.rhenigan.stormy.R;

/**
 * Created by henig on 4/4/2018.
 * ------------------------------
 */

public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.error_title)).setMessage(context.getString(R.string.error_message)).setPositiveButton(context.getString(R.string.error_button), null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
