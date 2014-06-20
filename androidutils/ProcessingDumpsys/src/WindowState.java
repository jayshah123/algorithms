import java.awt.Rectangle;

import com.jogamp.opengl.util.packrect.Rect;




public class WindowState {

	public String title;
	public Wmlayoutparams wmlp;
	public int stackPos;
	public int mSessionuid;
	public int requestedHeight,requestedWidth;
	public int mLayoutSeq;
	public int mBaseLayer,mSubLayer,mAnimLayer,mLastLayer;
	public int mToken,mRootToken;
	public int mViewVisibility,mSystemUiVisibility;
	public boolean mHaveFrame,mObscured;
	public int mSeq;
	public Rect mGivenContentInsets,mGivenVisibleInsets;
	public int mConfiguration;
	public Rect mShownFrame,mFrame,mFrameLast,mSystemDecorRect,mSystemDecorLast;
	public Rect containingf,pf,df,cf,vf;
	public Rect ci,vi;
	public float mShownAlpha,mAlpha,mLastAlpha;
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "title - "+title+" stack pos - "+stackPos+" mSessionuid = "+mSessionuid+" wmparams - "+wmlp+" mBaseLayer = "+mBaseLayer+" mSubLayer = "+mSubLayer;
		
	}
	
}
