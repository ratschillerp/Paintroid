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

package org.catrobat.paintroid.ui;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

public final class ToastFactory {
	private static Toast currentToast;

	private ToastFactory() {
	}

	public static Toast makeText(Context context, @StringRes int resId, int duration) {
		if (currentToast != null) {
			currentToast.cancel();
		}

		currentToast = Toast.makeText(context, resId, duration);
		return currentToast;
	}

	public static Toast makeText(Context context, String msg, int duration) {
		if (currentToast != null) {
			currentToast.cancel();
		}

		currentToast = Toast.makeText(context, msg, duration);
		return currentToast;
	}
}
