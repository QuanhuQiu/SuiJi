package com.fenghuo.cropscale;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;

public class CropImageLayout extends RelativeLayout
{

	private CropZoomImageView mZoomImageView;
	private CropImageBorderView mClipImageView;

	private int mHorizontalPadding =60;

	public CropImageLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		mZoomImageView = new CropZoomImageView(context);
		mClipImageView = new CropImageBorderView(context);

		android.view.ViewGroup.LayoutParams lp = new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		
		this.addView(mZoomImageView, lp);
		this.addView(mClipImageView, lp);

		
		// ����padding��px
		mHorizontalPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, mHorizontalPadding, getResources().getDisplayMetrics());
		mZoomImageView.setHorizontalPadding(mHorizontalPadding);
		mClipImageView.setHorizontalPadding(mHorizontalPadding);
	}

	/**
	 * ���⹫�����ñ߾�ķ���,��λΪdp
	 * 
	 * @param mHorizontalPadding
	 */
	public void setHorizontalPadding(int mHorizontalPadding)
	{
		this.mHorizontalPadding = mHorizontalPadding;
	}

	/**
	 * ����ͼƬ
	 * 
	 * @return
	 */
	public Bitmap clip()
	{
		return mZoomImageView.crop();
	}

	public void setBitmap(Bitmap bitmap) {
		mZoomImageView.setImageBitmap(bitmap);
	}

}
