package com.example.googleplay.utils;

import com.example.googleplay.application.BaseApplication;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;

/**
 * @项目�? GooglePlay10
 * @包名: org.itheima.googleplay10.utils
 * @类名: UIUtils
 * @创建�? 肖琦
 * @创建时间: 2015-8-22 下午2:07:58
 * @描述: TODO
 * 
 * @svn版本: $Rev: 12 $
 * @更新�? $Author: xq $
 * @更新时间: $Date: 2015-08-22 17:13:21 +0800 (Sat, 22 Aug 2015) $
 * @更新描述: TODO
 */
public class UIUtils
{

	/**
	 * 获得上下�?
	 * 
	 * @return
	 */
	public static Context getContext()
	{
		return BaseApplication.getContext();
	}

	/**
	 * 获得资源
	 * 
	 * @return
	 */
	public static Resources getResources()
	{
		return getContext().getResources();
	}

	/**
	 * 获得string类型的数�?
	 * 
	 * @param resId
	 * @return
	 */
	public static String getString(int resId)
	{
		return getContext().getResources().getString(resId);
	}

	/**
	 * 获得数组集合
	 * 
	 * @param resId
	 * @return
	 */
	public static String[] getStringArray(int resId)
	{
		return getResources().getStringArray(resId);
	}

	/**
	 * 获得颜色�?
	 * 
	 * @param resId
	 * @return
	 */
	public static int getColor(int resId)
	{
		return getResources().getColor(resId);
	}

	/**
	 * 获得handler
	 * 
	 * @return
	 */
	public static Handler getMainHandler()
	{
		return BaseApplication.getHandler();
	}

	/**
	 * 在主线程中执行任�?
	 * 
	 * @param task
	 */
	public static void post(Runnable task)
	{
		getMainHandler().post(task);
	}

	/**
	 * 像素转dp
	 * 
	 * @param px
	 * @return
	 */
	public static int px2dp(int px)
	{
		// px = dp * (dpi / 160)
		// dp = px * 160 / dpi

		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int dpi = metrics.densityDpi;
		return (int) (px * 160f / dpi + 0.5f);
	}

	/**
	 * dp转px
	 * 
	 * @param dp
	 * @return
	 */
	public static int dp2px(int dp)
	{
		// px = dp * (dpi / 160)
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		int dpi = metrics.densityDpi;

		return (int) (dp * (dpi / 160f) + 0.5f);
	}

	/**
	 * 获得包名
	 * 
	 * @return
	 */
	public static String getPackageName()
	{
		return getContext().getPackageName();
	}
}
