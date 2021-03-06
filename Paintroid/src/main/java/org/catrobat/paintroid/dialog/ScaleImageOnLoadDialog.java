/*
 * Paintroid: An image manipulation application for Android.
 * Copyright (C) 2010-2015 The Catrobat Team
 * (<http://developer.catrobat.org/credits>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.catrobat.paintroid.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import org.catrobat.paintroid.R;
import org.catrobat.paintroid.common.MainActivityConstants;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class ScaleImageOnLoadDialog extends MainActivityDialogFragment {

	private Uri uri;
	private int requestCode;

	public static ScaleImageOnLoadDialog newInstance(Uri uri, @MainActivityConstants.LoadImageRequestCode int requestCode) {
		ScaleImageOnLoadDialog scaleImageDialog = new ScaleImageOnLoadDialog();

		Bundle bundle = new Bundle();
		bundle.putString("Uri", uri.toString());
		bundle.putInt("requestCode", requestCode);
		scaleImageDialog.setArguments(bundle);
		return scaleImageDialog;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle arguments = getArguments();
		uri = Uri.parse(arguments.getString("Uri"));
		requestCode = arguments.getInt("requestCode");
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlertDialog.Builder(getActivity(), R.style.PocketPaintAlertDialog)
				.setTitle(R.string.dialog_scale_title)
				.setMessage(R.string.dialog_scale_message)
				.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						getPresenter().loadScaledImage(uri, requestCode);
					}
				})
				.setNegativeButton(android.R.string.cancel, null)
				.create();
	}
}
