package com.example.artista;

import java.lang.reflect.Field;

import android.util.Log;
import android.view.View;

public class PrintFlags {

	 // for mPrivateFlags:
    /** {@hide} */
    static final int WANTS_FOCUS                    = 0x00000001;
    /** {@hide} */
    static final int FOCUSED                        = 0x00000002;
    /** {@hide} */
    static final int SELECTED                       = 0x00000004;
    /** {@hide} */
    static final int IS_ROOT_NAMESPACE              = 0x00000008;
    /** {@hide} */
    static final int HAS_BOUNDS                     = 0x00000010;
    /** {@hide} */
    static final int DRAWN                          = 0x00000020;
    /**
     * When this flag is set, this view is running an animation on behalf of its
     * children and should therefore not cancel invalidate requests, even if they
     * lie outside of this view's bounds.
     *
     * {@hide}
     */
    static final int DRAW_ANIMATION                 = 0x00000040;
    /** {@hide} */
    static final int SKIP_DRAW                      = 0x00000080;
    /** {@hide} */
    static final int ONLY_DRAWS_BACKGROUND          = 0x00000100;
    /** {@hide} */
    static final int REQUEST_TRANSPARENT_REGIONS    = 0x00000200;
    /** {@hide} */
    static final int DRAWABLE_STATE_DIRTY           = 0x00000400;
    /** {@hide} */
    static final int MEASURED_DIMENSION_SET         = 0x00000800;
    /** {@hide} */
    static final int FORCE_LAYOUT                   = 0x00001000;
    /** {@hide} */
    static final int LAYOUT_REQUIRED                = 0x00002000;

    private static final int PRESSED                = 0x00004000;

    /** {@hide} */
    static final int DRAWING_CACHE_VALID            = 0x00008000;
    /**
     * Flag used to indicate that this view should be drawn once more (and only once
     * more) after its animation has completed.
     * {@hide}
     */
    static final int ANIMATION_STARTED              = 0x00010000;

    private static final int SAVE_STATE_CALLED      = 0x00020000;

    /**
     * Indicates that the View returned true when onSetAlpha() was called and that
     * the alpha must be restored.
     * {@hide}
     */
    static final int ALPHA_SET                      = 0x00040000;

    /**
     * Set by {@link #setScrollContainer(boolean)}.
     */
    static final int SCROLL_CONTAINER               = 0x00080000;

    /**
     * Set by {@link #setScrollContainer(boolean)}.
     */
    static final int SCROLL_CONTAINER_ADDED         = 0x00100000;

    /**
     * View flag indicating whether this view was invalidated (fully or partially.)
     *
     * @hide
     */
    static final int DIRTY                          = 0x00200000;

    /**
     * View flag indicating whether this view was invalidated by an opaque
     * invalidate request.
     *
     * @hide
     */
    static final int DIRTY_OPAQUE                   = 0x00400000;

    /**
     * Mask for {@link #DIRTY} and {@link #DIRTY_OPAQUE}.
     *
     * @hide
     */
    static final int DIRTY_MASK                     = 0x00600000;

    /**
     * Indicates whether the background is opaque.
     *
     * @hide
     */
    static final int OPAQUE_BACKGROUND              = 0x00800000;

    /**
     * Indicates whether the scrollbars are opaque.
     *
     * @hide
     */
    static final int OPAQUE_SCROLLBARS              = 0x01000000;

    /**
     * Indicates whether the view is opaque.
     *
     * @hide
     */
    static final int OPAQUE_MASK                    = 0x01800000;

    /**
     * Indicates a prepressed state;
     * the short time between ACTION_DOWN and recognizing
     * a 'real' press. Prepressed is used to recognize quick taps
     * even when they are shorter than ViewConfiguration.getTapTimeout().
     *
     * @hide
     */
    private static final int PREPRESSED             = 0x02000000;

    /**
     * Indicates whether the view is temporarily detached.
     *
     * @hide
     */
    static final int CANCEL_NEXT_UP_EVENT = 0x04000000;

    /**
     * Indicates that we should awaken scroll bars once attached
     *
     * @hide
     */
    private static final int AWAKEN_SCROLL_BARS_ON_ATTACH = 0x08000000;

    /**
     * Indicates that the view has received HOVER_ENTER.  Cleared on HOVER_EXIT.
     * @hide
     */
    private static final int HOVERED              = 0x10000000;

    /**
     * Indicates that pivotX or pivotY were explicitly set and we should not assume the center
     * for transform operations
     *
     * @hide
     */
    private static final int PIVOT_EXPLICITLY_SET = 0x20000000;

    /** {@hide} */
    static final int ACTIVATED                    = 0x40000000;

    /**
     * Indicates that this view was specifically invalidated, not just dirtied because some
     * child view was invalidated. The flag is used to determine when we need to recreate
     * a view's display list (as opposed to just returning a reference to its existing
     * display list).
     *
     * @hide
     */
    static final int INVALIDATED                  = 0x80000000;



	static void printprivateflags(View cv){
		try {
			Field f[] = cv.getClass().getSuperclass().getDeclaredFields();
			for(Field findi : f){
				System.out.println(findi);
				findi.setAccessible(true);
				if(findi.toString().contains("mPrivateFlags")){
					Integer i = (Integer) findi.get(cv);
					PrintFlags.printFlags(i);
					Log.d("jay","customview private flags state - "+i);
				}
			}
			

			//Integer i = (Integer) f.get(cv);
			//Log.d("jay","customview private flags state - "+i);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void printFlags(int i){
    	StringBuilder sb=new StringBuilder();
    	sb.append("hello "+i);
    	if((i&PRESSED)!=0)
    		sb.append("PRESSED ");
    	if((i&DRAWN)!=0)
    		sb.append("DRAWN ");
    	if((i&FOCUSED)!=0)
    		sb.append("FOCUSED ");
    	if((i&INVALIDATED)!=0)
    		sb.append("INVALIDATED ");
    	if((i&HAS_BOUNDS)!=0)
    		sb.append("HAS BOUNDS ");
    	if((i&CANCEL_NEXT_UP_EVENT)!=0)
    		sb.append("CANCEL NEXT UP EVENT ");
    	if((i&ALPHA_SET)!=0)
    		sb.append("ALPHA_SET ");
    	if((i&DRAWING_CACHE_VALID)!=0)
    		sb.append("DRAWING_CACHE_VALID ");
    	if((i&MEASURED_DIMENSION_SET)!=0)
    		sb.append("MEASURED_DIMENSION_SET ");
    	if((i&OPAQUE_BACKGROUND)!=0)
    		sb.append("OPAQUE_BACKGROUND ");
    	Log.d("jay","printing flags - "+sb.toString());
    	
    }
    
}
