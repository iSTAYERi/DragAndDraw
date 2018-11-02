package xyz.stayer.draganddraw

import android.support.v4.app.Fragment
import test.stayer.beatbox.SingleFragmentActivity

class DragAndDrawActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return DragAndDrawFragment.newInstance()
    }

}
