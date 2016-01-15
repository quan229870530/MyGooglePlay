package com.example.googleplay.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * @项目�? GooglePlay10
 * @包名: org.itheima.googleplay10
 * @类名: BaseApplication
 * @创建�? 肖琦
 * @创建时间: 2015-8-22 上午11:23:48
 * @描述: 程序入口
 * 
 * @svn版本: $Rev: 6 $
 * @更新�? $Author: xq $
 * @更新时间: $Date: 2015-08-22 14:23:07 +0800 (Sat, 22 Aug 2015) $
 * @更新描述: TODO
 */
public class BaseApplication extends Application
{

	private static Context	mContext;
	private static Handler	mHandler;
	private static Thread	mMainThread;
	private static long		mMainThreadId;
	private static Looper	mMainThreadLooper;

	@Override
	public void onCreate()
	{
		super.onCreate();

		// 程序的入�?
		mContext = this;

		// handler,用来子线程和主线程�?�?
		mHandler = new Handler();

		// 主线�?
		mMainThread = Thread.currentThread();
		// id
		// mMainThreadId = mMainThread.getId();
		mMainThreadId = android.os.Process.myTid();

		// looper
		mMainThreadLooper = getMainLooper();
	}

	public static Context getContext()
	{
		return mContext;
	}

	public static Handler getHandler()
	{
		return mHandler;
	}

	public static Thread getMainThread()
	{
		return mMainThread;
	}

	public static long getMainThreadId()
	{
		return mMainThreadId;
	}

	public static Looper getMainThreadLooper()
	{
		return mMainThreadLooper;
	}

}
