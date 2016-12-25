package wailaixing.com.palmuniversity.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import wailaixing.com.palmuniversity.MyApplication;

/**
 * Created by shiyanqi on 16/11/26.
 */

public final class PreferenceUtil
{


	public static void reset(final Context context)
	{

		SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
		edit.clear();
		edit.apply();
	}



	public static void put(String key, String value)
	{

		putString(key, value);
	}

	public static void put(String key, int value)
	{

		putInt(key, value);
	}

	public static void put(String key, float value)
	{

		putFloat(key, value);
	}

	public static void put(String key, boolean value)
	{

		putBoolean(key, value);
	}

	private static void putFloat(String key, float value)
	{

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putFloat(key, value);
		editor.apply();
	}

	public static SharedPreferences getPreferences()
	{

		return PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
	}

	public static int getInt(String key, int defValue)
	{

		return PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance()).getInt(key, defValue);
	}

	public static boolean getBoolean(String key, boolean defValue)
	{

		return PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance()).getBoolean(key, defValue);
	}

	public static void putStringProcess(String key, String value)
	{

		SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences("preference_mu", Context.MODE_MULTI_PROCESS);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.apply();
	}

	public static String getStringProcess(String key, String defValue)
	{

		SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences("preference_mu", Context.MODE_MULTI_PROCESS);
		return sharedPreferences.getString(key, defValue);
	}

	public static boolean hasString(String key)
	{

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
		return sharedPreferences.contains(key);
	}

	private static void putString(String key, String value)
	{

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.apply();
	}

	public static void putLong(String key, long value)
	{

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putLong(key, value);
		editor.apply();
	}

	public static void putBoolean(String key, boolean value)
	{

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.apply();
	}

	private static void putInt(String key, int value)
	{

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.apply();
	}

	public static void remove(String... keys)
	{

		if (keys != null)
		{
			SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance());
			SharedPreferences.Editor editor = sharedPreferences.edit();
			for (String key : keys)
			{
				editor.remove(key);
			}
			editor.apply();
		}
	}
}